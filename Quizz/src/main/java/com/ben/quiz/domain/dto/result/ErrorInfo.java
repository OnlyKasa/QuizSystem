package com.ben.quiz.domain.dto.result;

import java.io.Serializable;

public class ErrorInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String LEVEL_ERR = "ERR";
	public static final String LEVEL_WARNING = "WARNING";

	private String errMsg;
	private String errFieldId;
	private String errFieldValue;
	private String level = LEVEL_ERR;

	/**
	 * Constructor
	 *
	 * @param errMsg
	 * @param errFieldId
	 */
	public ErrorInfo(String errMsg, String errFieldId) {
		this.errFieldId = errFieldId;
		this.errMsg = errMsg;
		this.level = LEVEL_ERR;
	}

	/**
	 * Constructor
	 *
	 * @param errMsg
	 * @param errFieldId
	 * @param errFieldValue
	 */
	public ErrorInfo(String errMsg, String errFieldId, String errFieldValue) {
		this.errFieldId = errFieldId;
		this.errFieldValue = errFieldValue;
		this.errMsg = errMsg;
		this.level = LEVEL_ERR;
	}

	/**
	 * Constructor
	 *
	 * @param errMsg
	 * @param errFieldId
	 * @param level
	 */
	public ErrorInfo(String errMsg, String errFieldId, String errFieldValue, String level) {
		this.errFieldId = errFieldId;
		this.errFieldValue = errFieldValue;
		this.errMsg = errMsg;
		this.level = level;
	}

	/**
	 * Constructor
	 */
	public ErrorInfo() {
	}

	/**
	 * @return errMsg
	 */
	public String getErrMsg() {
		return errMsg;
	}

	/**
	 * @param errMsg
	 *            set errMsg
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	/**
	 * @return errFieldId
	 */
	public String getErrFieldId() {
		return errFieldId;
	}

	/**
	 * @param errFieldId
	 *            set errFieldId
	 */
	public void setErrFieldId(String errFieldId) {
		this.errFieldId = errFieldId;
	}

	/**
	 * @return the errFieldValue
	 */
	public String getErrFieldValue() {
		return errFieldValue;
	}

	/**
	 * @param errFieldValue
	 *            the errFieldValue to set
	 */
	public void setErrFieldValue(String errFieldValue) {
		this.errFieldValue = errFieldValue;
	}

	/**
	 * @return level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            set level
	 */
	public void setLevel(String level) {
		this.level = level;
	}

}
