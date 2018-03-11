package cn.kanmars.ecm.cache;

import redis.clients.jedis.*;
import redis.clients.jedis.params.geo.GeoRadiusParam;
import redis.clients.jedis.params.sortedset.ZAddParams;
import redis.clients.jedis.params.sortedset.ZIncrByParams;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by kanmars on 2017/9/8.
 */
public class RedisCache implements JedisCommands {
    private String host;
    private int port;
    private String businessType;

    private static Jedis jedis;

    public RedisCache(){

    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    private Jedis getJedisInstance(){
        //选择算法，需要按具体业务实现，可以根据BusinessType，进而指定具体的jedis
        if(jedis==null){
            jedis = new Jedis(host,port);
        }
        return jedis;
    }

    @Override
    public String set(String s, String s1) {
        return getJedisInstance().set(s,s1);
    }

    @Override
    public String set(String s, String s1, String s2, String s3, long l) {
        return getJedisInstance().set(s,s1,s2,s3,l);
    }

    @Override
    public String set(String s, String s1, String s2) {
        return getJedisInstance().set(s,s1,s2);
    }

    @Override
    public String get(String s) {
        return getJedisInstance().get(s);
    }

    @Override
    public Boolean exists(String s) {
        return getJedisInstance().exists(s);
    }

    @Override
    public Long persist(String s) {
        return getJedisInstance().persist(s);
    }

    @Override
    public String type(String s) {
        return getJedisInstance().type(s);
    }

    @Override
    public Long expire(String s, int i) {
        return getJedisInstance().expire(s,i);
    }

    @Override
    public Long pexpire(String s, long l) {
        return getJedisInstance().pexpire(s,l);
    }

    @Override
    public Long expireAt(String s, long l) {
        return getJedisInstance().expireAt(s,l);
    }

    @Override
    public Long pexpireAt(String s, long l) {
        return getJedisInstance().pexpireAt(s,l);
    }

    @Override
    public Long ttl(String s) {
        return getJedisInstance().ttl(s);
    }

    @Override
    public Long pttl(String s) {
        return getJedisInstance().pttl(s);
    }

    @Override
    public Boolean setbit(String s, long l, boolean b) {
        return getJedisInstance().setbit(s,l,b);
    }

    @Override
    public Boolean setbit(String s, long l, String s1) {
        return getJedisInstance().setbit(s,l,s1);
    }

    @Override
    public Boolean getbit(String s, long l) {
        return getJedisInstance().getbit(s,l);
    }

    @Override
    public Long setrange(String s, long l, String s1) {
        return getJedisInstance().setrange(s,l,s1);
    }

    @Override
    public String getrange(String s, long l, long l1) {
        return getJedisInstance().getrange(s,l,l1);
    }

    @Override
    public String getSet(String s, String s1) {
        return getJedisInstance().getSet(s,s1);
    }

    @Override
    public Long setnx(String s, String s1) {
        return getJedisInstance().setnx(s,s1);
    }

    @Override
    public String setex(String s, int i, String s1) {
        return getJedisInstance().setex(s,i,s1);
    }

    @Override
    public String psetex(String s, long l, String s1) {
        return getJedisInstance().psetex(s,l,s1);
    }

    @Override
    public Long decrBy(String s, long l) {
        return getJedisInstance().decrBy(s,l);
    }

    @Override
    public Long decr(String s) {
        return getJedisInstance().decr(s);
    }

    @Override
    public Long incrBy(String s, long l) {
        return getJedisInstance().incrBy(s,l);
    }

    @Override
    public Double incrByFloat(String s, double v) {
        return getJedisInstance().incrByFloat(s,v);
    }

    @Override
    public Long incr(String s) {
        return getJedisInstance().incr(s);
    }

    @Override
    public Long append(String s, String s1) {
        return getJedisInstance().append(s,s1);
    }

    @Override
    public String substr(String s, int i, int i1) {
        return getJedisInstance().substr(s,i,i1);
    }

    @Override
    public Long hset(String s, String s1, String s2) {
        return getJedisInstance().hset(s,s1,s2);
    }

    @Override
    public String hget(String s, String s1) {
        return getJedisInstance().hget(s,s1);
    }

    @Override
    public Long hsetnx(String s, String s1, String s2) {
        return getJedisInstance().hsetnx(s,s1,s2);
    }

    @Override
    public String hmset(String s, Map<String, String> map) {
        return getJedisInstance().hmset(s,map);
    }

    @Override
    public List<String> hmget(String s, String... strings) {
        return getJedisInstance().hmget(s,strings);
    }

    @Override
    public Long hincrBy(String s, String s1, long l) {
        return getJedisInstance().hincrBy(s,s1,l);
    }

    @Override
    public Double hincrByFloat(String s, String s1, double v) {
        return getJedisInstance().hincrByFloat(s,s1,v);
    }

    @Override
    public Boolean hexists(String s, String s1) {
        return getJedisInstance().hexists(s,s1);
    }

    @Override
    public Long hdel(String s, String... strings) {
        return getJedisInstance().hdel(s,strings);
    }

    @Override
    public Long hlen(String s) {
        return getJedisInstance().hlen(s);
    }

    @Override
    public Set<String> hkeys(String s) {
        return getJedisInstance().hkeys(s);
    }

    @Override
    public List<String> hvals(String s) {
        return getJedisInstance().hvals(s);
    }

    @Override
    public Map<String, String> hgetAll(String s) {
        return getJedisInstance().hgetAll(s);
    }

    @Override
    public Long rpush(String s, String... strings) {
        return getJedisInstance().rpush(s,strings);
    }

    @Override
    public Long lpush(String s, String... strings) {
        return getJedisInstance().lpush(s,strings);
    }

    @Override
    public Long llen(String s) {
        return getJedisInstance().llen(s);
    }

    @Override
    public List<String> lrange(String s, long l, long l1) {
        return getJedisInstance().lrange(s,l,l1);
    }

    @Override
    public String ltrim(String s, long l, long l1) {
        return getJedisInstance().ltrim(s,l,l1);
    }

    @Override
    public String lindex(String s, long l) {
        return getJedisInstance().lindex(s,l);
    }

    @Override
    public String lset(String s, long l, String s1) {
        return getJedisInstance().lset(s,l,s1);
    }

    @Override
    public Long lrem(String s, long l, String s1) {
        return getJedisInstance().lrem(s,l,s1);
    }

    @Override
    public String lpop(String s) {
        return getJedisInstance().lpop(s);
    }

    @Override
    public String rpop(String s) {
        return getJedisInstance().rpop(s);
    }

    @Override
    public Long sadd(String s, String... strings) {
        return getJedisInstance().sadd(s,strings);
    }

    @Override
    public Set<String> smembers(String s) {
        return getJedisInstance().smembers(s);
    }

    @Override
    public Long srem(String s, String... strings) {
        return getJedisInstance().srem(s,strings);
    }

    @Override
    public String spop(String s) {
        return getJedisInstance().spop(s);
    }

    @Override
    public Set<String> spop(String s, long l) {
        return getJedisInstance().spop(s,l);
    }

    @Override
    public Long scard(String s) {
        return getJedisInstance().scard(s);
    }

    @Override
    public Boolean sismember(String s, String s1) {
        return getJedisInstance().sismember(s,s1);
    }

    @Override
    public String srandmember(String s) {
        return getJedisInstance().srandmember(s);
    }

    @Override
    public List<String> srandmember(String s, int i) {
        return getJedisInstance().srandmember(s,i);
    }

    @Override
    public Long strlen(String s) {
        return getJedisInstance().strlen(s);
    }

    @Override
    public Long zadd(String s, double v, String s1) {
        return getJedisInstance().zadd(s,v,s1);
    }

    @Override
    public Long zadd(String s, double v, String s1, ZAddParams zAddParams) {
        return getJedisInstance().zadd(s,v,s1,zAddParams);
    }

    @Override
    public Long zadd(String s, Map<String, Double> map) {
        return getJedisInstance().zadd(s,map);
    }

    @Override
    public Long zadd(String s, Map<String, Double> map, ZAddParams zAddParams) {
        return getJedisInstance().zadd(s,map,zAddParams);
    }

    @Override
    public Set<String> zrange(String s, long l, long l1) {
        return getJedisInstance().zrange(s,l,l1);
    }

    @Override
    public Long zrem(String s, String... strings) {
        return getJedisInstance().zrem(s,strings);
    }

    @Override
    public Double zincrby(String s, double v, String s1) {
        return getJedisInstance().zincrby(s,v,s1);
    }

    @Override
    public Double zincrby(String s, double v, String s1, ZIncrByParams zIncrByParams) {
        return getJedisInstance().zincrby(s,v,s1,zIncrByParams);
    }

    @Override
    public Long zrank(String s, String s1) {
        return getJedisInstance().zrank(s,s1);
    }

    @Override
    public Long zrevrank(String s, String s1) {
        return getJedisInstance().zrevrank(s,s1);
    }

    @Override
    public Set<String> zrevrange(String s, long l, long l1) {
        return getJedisInstance().zrevrange(s,l,l1);
    }

    @Override
    public Set<Tuple> zrangeWithScores(String s, long l, long l1) {
        return getJedisInstance().zrangeWithScores(s,l,l1);
    }

    @Override
    public Set<Tuple> zrevrangeWithScores(String s, long l, long l1) {
        return getJedisInstance().zrevrangeWithScores(s,l,l1);
    }

    @Override
    public Long zcard(String s) {
        return getJedisInstance().zcard(s);
    }

    @Override
    public Double zscore(String s, String s1) {
        return getJedisInstance().zscore(s,s1);
    }

    @Override
    public List<String> sort(String s) {
        return getJedisInstance().sort(s);
    }

    @Override
    public List<String> sort(String s, SortingParams sortingParams) {
        return getJedisInstance().sort(s,sortingParams);
    }

    @Override
    public Long zcount(String s, double v, double v1) {
        return getJedisInstance().zcount(s,v,v1);
    }

    @Override
    public Long zcount(String s, String s1, String s2) {
        return getJedisInstance().zcount(s,s1,s2);
    }

    @Override
    public Set<String> zrangeByScore(String s, double v, double v1) {
        return getJedisInstance().zrangeByScore(s,v,v1);
    }

    @Override
    public Set<String> zrangeByScore(String s, String s1, String s2) {
        return getJedisInstance().zrangeByScore(s,s1,s2);
    }

    @Override
    public Set<String> zrevrangeByScore(String s, double v, double v1) {
        return getJedisInstance().zrevrangeByScore(s,v,v1);
    }

    @Override
    public Set<String> zrangeByScore(String s, double v, double v1, int i, int i1) {
        return getJedisInstance().zrangeByScore(s,v,v1,i,i1);
    }

    @Override
    public Set<String> zrevrangeByScore(String s, String s1, String s2) {
        return getJedisInstance().zrevrangeByScore(s,s1,s2);
    }

    @Override
    public Set<String> zrangeByScore(String s, String s1, String s2, int i, int i1) {
        return getJedisInstance().zrangeByScore(s,s1,s2,i,i1);
    }

    @Override
    public Set<String> zrevrangeByScore(String s, double v, double v1, int i, int i1) {
        return getJedisInstance().zrevrangeByScore(s,v,v1,i,i1);
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(String s, double v, double v1) {
        return getJedisInstance().zrangeByScoreWithScores(s,v,v1);
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(String s, double v, double v1) {
        return getJedisInstance().zrevrangeByScoreWithScores(s,v,v1);
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(String s, double v, double v1, int i, int i1) {
        return getJedisInstance().zrangeByScoreWithScores(s,v,v1,i,i1);
    }

    @Override
    public Set<String> zrevrangeByScore(String s, String s1, String s2, int i, int i1) {
        return getJedisInstance().zrevrangeByScore(s,s1,s2,i,i1);
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(String s, String s1, String s2) {
        return getJedisInstance().zrangeByScoreWithScores(s,s1,s2);
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(String s, String s1, String s2) {
        return getJedisInstance().zrevrangeByScoreWithScores(s,s1,s2);
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(String s, String s1, String s2, int i, int i1) {
        return getJedisInstance().zrangeByScoreWithScores(s,s1,s2,i,i1);
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(String s, double v, double v1, int i, int i1) {
        return getJedisInstance().zrevrangeByScoreWithScores(s,v,v1,i,i1);
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(String s, String s1, String s2, int i, int i1) {
        return getJedisInstance().zrevrangeByScoreWithScores(s,s1,s2,i,i1);
    }

    @Override
    public Long zremrangeByRank(String s, long l, long l1) {
        return getJedisInstance().zremrangeByRank(s,l,l1);
    }

    @Override
    public Long zremrangeByScore(String s, double v, double v1) {
        return getJedisInstance().zremrangeByScore(s,v,v1);
    }

    @Override
    public Long zremrangeByScore(String s, String s1, String s2) {
        return getJedisInstance().zremrangeByScore(s,s1,s2);
    }

    @Override
    public Long zlexcount(String s, String s1, String s2) {
        return getJedisInstance().zlexcount(s,s1,s2);
    }

    @Override
    public Set<String> zrangeByLex(String s, String s1, String s2) {
        return getJedisInstance().zrangeByLex(s,s1,s2);
    }

    @Override
    public Set<String> zrangeByLex(String s, String s1, String s2, int i, int i1) {
        return getJedisInstance().zrangeByLex(s,s1,s2);
    }

    @Override
    public Set<String> zrevrangeByLex(String s, String s1, String s2) {
        return getJedisInstance().zrevrangeByLex(s,s1,s2);
    }

    @Override
    public Set<String> zrevrangeByLex(String s, String s1, String s2, int i, int i1) {
        return getJedisInstance().zrevrangeByLex(s,s1,s2,i,i1);
    }

    @Override
    public Long zremrangeByLex(String s, String s1, String s2) {
        return getJedisInstance().zremrangeByLex(s,s1,s2);
    }

    @Override
    public Long linsert(String s, BinaryClient.LIST_POSITION list_position, String s1, String s2) {
        return getJedisInstance().linsert(s,list_position,s1,s2);
    }

    @Override
    public Long lpushx(String s, String... strings) {
        return getJedisInstance().lpushx(s,strings);
    }

    @Override
    public Long rpushx(String s, String... strings) {
        return getJedisInstance().rpushx(s,strings);
    }

    @Override
    public List<String> blpop(String s) {
        return getJedisInstance().blpop(s);
    }

    @Override
    public List<String> blpop(int i, String s) {
        return getJedisInstance().blpop(i,s);
    }

    @Override
    public List<String> brpop(String s) {
        return getJedisInstance().brpop(s);
    }

    @Override
    public List<String> brpop(int i, String s) {
        return getJedisInstance().brpop(i,s);
    }

    @Override
    public Long del(String s) {
        return getJedisInstance().del(s);
    }

    @Override
    public String echo(String s) {
        return getJedisInstance().echo(s);
    }

    @Override
    public Long move(String s, int i) {
        return getJedisInstance().move(s,i);
    }

    @Override
    public Long bitcount(String s) {
        return getJedisInstance().bitcount(s);
    }

    @Override
    public Long bitcount(String s, long l, long l1) {
        return getJedisInstance().bitcount(s,l,l1);
    }

    @Override
    public Long bitpos(String s, boolean b) {
        return getJedisInstance().bitpos(s,b);
    }

    @Override
    public Long bitpos(String s, boolean b, BitPosParams bitPosParams) {
        return getJedisInstance().bitpos(s,b,bitPosParams);
    }

    @Override
    public ScanResult<Map.Entry<String, String>> hscan(String s, int i) {
        return getJedisInstance().hscan(s,i);
    }

    @Override
    public ScanResult<String> sscan(String s, int i) {
        return getJedisInstance().sscan(s,i);
    }

    @Override
    public ScanResult<Tuple> zscan(String s, int i) {
        return getJedisInstance().zscan(s,i);
    }

    @Override
    public ScanResult<Map.Entry<String, String>> hscan(String s, String s1) {
        return getJedisInstance().hscan(s,s1);
    }

    @Override
    public ScanResult<Map.Entry<String, String>> hscan(String s, String s1, ScanParams scanParams) {
        return getJedisInstance().hscan(s,s1,scanParams);
    }

    @Override
    public ScanResult<String> sscan(String s, String s1) {
        return getJedisInstance().sscan(s,s1);
    }

    @Override
    public ScanResult<String> sscan(String s, String s1, ScanParams scanParams) {
        return getJedisInstance().sscan(s,s1,scanParams);
    }

    @Override
    public ScanResult<Tuple> zscan(String s, String s1) {
        return getJedisInstance().zscan(s,s1);
    }

    @Override
    public ScanResult<Tuple> zscan(String s, String s1, ScanParams scanParams) {
        return getJedisInstance().zscan(s,s1,scanParams);
    }

    @Override
    public Long pfadd(String s, String... strings) {
        return getJedisInstance().pfadd(s,strings);
    }

    @Override
    public long pfcount(String s) {
        return getJedisInstance().pfcount(s);
    }

    @Override
    public Long geoadd(String s, double v, double v1, String s1) {
        return getJedisInstance().geoadd(s,v,v1,s1);
    }

    @Override
    public Long geoadd(String s, Map<String, GeoCoordinate> map) {
        return getJedisInstance().geoadd(s,map);
    }

    @Override
    public Double geodist(String s, String s1, String s2) {
        return getJedisInstance().geodist(s,s1,s2);
    }

    @Override
    public Double geodist(String s, String s1, String s2, GeoUnit geoUnit) {
        return getJedisInstance().geodist(s,s1,s2,geoUnit);
    }

    @Override
    public List<String> geohash(String s, String... strings) {
        return getJedisInstance().geohash(s,strings);
    }

    @Override
    public List<GeoCoordinate> geopos(String s, String... strings) {
        return getJedisInstance().geopos(s,strings);
    }

    @Override
    public List<GeoRadiusResponse> georadius(String s, double v, double v1, double v2, GeoUnit geoUnit) {
        return getJedisInstance().georadius(s,v,v1,v2,geoUnit);
    }

    @Override
    public List<GeoRadiusResponse> georadius(String s, double v, double v1, double v2, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return getJedisInstance().georadius(s,v,v1,v2,geoUnit,geoRadiusParam);
    }

    @Override
    public List<GeoRadiusResponse> georadiusByMember(String s, String s1, double v, GeoUnit geoUnit) {
        return getJedisInstance().georadiusByMember(s,s1,v,geoUnit);
    }

    @Override
    public List<GeoRadiusResponse> georadiusByMember(String s, String s1, double v, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return getJedisInstance().georadiusByMember(s,s1,v,geoUnit,geoRadiusParam);
    }
}
