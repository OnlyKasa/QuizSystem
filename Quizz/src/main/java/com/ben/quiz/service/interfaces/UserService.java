package com.ben.quiz.service.interfaces;


import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface UserService {
//
//    void resetPassword(ForgotPasswordReq forgotPasswordReq) throws GoovalException;
//
//    void changePassword(ChangePasswordReq request) throws GoovalException;
//
//    Seiuser findUserByUserNameAndPassword(String userName, String password) throws GoovalException;
//
//    Seiuser findUserByUserName(String userName) throws GoovalException;
//
//    Map<String, Object> actLogin(UserFormReq request, BindingResult result);

    Map<String, Object> getUserInfo(String userID);

    String handleHome(Map<String, Object> inModel);

    ModelAndView handleLoggedIn();

    String handleLogout(HttpServletRequest request);
}
