package com.ben.quiz.domain.repository.interfaces;

import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.QuestionInformSaveReq;
import com.ben.quiz.domain.dto.request.QuestionInformSearchReq;
import com.ben.quiz.domain.dto.result.QuestionInformDto;
import com.ben.quiz.domain.model.QuestionInformation;

import java.util.List;

public interface QuestionInformRepository extends BaseRepository {
    List<QuestionInformDto> search(QuestionInformSearchReq searchReq,
                                   PagingReq pagingReq) throws QuizException;
    long count(QuestionInformSearchReq searchReq)throws QuizException;

    QuestionInformDto findByID(Integer iQuestionInformationPk)throws QuizException;

    List<QuestionInformDto>findBySubjectID(Integer iSubjectInformationPk,
                                           PagingReq pagingReq) throws QuizException;
    Long countBySubjectID(Integer iSubjectInformationPk) throws QuizException;

    QuestionInformation create(QuestionInformSaveReq saveReq) throws QuizException ;

    QuestionInformation update(QuestionInformSaveReq saveReq) throws QuizException ;

    void delete( Integer iQuestionInformationPk)throws QuizException ;
}
