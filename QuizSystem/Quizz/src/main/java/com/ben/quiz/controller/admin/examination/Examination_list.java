package com.ben.quiz.controller.admin.examination;

import com.ben.quiz.controller.base.BaseControllerWeb;
import com.ben.quiz.domain.common.constant.QuizTrasitionConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.model.SUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping(QuizTrasitionConst.ADMIN.PAGE_EXAMINATION_LIST)
public class Examination_list extends BaseControllerWeb {

    @Override
    @RequestMapping
    public String init(Map<String, Object> inModel) throws QuizException {
        if(Objects.equals( getUser().getStrTopMenu(), "ADM")
                || Objects.equals( getUser().getStrTopMenu(), "")
                || Objects.equals( getUser().getStrTopMenu(), "TEA")
                ){
            inModel.put("screenCode",  getUser().getStrTopMenu());
            return getDefaultPageMap(inModel, "A101");
        }else
           return redirect(QuizTrasitionConst.ERROR);
    }
}
