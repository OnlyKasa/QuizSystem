package com.ben.quiz.service.interfaces;

import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.ExaminationInformationSaveReq;
import com.ben.quiz.domain.dto.request.ExaminationInformationSearchReq;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.result.ExaminationInformationDto;
import com.ben.quiz.domain.model.ExaminationInformation;
import com.ben.quiz.domain.model.ExaminationInformationDetail;
import com.ben.quiz.domain.model.ExaminationInformationDetail_;

import java.util.List;

public interface ExaminationInformService {

    List<ExaminationInformationDto> search(ExaminationInformationSearchReq searchReq,
                                           PagingReq pagingReq) throws QuizException;
    long count(ExaminationInformationSearchReq searchReq)throws QuizException;

    ExaminationInformationDto findByID(Integer iExaminationInformationPk)throws QuizException;

    List<ExaminationInformationDto> findByDifficultyPk(Integer iRateOfDifficultyPk) throws QuizException;
    List<ExaminationInformationDto> findBySubjectPk(Integer iSubjectInformationPk) throws QuizException;
    List<ExaminationInformationDto> findByTeacherPk(Integer iTeacherInformationPk) throws QuizException;
    List<ExaminationInformationDto> findByRoomPk(Integer iExaminationRoomPk) throws QuizException;
    ExaminationInformation create(ExaminationInformationSaveReq saveReq) throws QuizException ;

    ExaminationInformation update(ExaminationInformationSaveReq saveReq) throws QuizException ;

    void delete( Integer iExaminationInformationPk)throws QuizException ;

    List<ExaminationInformationDetail> findDetailExamination(Integer iExaminationInformationPk, PagingReq pagingReq)throws QuizException;
    Long countDetailExamination(Integer iExaminationInformationPk) throws QuizException;
}
