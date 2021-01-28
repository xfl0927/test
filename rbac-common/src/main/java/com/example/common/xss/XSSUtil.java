package com.example.common.xss;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

/**
 * 过滤XSS工具
 *
 * @author Jack
 * @date 2020/04/25
 */
public class XSSUtil {

    public static String clean(String value){
        if(value==null){
            return null;
        }
        // 允许base64格式的图片,字符串不进行美化
        return Jsoup.clean(value,"",
            Whitelist.basicWithImages().addProtocols("img","src","data"),
            new Document.OutputSettings().prettyPrint(false));
    }

}

