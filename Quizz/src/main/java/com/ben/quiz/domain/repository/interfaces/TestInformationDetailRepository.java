package com.ben.quiz.domain.repository.interfaces;

import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.result.TestInformationDetailDto;
import com.ben.quiz.domain.model.TestInformation;
import com.ben.quiz.domain.model.TestInformationDetail;
import org.springframework.data.querydsl.QueryDslUtils;

import java.util.List;

public interface TestInformationDetailRepository extends BaseRepository{

    TestInformationDetailDto findByQuestionPkAndTestInformPk(Integer iQuestionInformationPk,
                                                             Integer iTestInformationPk) throws QuizException;

    List<TestInformationDetailDto> findByTestInformationPk(Integer iTestInformationPk, PagingReq pagingReq) throws QuizException;

    long countByTestID(Integer iTestInformationPk) throws QuizException ;
}
