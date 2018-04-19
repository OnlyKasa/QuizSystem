package com.ben.quiz.domain.dto.request;

import com.ben.quiz.domain.dto.result.TestInformationDetailDto;
import com.ben.quiz.domain.model.ExaminationInformation;
import com.ben.quiz.domain.model.StudentInformation;

import java.util.List;

public class TestInformationSaveReq {

    private int iTestInformationPk;
    private Integer iStudentInformationPk;
    private Double fExaminationResultScore;
    private Integer iExaminationResultNumAnswerTrue;
    private Integer iTestInformationPkEk;
    private Integer iExaminationInformationPk;
    private StudentInformation studentInformationByIStudentInformationPk;
    private ExaminationInformation examinationInformationByIExaminationInformationPk;

    private List<Integer> listiQuestionInformationPk ;
    private List<Integer> listDeleteiQuestionInformationPk;

    private List<TestInformationDetailDto>testInformationDetailDtos;

    public List<TestInformationDetailDto> getTestInformationDetailDtos() {
        return testInformationDetailDtos;
    }

    public void setTestInformationDetailDtos(List<TestInformationDetailDto> testInformationDetailDtos) {
        this.testInformationDetailDtos = testInformationDetailDtos;
    }

    public List<Integer> getListDeleteiQuestionInformationPk() {
        return listDeleteiQuestionInformationPk;
    }

    public void setListDeleteiQuestionInformationPk(List<Integer> listDeleteiQuestionInformationPk) {
        this.listDeleteiQuestionInformationPk = listDeleteiQuestionInformationPk;
    }

    public List<Integer> getListiQuestionInformationPk() {
        return listiQuestionInformationPk;
    }

    public void setListiQuestionInformationPk(List<Integer> listiQuestionInformationPk) {
        this.listiQuestionInformationPk = listiQuestionInformationPk;
    }

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

    public Integer getiExaminationInformationPk() {
        return iExaminationInformationPk;
    }

    public void setiExaminationInformationPk(Integer iExaminationInformationPk) {
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
