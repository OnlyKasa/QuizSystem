package com.ben.quiz.service.interfaces;

import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.TestInformationSaveReq;
import com.ben.quiz.domain.dto.request.TestInformationSearchReq;
import com.ben.quiz.domain.dto.result.TestInformationDetailDto;
import com.ben.quiz.domain.dto.result.TestInformationDto;
import com.ben.quiz.domain.model.TestInformation;

import java.util.List;

public interface TestInformService {
    List<TestInformationDto> search(TestInformationSearchReq searchReq,
                                    PagingReq pagingReq) throws QuizException;
    long count(TestInformationSearchReq searchReq)throws QuizException;

    TestInformationDto findByID(Integer iTestInformationPk)throws QuizException;

    List<TestInformationDto> findByStudentPk(Integer iStudentInformationPk) throws QuizException;

    List<TestInformationDto> findByExaminationPk(Integer iExaminationInformationPk) throws QuizException;

    TestInformation create(TestInformationSaveReq saveReq) throws QuizException ;

    TestInformation update(TestInformationSaveReq saveReq) throws QuizException ;

    void delete( Integer iTestInformationPk)throws QuizException ;

    List<TestInformationDetailDto> findByTestID(Integer iTestInformationPk , PagingReq pagingReq) throws QuizException;

    long countByTestID(Integer iTestInformationPk) throws QuizException ;

    boolean updateByTestID(List<TestInformationDetailDto> testInformationDetailDtos) throws QuizException;

    boolean updateScore(Integer iTestInformationPk) throws QuizException;
}
