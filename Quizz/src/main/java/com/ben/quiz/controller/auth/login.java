package com.ben.quiz.controller.auth;


import com.ben.quiz.controller.base.BaseControllerWeb;
import com.ben.quiz.domain.common.constant.QuizTrasitionConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.model.SUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping(QuizTrasitionConst.AUTH.LOG_IN)
public class login  extends BaseControllerWeb{

    @Override
    @RequestMapping
    public String init(Map<String, Object> inModel) throws QuizException {
        return getDefaultPageMap(inModel);
    }
}

