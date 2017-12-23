package com.ben.quiz.controller.admin.teacher;

import com.ben.quiz.controller.base.BaseControllerWeb;
import com.ben.quiz.domain.common.constant.QuizTrasitionConst;
import com.ben.quiz.domain.common.exception.QuizException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping(QuizTrasitionConst.ADMIN.PAGE_TEACHER_EDIT)
public class Teacher_edit extends BaseControllerWeb {

    @RequestMapping("/{iTeacherInformationPk}")
    public String prepareEdit(Map<String, Object> inModel,
                              @PathVariable(value = "iTeacherInformationPk") Integer iTeacherInformationPk) throws QuizException {

        if(Objects.equals( getUser().getStrTopMenu(), "ADM") || Objects.equals( getUser().getStrTopMenu(), "")){
            inModel.put("iTeacherInformationPk", iTeacherInformationPk);
            inModel.put("screenCode",  getUser().getStrTopMenu());
            return getDefaultPageMap(inModel, "A107_1");
        }else
            return redirect(QuizTrasitionConst.ERROR);
    }
}
