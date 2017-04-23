package com.cyx.util;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * 
 * @author niyongsheng
 * @version 创建时间：2017年4月23日 下午9:38:22 
 * @mail yongsheng_zg2009@163.com
 */
public class HttpUtil {
    public static JSONObject getRequestJson(HttpServletRequest request){
        JSONObject json = new JSONObject();
        try {
            BufferedReader reader = request.getReader();
            StringBuffer jb = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null)
                jb.append(line);
            String jbstring=jb.toString();
            json = JSONObject.parseObject(jbstring);
            System.out.println("json:"+json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
