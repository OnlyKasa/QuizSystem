package com.ben.quiz.domain.dto.request;

import java.sql.Date;

public class StudentInformationSearchReq {
    private String iStudentInformationCode;
    private Integer iFacultyInformationPk;
    private String strStudentInformationFirstName;
    private String strStudentInformationLastName;
    private Date dtStudentInformationBirthday;


    private String strFacultyInformationShortName;
    private String strFacultyInformationFullName;

    public String getStrFacultyInformationShortName() {
        return strFacultyInformationShortName;
    }

    public Date getDtStudentInformationBirthday() {
        return dtStudentInformationBirthday;
    }

    public void setDtStudentInformationBirthday(Date dtStudentInformationBirthday) {
        this.dtStudentInformationBirthday = dtStudentInformationBirthday;
    }

    public void setStrFacultyInformationShortName(String strFacultyInformationShortName) {
        this.strFacultyInformationShortName = strFacultyInformationShortName;
    }

    public String getStrFacultyInformationFullName() {
        return strFacultyInformationFullName;
    }

    public void setStrFacultyInformationFullName(String strFacultyInformationFullName) {
        this.strFacultyInformationFullName = strFacultyInformationFullName;
    }

    public String getiStudentInformationCode() {
        return iStudentInformationCode;
    }

    public void setiStudentInformationCode(String iStudentInformationCode) {
        this.iStudentInformationCode = iStudentInformationCode;
    }

    public Integer getiFacultyInformationPk() {
        return iFacultyInformationPk;
    }

    public void setiFacultyInformationPk(Integer iFacultyInformationPk) {
        this.iFacultyInformationPk = iFacultyInformationPk;
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
}
