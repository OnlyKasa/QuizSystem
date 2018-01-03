package com.ben.quiz.controller.restful;


import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.result.TestInformationDetailDto;
import com.ben.quiz.service.interfaces.TestInformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
