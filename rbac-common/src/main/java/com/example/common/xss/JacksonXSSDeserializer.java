package com.example.common.xss;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;

import java.io.IOException;

/**
 * jackson防XSS反序列化器
 *
 * @author Jack
 * @date 2020/04/25
 */
public class JacksonXSSDeserializer extends StdScalarDeserializer<String> implements ContextualDeserializer {

    public JacksonXSSDeserializer() {
        super(String.class);
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
        if (property != null) {
            IgnoreXSS annotation = property.getAnnotation(IgnoreXSS.class);
            if (annotation != null) {
                return StringDeserializer.instance;
            }
        }
        return this;
    }

    @Override
    public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = StringDeserializer.instance.deserialize(p, ctxt);
        return XSSUtil.clean(value);
    }

    @Override
    public String deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        String value = StringDeserializer.instance.deserializeWithType(jp, ctxt, typeDeserializer);
        return XSSUtil.clean(value);
    }

    @Override
    public boolean isCachable() {
        return StringDeserializer.instance.isCachable();
    }

}

