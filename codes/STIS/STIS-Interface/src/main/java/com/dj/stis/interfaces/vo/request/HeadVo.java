package com.dj.stis.interfaces.vo.request;

/**
 * Description: 【方法功能中文描述】 <br/>
 * Created on 10:28 2017/6/5 <br/>
 *
 * @author: <a href="mailto: dengjiang@camelotchina.com">邓江</a><br/>
 * @version: 1.0 <br/>
 * Copyright (c) 2017年 北京柯莱特科技有限公司 交付部
 */
public class HeadVo {
    //客户端ip
    private String clientIP;
    //客户端
    private String client;
    //编码方式
    private String charset;

    public String getClientIP() {
        return clientIP;
    }

    public void setClientIP(String clientIP) {
        this.clientIP = clientIP;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }
}
