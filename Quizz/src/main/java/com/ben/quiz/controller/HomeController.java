/*
 * Created by: QuangNV
 * Created date: 22/08/2017
 * For: home
 * */
package com.ben.quiz.controller;

import com.ben.quiz.controller.base.BaseController;
import com.ben.quiz.domain.common.constant.QuizTrasitionConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@Scope("session")
@RequestMapping(value = "/")
public class HomeController extends BaseController {

	@Autowired
	UserService userService;

	@RequestMapping("")
	public String handleHome(Map<String, Object> inModel) throws QuizException
	{
		return userService.handleHome(inModel);
	}

	@GetMapping(QuizTrasitionConst.AUTH.LOG_IN)
	public ModelAndView handleLoggedIn() throws QuizException {
		return userService.handleLoggedIn();
	}

	@RequestMapping(QuizTrasitionConst.AUTH.LOG_OUT)
	public String handleLogout()throws QuizException{
		return userService.handleLogout(this.getRequest());
	}
}
