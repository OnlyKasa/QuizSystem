package com.ben.quiz.controller.restful;


import com.ben.quiz.controller.base.BaseControllerRestful;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.UserLoginReq;
import com.ben.quiz.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController extends BaseControllerRestful {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Long login(@RequestBody @Valid UserLoginReq request) throws QuizException {
        return userService.actLogin(request);
    }

}
