package com.ben.quiz.domain.dto.result;

public class ExaminationInformationDetailDto {

    private Integer iTestInformationPk;
    private Integer iExaminationInformationPk;
    private Integer iStudentInformationPk;
    private String iStudentInformationCode;
    private String strStudentInformationFirstName;
    private String strStudentInformationLastName;
    private String strFacultyInformationFullName;


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

    public String getStrFacultyInformationFullName() {
        return strFacultyInformationFullName;
    }

    public void setStrFacultyInformationFullName(String strFacultyInformationFullName) {
        this.strFacultyInformationFullName = strFacultyInformationFullName;
    }

    public Integer getiTestInformationPk() {
        return iTestInformationPk;
    }

    public void setiTestInformationPk(Integer iTestInformationPk) {
        this.iTestInformationPk = iTestInformationPk;
    }

    public Integer getiExaminationInformationPk() {
        return iExaminationInformationPk;
    }

    public void setiExaminationInformationPk(Integer iExaminationInformationPk) {
        this.iExaminationInformationPk = iExaminationInformationPk;
    }

    public Integer getiStudentInformationPk() {
        return iStudentInformationPk;
    }

    public void setiStudentInformationPk(Integer iStudentInformationPk) {
        this.iStudentInformationPk = iStudentInformationPk;
    }
}
