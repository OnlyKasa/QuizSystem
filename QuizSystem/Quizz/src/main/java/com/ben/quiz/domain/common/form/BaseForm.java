package com.ben.quiz.domain.common.form;


import com.ben.quiz.domain.dto.result.ErrorInfo;

import java.util.ArrayList;
import java.util.List;

public class BaseForm {

	private List<ErrorInfo> errInfo = new ArrayList<ErrorInfo>();

	/**
	 * @return errInfo
	 */
	public List<ErrorInfo> getErrInfo() {
		return errInfo;
	}

	/**
	 * @param errInfo
	 *            set errInfo
	 */
	public void setErrInfo(List<ErrorInfo> errInfo) {
		this.errInfo = errInfo;
	}

	/**
	 * With or without error
	 * 
	 * @return
	 */
	public boolean hasErrors() {

		for (ErrorInfo e : errInfo) {
			if (ErrorInfo.LEVEL_ERR.equals(e.getLevel())) {
				return true;
			}
		}

		return false;
	}

	/**
	 * With warning
	 * 
	 * @return
	 */
	public boolean hasWarning() {

		for (ErrorInfo e : errInfo) {
			if (ErrorInfo.LEVEL_WARNING.equals(e.getLevel())) {
				return true;
			}
		}

		return false;
	}

}
