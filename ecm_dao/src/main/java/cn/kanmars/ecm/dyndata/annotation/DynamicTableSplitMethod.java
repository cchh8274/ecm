package cn.kanmars.ecm.dyndata.annotation;

import java.lang.annotation.*;

/**
 * Created by kanmars on 2017/5/9.
 * 该注解只能用在Dao层的Method上，并且需要在xml中配置@TableSplitor@用于动态分表
 */
@Target({ ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DynamicTableSplitMethod {
    /**
     * 作为分表key的参数的索引，从0开始
     * @return
     */
    int[] splitKeyIndex() default {};

    /**
     * 需要指定DynamicTableSplitor的实现类，用于将分表key转化为一个表的后缀
     * @return
     */
    String suffixBeanName();
}
