package com.dj.stis.common.redis;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

/**
 * Description: 【Redis 客户端】 <br/>
 * Created on 9:19 2017/7/21 <br/>
 */
public class RedisClient {

    private Jedis jedis = RedisConfig.getJedis();

    public void set(String key, String value){
        jedis.set(key, value);
    }

    public String get(String key){
        return jedis.get(key);
    }

    public void setHash(String key, String field, String value){
        jedis.hset(key, field, value);
    }

    public void setHash(String key, Map<String, String> map){
       jedis.hmset(key, map);
    }

    public String getHash(String key, String field){
        return jedis.hget(key, field);
    }

    public Map<String, String> getHash(String key){
        return jedis.hgetAll(key);
    }

    public List<String> getFields(String key){
        return jedis.hvals(key);
    }



    public static void main(String[] strs){
        new RedisClient().set("key", "hello, im comming!");
        System.out.print(new RedisClient().get("key"));
    }
}
