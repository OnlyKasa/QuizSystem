package com.ben.quiz.controller.admin.examination;

import com.ben.quiz.controller.base.BaseControllerWeb;
import com.ben.quiz.domain.common.constant.QuizTrasitionConst;
import com.ben.quiz.domain.common.exception.QuizException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping(QuizTrasitionConst.ADMIN.PAGE_LIST_STUDENT_CREATE)
public class Student_list_create extends BaseControllerWeb {

    @RequestMapping("")
    public String prepareEdit(Map<String, Object> inModel, Integer iExaminationInformationPk, Integer numberStudent,Integer percentMatch) throws QuizException {

        if(Objects.equals( getUser().getStrTopMenu(), "ADM")
                || Objects.equals( getUser().getStrTopMenu(), "")
                || Objects.equals( getUser().getStrTopMenu(), "TEA")
                ){
            inModel.put("iExaminationInformationPk", iExaminationInformationPk);
            inModel.put("numberStudent", numberStudent);
            inModel.put("screenCode",  getUser().getStrTopMenu());
            inModel.put("percentMatch",  percentMatch);

            return getDefaultPageMap(inModel, "A101_4");
        }else
            return redirect(QuizTrasitionConst.ERROR);
    }
}
