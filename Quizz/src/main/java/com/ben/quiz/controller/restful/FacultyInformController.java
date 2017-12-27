package com.ben.quiz.controller.restful;

import com.ben.quiz.controller.base.BaseControllerRestful;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.FacultyInformSearchReq;
import com.ben.quiz.domain.dto.request.FacultyInformationSaveReq;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.result.FacultyInformDto;
import com.ben.quiz.domain.model.FacultyInformation;
import com.ben.quiz.service.interfaces.FacultyInformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyInformController extends BaseControllerRestful {
    @Autowired
    FacultyInformService facultyInformService;

    @GetMapping("/search")
    public List<FacultyInformDto> search(@Valid FacultyInformSearchReq facultyInformSearchReq,
                                  PagingReq pagingReq) throws QuizException{
        return facultyInformService.search(facultyInformSearchReq, pagingReq);
    }
    @GetMapping("/count")
    public long count(FacultyInformSearchReq facultyInformSearchReq) throws QuizException{
        return facultyInformService.count(facultyInformSearchReq);
    }
    @GetMapping("/find/ID{iFacultyInformationPk}")
    public FacultyInformDto findByID(@PathVariable("iFacultyInformationPk") Integer iFacultyInformationPk)throws QuizException{
        return facultyInformService.findByID(iFacultyInformationPk);
    }
    @PostMapping("/create")
    public FacultyInformation create(@RequestBody @Valid FacultyInformationSaveReq saveReq) throws QuizException {
        return facultyInformService.create(saveReq);
    }

    @PostMapping("/update")
    public FacultyInformation update(@RequestBody @Valid FacultyInformationSaveReq saveReq) throws QuizException {
        return facultyInformService.update(saveReq);
    }

    @DeleteMapping("/delete/{iFacultyInformationPk}")
    public void delete(@PathVariable("iFacultyInformationPk") Integer iFacultyInformationPk) throws QuizException {
        facultyInformService.delete(iFacultyInformationPk);
    }

}
