package com.dj.stis.interfaces.vo.request;

/**
 * Description: 【方法功能中文描述】 <br/>
 * Created on 11:48 2017/6/5 <br/>
 *
 * @author: <a href="mailto: dengjiang@camelotchina.com">邓江</a><br/>
 * @version: 1.0 <br/>
 * Copyright (c) 2017年 北京柯莱特科技有限公司 交付部
 */
public class Platform {

    private String OS;

    private String System;

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public String getSystem() {
        return System;
    }

    public void setSystem(String system) {
        System = system;
    }

    @Override
    public String toString() {
        return "Platform{" +
                "OS='" + OS + '\'' +
                ", System='" + System + '\'' +
                '}';
    }
}
