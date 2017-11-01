/*
 * Created by: DucPH
 * Created date: 22/08/2017
 * For: home
 * */
package com.ben.quiz.controller;

import com.ben.quiz.controller.base.BaseController;
import com.ben.quiz.domain.common.constant.QuizTrasitionConst;
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

//	@Autowired
//	UserService userService;
//
//	@RequestMapping("")
//	public String handleHome(Map<String, Object> inModel) {
//		return userService.handleHome(inModel);
//	}
//
//	@GetMapping(QuizTrasitionConst.TEMPLATE.HOME)
//	public ModelAndView handleLoggedIn() {
//		return userService.handleLoggedIn();
//	}
//
//	@RequestMapping(QuizTrasitionConst.AUTH.LOG_OUT)
//	public String handleLogout(){
//		return userService.handleLogout(this.getRequest());
//	}
}