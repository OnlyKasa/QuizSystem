package com.ben.quiz.domain.repository.interfaces;

import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.ExaminationInformationSaveReq;
import com.ben.quiz.domain.dto.request.ExaminationInformationSearchReq;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.result.ExaminationInformationDto;
import com.ben.quiz.domain.model.ExaminationInformation;

import java.util.List;

public interface ExaminationInformRepository extends BaseRepository{
    List<ExaminationInformationDto> search(ExaminationInformationSearchReq searchReq,
                                           PagingReq pagingReq) throws QuizException;
    long count(ExaminationInformationSearchReq searchReq)throws QuizException;

    ExaminationInformationDto findByID(Integer iExaminationInformationPk)throws QuizException;

    ExaminationInformation create(ExaminationInformationSaveReq saveReq) throws QuizException ;

    ExaminationInformation update(ExaminationInformationSaveReq saveReq) throws QuizException ;

    void delete( Integer iExaminationInformationPk)throws QuizException ;

}
