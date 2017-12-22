package com.ben.quiz.controller.admin.question;

import com.ben.quiz.controller.base.BaseControllerWeb;
import com.ben.quiz.domain.common.constant.QuizTrasitionConst;
import com.ben.quiz.domain.common.exception.QuizException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping(QuizTrasitionConst.ADMIN.PAGE_QUESTION_EDIT)
public class Question_edit extends BaseControllerWeb {

    @RequestMapping("/ID/{iQuestionInformation}")
    public String prepareEdit(Map<String, Object> inModel,
                              @PathVariable(value = "iQuestionInformation") Integer iQuestionInformation) throws QuizException {

        if(Objects.equals( getUser().getStrTopMenu(), "ADM")
                || Objects.equals( getUser().getStrTopMenu(), "")
                || Objects.equals( getUser().getStrTopMenu(), "TEA")
                ){
            inModel.put("iQuestionInformation", iQuestionInformation);
            inModel.put("screenCode",  getUser().getStrTopMenu());
            return getDefaultPageMap(inModel, "A104_1");
        }else
            return redirect(QuizTrasitionConst.ERROR);
    }
}
