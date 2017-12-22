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
@RequestMapping(QuizTrasitionConst.ADMIN.PAGE_EXAMINATION_EDIT)
public class Examination_edit extends BaseControllerWeb {

    @RequestMapping("/ID/{iExaminationInformationPk}")
    public String prepareEdit(Map<String, Object> inModel,
                              @PathVariable(value = "iExaminationInformationPk") Integer iExaminationInformationPk) throws QuizException {

        if(Objects.equals( getUser().getStrTopMenu(), "ADM")
                || Objects.equals( getUser().getStrTopMenu(), "")
                || Objects.equals( getUser().getStrTopMenu(), "TEA")
                ){
            inModel.put("iExaminationInformationPk", iExaminationInformationPk);
            inModel.put("screenCode",  getUser().getStrTopMenu());
            return getDefaultPageMap(inModel, "A101_1");
        }else
            return redirect(QuizTrasitionConst.ERROR);
    }
}
