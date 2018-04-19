package com.ben.quiz.domain.dto.result;

import java.sql.Timestamp;

public class TestInformationDetailDto {

    private int iTestInformationDetailPk;
    private Integer iTestInformationPk;
    private Integer iQuestionInformationPk;


    private String strStudentAnswer;
    private String strQuestionContentInformation;
    private String strAnswer1 ;
    private String strAnswer2 ;
    private String strAnswer3 ;
    private String strAnswer4 ;
    private String strAnswer5 ;
    private Integer iQuestionInformationLevel ;

    private Timestamp dtExaminationDay ;
    private Integer iTestInformationTime;
    private String strSubjectInformationName;


    public Timestamp getDtExaminationDay() {
        return dtExaminationDay;
    }

    public void setDtExaminationDay(Timestamp dtExaminationDay) {
        this.dtExaminationDay = dtExaminationDay;
    }

    public Integer getiTestInformationTime() {
        return iTestInformationTime;
    }

    public void setiTestInformationTime(Integer iTestInformationTime) {
        this.iTestInformationTime = iTestInformationTime;
    }

    public String getStrSubjectInformationName() {
        return strSubjectInformationName;
    }

    public void setStrSubjectInformationName(String strSubjectInformationName) {
        this.strSubjectInformationName = strSubjectInformationName;
    }

    public String getStrQuestionContentInformation() {
        return strQuestionContentInformation;
    }

    public void setStrQuestionContentInformation(String strQuestionContentInformation) {
        this.strQuestionContentInformation = strQuestionContentInformation;
    }

    public String getStrAnswer1() {
        return strAnswer1;
    }

    public void setStrAnswer1(String strAnswer1) {
        this.strAnswer1 = strAnswer1;
    }

    public String getStrAnswer2() {
        return strAnswer2;
    }

    public void setStrAnswer2(String strAnswer2) {
        this.strAnswer2 = strAnswer2;
    }

    public String getStrAnswer3() {
        return strAnswer3;
    }

    public void setStrAnswer3(String strAnswer3) {
        this.strAnswer3 = strAnswer3;
    }

    public String getStrAnswer4() {
        return strAnswer4;
    }

    public void setStrAnswer4(String strAnswer4) {
        this.strAnswer4 = strAnswer4;
    }

    public String getStrAnswer5() {
        return strAnswer5;
    }

    public void setStrAnswer5(String strAnswer5) {
        this.strAnswer5 = strAnswer5;
    }

    public Integer getiQuestionInformationLevel() {
        return iQuestionInformationLevel;
    }

    public void setiQuestionInformationLevel(Integer iQuestionInformationLevel) {
        this.iQuestionInformationLevel = iQuestionInformationLevel;
    }

    public int getiTestInformationDetailPk() {
        return iTestInformationDetailPk;
    }

    public void setiTestInformationDetailPk(int iTestInformationDetailPk) {
        this.iTestInformationDetailPk = iTestInformationDetailPk;
    }

    public Integer getiTestInformationPk() {
        return iTestInformationPk;
    }

    public void setiTestInformationPk(Integer iTestInformationPk) {
        this.iTestInformationPk = iTestInformationPk;
    }

    public Integer getiQuestionInformationPk() {
        return iQuestionInformationPk;
    }

    public void setiQuestionInformationPk(Integer iQuestionInformationPk) {
        this.iQuestionInformationPk = iQuestionInformationPk;
    }

    public String getStrStudentAnswer() {
        return strStudentAnswer;
    }

    public void setStrStudentAnswer(String strStudentAnswer) {
        this.strStudentAnswer = strStudentAnswer;
    }
}
