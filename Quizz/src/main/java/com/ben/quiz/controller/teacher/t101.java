package com.ben.quiz.controller.teacher;

import com.ben.quiz.controller.base.BaseControllerWeb;
import com.ben.quiz.domain.common.constant.QuizTrasitionConst;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
@Controller
@RequestMapping(QuizTrasitionConst.TEACHER.PAGE_GET_EXAMINATION)
public class t101 extends BaseControllerWeb {
    @Override
    @RequestMapping
    public String init(Map<String, Object> inModel) {
        return getDefaultPageMap(inModel, "T101");
    }
}
