package cn.kanmars.ecm.appno;

import cn.com.xbase.frame.util.DateUtils;
import cn.com.xbase.frame.util.StringUtils;
import cn.kanmars.ecm.cache.RedisCache;

/**
 * 基于redis的流水号生成器，可以实现按天生成从1开始的连续流水号
 * 使用时需要：
 * 1）在spring的autoConf中注入redisCache
 * 2）调用ApplicationNoCreator的静态方法
 * Created by kanmars on 2017/10/11.
 */
public class ApplicationNoCreator {

    public static final String REDIS_PREFIX = "REDIS_PREFIX_APPNO_";

    private static RedisCache redisCache;

    private static RedisCache getRedisCache() {
        return redisCache;
    }

    public static void setRedisCache(RedisCache redisCache) {
        ApplicationNoCreator.redisCache = redisCache;
    }

    /**
     * 检查redis是否已设置
     */
    private static void checkRedisCache(){
        if(ApplicationNoCreator.redisCache==null){throw new RuntimeException("使用ApplicationNoCreator时必须设置redisCache!");}
    }

    /**
     * 创建一个applicationNo，每天都从1开始
     * @param appType   业务类型
     * @return
     */
    public static long createApplicationNo(String appType){
        checkRedisCache();
        String key = REDIS_PREFIX+DateUtils.getCurrDate()+"_"+appType;
        long result = redisCache.incr(key);
        return result;
    }

    /**
     * 创建一个指定格式的applicationNo，每天都从1开始
     * @param appType   业务类型
     * @param prefix    前缀
     * @param suffix    后缀
     * @param filler    字符填充
     * @param numLength 数字区域长度
     * @param atEnd     字符填充的位置
     * @return
     */
    public static String createApplicationNo(String appType,String prefix,String suffix, char filler, int numLength, boolean atEnd){
        long applicationNo = createApplicationNo(appType);
        StringBuilder sb = new StringBuilder();
        sb.append(prefix)
                .append(StringUtils.fillString(applicationNo+"",filler,numLength,atEnd))
                .append(suffix);
        return sb.toString();
    }

    /**
     * 创建一个指定格式的applicationNo，每天都从1开始
     * @param appType   业务类型
     * @param filler    字符填充
     * @param numLength 数字区域长度
     * @param atEnd     字符填充的位置
     * @return
     */
    public static String createApplicationNo(String appType,char filler, int numLength, boolean atEnd){
        long appno = createApplicationNo(appType);
        return StringUtils.fillString(appno+"",filler,numLength,atEnd);
    }

    public static void main(String[] args) {
        //初始化RedisCache，或者从Spring的AutoConf中注入，设置host和port和businessType
        RedisCache redisCache = new RedisCache();
        redisCache.setHost("");
        redisCache.setPort(1);
        redisCache.setBusinessType("");
        ApplicationNoCreator.setRedisCache(redisCache);
        for(int i=0;i<1000;i++){
            System.out.println(ApplicationNoCreator.createApplicationNo("BYSOMEORDER"));
        }
    }
}
