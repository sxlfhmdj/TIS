package com.dj.stis.service.uic;

import com.dj.stis.interfaces.uic.CustService;
import com.dj.stis.repository.customer.CustinfoRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description: 【用户服务实现】 <br/>
 * Created on 19:11 2017/6/4 <br/>
 *
 * @author: <a href="mailto: dengjiang@camelotchina.com">邓江</a><br/>
 * @version: 1.0 <br/>
 * Copyright (c) 2017年 北京柯莱特科技有限公司 交付部
 */
public class CustServiceImpl implements CustService {

    @Autowired
    private CustinfoRepository custinfoRepository;

    @Override
    public String doLogin(String jsondata) {
        return null;
    }

    @Override
    public String cancelLogin(String jsondata) {
        return null;
    }

    @Override
    public String register(String jsondata) {
        return null;
    }

    @Override
    public String getCustinfo(String jsondata) {


        return null;
    }

    @Override
    public String modifyCustinfo(String jsondata) {
        return null;
    }

    @Override
    public String modifyCustPwd(String jsondata) {
        return null;
    }
}
