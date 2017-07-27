package com.dj.stis.interfaces.vo.request;



/**
 * Description: 【方法功能中文描述】 <br/>
 * Created on 10:28 2017/6/5 <br/>
 *
 * @author: <a href="mailto: dengjiang@camelotchina.com">邓江</a><br/>
 * @version: 1.0 <br/>
 * Copyright (c) 2017年 北京柯莱特科技有限公司 交付部
 */
public class BaseVo {
    private String session;

    private HeadVo headVo;

    private Platform platform;

    private String custno;

    private String custname;

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public HeadVo getHeadVo() {
        return headVo;
    }

    public void setHeadVo(HeadVo headVo) {
        this.headVo = headVo;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public String getCustno() {
        return custno;
    }

    public void setCustno(String custno) {
        this.custno = custno;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }
}
