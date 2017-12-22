package com.ben.quiz.domain.common.util;

import java.net.URLDecoder;

public class SQLUtil {

    private SQLUtil() {
    }

    public static String formatParam(String param) {
        return param.replaceAll("\0","[\0]")
                .replaceAll("\n", "[\n]")
                .replaceAll("\r", "[\r]")
                .replaceAll("%", "\\\\%")
                .replaceAll("_","\\\\_");
    }

    public static String AllLike(String param) {
        if (param == null) {
            return "%%";
        } else {
            return "%" + formatParam(param) + "%";
        }
    }
    public static String AllLikeDecode(String param) {
        if (param == null) {
            return "%%";
        } else {
            return "%" + URLDecoder.decode(param ) + "%";
        }
    }

    public static String BeforeLike(String param){
        return "%" + formatParam(param);
    }
    public static String AfterLike(String param){
        return formatParam(param) + "%";
    }

    public static String BeforeLikeDecode(String param){
        return "%" + URLDecoder.decode(param);
    }
    public static String AfterLikeDecode(String param){
        return URLDecoder.decode(param) + "%";
    }

    public static String AllLikeExact(String param) {
        if (param == null || param.equals("")) {
            return "%%";
        } else {
            return formatParam(param);
        }
    }

    public static String AllLikeDecodeExact(String param) {
        if (param == null || param.equals("")) {
            return "%%";
        } else {
            return URLDecoder.decode(param);
        }
    }
    
}