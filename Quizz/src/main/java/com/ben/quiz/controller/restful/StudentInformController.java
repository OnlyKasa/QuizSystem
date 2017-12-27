package com.ben.quiz.controller.restful;

import com.ben.quiz.controller.base.BaseControllerRestful;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.*;
import com.ben.quiz.domain.dto.result.StudentInformDto;
import com.ben.quiz.domain.model.StudentInformation;
import com.ben.quiz.service.interfaces.StudentInformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentInformController extends BaseControllerRestful {
    @Autowired
    StudentInformService studentInformService;

    @GetMapping("/search")
    public List<StudentInformDto> search(@Valid StudentInformationSearchReq searchReq,
                                         PagingReq pagingReq) throws QuizException {
        return studentInformService.search(searchReq, pagingReq);
    }
    @GetMapping("/count")
    public long count(StudentInformationSearchReq searchReq) throws QuizException{
        return studentInformService.count(searchReq);
    }
    @GetMapping("/find/ID{iStudentInformationPk}")
    public StudentInformDto findByID(@PathVariable("iStudentInformationPk") Integer iStudentInformationPk)throws QuizException{
        return studentInformService.findByID(iStudentInformationPk);
    }
    @PostMapping("/create")
    public StudentInformation create(@RequestBody @Valid StudentInformationSaveReq saveReq) throws QuizException {
        return studentInformService.create(saveReq);
    }

    @PostMapping("/update")
    public StudentInformation update(@RequestBody @Valid StudentInformationSaveReq saveReq) throws QuizException {
        return studentInformService.update(saveReq);
    }

    @DeleteMapping("/delete/{iStudentInformationPk}")
    public void delete(@PathVariable("iStudentInformationPk") Integer iStudentInformationPk) throws QuizException {
        studentInformService.delete(iStudentInformationPk);
    }
}