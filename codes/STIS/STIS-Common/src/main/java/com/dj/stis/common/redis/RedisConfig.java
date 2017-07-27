package com.dj.stis.common.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Properties;

/**
 * Description: 【Redis Config】 <br/>
 * Created on 9:33 2017/7/21 <br/>
 *
 */
public class RedisConfig {

    private static final Logger logger = LoggerFactory.getLogger(RedisClient.class);

    /**
     * 读取Redis配置文件
     */
    private static Properties properties = new Properties();

    private static JedisPool jedisPool = null;


    /**
     * 获取Jedis实例
     * @return
     */
    public static synchronized Jedis getJedis() {
        try {
            if (getJedisPool() != null) {
                Jedis resource = jedisPool.getResource();
                return resource;
            } else {
                logger.error("获取Jedis连接池失败！");
                return null;
            }
        } catch (Exception e) {
            logger.error("获取jedis连接失败");
            return null;
        }
    }

    public static JedisPool getJedisPool(){
        if (jedisPool == null){
            initPool();
        }
        return jedisPool;
    }

    public static void initPool(){
        try{
            properties.load(RedisConfig.class.getClassLoader().getResourceAsStream("redis.properties"));
        }catch (Exception e){
            logger.error("读取配置文件redis.properties出错！");
        }
        RedisPoolConfig poolConfig = new RedisPoolConfig(properties);

        String host = properties.getProperty("redis.host");
        String port = properties.getProperty("redis.port");
        String password = properties.getProperty("redis.password");
        String timeout = properties.getProperty("redis.timeout");

        jedisPool = new JedisPool(poolConfig, host, Integer.valueOf(port),
                Integer.valueOf(timeout), password);
    }

}
