package cn.kanmars.ecm.dyndata;

import cn.com.xbase.frame.logger.HLogger;
import cn.com.xbase.frame.logger.LoggerManager;
import cn.com.xbase.frame.util.StringUtils;
import cn.kanmars.ecm.dyndata.DynamicTableSplitor;
import cn.kanmars.ecm.dyndata.annotation.DynamicTableSplitMethod;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.*;

import static org.apache.ibatis.reflection.SystemMetaObject.DEFAULT_OBJECT_FACTORY;
import static org.apache.ibatis.reflection.SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY;

/**
 * Created by kanmars on 2017/5/9.
 */
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})
})
@Component
public class DynamicTableSplitorInteceptor implements Interceptor,ApplicationContextAware {
    private HLogger logger = LoggerManager.getLoger("TableSplitorInteceptor");
    static ApplicationContext ac;
    public static HashMap<String,Method> class_methodMap = new HashMap<String, Method>();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaStatementHandler = MetaObject.forObject(statementHandler, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
        String originalSql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
        BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
        Object parameterObject = metaStatementHandler.getValue("delegate.boundSql.parameterObject");

        if (originalSql!=null&&!originalSql.equals("")) {
            MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
            String id = mappedStatement.getId();
            Method m = getClassMethodByIdUseCache(id);
            DynamicTableSplitMethod dtsm = null;
            if((dtsm=m.getAnnotation(DynamicTableSplitMethod.class))!=null){
                int[] splitKeyIndex = dtsm.splitKeyIndex();
                String suffixBeanName = dtsm.suffixBeanName();
                if(StringUtils.isEmpty(suffixBeanName)){
                    throw new RuntimeException("使用DynamicTableSplitMethod时，必须设置value属性为实现了DynamicTableSplitor的bean的name!");
                }
                if(parameterObject==null){
                    throw new RuntimeException("使用DynamicTableSplitMethod时，Mapper必须有参数");
                }
                Object[] splitKeys = null;
                if(splitKeyIndex.length!=0){
                    splitKeys = new Object[splitKeyIndex.length];

                    if(!parameterObject.getClass().isArray()){
                        //参数为单个对象
                        if(splitKeyIndex.length>1 || splitKeyIndex[0]!=0){
                            throw new RuntimeException("使用DynamicTableSplitMethod时，splitKeyIndex值为["+splitKeyIndex[0]+"],但参数下标最大为[0]");
                        }
                        splitKeys[0] = parameterObject;
                    }else{
                        //参数为数组
                        List argslist = Arrays.asList(parameterObject);
                        for(int i=0;i<splitKeyIndex.length;i++){
                            if(splitKeyIndex[i]>argslist.size()-1){
                                throw new RuntimeException("使用DynamicTableSplitMethod时，splitKeyIndex值为["+splitKeyIndex[i]+"],但参数下标最大为["+(argslist.size()-1)+"]");
                            }
                            splitKeys[i] = argslist.get(splitKeyIndex[i]);
                        }
                    }
                }else{
                    throw new RuntimeException("使用DynamicDataSource时，必须设置splitKeyIndex");
                }


                logger.debug("使用DynamicTableSplitor为["+suffixBeanName+"]");

                DynamicTableSplitor dynamicTableSplitor = (DynamicTableSplitor)ac.getBean(suffixBeanName);

                String splitsuffix = dynamicTableSplitor.suffix(splitKeys);
                //给参数中设置TableSplitor属性
                String newSql= originalSql.replaceAll("@\\ *TableSplitor\\ *\\@",splitsuffix);

                metaStatementHandler.setValue("delegate.boundSql.sql", newSql);
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.debug("TableSplitorInteceptor已设置application-start");
        this.ac = applicationContext;
        logger.debug("TableSplitorInteceptor已设置application-end");
    }

    private Method getClassMethodByIdUseCache(String id) throws ClassNotFoundException {
        if(class_methodMap.containsKey(id)){
            return class_methodMap.get(id);
        }
        String className = id.substring(0, id.lastIndexOf("."));
        Class<?>  classObj = Class.forName(className);
        Method[] methods = classObj.getMethods();
        Method m = null;
        for(Method m_t : methods){
            if(m_t.getName().equals(id.substring(id.lastIndexOf(".")+1))){
                //如果到了目标方法
                if(m!=null){
                    throw new RuntimeException("Mybatis中禁用相同的方法名称！");
                }
                m = m_t;
            }
        }
        if(m==null){
            throw new RuntimeException("未找到对应的方法method["+id+"]");
        }
        class_methodMap.put(id,m);
        return m;
    }
}
