package com.dj.stis.common.utils;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;

/**
 * Description: 【Json工具类】 <br/>
 * Created on 11:40 2017/8/3 <br/>
 *
 */
public class JsonUtils {
    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);
    private static Gson gson = new Gson();


    public static String toJson(Object object){
        init();
        String jsonStr = gson.toJson(object);
        return jsonStr;
    }

    public static <T> T fromJson(String jsonStr, Class<T> clazz){
        init();
        T object = null;
        try{
            object = gson.fromJson(jsonStr, clazz);
        }catch(Exception e)
        {
            logger.error("Gson转换失败");
        }
        return object;
    }

    public static <T> T fromJson(String json, Type typeOfT){
        init();
        T object = null;
        try{
            object = gson.fromJson(json, typeOfT);
        }catch(Exception e)
        {
            logger.error("Gson转换失败");
        }
        return object;
    }

    private static void init(){
        if (null == gson){
            gson = new Gson();
        }
    }


}
