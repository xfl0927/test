package com.example.common.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 封装json操作
 *
 * @author Jack
 * @date 2020/04/25
 */
public class JsonUtil {

    private final static Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    private static ObjectMapper mapper = new ObjectMapper();
    static{
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule());
    }


    public static <T> T parseObject(String json, Class<T> clazz){
        T t;
        if(StringUtils.isBlank(json)){
            return null;
        }
        try {
            t = mapper.readValue(json, clazz);
        } catch (JsonParseException e) {
            LOGGER.error("json反序列化异常", e);
            throw new RuntimeException(MessageSourceUtil.getMessage("error.json_deserialize_error"),e);
        } catch (JsonMappingException e) {
            LOGGER.error("json反序列化异常", e);
            throw new RuntimeException(MessageSourceUtil.getMessage("error.json_deserialize_error"),e);
        } catch (IOException e) {
            LOGGER.error("json反序列化异常", e);
            throw new RuntimeException(MessageSourceUtil.getMessage("error.json_deserialize_error"),e);
        }
        return t;
    }


    public static String toJSONString(Object obj){
        String str;
        try {
            str = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            LOGGER.error("json序列化异常", e);
            throw new RuntimeException(MessageSourceUtil.getMessage("error.json_serialize_error"),e);
        }
        return str;
    }

    public static String toJSONString(Object object,boolean prettyFormat){
        if(prettyFormat) {
            try {
                return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
            } catch (JsonProcessingException e) {
                LOGGER.error("json序列化异常", e);
                throw new RuntimeException(MessageSourceUtil.getMessage("error.json_serialize_error"),e);
            }
        }
        return toJSONString(object);

    }

    public static <T> List<T> parseArray(String json, Class<T> clazz){
        List<T> list;
        if(StringUtils.isBlank(json)){
            return null;
        }
        try {
            JavaType javaType = getCollectionType(ArrayList.class, clazz);
            list = mapper.readValue(json, javaType);
        } catch (JsonParseException e) {
            LOGGER.error("json反序列化异常", e);
            throw new RuntimeException(MessageSourceUtil.getMessage("error.json_deserialize_error"),e);
        } catch (JsonMappingException e) {
            LOGGER.error("json反序列化异常", e);
            throw new RuntimeException(MessageSourceUtil.getMessage("error.json_deserialize_error"),e);
        } catch (IOException e) {
            LOGGER.error("json反序列化异常", e);
            throw new RuntimeException(MessageSourceUtil.getMessage("error.json_deserialize_error"),e);
        }
        return list;
    }

    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }


}

