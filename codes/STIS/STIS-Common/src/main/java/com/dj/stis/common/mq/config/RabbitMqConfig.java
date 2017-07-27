package com.dj.stis.common.mq.config;

import com.dj.stis.common.mq.MqConfig;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description: 【RabbitMq 配置】 <br/>
 * Created on 11:54 2017/7/21 <br/>
 *
 */
public class RabbitMqConfig extends MqConfig{

    private static final Logger logger = LoggerFactory.getLogger(RabbitMqConfig.class);

    private static ConnectionFactory factory;

    private Connection connection;

    private void initConnectionFactory(){
        factory= new ConnectionFactory();

        String host = properties.getProperty("rabbitmq.host", DEFAULT_HOST);
        int port = Integer.valueOf(properties.getProperty("rabbitmq.port", DEFAULT_RABBIT_PORT));
        String virtualHost = properties.getProperty("rabbitmq.virtualHost", DEFAULT_VHOST);
        String username = properties.getProperty("rabbitmq.username", DEFAULT_USERNAME);
        String password = properties.getProperty("rabbitmq.password", DEFAULT_PASSOWRD);

        factory.setHost(host);
        factory.setPort(port);
        factory.setVirtualHost(virtualHost);
        factory.setUsername(username);
        factory.setPassword(password);
    }

    public Connection getConn(){
        if (factory == null){
            initConnectionFactory();
        }
        try{
            connection = factory.newConnection();
        }catch (Exception e){
            logger.error("获取RabbitMQ连接异常！");
        }
        return connection;
    }

    public Channel getChannel(){
        Channel channel = null;
        try {
           channel = getConn().createChannel();
        }catch (Exception e){
            logger.error("获取Channel失败！");
        }
        return channel;
    }

    public void closeChannel(Channel channel){
        try {
            channel.close();
        }catch (Exception e){
            logger.error("关闭Channel失败");
        }
    }

    public void closeConn(){
        try {
            connection.close();
        }catch (Exception e){
            logger.error("关闭连接失败");
        }
    }

}
