package com.ben.quiz.controller.base;

import com.ben.quiz.domain.common.constant.QuizTrasitionConst;
import com.ben.quiz.domain.model.SUser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Web controller base class for project
 *
 * @author Quangnv
 *
 */
public class BaseControllerWeb extends BaseController {
	@Autowired
	private SUser sUser;

	private SUser getSUser() {
		return sUser;
	}

	//Make default page map
	public String getDefaultPageMap(Map<String, Object> inModel){
		String controllerName = this.getClass().asSubclass(this.getClass()).getName();
		String[] classNames = controllerName.split("\\.");
		controllerName = classNames[classNames.length - 1];
		Logger.getLogger(this.getClass().asSubclass(this.getClass())).info(controllerName+".init");
		if (sUser == null || sUser.getStrUsername() == null || sUser.getStrUsername().equals("")
				|| sUser.getStrUsername().equals("null")) {
			// If not logged in, redirect to login page
			return redirect(QuizTrasitionConst.DOMAIN_ROOT);
		}
		inModel.put("fullname", getSUser().getStrFullName());
		inModel.put("screencode",getSUser().getStrTopMenu());
		try {
			return (String) Class.forName("com.ben.quiz.domain.common.constant.QuizTrasitionConst$TEMPLATE").getDeclaredField(controllerName).get(null);
		} catch (Exception e) {
			return redirect(QuizTrasitionConst.ERROR);
		}
	}
	public String getDefaultPageMap(Map<String, Object> inModel, String controllerName){
		Logger.getLogger(this.getClass().asSubclass(this.getClass())).info(controllerName+".init");
		if (sUser == null || sUser.getStrUsername() == null || sUser.getStrUsername().equals("")
				|| sUser.getStrUsername().equals("null")) {
			// If not logged in, redirect to login page
			return redirect(QuizTrasitionConst.DOMAIN_ROOT);
		}
		inModel.put("fullname", getSUser().getStrFullName());
		inModel.put("screencode",getSUser().getStrTopMenu());
		try {
			return (String) Class.forName("com.ben.quiz.domain.common.constant.QuizTrasitionConst$TEMPLATE").getDeclaredField(controllerName).get(null);
		} catch (Exception e) {
			return redirect(QuizTrasitionConst.ERROR);
		}
	}

	//Default init
	@RequestMapping(INIT)
	public String init(Map<String, Object> inModel) {
		return getDefaultPageMap(inModel);
	}
}
