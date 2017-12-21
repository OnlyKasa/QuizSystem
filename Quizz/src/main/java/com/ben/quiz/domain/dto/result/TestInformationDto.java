package com.ben.quiz.domain.dto.result;

import com.ben.quiz.domain.model.ExaminationInformation;
import com.ben.quiz.domain.model.StudentInformation;

public class TestInformationDto {
    private int iTestInformationPk;
    private Integer iStudentInformationPk;
    private Double fExaminationResultScore;
    private Integer iExaminationResultNumAnswerTrue;
    private Integer iTestInformationPkEk;
    private int iExaminationInformationPk;


    private StudentInformation studentInformationByIStudentInformationPk;
    private ExaminationInformation examinationInformationByIExaminationInformationPk;

    public int getiTestInformationPk() {
        return iTestInformationPk;
    }

    public void setiTestInformationPk(int iTestInformationPk) {
        this.iTestInformationPk = iTestInformationPk;
    }

    public Integer getiStudentInformationPk() {
        return iStudentInformationPk;
    }

    public void setiStudentInformationPk(Integer iStudentInformationPk) {
        this.iStudentInformationPk = iStudentInformationPk;
    }

    public Double getfExaminationResultScore() {
        return fExaminationResultScore;
    }

    public void setfExaminationResultScore(Double fExaminationResultScore) {
        this.fExaminationResultScore = fExaminationResultScore;
    }

    public Integer getiExaminationResultNumAnswerTrue() {
        return iExaminationResultNumAnswerTrue;
    }

    public void setiExaminationResultNumAnswerTrue(Integer iExaminationResultNumAnswerTrue) {
        this.iExaminationResultNumAnswerTrue = iExaminationResultNumAnswerTrue;
    }

    public Integer getiTestInformationPkEk() {
        return iTestInformationPkEk;
    }

    public void setiTestInformationPkEk(Integer iTestInformationPkEk) {
        this.iTestInformationPkEk = iTestInformationPkEk;
    }

    public int getiExaminationInformationPk() {
        return iExaminationInformationPk;
    }

    public void setiExaminationInformationPk(int iExaminationInformationPk) {
        this.iExaminationInformationPk = iExaminationInformationPk;
    }

    public StudentInformation getStudentInformationByIStudentInformationPk() {
        return studentInformationByIStudentInformationPk;
    }

    public void setStudentInformationByIStudentInformationPk(StudentInformation studentInformationByIStudentInformationPk) {
        this.studentInformationByIStudentInformationPk = studentInformationByIStudentInformationPk;
    }

    public ExaminationInformation getExaminationInformationByIExaminationInformationPk() {
        return examinationInformationByIExaminationInformationPk;
    }

    public void setExaminationInformationByIExaminationInformationPk(ExaminationInformation examinationInformationByIExaminationInformationPk) {
        this.examinationInformationByIExaminationInformationPk = examinationInformationByIExaminationInformationPk;
    }
}
