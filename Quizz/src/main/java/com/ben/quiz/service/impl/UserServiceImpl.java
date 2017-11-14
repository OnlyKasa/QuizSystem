package com.ben.quiz.service.impl;

import com.ben.quiz.domain.common.constant.CommonConst;
import com.ben.quiz.domain.common.constant.QuizTrasitionConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.common.util.JspUtil;
import com.ben.quiz.domain.model.SUser;
import com.ben.quiz.domain.model.SeiUser;
import com.ben.quiz.domain.repository.interfaces.UserRepository;
import com.ben.quiz.service.interfaces.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private SUser sUser;
    @Autowired
    private UserRepository userRepository ;
    @Override
    public String handleHome(Map<String, Object> inModel) throws QuizException{
        try {
            // Get user on session
            if (sUser == null || sUser.getStrUsername() == null || sUser.getStrUsername().equals("")
                    || sUser.getStrUsername().equals("null")) {
                // If not logged in, redirect to login page
                return QuizTrasitionConst.AUTH.LOG_IN;
            }
            // Check login
            //		System.out.println(">>>>>>>>>> Account OK:" + getSUser().getStrUsername() + " >>>>>>>>>>>");
            inModel.put("fullname", sUser.getStrFullName());
            return QuizTrasitionConst.TEMPLATE.HOME;
        } catch (Exception ex) {
            Logger.getLogger(UserServiceImpl.class).error(ex);
            throw new QuizException(1, CommonConst.ERROR_MESSAGER) ;
        }
    }

    @Override
    public ModelAndView handleLoggedIn() {
        try {
            ModelAndView modelAndView = new ModelAndView("archive");
            if (!(sUser == null || sUser.getStrUsername() == null || sUser.getStrUsername().equals(""))) {
                modelAndView.addObject("currentUser", sUser);
            }
            return modelAndView;
        } catch (Exception ex) {
            Logger.getLogger(UserServiceImpl.class).error(ex);
            return null;
        }
    }

    @Override
    public String handleLogout(HttpServletRequest request) {
        try {
            sUser = new SUser();
            return JspUtil.redirect(QuizTrasitionConst.AUTH.LOG_IN, request);
        } catch (Exception ex) {
            Logger.getLogger(UserServiceImpl.class).error(ex);
            return null;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        try {
            SeiUser seiUser = userRepository.findSeiUserByUserId(userName);
            return new org.springframework.security.core.userdetails.User(
                    seiUser.getUserId(),
                    seiUser.getPassword(),
                    AuthorityUtils.createAuthorityList(seiUser.getTopMenu())
            );
        } catch (QuizException e) {
            e.printStackTrace();
        }
        return null;
    }
}
