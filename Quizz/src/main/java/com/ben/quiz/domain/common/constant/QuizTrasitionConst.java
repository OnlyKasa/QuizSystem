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

    public interface STUDENT{
        public static final String ROOT = "/student";
        public static String PAGE_TEST = STUDENT.ROOT + "/s101";
    }

    public interface TEACHER{

        public static final String ROOT = "/teacher";
        public static String PAGE_GET_EXAMINATION = TEACHER.ROOT + "/t101";
        public static String PAGE_EXAMINATION_DETAIL = TEACHER.ROOT + "/t101_1";


    }

    public interface ADMIN{
        public static final String ROOT = "/admin";
        public static String PAGE_STUDENT_LIST_FOR_EXAMINATION = ADMIN.ROOT + "/a101_3";
        public static String PAGE_EXAMINATION_LIST = ADMIN.ROOT + "/a101";
        public static String PAGE_EXAMINATION_EDIT = ADMIN.ROOT + "/a101_1";
        public static String PAGE_EXAMINATION_CREATE = ADMIN.ROOT + "/a101_2";

        public static String PAGE_DIFFICULTY_LIST =  ADMIN.ROOT + "/a102";
        public static String PAGE_DIFFICULTY_EDIT =  ADMIN.ROOT + "/a102_1";
        public static String PAGE_DIFFICULTY_CREATE =  ADMIN.ROOT + "/a102_2";

        public static String PAGE_TESTS_LIST =  ADMIN.ROOT + "/a103";

        public static String PAGE_QUESTION_LIST =  ADMIN.ROOT + "/a104";
        public static String PAGE_QUESTION_EDIT =  ADMIN.ROOT + "/a104_1";
        public static String PAGE_QUESTION_CREATE =  ADMIN.ROOT + "/a104_2";


        public static String PAGE_SUBJECT_LIST =  ADMIN.ROOT + "/a105";
        public static String PAGE_SUBJECT_EDIT =  ADMIN.ROOT + "/a105_1";
        public static String PAGE_SUBJECT_CREATE =  ADMIN.ROOT + "/a105_2";

        public static String PAGE_STUDENT_LIST =  ADMIN.ROOT + "/a106";
        public static String PAGE_STUDENT_EDIT =  ADMIN.ROOT + "/a106_1";
        public static String PAGE_STUDENT_CREATE =  ADMIN.ROOT + "/a106_2";

        public static String PAGE_TEACHER_LIST =  ADMIN.ROOT + "/a107";
        public static String PAGE_TEACHER_EDIT =  ADMIN.ROOT + "/a107_1";
        public static String PAGE_TEACHER_CREATE =  ADMIN.ROOT + "/a107_2";

        public static String PAGE_ROOM_LIST =  ADMIN.ROOT + "/a108";
        public static String PAGE_ROOM_EDIT =  ADMIN.ROOT + "/a108_1";
        public static String PAGE_ROOM_CREATE =  ADMIN.ROOT + "/a108_2";

        public static String PAGE_FACULTY_LIST =  ADMIN.ROOT + "/a109";
        public static String PAGE_FACULTY_EDIT =  ADMIN.ROOT + "/a109_1";
        public static String PAGE_FACULTY_CREATE =  ADMIN.ROOT + "/a109_2";


    }

    public interface TEMPLATE {
        public static String HOME = "home";
        public static String LOGIN = "login";
        public static String LOGOUT = "logout";
        public static String S101 = "s101";
        public static String T101 = "t101";
        public static String T101_1 = "t101_1";
        public static String A101 = "a101";
        public static String A101_1 = "a101_1";
        public static String A101_2 = "a101_2";
        public static String A101_3 = "a101_3";

        public static String A102 = "a102";
        public static String A102_1 = "a102_1";
        public static String A102_2 = "a102_2";

        public static String A103 = "a103";

        public static String A104 = "a104";
        public static String A104_1 = "a104_1";
        public static String A104_2 = "a104_2";

        public static String A105= "a105";
        public static String A105_1 = "a105_1";
        public static String A105_2 = "a105_2";


        public static String A106= "a106";
        public static String A106_1 = "a106_1";
        public static String A106_2 = "a106_2";

        public static String A107= "a107";
        public static String A107_1 = "a107_1";
        public static String A107_2 = "a107_2";

        public static String A108= "a108";
        public static String A108_1 = "a108_1";
        public static String A108_2 = "a108_2";

        public static String A109= "a109";
        public static String A109_1 = "a109_1";
        public static String A109_2 = "a109_2";

    }

}
