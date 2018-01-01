package com.ben.quiz.domain.repository.interfaces;

import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.RateOfDifficultyReq;
import com.ben.quiz.domain.dto.result.RateOfDifficultyDto;
import com.ben.quiz.domain.model.RateOfDifficulty;

import java.util.List;

public interface RateOfDifficultyRepository extends BaseRepository{

    List<RateOfDifficultyDto> search(RateOfDifficultyReq searchReq,
                                     PagingReq pagingReq) throws QuizException;
    long count(RateOfDifficultyReq searchReq)throws QuizException;

    RateOfDifficultyDto findByID(Integer iRateOfDifficultyPk)throws QuizException;

    RateOfDifficulty create(RateOfDifficultyReq saveReq) throws QuizException ;

    RateOfDifficulty update(RateOfDifficultyReq saveReq) throws QuizException ;

    void delete( Integer iRateOfDifficultyPk)throws QuizException ;
}
