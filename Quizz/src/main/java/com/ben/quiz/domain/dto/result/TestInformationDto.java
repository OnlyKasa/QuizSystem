package com.ben.quiz.domain.dto.result;

import java.sql.Timestamp;

public class TestInformationDto {
    private int iTestInformationPk;
    private Integer iStudentInformationPk;
    private Double fExaminationResultScore;
    private Integer iExaminationResultNumAnswerTrue;
    private Integer iTestInformationPkEk;
    private int iExaminationInformationPk;

    private String iStudentInformationCode;
    private String strStudentInformationFirstName;
    private String strStudentInformationLastName;

    private String strExaminationInformationCode;
    private Timestamp dtExaminationDay;
    private int iTestInformationTime;


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


    public String getiStudentInformationCode() {
        return iStudentInformationCode;
    }

    public void setiStudentInformationCode(String iStudentInformationCode) {
        this.iStudentInformationCode = iStudentInformationCode;
    }

    public String getStrStudentInformationFirstName() {
        return strStudentInformationFirstName;
    }

    public void setStrStudentInformationFirstName(String strStudentInformationFirstName) {
        this.strStudentInformationFirstName = strStudentInformationFirstName;
    }

    public String getStrStudentInformationLastName() {
        return strStudentInformationLastName;
    }

    public void setStrStudentInformationLastName(String strStudentInformationLastName) {
        this.strStudentInformationLastName = strStudentInformationLastName;
    }

    public String getStrExaminationInformationCode() {
        return strExaminationInformationCode;
    }

    public void setStrExaminationInformationCode(String strExaminationInformationCode) {
        this.strExaminationInformationCode = strExaminationInformationCode;
    }

    public Timestamp getDtExaminationDay() {
        return dtExaminationDay;
    }

    public void setDtExaminationDay(Timestamp dtExaminationDay) {
        this.dtExaminationDay = dtExaminationDay;
    }

    public int getiTestInformationTime() {
        return iTestInformationTime;
    }

    public void setiTestInformationTime(int iTestInformationTime) {
        this.iTestInformationTime = iTestInformationTime;
    }
}
