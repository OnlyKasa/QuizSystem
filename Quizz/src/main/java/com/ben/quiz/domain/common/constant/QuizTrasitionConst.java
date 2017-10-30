/*******************************************************************************
 * •Copyright 2017 Panasonic Healthcare Co., Ltd. All rights reserved.
 ******************************************************************************/
package com.ben.quiz.domain.common.constant;

/**
 * Gooval constants url
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

        public static String C101 = AUTH.ROOT + "/C101";
        public static String C102 = AUTH.ROOT + "/C102";
        public static String C103 = AUTH.ROOT + "/C103";
        public static String C104 = AUTH.ROOT + "/C104";
        public static String C105 = AUTH.ROOT + "/C105";
        public static String C105_2 = AUTH.ROOT + "/C105_2";
        public static String C105_3 = AUTH.ROOT + "/C105_3";
        public static String C106 = AUTH.ROOT + "/C106";
        public static String C107 = AUTH.ROOT + "/C107";
        public static String C108 = AUTH.ROOT + "/C108";
        public static String C109 = AUTH.ROOT + "/C109";

        public static String LOG_OUT = AUTH.ROOT + "/logout";
    }

    public interface COMPANY {
        public static final String ROOT = "/company";
        public static String M19 = COMPANY.ROOT + "/M19";
        public static String M19_2 = COMPANY.ROOT + "/M19_2";
        public static String M19_3 = COMPANY.ROOT + "/M19_3";
        public static String AM19 = COMPANY.ROOT + "/AM19";
        public static String M20 = COMPANY.ROOT + "/M20";
        public static String M20_2 = COMPANY.ROOT + "/M20_2";
        public static String M20_3 = COMPANY.ROOT + "/M20_3";
        public static String M21 = COMPANY.ROOT + "/M21";
        public static String M21_3 = COMPANY.ROOT + "/M21_3";
        public static String AM22 = COMPANY.ROOT + "/AM22";
        public static String AM22_2 = COMPANY.ROOT + "/AM22_2";
        public static String AM22_3 = COMPANY.ROOT + "/AM22_3";
        public static String AM25 = COMPANY.ROOT + "/AM25";
        public static String AM25_2 = COMPANY.ROOT + "/AM25_2";
        public static String AM25_3 = COMPANY.ROOT + "/AM25_3";
    }

    public interface OFFICE {
        public static final String ROOT = "/office";
        public static String M22 = OFFICE.ROOT + "/M22";
        public static String M22_2 = OFFICE.ROOT + "/M22_2";
        public static String M22_3 = OFFICE.ROOT + "/M22_3";
        public static String M23 = OFFICE.ROOT + "/M23";
        public static String M23_3 = OFFICE.ROOT + "/M23_3";

    }

    public interface EMPLOYEE {
        public static final String ROOT = "/employee";
        public static String M24 = EMPLOYEE.ROOT + "/M24";
        public static String M24_2 = EMPLOYEE.ROOT + "/M24_2";
        public static String M24_3 = EMPLOYEE.ROOT + "/M24_3";
        public static String M24_4 = EMPLOYEE.ROOT + "/M24_4";
        public static String M25 = EMPLOYEE.ROOT + "/M25";
        public static String M25_3 = EMPLOYEE.ROOT + "/M25_3";
    }

    public interface FOODCOMPANY {
        public static final String ROOT = "/foodcompany";
        public static String M26 = FOODCOMPANY.ROOT + "/M26";
        public static String M27 = FOODCOMPANY.ROOT + "/M27";
        public static String M27_2 = FOODCOMPANY.ROOT + "/M27_2";
        public static String M27_3 = FOODCOMPANY.ROOT + "/M27_3";
        public static String M28 = FOODCOMPANY.ROOT + "/M28";
    }

    public interface STORE {
        public static final String ROOT = "/foodcompany";
        public static String M28 = STORE.ROOT + "/M28";
        public static String M28_2 = STORE.ROOT + "/M28_2";
        public static String M28_3 = STORE.ROOT + "/M28_3";
        public static String M29 = STORE.ROOT + "/M29";

    }

    public interface MENU {
        public static final String ROOT = "/menu";
        public static String M09 = MENU.ROOT + "/M09";
        public static String M10 = MENU.ROOT + "/M10";
        public static String M11 = MENU.ROOT + "/M11";
    }

    public interface DELIVERYMENU {
        public static final String ROOT = "/deliverymenu";
        public static String M12 = DELIVERYMENU.ROOT + "/M12";
        public static String M13 = DELIVERYMENU.ROOT + "/M13";
    }

    public interface ORDER {
        public static final String ROOT = "/order";
        public static String M30 = ORDER.ROOT + "/M30";
        public static String M31 = ORDER.ROOT + "/M31";
    }

    public interface CATEGORY {
        public static String CITY = "city";
        public static String PREFECTURE = "prefecture";
        public static String AUTHORITY = "authority";
        public static String INVOICE_METHOD = "invoiceMethod";
        public static String CARD_TYPE = "cardType";
        public static String CARD_USE = "cardUse";
        public static String CARD_STOP = "cardStop";
    }

    public interface TEMPLATE {

        public static String HOME = "home";

    }

}
