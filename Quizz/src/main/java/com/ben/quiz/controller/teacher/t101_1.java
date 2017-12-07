package com.ben.quiz.controller.teacher;


import com.ben.quiz.controller.base.BaseControllerWeb;
import com.ben.quiz.domain.common.constant.QuizTrasitionConst;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
@Controller
@RequestMapping(QuizTrasitionConst.TEACHER.PAGE_EXAMINATION_DETAIL)
public class t101_1 extends BaseControllerWeb {
    @RequestMapping("/ID/{iExaminationInformationPk}")
    public String prepareEdit(Map<String, Object> inModel,
                              @PathVariable(value = "iExaminationInformationPk") Integer iExaminationInformationPk) {
        inModel.put("iExaminationInformationPk", iExaminationInformationPk);
        return getDefaultPageMap(inModel, "T101_1");
    }
}
