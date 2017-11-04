package com.ben.quiz.domain.common.constant;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CodeConst {
	/** When registering DB */
	public interface shortOnOffFlg {
		// OFF
		public static final short OFF = 0;
		// ON
		public static final short ON = 1;
	}

	/** Method of rounding up consumption tax */
	public interface TaxRoundMethod {
		// {@ value}: Round-off to the nearest whole number (specified value)
		public static final int ROUND_HALF_UP = 1;
		// {@ value}: Truncate after decimal point
		public static final int ROUND_DOWN = 2;
		// {@ value}: round up to the decimal place
		public static final int ROUND_UP = 3;
	}

	/** Screen mode: 01-Modify; 02-Add */
	public interface ScreenMode {
		/** Modify screen mode */
		public static final String MODIFY = "01";
		/** Add screen mode */
		public static final String ADD = "02";
	}

	/** Controller Status */
	public interface ctrlStatus {
		// Normal
		public static final String NORMAL = "000";
		// Input error
		public static final String WEB_ERR = "100";
		// DB related error
		public static final String BIZ_ERR = "200";
	}

	/** Setting key */
	public interface SettingKey {
		public static final String LOCK_ACCOUNT_ACTIVE = "1";
		public static final String PERIODIC_CHANGE_OF_PASSWORD_ACTIVE = "1";
	}

	/**
	 * Use for Error Code
	 *
	 * @author QuangNV
	 *
	 */
	public interface ErrorCode {
		public static String errorCode = "error_code";
		public static int success = 2000 ;
		// Your username is not correct!
		public static final int ERR_001 = 1;
		// You are not a company!
		public static final int ERR_002 = 2;
		// You are not a company!
		public static final int ERR_003 = 3;
		// Your username or password is not correct!
		public static final int ERR_004 = 4;
		// user does not exits
		public static final int ERR_005 = 5;
		// error send mail fail ex.getMessage();
		public static final int ERR_006 = 6;
		// change password save data error
		public static final int ERR_007 = 7;
		//company contract information
		public static final int ERR_008 = 8;
		// create fail
		public static final int ERR_009 = 9;
		// @RequestParam userid and email valid @NotNull
		public static final int ERR_010 = 10;
		// @RequestParam userid  valid @NotNull
		public static final int ERR_011 = 11;
		// update fail
		public static final int ERR_012 = 12;
		// @RequestParam("iCompPk")  valid iCompPk>0
		public static final int ERR_013 = 13;
		// Cant not delete data company the contract end date finish > current date
		public static final int ERR_014 = 14;
		// An unexpected error occurred.
		public static final int ERR_015 = 15;
		// reset password fail
		public static final int ERR_016 = 16;
		// Email not  exits
		public static final int ERR_017 = 17;
		public static final int ERR_018 = 18;
		public static final int ERR_019 = 19;
		// valid Param iManidPk not null
		public static final int ERR_020 = 20;
		// User permission
		public static final int ERR_021 = 21;
		// delete fail
		public static final int ERR_022 = 22;
		// delete file fail
		public static final int ERR_023 = 23;
		// valid create manual
		public static final int ERR_024 = 24;
		// valid update manual
		public static final int ERR_025 = 25;
		//contact date start < date now
		public static final int ERR_026 = 26;
		//contact date finish < date now
		public static final int ERR_027 = 27;
		//contract date start >= contract date finish
		public static final int ERR_028 = 28;
		// contract Exits can't create contract
		public static final int ERR_029 = 29;
		//Contract expiration can't not update date start
		public static final int ERR_030 = 30;
		//Contract expiration can't not update date finnish
		public static final int ERR_031 = 31;
		//Contract expiration can't update contract
		public static final int ERR_032 = 32;
		//Some establishments have usage end dates set after the contract end date.
		public static final int ERR_033 = 33;
		// vaild i_contract_pk not null
		public static final int ERR_034 = 34;
		// update succes send mail to admin fail
		public static final int ERR_035 = 35;
		// vaild i_branch_monthly_price_detail_pk not null
		public static final int ERR_036 = 36;
		// vaild i_card_pk  not null
		public static final int ERR_037 = 37;
		// Data does not exit
		public static final int ERR_099 = 99;
		public static final int ERR_999 = 999;
		//An unexpected error occurred.
		public static final	int ERR_1000=1000;
		// Manual not exit 
		public static final int ERR_38 = 38 ;
	}

	/**
	 * Use for Authentication
	 * 
	 * @author QuangNV
	 *
	 */
	public interface Authentication {

		public static final String LOGIN_BY_ID = "ids";
		public static final String LOGIN_BY_USERNAME = "username";
		public static final int LOGIN_FAILURE_TIMES_0 = 0;
		public static final int LOGIN_FAILURE_TIMES_1 = 1;
		public static final int LOGIN_FAILURE_TIMES_3 = 3;
		public static final int LOGIN_FAILURE_TIMES_4 = 4;
		public static final int LOGIN_FAILURE_TIMES_5 = 5;
		public static final String LOGIN_ACCOUNT_IS_LOCKED = "AccountIsLocked";
		public static final String LOGIN_PERMISSION_CLASS = "class";
		public static final String ERROR_USERNAME_CODE = "ERROR_USERNAME_CODE";
		public static final String ERROR_PASSWORD_CODE = "ERROR_PASSWORD_CODE";
		public static final String ERROR_PASSWORD_CODE_1LOGIN_LEFT = "ERROR_PASSWORD_CODE_1LOGIN_LEFT";
		public static final String ERROR_PASSWORD_CODE_2LOGIN_LEFT = "ERROR_PASSWORD_CODE_2LOGIN_LEFT";
		public static final String ERROR_PASSWORD_CODE_3LOGIN_LEFT = "ERROR_PASSWORD_CODE_3LOGIN_LEFT";
		public static final String ERROR_COMMON_CODE = "ERROR_COMMON_CODE";
		public static final String ERROR_USER_ID_ONLY_NUMBER_CODE = "ERROR_USER_ID_ONLY_NUMBER_CODE";
		public static final String ERROR_USER_NAME_EMPTY_CODE = "ERROR_USER_NAME_EMPTY_CODE";
		public static final String ERROR_PASSWORD_EMPTY_CODE = "ERROR_PASSWORD_EMPTY_CODE";
		public static final String ERROR_NOT_SUPPORT_METHOD_CODE = "ERROR_NOT_SUPPORT_METHOD_CODE";
		public static final String ERROR_ALL_EMPTY_CODE = "ERROR_ALL_EMPTY_CODE";
		public static final String ERROR_USERNAME_ONLY_LETTERS_OR_NUMBERS = "ERROR_USERNAME_ONLY_LETTERS_OR_NUMBERS";
	}

	public static class LogOutAccount {
		public static Map<Long, Set<Long>> MAP_ACCOUNT_LOGIN = new HashMap<>();
		public static Set<Long> SET_ACCOUNT_LOCKED = new HashSet<>();
		public static Map<Long, Set<Long>> ACCOUNTS_MUST_LOG_OUT = new HashMap<>();
	}

	/**
	 * User for Customer
	 * 
	 * @author QuangNV
	 */
	public interface Customer {
		public static final String UPDATE = "update";
		public static final String INSERT = "insert";
		public static final String DELETE = "insert";
	}

	public static final String SUCCESS = "01";

	public interface StringDefault {
		static final String StringDefaultV1 = "..........................";
		static final String StringDefaultV2 = "..................................................";
	}
}
