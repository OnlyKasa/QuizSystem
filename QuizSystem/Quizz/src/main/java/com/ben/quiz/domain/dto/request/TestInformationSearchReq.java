package com.ben.quiz.domain.dto.request;

public class TestInformationSearchReq {

    private String iStudentInformationCode;
    private String strStudentInformationFirstName;
    private String strStudentInformationLastName;

    private String strExaminationInformationCode;


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
