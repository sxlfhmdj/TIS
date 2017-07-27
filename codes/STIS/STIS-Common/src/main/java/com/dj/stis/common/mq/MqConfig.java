package com.dj.stis.common.mq;

import com.dj.stis.common.mq.config.RabbitMqConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Description: 【mq配置】 <br/>
 * Created on 11:50 2017/7/21 <br/>
 *
 */

public class MqConfig {

    private static final Logger logger = LoggerFactory.getLogger(MqConfig.class);

    /**
     * 读取mq配置文件
     */
    public static Properties properties = new Properties();

    public static final String DEFAULT_HOST = "localhost";
    public static final String DEFAULT_RABBIT_PORT = "5672";
    public static final String DEFAULT_USERNAME = "";
    public static final String DEFAULT_PASSOWRD = "";
    public static final String DEFAULT_VHOST = "/";

    public void initConfig(){
        try{
            properties.load(RabbitMqConfig.class.getClassLoader().getResourceAsStream("mq.properties"));
        }catch (Exception e){
            logger.error("读取配置文件redis.properties出错！");
        }
    }

}
