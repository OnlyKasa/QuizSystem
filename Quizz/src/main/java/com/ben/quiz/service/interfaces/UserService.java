package com.ben.quiz.service.interfaces;

import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.UserLoginReq;
import com.ben.quiz.domain.model.Seiuser;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface UserService extends UserDetailsService {

    Long actLogin(UserLoginReq request) throws QuizException;

    Seiuser findUserByUserName(String userName) throws QuizException;

    String handleHome(Map<String, Object> inModel)throws QuizException;

    ModelAndView handleLoggedIn()throws QuizException;

    String handleLogout(HttpServletRequest request)throws QuizException;
}
