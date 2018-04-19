package com.ben.quiz.controller.restful;


import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.*;
import com.ben.quiz.domain.dto.result.ExaminationInformationDto;
import com.ben.quiz.domain.dto.result.FacultyInformDto;
import com.ben.quiz.domain.model.ExaminationInformation;
import com.ben.quiz.domain.model.ExaminationInformationDetail;
import com.ben.quiz.domain.model.FacultyInformation;
import com.ben.quiz.service.interfaces.ExaminationInformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/examination")
public class ExaminationInformController {

    @Autowired
    private ExaminationInformService examinationInformService ;


    @GetMapping("/findDetailExamination/{iExaminationInformationPk}")
    public List<ExaminationInformationDetail>  findDetailExamination(@PathVariable("iExaminationInformationPk") Integer iExaminationInformationPk, PagingReq pagingReq)throws QuizException{
        return  examinationInformService.findDetailExamination(iExaminationInformationPk,pagingReq);
    }

    @GetMapping("/countDetailExamination/{iExaminationInformationPk}")
    public long countDetailExamination(@PathVariable("iExaminationInformationPk")Integer iExaminationInformationPk)throws QuizException{
        return  examinationInformService.countDetailExamination(iExaminationInformationPk);
    }

    @GetMapping("/search")
    public List<ExaminationInformationDto> search(@Valid ExaminationInformationSearchReq examinationInformationSearchReq,
                                                  PagingReq pagingReq) throws QuizException {
        return examinationInformService.search(examinationInformationSearchReq, pagingReq);
    }
    @GetMapping("/count")
    public long count(ExaminationInformationSearchReq examinationInformationSearchReq) throws QuizException{
        return examinationInformService.count(examinationInformationSearchReq);
    }
    @GetMapping("/find/ID{iExaminationInformationPk}")
    public ExaminationInformationDto findByID(@PathVariable("iExaminationInformationPk") Integer iExaminationInformationPk)throws QuizException{
        return examinationInformService.findByID(iExaminationInformationPk);
    }
    @PostMapping("/create")
    public ExaminationInformation create(@RequestBody @Valid ExaminationInformationSaveReq saveReq) throws QuizException {
        return examinationInformService.create(saveReq);
    }

    @PutMapping("/update")
    public ExaminationInformation update(@RequestBody @Valid ExaminationInformationSaveReq saveReq) throws QuizException {
        return examinationInformService.update(saveReq);
    }

    @DeleteMapping("/delete/{iExaminationInformationPk}")
    public void delete(@PathVariable("iExaminationInformationPk") Integer iExaminationInformationPk) throws QuizException {
        examinationInformService.delete(iExaminationInformationPk);
    }
}
