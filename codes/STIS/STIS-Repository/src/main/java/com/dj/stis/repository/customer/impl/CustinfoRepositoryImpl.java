package com.dj.stis.repository.customer.impl;

import com.dj.stis.common.utils.ObjectUtils;
import com.dj.stis.dao.tis.iface.CustinfoMapper;
import com.dj.stis.entity.customer.Custinfo;
import com.dj.stis.repository.customer.CustinfoRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description: 【用户仓储实现】 <br/>
 * Created on 18:40 2017/6/4 <br/>
 *
 * @author: <a href="mailto: dengjiang@camelotchina.com">邓江</a><br/>
 * @version: 1.0 <br/>
 * Copyright (c) 2017年 北京柯莱特科技有限公司 交付部
 */
public class CustinfoRepositoryImpl implements CustinfoRepository{
    @Autowired
    private CustinfoMapper custinfoMapper;

    @Override
    public Custinfo getCustinfoByCustno(String custno) {
        com.dj.stis.dao.tis.dao.Custinfo custinfoOfData = custinfoMapper.selectByPrimaryKey(custno);
        Custinfo custinfo = new Custinfo();
        if (custinfoOfData != null){
            ObjectUtils.copyProperties(custinfoOfData, custinfo);
        }else {
            return null;
        }
        return custinfo;
    }
}
