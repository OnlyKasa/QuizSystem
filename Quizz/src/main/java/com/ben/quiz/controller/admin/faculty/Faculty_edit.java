package com.ben.quiz.controller.admin.faculty;

import com.ben.quiz.controller.base.BaseControllerWeb;
import com.ben.quiz.domain.common.constant.QuizTrasitionConst;
import com.ben.quiz.domain.common.exception.QuizException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping(QuizTrasitionConst.ADMIN.PAGE_FACULTY_EDIT)
public class Faculty_edit extends BaseControllerWeb {

    @RequestMapping("/{iFacultyInformationPk}")
    public String prepareEdit(Map<String, Object> inModel,
                              @PathVariable(value = "iFacultyInformationPk") Integer iFacultyInformationPk) throws QuizException {

        if(Objects.equals( getUser().getStrTopMenu(), "ADM") || Objects.equals( getUser().getStrTopMenu(), "")){
            inModel.put("iFacultyInformationPk", iFacultyInformationPk);
            inModel.put("screenCode",  getUser().getStrTopMenu());
            return getDefaultPageMap(inModel, "A109_1");
        }else
            return redirect(QuizTrasitionConst.ERROR);
    }
}
