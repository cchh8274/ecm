package exec;

import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数据库模式转换器，作用为将DAO层的Mapper文件转化为指定的数据库形式
 * 支持:
 *  1、MYSQL->ORACLE
 *  2、MYSQL->DB2
 *  3、MYSQL->SQLITE
 *  4、ORACLE->MYSQL
 *  5、DB2->MYSQL
 *  6、SQLITE->MYSQL
 * Created by kanmars on 2017/8/28.
 */
public class DBTypeTrans {
    public static final String MODE_MYSQL_TO_ORACLE = "MYSQL->ORACLE";
    public static final String MODE_MYSQL_TO_DB2 = "MYSQL->DB2";
    public static final String MODE_MYSQL_TO_SQLITE = "MYSQL->SQLITE";
    public static final String MODE_ORACLE_TO_MYSQL = "ORACLE->MYSQL";
    public static final String MODE_DB2_TO_MYSQL = "DB2->MYSQL";
    public static final String MODE_SQLITE_TO_MYSQL = "SQLITE->MYSQL";
    public static void main(String[] args) throws IOException {
        String targetDir = "E:\\code\\ecm\\branches\\ecm_parent_0.1.0_BR\\ecm_dao\\src\\main\\resources\\props\\ecm\\mapper";
        String mode = MODE_MYSQL_TO_ORACLE;
        dbTypeTrans(targetDir,mode);
    }

    public static void dbTypeTrans(String targetDir,String mode) throws IOException {
        iteratorFile(targetDir,mode);
    }

    public static void iteratorFile(String targetDir,String mode)
            throws IOException {
        // 获取目标文件夹当前下的文件或目录
        File[] file = (new File(targetDir)).listFiles();
        for (int i = 0; i < file.length; i++) {
            if (file[i].isFile()) {
                // 源文件
                File sourceFile = file[i];
                String filename = sourceFile.getCanonicalPath();
                if(filename.toLowerCase().endsWith(".xml")){
                    //是xml文件
                    String tmpFilename = filename+".tmp";
                    String fileContent = "";
                    String tmp = "";
                    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"utf-8"));
                    while((tmp=br.readLine())!=null){
                        fileContent += tmp;
                        fileContent += "\r\n";
                    }
                    br.close();
                    if(mode.equalsIgnoreCase(MODE_MYSQL_TO_ORACLE)){
                        fileContent = transContent_MYSQL_TO_ORACLE(fileContent);
                    }
                    if(mode.equalsIgnoreCase(MODE_MYSQL_TO_DB2)){
                        fileContent = transContent_MYSQL_TO_DB2(fileContent);
                    }
                    if(mode.equalsIgnoreCase(MODE_MYSQL_TO_SQLITE)){
                        fileContent = transContent_MYSQL_TO_SQLITE(fileContent);
                    }
                    if(mode.equalsIgnoreCase(MODE_ORACLE_TO_MYSQL)){
                        fileContent = transContent_ORACLE_TO_MYSQL(fileContent);
                    }
                    if(mode.equalsIgnoreCase(MODE_DB2_TO_MYSQL)){
                        fileContent = transContent_DB2_TO_MYSQL(fileContent);
                    }
                    if(mode.equalsIgnoreCase(MODE_SQLITE_TO_MYSQL)){
                        fileContent = transContent_SQLITE_TO_MYSQL(fileContent);
                    }

                    PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(tmpFilename),"utf-8"));
                    pw.write(fileContent);
                    pw.close();
                    new File(filename).delete();
                    new File(tmpFilename).renameTo(new File(filename));
                }
            }
            if (file[i].isDirectory()) {
                iteratorFile(file[i].getCanonicalPath(), mode);
            }
        }
    }

    public static String transContent_MYSQL_TO_ORACLE(String content){
        //MYSQL修改为ORACLE，需要修改queryForPage，insertBatch，updateBatch语句
        //queryForPage
        content = content.replaceAll(
                "<if *test=\\\"countFlag *!= *null *and *countFlag *== *'Y'.toString\\(\\) *\\\">\r\n\\ *select *count\\(1\\) *as *TOTALCOUNT *from *\\(\r\n\\ *</if>"
                ,	"<if test=\\\"countFlag != null and countFlag == 'Y'.toString\\(\\) \\\">\r\n        select count\\(1\\) as TOTALCOUNT from \\(\r\n        </if>\r\n"
                        +"        <if test=\"countFlag != null and countFlag == 'N'.toString() \">\r\n"
                        +"        <![CDATA[ select * from ( select interTable.*,rownum rn from ( ]]>\r\n"
                        +"        </if>"
        );
        content = content.replaceAll(
                "<if *test=\\\"countFlag *!= *null *and *countFlag *== *'N'.toString\\(\\) *\\\">\r\n\\ *limit #\\{limitStart,jdbcType=DECIMAL\\},#\\{limitSize,jdbcType=DECIMAL\\}\r\n\\ *</if>"
                ,	"<if test=\\\"countFlag != null and countFlag == 'N'.toString\\(\\) \\\">\r\n        ) interTable where rownum &lt;= #{limitStart,jdbcType=DECIMAL}+#{limitSize,jdbcType=DECIMAL}\r\n        </if>"
                +   "<if test=\\\"countFlag != null and countFlag == 'N'.toString\\(\\) \\\">\r\n        ) outerTable where outerTable.rn > #{limitStart,jdbcType=DECIMAL}\r\n        </if>"
        );
        content = content.replaceAll(
                "<if *test=\\\"countFlag *!= *null *and *countFlag *== *'Y'.toString\\(\\) *\\\">\r\n\\ *\\) as TMP_COUNT_TABLE\r\n\\ *</if>"
                ,	"<if test=\\\"countFlag != null and countFlag == 'Y'.toString() \\\">\r\n        ) TMP_COUNT_TABLE\r\n        </if>"
        );
        //insertBatch
        content = content.replaceAll(
                "\r\n *<foreach collection=\\\"list\\\" item=\\\"item\\\" index=\\\"index\\\" open=\\\"\\(\\\" close=\\\"\\)\\\" separator=\\\"\\),\\(\\\">\r\n *","(");
        content = content.replaceAll(
                "(\r\n)        </foreach>(\r\n)*\\ *</insert>",
                ")\r\n        </foreach>\r\n    </insert>"
        );
        content = content.replaceAll(
                "\r\n    <insert id=\\\"insertBatch\\\"  parameterType=\\\"java.util.List\\\"> *\r\n *",
                "\r\n    <insert id=\"insertBatch\"  parameterType=\"java.util.List\">\r\n        <foreach collection=\"list\" item=\"item\" index=\"index\" open=\"begin\" close=\"end;\" separator=\";\">\r\n            "
        );
        //updateBatch
        content = content.replaceAll(
                "\r\n    <update id=\\\"updateBatch\\\" parameterType=\\\"java.util.List\\\" >\r\n *<foreach collection=\\\"list\\\" item=\\\"item\\\" index=\\\"index\\\" open=\\\"\\\" close=\\\"\\\" separator=\\\";\\\">",
                "\r\n    <update id=\"updateBatch\" parameterType=\"java.util.List\" >\r\n        <foreach collection=\"list\" item=\"item\" index=\"index\" open=\"begin\" close=\"end;\" separator=\";\">"
        );
        return content;
    }
    public static String transContent_MYSQL_TO_DB2(String content){
        //MYSQL修改为DB2，需要修改queryForPage语句
        //queryForPage
        content = content.replaceAll(
                "<if *test=\\\"countFlag *!= *null *and *countFlag *== *'Y'.toString\\(\\) *\\\">\r\n\\ *select *count\\(1\\) *as *TOTALCOUNT *from *\\(\r\n\\ *</if>"
                ,	"<if test=\\\"countFlag != null and countFlag == 'Y'.toString\\(\\) \\\">\r\n        select count\\(1\\) as TOTALCOUNT from \\(\r\n        </if>\r\n"
                        +"        <if test=\"countFlag != null and countFlag == 'N'.toString() \">\r\n"
                        +"        <![CDATA[ select * from ( select interTable.*,ROW_NUMBER() OVER () as ROWNUM from (  ]]>\r\n"
                        +"        </if>"
        );
        content = content.replaceAll(
                "<if *test=\\\"countFlag *!= *null *and *countFlag *== *'N'.toString\\(\\) *\\\">\r\n\\ *limit #\\{limitStart,jdbcType=DECIMAL\\},#\\{limitSize,jdbcType=DECIMAL\\}\r\n\\ *</if>"
                ,	"<if test=\\\"countFlag != null and countFlag == 'N'.toString\\(\\) \\\">\r\n        ) interTable )where ROWNUM &gt;#{limitStart,jdbcType=DECIMAL} and ROWNUM &lt;= #{limitStart,jdbcType=DECIMAL}+#{limitSize,jdbcType=DECIMAL}\r\n        </if>"
        );
        content = content.replaceAll(
                "<if *test=\\\"countFlag *!= *null *and *countFlag *== *'Y'.toString\\(\\) *\\\">\r\n\\ *\\) as TMP_COUNT_TABLE\r\n\\ *</if>"
                ,	"<if test=\\\"countFlag != null and countFlag == 'Y'.toString() \\\">\r\n        ) TMP_COUNT_TABLE\r\n        </if>"
        );
        return content;
    }
    public static String transContent_MYSQL_TO_SQLITE(String content){
        //MYSQL修改为SQLITE，需要修改CONCAT函数
        //将CONCAT(#{l1Code,jdbcType=VARCHAR},'%')修改为#{l1Code,jdbcType=VARCHAR}||'%'，其他不变
        Pattern p = Pattern.compile("CONCAT\\(([^\\)]*)\\)");
        Matcher m = p.matcher(content);
        while(m.find()){
            String str = m.group(0);
            String innerCode = m.group(1);//#{l1Code,jdbcType=VARCHAR},'%'
            String replacestr = str;
            String newStr = innerCode.substring(0,innerCode.lastIndexOf(","))+"||'%'";
            content = content.replace(replacestr, newStr);
        }
        return content;
    }
    public static String transContent_ORACLE_TO_MYSQL(String content){
        //TODO 待补充
        if(1==1)throw new RuntimeException("该格式转换尚不支持");
        return content;
    }
    public static String transContent_DB2_TO_MYSQL(String content){
        //TODO 待补充
        if(1==1)throw new RuntimeException("该格式转换尚不支持");
        return content;
    }
    public static String transContent_SQLITE_TO_MYSQL(String content){
        //TODO 待补充
        if(1==1)throw new RuntimeException("该格式转换尚不支持");
        return content;
    }


}
