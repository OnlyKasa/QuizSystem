package com.ben.quiz.controller.student;

import com.ben.quiz.controller.base.BaseControllerWeb;
import com.ben.quiz.domain.common.constant.QuizTrasitionConst;
import com.ben.quiz.domain.common.exception.QuizException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping(QuizTrasitionConst.STUDENT.PAGE_VIEW_TESTS)
public class s102 extends BaseControllerWeb {
    @RequestMapping()
    public String prepareEdit(Map<String, Object> inModel) throws QuizException {
        if(Objects.equals( getUser().getStrTopMenu(), "STU")
                || Objects.equals( getUser().getStrTopMenu(), "")
                ){
            inModel.put("iStudentInformationPk",getUser().getiStudentInformationPk());
            inModel.put("screenCode",  getUser().getStrTopMenu());
            return getDefaultPageMap(inModel, "S102");
        }else
            return redirect(QuizTrasitionConst.ERROR);
    }
}