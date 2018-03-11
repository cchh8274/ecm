package cn.kanmars.ecm.lock;

import cn.com.xbase.frame.util.StringUtils;
import cn.com.xbase.tools.idgen.IDGeneratorTools;
import cn.kanmars.ecm.cache.RedisCache;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 依赖于Redis的全局分布式锁
 * 实现了独占锁、锁定一段时间的功能
 * 应用场景：定时任务执行某个定时任务时:
 *  1)初始化一个GlobalRedisReentrantLock redisLock = new GlobalRedisReentrantLock(orderNo,redisCache)创建一个锁
 *  2)使用redisLock.tryLockSomeSecond(15*60)根据订单号进行锁定记录15分钟；
 *  2)在logic中校验记录状态（防止解锁后多次执行）
 *  3)任务执行完成后在final块中解锁redisLock.unLock()进行解锁
 * Created by kanmars on 2017/10/11.
 */
public class GlobalRedisReentrantLock{

    public static final String REDIS_PREFIX = "REDIS_PREFIX_LOCK_";

    private String key;
    private RedisCache redisCache;
    private ThreadLocal<String> operatorName = new ThreadLocal<String>();

    public GlobalRedisReentrantLock(String key, RedisCache redisCache) {
        this.key = key;
        this.redisCache = redisCache;
        setOperatorName(IDGeneratorTools.createSimpleLong()+"");
    }

    /**
     * 设置操作者名称，如果操作者名称相同，
     * 则两个不同线程或者不同调用者的操作结果是完全一致的
     * @param operatorName
     */
    public void setOperatorName(String operatorName){
        this.operatorName.set(operatorName);
    }

    /**
     * 是否公平锁
     * @return
     */
    public boolean isFair(){
        //默认公平锁，无抢占
        return true;
    }

    /**
     * 尝试锁定，立即返回，返回结果为是否锁定成功
     * 锁定时间为永久，可以重复调用，如果之前已被有时间属性的lock锁定，时间变更为永久锁定
     * @return
     */
    public boolean tryLock(){
        String operatorName = this.operatorName.get();
        //判断锁是否已被锁定
        String ownerName = getOwnerName();
        if(operatorName.equals(ownerName)){
            //如果已被自己锁定，则返回成功
            return true;
        }
        //如果没有被自己锁定，则尝试加锁
        redisCache.rpush(GlobalRedisReentrantLock.REDIS_PREFIX+key,operatorName);
        //再次判断锁是否已被锁定
        ownerName = redisCache.lindex(GlobalRedisReentrantLock.REDIS_PREFIX+key,0);
        if(StringUtils.isNotEmpty(ownerName)&&ownerName.equals(operatorName)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 尝试锁定一段时间，立即返回，返回结果为是否锁定成功
     * 锁定时间为参数传入，可以重复调用，如果之前已被有时间属性的lock锁定，时间属性会更新
     * 如果l为0或者时间小于1秒，则
     * @return
     */
    public boolean tryLockSomeSecond(int second){
        if(second<1){throw new RuntimeException("锁定时间不能小于1秒");}
        String operatorName = this.operatorName.get();
        redisCache.rpush(GlobalRedisReentrantLock.REDIS_PREFIX+key,operatorName);
        String ownerName = getOwnerName();
        if(StringUtils.isNotEmpty(ownerName)&&ownerName.equals(operatorName)){
            redisCache.expire(GlobalRedisReentrantLock.REDIS_PREFIX+key,second);
            return true;
        }else{
            return false;
        }
    }

    /**
     * 尝试解锁定，立即返回，可多次调用
     * @return
     */
    public void unLock(){
        String operatorName = this.operatorName.get();
        String ownerName = getOwnerName();
        if(StringUtils.isNotEmpty(ownerName)&&ownerName.equals(operatorName)){//ownerName可能为null
            redisCache.del(GlobalRedisReentrantLock.REDIS_PREFIX+key);
        }else{
            //存在但并非自身创建的，或者不存在，因此不删除
            return;
        }
    }

    public String getOwnerName(){
        if(redisCache.exists(GlobalRedisReentrantLock.REDIS_PREFIX+key)){
            String ownerName = redisCache.lindex(GlobalRedisReentrantLock.REDIS_PREFIX+key,0);
            return ownerName;
        }else{
            return null;
        }
    }

    public boolean isLocked(){
        if(StringUtils.isNotEmpty(getOwnerName())){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        //初始化RedisCache，或者从Spring的AutoConf中注入，设置host和port和businessType
        RedisCache redisCache = new RedisCache();
        redisCache.setHost("");
        redisCache.setPort(1);
        redisCache.setBusinessType("");

        GlobalRedisReentrantLock globalRedisReentrantLock = new GlobalRedisReentrantLock(
                "this is a key for example:orderNo,tansNo and so on",
                redisCache
        );
        //尝试锁定
        if(globalRedisReentrantLock.tryLock()){
            globalRedisReentrantLock.tryLock();//以线程为单位，可以重复锁定，对既有结果不影响
            globalRedisReentrantLock.tryLock();//以线程为单位，可以重复锁定，对既有结果不影响
            globalRedisReentrantLock.tryLock();//以线程为单位，可以重复锁定，对既有结果不影响
            globalRedisReentrantLock.tryLock();//以线程为单位，可以重复锁定，对既有结果不影响
            globalRedisReentrantLock.tryLock();//以线程为单位，可以重复锁定，对既有结果不影响
            System.out.println("锁定成功");
        }else{
            System.out.println("锁定失败");
        }
        if(globalRedisReentrantLock.tryLockSomeSecond(3600)){
            globalRedisReentrantLock.tryLockSomeSecond(3600);//以线程为单位，可以重复锁定，锁定并更新时间
            globalRedisReentrantLock.tryLockSomeSecond(3600);//以线程为单位，可以重复锁定，锁定并更新时间
            globalRedisReentrantLock.tryLockSomeSecond(3600);//以线程为单位，可以重复锁定，锁定并更新时间
            globalRedisReentrantLock.tryLockSomeSecond(3600);//以线程为单位，可以重复锁定，锁定并更新时间
            System.out.println("锁定3600秒成功");
        }else{
            System.out.println("锁定3600秒失败");
        }
        //尝试解锁
        globalRedisReentrantLock.unLock();

    }

}
