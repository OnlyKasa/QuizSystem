package com.ben.quiz.controller.admin.student;

import com.ben.quiz.controller.base.BaseControllerWeb;
import com.ben.quiz.domain.common.constant.QuizTrasitionConst;
import com.ben.quiz.domain.common.exception.QuizException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping(QuizTrasitionConst.ADMIN.PAGE_STUDENT_CREATE)
public class Student_create extends BaseControllerWeb {

    @RequestMapping()
    public String prepareEdit(Map<String, Object> inModel)throws QuizException {
        if(Objects.equals( getUser().getStrTopMenu(), "ADM")
                || Objects.equals( getUser().getStrTopMenu(), "")
                || Objects.equals( getUser().getStrTopMenu(), "TEA")
                ){
            inModel.put("screenCode",  getUser().getStrTopMenu());
            return getDefaultPageMap(inModel, "A106_2");
        }else
            return redirect(QuizTrasitionConst.ERROR);
    }
}
