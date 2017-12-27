package com.ben.quiz.controller.admin.difficulty;

import com.ben.quiz.controller.base.BaseControllerWeb;
import com.ben.quiz.domain.common.constant.QuizTrasitionConst;
import com.ben.quiz.domain.common.exception.QuizException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping(QuizTrasitionConst.ADMIN.PAGE_DIFFICULTY_EDIT)
public class Difficulty_edit extends BaseControllerWeb {

    @RequestMapping("/{iRateOfDifficultyPk}")
    public String prepareEdit(Map<String, Object> inModel,
                              @PathVariable(value = "iRateOfDifficultyPk") Integer iRateOfDifficultyPk) throws QuizException {

        if(Objects.equals( getUser().getStrTopMenu(), "ADM")
                || Objects.equals( getUser().getStrTopMenu(), "")
                || Objects.equals( getUser().getStrTopMenu(), "TEA")
                ){
            inModel.put("iRateOfDifficultyPk", iRateOfDifficultyPk);
            inModel.put("screenCode",  getUser().getStrTopMenu());
            return getDefaultPageMap(inModel, "A102_1");
        }else
            return redirect(QuizTrasitionConst.ERROR);
    }
}
