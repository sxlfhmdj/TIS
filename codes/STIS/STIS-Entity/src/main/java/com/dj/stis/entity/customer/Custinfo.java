package com.dj.stis.entity.customer;

import java.util.Date;

/**
 * Description: 【用户信息实体】 <br/>
 * Created on 18:56 2017/6/4 <br/>
 *
 * @author: <a href="mailto: dengjiang@camelotchina.com">邓江</a><br/>
 * @version: 1.0 <br/>
 * Copyright (c) 2017年 北京柯莱特科技有限公司 交付部
 */
public class Custinfo {
    //用户编号
    private String custno;
    //用户名称
    private String custname;
    //用户类型
    private String custtype;
    //证件号
    private String certid;
    //证件类型
    private String certtype;
    //手机号
    private String telephone;
    //性别
    private String sex;
    //电子邮件
    private String email;
    //用户状态
    private String state;
    //用户家庭地址
    private String address;

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

    public String getCusttype() {
        return custtype;
    }

    public void setCusttype(String custtype) {
        this.custtype = custtype;
    }

    public String getCertid() {
        return certid;
    }

    public void setCertid(String certid) {
        this.certid = certid;
    }

    public String getCerttype() {
        return certtype;
    }

    public void setCerttype(String certtype) {
        this.certtype = certtype;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Custinfo{" +
                "custno='" + custno + '\'' +
                ", custname='" + custname + '\'' +
                ", custtype='" + custtype + '\'' +
                ", certid='" + certid + '\'' +
                ", certtype='" + certtype + '\'' +
                ", telephone='" + telephone + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", state='" + state + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
