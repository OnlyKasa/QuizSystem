package com.ben.quiz.domain.dto.request;

import java.sql.Timestamp;

public class TestInformationSearchReq {

    private String iStudentInformationCode;
    private String strStudentInformationFirstName;
    private String strStudentInformationLastName;

    private String strExaminationInformationCode;

    private Timestamp dtExaminationDay;
    private String strSubjectInformationName;

    private Integer iStudentInformationPk;

    public Integer getiStudentInformationPk() {
        return iStudentInformationPk;
    }

    public void setiStudentInformationPk(Integer iStudentInformationPk) {
        this.iStudentInformationPk = iStudentInformationPk;
    }

    public Timestamp getDtExaminationDay() {
        return dtExaminationDay;
    }

    public void setDtExaminationDay(Timestamp dtExaminationDay) {
        this.dtExaminationDay = dtExaminationDay;
    }

    public String getStrSubjectInformationName() {
        return strSubjectInformationName;
    }

    public void setStrSubjectInformationName(String strSubjectInformationName) {
        this.strSubjectInformationName = strSubjectInformationName;
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
}
