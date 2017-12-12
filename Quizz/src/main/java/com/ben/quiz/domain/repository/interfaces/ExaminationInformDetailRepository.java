package com.ben.quiz.domain.repository.interfaces;

import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.model.ExaminationInformationDetail;

import java.util.List;

public interface ExaminationInformDetailRepository extends BaseRepository{
    List<ExaminationInformationDetail> findByStudent(Integer iStudentInformationPk) throws QuizException;

    List<ExaminationInformationDetail> findByExamination(Integer iExaminationInformationPk) throws QuizException;

    ExaminationInformationDetail findByStudentPkAndExaminationPk(Integer iStudentInformationPk,
                                   Integer iExaminationInformationPk) throws QuizException;
}