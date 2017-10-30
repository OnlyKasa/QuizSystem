package com.ben.quiz.controller.base;

import com.ben.quiz.domain.common.constant.CommonConst;
import com.ben.quiz.domain.common.form.BaseForm;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Controller base class for project
 *
 * @author
 *
 */
public class BaseController {

	public static final String PREFIX_SAVEKEY_CHANGE_CHECK = "quizChangeCheck.";
	public static final String SUFFIX_SAVEKEY_CHANGE_AUTO_REMOVE = "_AutoRemove";
	public static final String CHANGE_CHECK_IS_CHANGED = "isChanged";
	public static final String FIND_BY_ID = "/find/ID";
	public static final String COUNT = "/count";
	public static final String FIND = "/find";
	public static final String LOGIN = "/login";
	public static final String ERROR = "/error";
	public static final String ERROR_PAGE = "/common/error";
	public static final String INIT = "/init";
	public static final String SEARCH = "/search";
	public static final String SEARCH_PAGE = "/searchPage";
	public static final String ADD = "/add";
	public static final String SAVE = "/save";
	public static final String VALIDATE_BEFORE_SAVE = "/validateBeforeSave";
	public static final String NEXT = "/next";
	public static final String MODIFY = "/modify";
	public static final String REGISTER="/register";
	public static final String DELETE = "/delete";
	public static final String INACTIVE = "/inactive";
	public static final String MERGE = "/merge";
	public static final String SORT = "/sort";
	public static final String CANCEL = "/cancel";
	public static final String BACK = "/back";
	public static final String VIEW = "/view";
	public static final String EDIT = "/edit";

	public static final String DELETE_ALL = "/deleteAll";
	public static final String CANCEL_AND_CREATE_NEW = "/cancelAndCreateNew";
	public static final String CANCEL_AND_FINISH = "/cancelAndFinish";

	public static final String DUPLICATER = "/duplicate";


	/**
	 * Redirect
	 * @param requestMapping
	 * @return
	 */
	protected String redirect(String requestMapping) {
		HttpServletRequest request = this.getRequest();
		// Store request parameter csrf in session
		HttpSession session = request.getSession();
		session.setAttribute(CommonConst.QUIZ_CSRF_PARAMETER_FNAME,
				request.getParameter(CommonConst.QUIZ_CSRF_PARAMETER_FNAME));
		return "redirect:" + requestMapping;
	}

	/**
	 * Retrieve form information saved with saveFormValue.
	 * @param type
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T extends BaseForm> T getBeforeFormValue(Class<T> type) {
		return (T) this.getSession().getAttribute(PREFIX_SAVEKEY_CHANGE_CHECK + type.getSimpleName());
	}

	/**
	 * Get request object
	 * @return
	 */
	protected HttpServletRequest getRequest() {
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = sra.getRequest();
		return request;
	}

	/**
	 * Get session object
	 * @return
	 */
	protected HttpSession getSession() {
		return this.getRequest().getSession();
	}
}
