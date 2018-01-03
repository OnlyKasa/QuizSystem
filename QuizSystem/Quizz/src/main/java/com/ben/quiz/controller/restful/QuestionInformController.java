package com.ben.quiz.controller.restful;

import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.*;
import com.ben.quiz.domain.dto.result.ExaminationInformationDto;
import com.ben.quiz.domain.dto.result.QuestionInformDto;
import com.ben.quiz.domain.model.ExaminationInformation;
import com.ben.quiz.domain.model.ExaminationInformationDetail;
import com.ben.quiz.domain.model.QuestionInformation;
import com.ben.quiz.service.interfaces.ExaminationInformService;
import com.ben.quiz.service.interfaces.QuestionInformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionInformController {



    @Autowired
    private QuestionInformService questionInformService ;


    @GetMapping("/findBySubjectID/{iSubjectInformationPk}")
    public List<QuestionInformDto> findDetailExamination(@PathVariable("iSubjectInformationPk") Integer iSubjectInformationPk, PagingReq pagingReq)throws QuizException {
        return  questionInformService.findBySubjectID(iSubjectInformationPk,pagingReq);
    }

    @GetMapping("/countBySubjectID/{iSubjectInformationPk}")
    public long countDetailExamination(@PathVariable("iSubjectInformationPk")Integer iSubjectInformationPk)throws QuizException{
        return  questionInformService.countBySubjectID(iSubjectInformationPk);
    }

    @GetMapping("/search")
    public List<QuestionInformDto> search(@Valid QuestionInformSearchReq questionInformSearchReq,
                                                  PagingReq pagingReq) throws QuizException {
        return questionInformService.search(questionInformSearchReq, pagingReq);
    }
    @GetMapping("/count")
    public long count(QuestionInformSearchReq questionInformSearchReq) throws QuizException{
        return questionInformService.count(questionInformSearchReq);
    }
    @GetMapping("/find/ID{iQuestionInformationPk}")
    public QuestionInformDto findByID(@PathVariable("iQuestionInformationPk") Integer iQuestionInformationPk)throws QuizException{
        return questionInformService.findByID(iQuestionInformationPk);
    }
    @PostMapping("/create")
    public QuestionInformation create(@RequestBody @Valid QuestionInformSaveReq saveReq) throws QuizException {
        return questionInformService.create(saveReq);
    }

    @PutMapping("/update")
    public QuestionInformation update(@RequestBody @Valid QuestionInformSaveReq saveReq) throws QuizException {
        return questionInformService.update(saveReq);
    }

    @DeleteMapping("/delete/{iQuestionInformationPk}")
    public void delete(@PathVariable("iQuestionInformationPk") Integer iQuestionInformationPk) throws QuizException {
        questionInformService.delete(iQuestionInformationPk);
    }
}
