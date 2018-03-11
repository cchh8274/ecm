package pipe.impl.meta;

/**
 * Created by baolong on 2016/8/23.
 */
public enum SQLTYPE {
    INT,BIGINT,NUMBER,DECIMAL,CHAR,VARCHAR,TINYBLOB,BLOB,MEDIUMBLOB,LONGBLOB;
    //##################################################################################
    //                        ORACLE              MYSQL             DB2             SQLITE
    //Integer                 NUMBER(9)           int             INTEGER             int
    //Long                    NUMBER(17)          bigint          BIGINT              bigint
    //BigDecimal              NUMBER(18)          decimal(18)     DECIMAL(18)         decimal(18)
    //String                  CHAR,VARCHAR2       char,varchar    CHAR,VARCHAR        char,varchar
    //byte[]                  BLOB                longblob        BLOB                blob
    //##################################################################################
    //数据库设计规范：        ORACLE              MYSQL             DB2             SQLITE
    //BLOB块                  BLOB                LONGBLOB        BLOB                BLOB
    //CHAR1                   CHAR(1)             char(1)         CHAR(1)             char(1)
    //CHAR2                   CHAR(2)             char(2)         CHAR(2)             char(2)
    //CHAR3                   CHAR(3)             char(3)         CHAR(3)             char(3)
    //CHAR4                   CHAR(4)             char(4)         CHAR(4)             char(4)
    //CHAR8                   CHAR(8)             char(8)         CHAR(8)             char(8)
    //CHAR36                  CHAR(36)            char(36)        CHAR(36)            char(36)
    //保留域                  VARCHAR2(256)       varchar(256)    VARCHAR(256)        varchar(256)
    //int                     NUMBER(9)           int(11)         INTEGER             int(11)
    //long                    NUMBER(17)          bigint          BIGINT              bigint
    //文本0008-标志           VARCHAR2(8)         varchar(8)      VARCHAR(8)          varchar(8)
    //文本0032-名字           VARCHAR2(32)        varchar(32)     VARCHAR(32)         varchar(32)
    //文本0064-名字           VARCHAR2(64)        varchar(64)     VARCHAR(64)         varchar(64)
    //文本0128-名字           VARCHAR2(128)       varchar(128)    VARCHAR(128)        varchar(128)
    //文本0256-描述           VARCHAR2(256)       varchar(256)    VARCHAR(256)        varchar(256)
    //文本0512-地址           VARCHAR2(512)       varchar(512)    VARCHAR(512)        varchar(512)
    //文本2000-内容           VARCHAR2(2000)      varchar(2000)   VARCHAR(2000)       varchar(2000)
    //日期yyyymmdd            CHAR(8)             char(8)         CHAR(8)             char(8)
    //时间yyyymmddhh24miss    CHAR(14)            char(14)        CHAR(14)            char(14)
    //表ID-long               NUMBER(17)          bigint          BIGINT              bigint
    //表单号                  VARCHAR2(50)        varchar(50)     VARCHAR(50)         varchar(50)
    //金额16-2                NUMBER(16,2)        decimal(16,2)   DECIMAL(16,2)       decimal(16,2)
    //金额_分                 NUMBER(18)          decimal(18)     DECIMAL(18)         decimal(18)
    public static SQLTYPE getSqlType(String name){
        if(name.equals("INT"))return SQLTYPE.INT;
        if(name.equals("BIGINT"))return SQLTYPE.BIGINT;
        if(name.equals("DECIMAL"))return SQLTYPE.DECIMAL;
        if(name.equals("NUMBER"))return SQLTYPE.NUMBER;
        if(name.equals("CHAR"))return SQLTYPE.CHAR;
        if(name.equals("VARCHAR"))return SQLTYPE.VARCHAR;
        if(name.equals("VARCHAR2"))return SQLTYPE.VARCHAR;
        if(name.equals("TINYBLOB"))return SQLTYPE.TINYBLOB;
        if(name.equals("BLOB"))return SQLTYPE.BLOB;
        if(name.equals("MEDIUMBLOB"))return SQLTYPE.MEDIUMBLOB;
        if(name.equals("LONGBLOB"))return SQLTYPE.LONGBLOB;
        return null;
    }
}
