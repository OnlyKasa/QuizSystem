package com.ben.quiz.service.interfaces;

import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.FacultyInformSearchReq;
import com.ben.quiz.domain.dto.request.FacultyInformationSaveReq;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.RateOfDifficultyReq;
import com.ben.quiz.domain.dto.result.FacultyInformDto;
import com.ben.quiz.domain.model.FacultyInformation;
import com.ben.quiz.domain.model.RateOfDifficulty;

import java.util.List;

public interface RateOfDifficultyService {

    List<RateOfDifficulty> search(RateOfDifficultyReq searchReq,
                                  PagingReq pagingReq) throws QuizException;
    long count(RateOfDifficultyReq searchReq)throws QuizException;

    RateOfDifficulty findByID(Integer iRateOfDifficultyPk)throws QuizException;

    RateOfDifficulty create(RateOfDifficultyReq saveReq) throws QuizException ;

    RateOfDifficulty update(RateOfDifficultyReq saveReq) throws QuizException ;

    void delete( Integer iRateOfDifficultyPk)throws QuizException ;
}
