package com.dj.stis.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Description: 【方法功能中文描述】 <br/>
 * Created on 9:24 2017/6/5 <br/>
 *
 */
public class ObjectUtils {

    private final static Logger logger = LoggerFactory.getLogger(ObjectUtils.class);

    /**
     * 复制源对象和目标对象的属性值
     *
     * @param source
     * @param target
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public static void copyProperties(Object source, Object target) {
        try {
            Class sourceClass = source.getClass();//得到对象的Class
            Class targetClass = target.getClass();//得到对象的Class

            Field[] sourceFields = sourceClass.getDeclaredFields();//得到Class对象的所有属性
            Field[] targetFields = targetClass.getDeclaredFields();//得到Class对象的所有属性

            for (Field sourceField : sourceFields) {
                String name = sourceField.getName();//属性名
                Class type = sourceField.getType();//属性类型

                String methodName = name.substring(0, 1).toUpperCase() + name.substring(1);

                Method getMethod = sourceClass.getMethod("get" + methodName);//得到属性对应get方法

                Object value = getMethod.invoke(source);//执行源对象的get方法得到属性值

                for (Field targetField : targetFields) {
                    String targetName = targetField.getName();//目标对象的属性名

                    if (targetName.equals(name)) {
                        Method setMethod = targetClass.getMethod("set" + methodName, type);//属性对应的set方法

                        setMethod.invoke(target, value);//执行目标对象的set方法
                    }
                }
            }
        } catch (Exception e) {
            logger.error("属性copy失败！");
        }
    }

}

