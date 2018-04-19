package com.ben.quiz.domain.common.constant;

import com.ben.quiz.domain.dto.result.ErrorInfo;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constant {
    private static final Logger logger = Logger.getLogger(Constant.class);

    public static final String DATE_FORMAT_DD_MM_YYYY = "dd/MM/yyyy";
    public static  final String DATE_FORMAT_YYYY_MM = "yyyy-MM";
    public static String BASIC_AUTH = "T21pbmV4dDpPbWluZXh0MjAxNw=="; // Ominext:Ominext2017

    /**
     * URL
     */
    public interface URL {
        String FORGOT_PASSWORD = "/quiz/forgot-password";
        String LOGIN = "/quiz/login";
        String CHANGE_PASSWORD = "/quiz/change-password";
    }

    /**
     * Controller Status
     */
    public interface ctrlStatus {
        // Normal
        String NORMAL = "S0";

        // Input error
        String ERR_VALIDATE = "E1";

        // Login failed
        String ERR_WRONG_LOGIN = "E2";

        // Permission Denied
        String ERR_PERMISSION_DENIED = "E3";

        // Data notfound
        String ERR_DATA_NOT_FOUND = "E4";

        // Data existed
        String ERR_DATA_EXISTED = "E5";

        // Exception
        String ERR_EXCEPTION = "E6";
        // Token invalid or expried
        String ERR_AUTH_INVALID = "E7";
    }

    /**
     * Controller key
     */
    public interface ctrlKey {

        // Status
        public static final String STATUS = "status";

        // Message
        public static final String MESSAGE = "message";

        // Data
        public static final String DATA = "data";
    }


    public static <T> Map<String, Object> responseSuccess(String key, T object) {
        return responseSuccess(key, object, null);
    }

    public static <T> Map<String, Object> responseSuccess(String mesage) {
        return responseSuccess(ctrlKey.MESSAGE, mesage, null);
    }

    public static Map<String, Object> responseError(String message) {
        return responseError(message, ctrlStatus.ERR_EXCEPTION);
    }

    public static Map<String, Object> responsePermissionDenied() {
        return responsePermissionDenied("Permission denied");
    }

    public static Map<String, Object> responsePermissionDenied(String message) {
        return responseError(message, ctrlStatus.ERR_PERMISSION_DENIED);
    }

    public static <T> Map<String, Object> responseSuccess(String key, T object, String message) {
        Map<String, Object> map = new HashMap<>();
        map.put(ctrlKey.STATUS, Constant.ctrlStatus.NORMAL);
        if (message != null)
            map.put(ctrlKey.MESSAGE, message);
        if (!StringUtils.isEmpty(key) && key.equals(ctrlKey.MESSAGE)) {
            map.put(ctrlKey.MESSAGE, object);
        } else
            map.put(ctrlKey.DATA, object);
        logger.info("======================Success==================================");
        logger.info(object);
        return map;
    }

    public static Map<String, Object> responseError(String status, List<ErrorInfo> errorList) {
        Map<String, Object> map = new HashMap<>();
        map.put(status, errorList);
        return map;
    }

    public static Map<String, Object> responseError(int errorCode, List<ErrorInfo> errorList) {
        Map<String, Object> map = new HashMap<>();
        //message
        map.put("error", errorCode);
        map.put("data", errorList);
        return map;
    }

    public static Map<String, Object> responseMessage(String messCode, Object messList) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", messCode);
        map.put("data", messList);
        return map;
    }
    
    public static Map<String, Object> responseMessage(String messCode, Object messList, Object desciption) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", messCode);
        map.put("data", messList);
        map.put("desc", desciption);
        return map;
    }

    public static Map<String, Object> responseMessage(int messCode, Object messList) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", messCode);
        map.put("data", messList);
        return map;
    }

    public static Map<String, Object> responseError(String message, String status) {
        Map<String, Object> map = new HashMap<>();
        map.put(ctrlKey.STATUS, status);
        if (message != null) {
            map.put(ctrlKey.MESSAGE, message);
            logger.info("======================Error==================================");
            logger.info(message);
        }
        return map;
    }
}
