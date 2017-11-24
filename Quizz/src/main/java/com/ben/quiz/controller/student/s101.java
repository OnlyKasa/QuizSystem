package com.ben.quiz.controller.student;

import com.ben.quiz.controller.base.BaseControllerWeb;
import com.ben.quiz.domain.common.constant.QuizTrasitionConst;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
@Controller
@RequestMapping(QuizTrasitionConst.STUDENT.PAGE_TEST)
public class s101 extends BaseControllerWeb {

    @RequestMapping("/ID/{iTestInformationPk}")
    public String prepareEdit(Map<String, Object> inModel, @PathVariable(value = "iTestInformationPk") Integer iTestInformationPk) {
        inModel.put("iTestInformationPk", iTestInformationPk);
        return getDefaultPageMap(inModel, "S101");
    }
}
