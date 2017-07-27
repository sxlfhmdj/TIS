package com.dj.stis.dao.tis.iface;

import com.dj.stis.dao.tis.dao.Custinfo;

public interface CustinfoMapper {
    int deleteByPrimaryKey(String custno);

    int insert(Custinfo record);

    int insertSelective(Custinfo record);

    Custinfo selectByPrimaryKey(String custno);

    int updateByPrimaryKeySelective(Custinfo record);

    int updateByPrimaryKeyWithBLOBs(Custinfo record);

    int updateByPrimaryKey(Custinfo record);
}