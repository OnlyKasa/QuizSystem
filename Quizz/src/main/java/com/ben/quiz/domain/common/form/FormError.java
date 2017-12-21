package com.ben.quiz.domain.common.form;

import com.ben.quiz.domain.dto.result.ErrorInfo;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class FormError {

	public static List<ErrorInfo> bindingResult(BindingResult result) {

		List<ErrorInfo> errorList = new ArrayList<ErrorInfo>();
		if (result.hasErrors()) {
			List<FieldError> errs = result.getFieldErrors();
			for (FieldError fieldError : errs) {
				errorList.add(new ErrorInfo(fieldError.getDefaultMessage(), fieldError.getField()));
			}
			return errorList;
		}
		return errorList;
	}
}
