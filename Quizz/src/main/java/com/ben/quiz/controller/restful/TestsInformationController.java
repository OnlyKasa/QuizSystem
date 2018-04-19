package com.ben.quiz.controller.restful;


import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.TestInformationSaveReq;
import com.ben.quiz.domain.dto.request.TestInformationSearchReq;
import com.ben.quiz.domain.dto.result.TestInformationDetailDto;
import com.ben.quiz.domain.dto.result.TestInformationDto;
import com.ben.quiz.service.interfaces.TestInformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tests")
public class TestsInformationController {

    @Autowired
    private TestInformService testInformService;


    @GetMapping("/countByTestID")
    public long countByTestID(Integer iTestInformationPk) throws QuizException {
        return testInformService.countByTestID(iTestInformationPk);
    }

    @GetMapping("/findByTestID")
    public List<TestInformationDetailDto> findByTestID(Integer iTestInformationPk , PagingReq pagingReq) throws QuizException {
        return testInformService.findByTestID(iTestInformationPk, pagingReq);
    }



    @GetMapping("/search")
    public List<TestInformationDto> search(@Valid TestInformationSearchReq examinationInformationSearchReq,
                                           PagingReq pagingReq) throws QuizException {
        return testInformService.search(examinationInformationSearchReq, pagingReq);
    }
    @GetMapping("/count")
    public long count(TestInformationSearchReq examinationInformationSearchReq) throws QuizException{
        return testInformService.count(examinationInformationSearchReq);
    }
    @GetMapping("/find/ID{iTestInformationPk}")
    public TestInformationDto findByID(@PathVariable("iTestInformationPk") Integer iTestInformationPk)throws QuizException{
        return testInformService.findByID(iTestInformationPk);
    }


    @PostMapping("/updateByTestID")
    public boolean updateByTestID(@RequestBody @Valid TestInformationSaveReq testInformationSaveReq) throws QuizException{
        return testInformService.updateByTestID(testInformationSaveReq.getTestInformationDetailDtos());
    }
    @GetMapping("/beginTest/{iTestInformationPk}")
    public boolean updateScore(@PathVariable("iTestInformationPk") Integer iTestInformationPk) throws QuizException{
        return  testInformService.updateScore(iTestInformationPk);
    }

}

