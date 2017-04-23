package com.cyx.util;

import com.alibaba.fastjson.JSON;
/**
 * s
 * @author niyongsheng
 * @version 创建时间：2017年4月23日 下午9:37:40 
 * @mail yongsheng_zg2009@163.com
 */
public class FastJsonUtil {
    /**
     * 将传入的实体类对象转换为JSON格式字符串对象。对需要转换的属性字段要提供get方法，否则该字段不被转换。如果转换过程出错，则返回""。
     *
     * @return
     */
    public static String json2String(Object obj) {
        return JSON.toJSONString(obj);
    }

    /**
     * 将传入的JSON字符串对象转换为org.codehaus.jackson.JsonNode对象。如果传入字符串格式不正确则返回null。
     *
     * @param string
     *
     * @return
     */
    public static <T> T  string2Json(String string,Class<T> clazz) {
        return JSON.parseObject(string, clazz);
    }
}
