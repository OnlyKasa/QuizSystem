package com.ben.quiz.controller.restful;

import com.ben.quiz.controller.base.BaseControllerRestful;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.TeacherInformationSaveReq;
import com.ben.quiz.domain.dto.request.TeacherInformationSearchReq;
import com.ben.quiz.domain.dto.result.TeacherInformDto;
import com.ben.quiz.domain.model.TeacherInformation;
import com.ben.quiz.service.interfaces.TeacherInformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherInformController extends BaseControllerRestful {

    private final TeacherInformService teacherInformService;

    @Autowired
    public TeacherInformController(TeacherInformService teacherInformService) {
        this.teacherInformService = teacherInformService;
    }

    @GetMapping("/search")
    public List<TeacherInformDto> search(@Valid TeacherInformationSearchReq  searchReq,
                                         PagingReq pagingReq) throws QuizException {
        //TODO teacher + faculty left join
        return teacherInformService.search(searchReq, pagingReq);
    }
    @GetMapping("/count")
    public long count(@Valid TeacherInformationSearchReq searchReq) throws QuizException{
        return teacherInformService.count(searchReq);
    }
    @GetMapping("/find/ID{iTeacherInformationPk}")
    public TeacherInformDto findByID(@PathVariable("iTeacherInformationPk")
                                                 Integer iTeacherInformationPk)
            throws QuizException{
        return teacherInformService.findByID(iTeacherInformationPk);
    }
    @GetMapping("/findByFacultyPk/ID{iFacultyInformationPk}")
    public List<TeacherInformDto> findByFacultyPk(@PathVariable("iFacultyInformationPk")
                                             Integer iFacultyInformationPk)
            throws QuizException{
        return teacherInformService.findByFacultyPk(iFacultyInformationPk);
    }
    @PostMapping("/create")
    public TeacherInformation create(@RequestBody @Valid TeacherInformationSaveReq saveReq)
            throws QuizException {
        return teacherInformService.create(saveReq);
    }

    @PostMapping("/update")
    public TeacherInformation update(@RequestBody @Valid TeacherInformationSaveReq saveReq)
            throws QuizException {
        return teacherInformService.update(saveReq);
    }

    @DeleteMapping("/delete/{iTeacherInformationPk}")
    public void delete(@PathVariable("iTeacherInformationPk") Integer iTeacherInformationPk)
            throws QuizException {
        teacherInformService.delete(iTeacherInformationPk);
    }


}
