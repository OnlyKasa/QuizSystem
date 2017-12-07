package com.ben.quiz.service.interfaces;

import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.SubjectInformationSaveReq;
import com.ben.quiz.domain.dto.request.SubjectInformationSearchReq;
import com.ben.quiz.domain.dto.result.SubjectInformationDto;
import com.ben.quiz.domain.model.SubjectInformation;

import java.util.List;

public interface SubjectInformService {

    List<SubjectInformationDto> search(SubjectInformationSearchReq searchReq,
                                       PagingReq pagingReq) throws QuizException;
    long count(SubjectInformationSearchReq searchReq)throws QuizException;

    SubjectInformationDto findByID(Integer iSubjectInformationPk)throws QuizException;

    SubjectInformation create(SubjectInformationSaveReq saveReq) throws QuizException ;

    SubjectInformation update(SubjectInformationSaveReq saveReq) throws QuizException ;

    void delete( Integer iSubjectInformationPk)throws QuizException ;
}
