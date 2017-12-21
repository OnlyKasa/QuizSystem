package com.ben.quiz.domain.repository.interfaces;

import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.TeacherInformationSaveReq;
import com.ben.quiz.domain.dto.request.TeacherInformationSearchReq;
import com.ben.quiz.domain.dto.result.TeacherInformDto;
import com.ben.quiz.domain.model.TeacherInformation;

import java.util.List;

public interface TeacherInformRepository extends BaseRepository {

    List<TeacherInformDto> search(TeacherInformationSearchReq searchReq,
                                  PagingReq pagingReq) throws QuizException;
    long count(TeacherInformationSearchReq searchReq)throws QuizException;

    TeacherInformDto findByID(Integer iTeacherInformationPk)throws QuizException;

    TeacherInformation create(TeacherInformationSaveReq saveReq) throws QuizException ;

    TeacherInformation update(TeacherInformationSaveReq saveReq) throws QuizException ;

    void delete( Integer iTeacherInformationPk)throws QuizException ;
}
