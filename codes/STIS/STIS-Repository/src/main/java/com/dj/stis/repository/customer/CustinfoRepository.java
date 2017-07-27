package com.dj.stis.repository.customer;

import com.dj.stis.entity.customer.Custinfo;

/**
 * Description: 【用户信息仓储】 <br/>
 * Created on 18:39 2017/6/4 <br/>
 *
 * @author: <a href="mailto: dengjiang@camelotchina.com">邓江</a><br/>
 * @version: 1.0 <br/>
 * Copyright (c) 2017年 北京柯莱特科技有限公司 交付部
 */
public interface CustinfoRepository {

    /**
     * 根据用户编号获取用户信息
     *
     * @param custno
     * @return
     */
    public Custinfo getCustinfoByCustno(String custno);


}
