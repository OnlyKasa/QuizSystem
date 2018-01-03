package com.ben.quiz.domain.repository.interfaces;

import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.model.TestInformationDetail;

public interface TestInformationDetailRepository extends BaseRepository{

    TestInformationDetail findByQuestionPkAndTestInformPk(Integer iQuestionInformationPk,
                                                          Integer iTestInformationPk) throws QuizException;
}
