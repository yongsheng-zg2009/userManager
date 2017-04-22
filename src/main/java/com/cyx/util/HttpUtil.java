package com.cyx.util;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Administrator on 17/4/18.
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
