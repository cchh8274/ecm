package pipe.unionimpl;

import context.Context;
import exec.Generator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pipe.Pipe;
import utils.FileUtils;
import utils.FormatUtils;
import utils.StringUtils;
import utils.TypeUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by baolong on 2017/2/27.
 */
public class Create_012_Dao implements Pipe {

    public void exec(Context c) throws Exception {
        //创建文件夹
        if(!FileUtils.mkdirs((String) c.get(Context.PATH_DAO))){
            throw new Exception("文件夹["+(String)c.get(Context.PATH_DAO)+"]创建不成功");
        }
        String tableName = (String)c.get(Context.CURR_TABLE);
        String entityClassName = FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(tableName));
        String className = "Union"+FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(tableName))+"Mapper";
        String fileName = className+".java";
        File entityFile = new File((String)c.get(Context.PATH_DAO) + File.separator+fileName);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(entityFile),(String)c.get(Context.FILE_CHARSET)));

        //准备内容
        StringBuilder sb = new StringBuilder();
        sb.append("/**\r\n * ecm Generator \r\n */\r\n");
        sb.append("package "+(String)c.get(Context.PACKAGE_DAO)+";").append("\r\n").append("\r\n").append("\r\n");
        //增加import
        sb.append("import java.util.List;").append("\r\n");
        sb.append("import java.util.HashMap;").append("\r\n");

        //增加类注释
        sb.append("/**").append("\r\n");
        sb.append(" * "+(String)c.get(Context.CURR_TABLE_COMMENT)).append("\r\n");
        sb.append(" * "+(String)c.get(Context.CURR_TABLE)).append("\r\n");
        sb.append(" */").append("\r\n");

        //增加标签
        List<String> annotation_entity_list = (List)c.get(Context.ANNOTATION_DAO);
        if(annotation_entity_list!=null){
            for (String s : annotation_entity_list){
                sb.append("@"+s).append("\r\n");
            }
        }
        //增加类名
        sb.append("public interface " + className + " ");
        String extendsClass = (String)c.get(Context.EXTENDS_DAO);
        if(!StringUtils.isEmpty(extendsClass)){
            sb.append("extends " + extendsClass+ " ");
        }

        //增加接口
        List<String> implements_entity_list = (List)c.get(Context.IMPLEMENTS_DAO);
        if(implements_entity_list!=null){
            sb.append("implements ");
            for (int i=0;i<implements_entity_list.size();i++){
                sb.append("" + implements_entity_list.get(i));
                if (i!=implements_entity_list.size()-1){
                    sb.append(",");
                }
            }
        }
        sb.append("{").append("\r\n");

        sb.append("    /**").append("\r\n");
        sb.append("     * 分页查询").append("\r\n");
        sb.append("     * 参数有两种情况：").append("\r\n");
        sb.append("     *     1、传递countFlag=Y标记,则返回的是计数").append("\r\n");
        sb.append("     *     2、传递countFlag=N标记、limitStart、limitSize,则返回的是分页结果,字段未驼峰化").append("\r\n");
        sb.append("     */").append("\r\n");
        sb.append("    public List<HashMap> queryForPage(HashMap paramMap);").append("\r\n");
        sb.append("}").append("\r\n");
        pw.println(sb.toString());
        pw.close();
    }
}
