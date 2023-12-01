package com.mxjsxz.demo.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

/**
 * json工具类
 *
 * @author xuwenbing
 * @date 2019-06-12
 */
public class JsonUtil {
    /**
     * 将json字符串转换成Object
     *
     * @param text
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T parseObject(String text, Class<T> clazz) {
        if (StringUtils.isNotBlank(text)) {
            T t = JSONObject.parseObject(text, clazz);
            return t;
        } else {
            return null;
        }
    }

    /**
     * 将Object转换成json字符串
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> String toJson(T t) {
        if (t != null) {
            return JSONObject.toJSONString(t);
        } else {
            return null;
        }
    }
}
