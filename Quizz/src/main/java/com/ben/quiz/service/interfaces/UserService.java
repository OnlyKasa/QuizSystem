package com.ben.quiz.service.interfaces;

import com.ben.quiz.domain.common.exception.QuizException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface UserService extends UserDetailsService {
//
//    void resetPassword(ForgotPasswordReq forgotPasswordReq) throws QuizException;
//
//    void changePassword(ChangePasswordReq request) throws QuizException;
//
//    Seiuser findUserByUserNameAndPassword(String userName, String password) throws QuizException;
//
//    Seiuser findUserByUserName(String userName) throws QuizException;
//
//    Map<String, Object> actLogin(UserFormReq request, BindingResult result);

//    Map<String, Object> getUserInfo(String userID) throws QuizException;

    String handleHome(Map<String, Object> inModel)throws QuizException;

    ModelAndView handleLoggedIn()throws QuizException;

    String handleLogout(HttpServletRequest request)throws QuizException;
}
