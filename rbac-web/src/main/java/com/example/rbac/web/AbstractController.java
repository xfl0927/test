package com.example.rbac.web;

import com.example.common.convert.MyCustomDateEditor;
import com.example.common.convert.MyCustomLocalDateEditor;
import com.example.common.convert.MyCustomLocalDateTimeEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 抽象controller
 *
 * @author Jack
 * @date 2020/04/25
 */
public abstract class AbstractController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new MyCustomDateEditor());
        binder.registerCustomEditor(LocalDate.class, new MyCustomLocalDateEditor());
        binder.registerCustomEditor(LocalDateTime.class, new MyCustomLocalDateTimeEditor());
    }

}

