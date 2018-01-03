package com.ben.quiz.controller.student;

import com.ben.quiz.controller.base.BaseControllerWeb;
import com.ben.quiz.domain.common.constant.QuizTrasitionConst;
import com.ben.quiz.domain.common.exception.QuizException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping(QuizTrasitionConst.STUDENT.PAGE_TEST)
public class s101 extends BaseControllerWeb {
    @RequestMapping("/{iTestInformationPk}")
    public String prepareEdit(Map<String, Object> inModel, @PathVariable(value = "iTestInformationPk") Integer iTestInformationPk) throws QuizException {

        if(Objects.equals( getUser().getStrTopMenu(), "STU")
                || Objects.equals( getUser().getStrTopMenu(), "")
                ){
            inModel.put("screenCode",  getUser().getStrTopMenu());
            inModel.put("iTestInformationPk", iTestInformationPk);
            return getDefaultPageMap(inModel, "S101");
        }else
            return redirect(QuizTrasitionConst.ERROR);
    }
}
