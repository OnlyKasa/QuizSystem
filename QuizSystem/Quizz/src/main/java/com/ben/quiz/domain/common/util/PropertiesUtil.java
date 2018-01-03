package com.ben.quiz.domain.common.util;

/**
 * @author ben
 */

public class PropertiesUtil {
    public static String getMessage(String messageCode){
        return ResourceUtil.getProperty("quizMessage_en.properties", messageCode);
    }
}
