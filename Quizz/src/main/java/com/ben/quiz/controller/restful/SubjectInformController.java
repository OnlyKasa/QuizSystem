package com.ben.quiz.controller.restful;

import com.ben.quiz.controller.base.BaseControllerRestful;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.*;
import com.ben.quiz.domain.dto.result.SubjectInformationDto;
import com.ben.quiz.domain.model.SubjectInformation;
import com.ben.quiz.domain.repository.interfaces.SubjectInformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectInformController extends BaseControllerRestful {
    private final SubjectInformRepository subjectInformRepository;

    @Autowired
    public SubjectInformController(SubjectInformRepository subjectInformRepository) {
        this.subjectInformRepository = subjectInformRepository;
    }

    @GetMapping("/search")
    public List<SubjectInformationDto> search(@Valid SubjectInformationSearchReq searchReq,
                                         PagingReq pagingReq) throws QuizException {
        return subjectInformRepository.search(searchReq, pagingReq);
    }
    @GetMapping("/count")
    public long count(SubjectInformationSearchReq searchReq) throws QuizException{
        return subjectInformRepository.count(searchReq);
    }
    @GetMapping("/find/ID{iSubjectInformationPk}")
    public SubjectInformationDto findByID(@PathVariable("iSubjectInformationPk") Integer iSubjectInformationPk)throws QuizException{
        return subjectInformRepository.findByID(iSubjectInformationPk);
    }
    @PostMapping("/create")
    public SubjectInformation create(@RequestBody @Valid SubjectInformationSaveReq saveReq) throws QuizException {
        return subjectInformRepository.create(saveReq);
    }

    @PostMapping("/update")
    public SubjectInformation update(@RequestBody @Valid SubjectInformationSaveReq saveReq) throws QuizException {
        return subjectInformRepository.update(saveReq);
    }

    @DeleteMapping("/delete/{iSubjectInformationPk}")
    public void delete(@PathVariable("iSubjectInformationPk") Integer iSubjectInformationPk) throws QuizException {
        subjectInformRepository.delete(iSubjectInformationPk);
    }
}

