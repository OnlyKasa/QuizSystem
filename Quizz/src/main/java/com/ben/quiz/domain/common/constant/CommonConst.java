package com.ben.quiz.domain.common.constant;

import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

public class CommonConst {
	public static final String ERROR_MESSAGER = "An error occurred on the system side";
    public static final String DATABASE_ERROR = "database.error";
    public static final String SERVICE_ERROR = "service.error";
    public static final String BUSINESS_ERROR = "business.error";
	/** Session key constant: login failure status */
	public static final String SESION_KEY_LOGIN_FAIL_STATUS = "LOGIN_FAIL_STATUS";

	/** The URL of the screen after the authentication is failure */
	public static final String REDIRECT_FAILURE_URL = "../C101";

	/** The URL of the screen message alert lock account */

	public static final String REDIRECT_LOCKED_ACCOUNT = "../C105/init";

	/** The URL of the TOP screen after the authentication is successful */
	public static final String REDIRECT_TOP_URL = "patient_registration/HP03/init";

	/** The URL of the screen after logout */
	public static final String REDIRECT_LOGOUT_URL = "C101/init";

	/** The URL of the screen change password */

	public static final String REDIRECT_CHANGEPASS_URL = "../C104/init";

	/** Authentication failure state constant value */
	public static final String LOGIN_FAIL_STATUS_VALUE = "1";

	/** One-time token parameter name */
	public static final String QUIZ_CSRF_PARAMETER_FNAME = "_csrf";

	public static final String QUIZ_SESSION_CSRF_TOKEN_ATTR_NAME = HttpSessionCsrfTokenRepository.class.getName()
			.concat(".CSRF_TOKEN");

	/** Partial image file Temporary folder */
	public static final String BUI_IMG_TEMP_PATH = "/resources/buiImg/";

	/** Space character */
	public static final String SPACE_CHARACTER = " ";

	/** Sentio symbol for like clause query */
	public static final String SENTIO_SYMBOL = "%";

	/** String empty */
	public static final String STRING_EMPTY = "";

	/** String date format */
	public static final String DATE_FORMAT_DD_MM_YYYY = "dd/MM/yyyy";
	public static final String DATE_FORMAT_YYYY_MM_DD_SLASH = "yyyy/MM/dd";
	public static final String DATE_FORMAT_YYY_MM_DD_HH_MM_SS_MINUS = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT_YYYY_MM_DD_HH_MM_SLASH = "yyyy/MM/dd HH:mm";
	public static final String DATE_FORMAT_DD_MM_YYYY_HH_MM_SLASH = "dd/MM/yyyy HH:mm";
	public static final String DATE_FORMAT_DD_MM_YYYY_HH_MM_SS_SLASH = "dd/MM/yyyy HH:mm:ss";
	public static final String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS_SLASH = "yyyy/MM/dd HH:mm:ss";
	public static final String DATE_FORMAT_YYYY_MM_MINUS = "yyyy-MM";
	public static final String DATE_FORMAT_YYYY_MM_DD_MINUS = "yyyy-MM-dd";
	public static final String DATE_FORMAT_DD_MM_YYYY_MINUS = "dd-MM-yyyy";
	public static final String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS_MINUS = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS_SSSMINUS = "yyyy-MM-dd HH:mm:ss.SSS";

	public static final String HOUR_FORMAT_HH_MM_SS_SSS = " HH:mm:ss.SSS";

	/** TIRET_SYMBOL */
	public static final String TIRET_SYMBOL = "-";

	/** Comma symbol */
	public static final String COMMA_SYMBOL = ",";

	/** Colon symbol */
	public static final String COLON_SYMBOL = ":";

	public static final String SLASH_SYMBOL = "/";

	/** Method post */
	public static final String METHOD_POST = "POST";

	/** Method get */
	public static final String METHOD_GET = "GET";

	/** Use when update profile. */
	public static final String FLAG_USER_CHANGED_PASSWORD = "YES";

	public static final String QUESTION_SYMBOL = "?";

	/**
	 * Use for check must change password if setting periodic_change_of_password = 1
	 */
	public static final String FLAG_USER_GO_FROM_LOGIN = "FLAG_USER_GO_FROM_LOGIN";

	public static final String IS_CLICK_BUTTON_LOGOUT = "IS_CLICK_BUTTON_LOGOUT";

	public interface HostMail {
		String HOST = "ominext.sakura.ne.jp";
		String USERNAME = "noreply@talent.ominext.com";
		String PASSWORD = "1qazxsW2";
		String FROM = "no-reply@quiz.jp";
	}

}
