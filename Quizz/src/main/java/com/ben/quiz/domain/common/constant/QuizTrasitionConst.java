/*******************************************************************************
 * •Copyright 2017 Panasonic Healthcare Co., Ltd. All rights reserved.
 ******************************************************************************/
package com.ben.quiz.domain.common.constant;

/**
 * Quiz constants url
 */
public class QuizTrasitionConst {

    public static final String DOMAIN_ROOT = "/";
    public static final String ERROR = "/error";
    public static final String HOME_PAGE = "home";

    /**
     * Common
     */
    public interface COMMON {
        public static final String ROOT = "/common";
        public static String ERROR = COMMON.ROOT + "/error";
    }

    /**
     * Auth
     */
    public interface AUTH {

        public static final String ROOT = "/auth";

        public static String LOG_OUT = AUTH.ROOT + "/logout";

        public static String LOG_IN = AUTH.ROOT + "/login";

    }


    public interface TEMPLATE {

        public static String HOME = "home";

    }

}
