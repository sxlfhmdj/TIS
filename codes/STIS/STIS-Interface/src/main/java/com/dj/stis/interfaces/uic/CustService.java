package com.dj.stis.interfaces.uic;

/**
 * Description: 【用户服务接口】 <br/>
 * Created on 19:11 2017/6/4 <br/>
 *
 * @author: <a href="mailto: dengjiang@camelotchina.com">邓江</a><br/>
 * @version: 1.0 <br/>
 * Copyright (c) 2017年 北京柯莱特科技有限公司 交付部
 */
public interface CustService {
    /**
     * 用户登录Web
     *
     * @param jsondata
     * @return
     */
    public String doLogin(String jsondata);

    /**
     * 用户注销登录
     *
     * @param jsondata
     * @return
     */
    public String cancelLogin(String jsondata);

    /**
     * 用户注册
     *
     * @param jsondata
     * @return
     */
    public String register(String jsondata);

    /**
     * 获取用户基本信息
     *
     * @param jsondata
     * @return
     */
    public String getCustinfo(String jsondata);

    /**
     * 修改用户基本信息
     *
     * @param jsondata
     * @return
     */
    public String modifyCustinfo(String jsondata);

    /**
     * 修改用户密码
     * 
     * @param jsondata
     * @return
     */
    public String modifyCustPwd(String jsondata);

}
