package com.example.common.convert;

import com.example.common.util.DateUtil;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.time.LocalDateTime;

/**
 * 自定义日期装换
 *
 * @author Jack
 * @date 2020/04/25
 */
public class MyCustomLocalDateTimeEditor extends PropertyEditorSupport {


    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (!StringUtils.hasText(text)) {
            // Treat empty String as null value.
            setValue(null);
        } else {
            setValue(DateUtil.parseLocalDateTime(text));
        }
    }

    @Override
    public String getAsText() {
        LocalDateTime value = (LocalDateTime) getValue();
        return DateUtil.getLocalDateTimeStr(value);
    }


}


