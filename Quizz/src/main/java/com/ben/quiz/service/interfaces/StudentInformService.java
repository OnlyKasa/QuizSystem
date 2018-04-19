package com.ben.quiz.service.interfaces;

import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.StudentInformationSaveReq;
import com.ben.quiz.domain.dto.request.StudentInformationSearchReq;
import com.ben.quiz.domain.dto.result.StudentInformDto;
import com.ben.quiz.domain.model.StudentInformation;

import java.util.List;

public interface StudentInformService {

    List<StudentInformDto> search(StudentInformationSearchReq searchReq,
                                  PagingReq pagingReq) throws QuizException;
    long count(StudentInformationSearchReq searchReq)throws QuizException;

    StudentInformDto findByID(Integer iStudentInformationPk)throws QuizException;

    List<StudentInformDto> findByFacultyPk(Integer iFacultyInformationPk) throws QuizException;

    StudentInformation create(StudentInformationSaveReq saveReq) throws QuizException ;

    StudentInformation update(StudentInformationSaveReq saveReq) throws QuizException ;

    void delete( Integer iStudentInformationPk)throws QuizException ;

}
