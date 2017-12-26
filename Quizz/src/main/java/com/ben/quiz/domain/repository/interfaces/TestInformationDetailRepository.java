package com.ben.quiz.domain.repository.interfaces;

import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.result.TestInformationDetailDto;
import com.ben.quiz.domain.model.TestInformation;
import com.ben.quiz.domain.model.TestInformationDetail;

import java.util.List;

public interface TestInformationDetailRepository extends BaseRepository{

    TestInformationDetailDto findByQuestionPkAndTestInformPk(Integer iQuestionInformationPk,
                                                             Integer iTestInformationPk) throws QuizException;

    List<TestInformationDetailDto> findByTestInformationPk(Integer iTestInformationPk) throws QuizException;

}
