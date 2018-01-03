package com.ben.quiz.domain.repository.interfaces;

import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.TestInformationSearchReq;
import com.ben.quiz.domain.dto.result.TestInformationDto;

import java.util.List;

public interface TestInformRepository extends BaseRepository{
    List<TestInformationDto> search(TestInformationSearchReq searchReq,
                                    PagingReq pagingReq) throws QuizException;
    long count(TestInformationSearchReq searchReq)throws QuizException;

    TestInformationDto findByID(Integer iTestInformationPk)throws QuizException;

}
