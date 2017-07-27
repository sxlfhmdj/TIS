package com.dj.stis.common.redis;

import com.dj.stis.common.utils.StringUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.util.Properties;

/**
 * Description: 【Redis Pool Config】 <br/>
 * Created on 9:58 2017/7/21 <br/>
 *
 */
public class RedisPoolConfig extends GenericObjectPoolConfig {

    RedisPoolConfig(Properties properties){
        String maxidle = properties.getProperty("redis.maxidle");
        String minidle = properties.getProperty("redis.minidle");
        String maxtotal = properties.getProperty("redis.maxtotal");

        if (StringUtils.isNotBlank(maxidle)){
            this.setMaxIdle(Integer.valueOf(maxidle));
        }

        if (StringUtils.isNotBlank(minidle)){
            this.setMinIdle(Integer.valueOf(minidle));
        }

        if (StringUtils.isNotBlank(maxtotal)){
            this.setMaxTotal(Integer.valueOf(maxtotal));
        }
    }
}
