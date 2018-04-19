package com.ben.quiz.domain.dto.result;

import com.ben.quiz.domain.model.FacultyInformation;

public class TeacherInformDto {

    private int iTeacherInformationPk;
    private Integer iFacultyInformationPk;
    private String strTeacherInformationFirstName;
    private String strTeacherInformationLastName;
    private Boolean bTeacherInformationGender;
    private String strTeacherInformationPhone;
    private Integer iTeacherInformationPkEk;

    private String strFacultyInformationShortName;
    private String strFacultyInformationFullName;

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStrFacultyInformationShortName() {
        return strFacultyInformationShortName;
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

    public int getiTeacherInformationPk() {
        return iTeacherInformationPk;
    }

    public void setiTeacherInformationPk(int iTeacherInformationPk) {
        this.iTeacherInformationPk = iTeacherInformationPk;
    }

    public Integer getiFacultyInformationPk() {
        return iFacultyInformationPk;
    }

    public void setiFacultyInformationPk(Integer iFacultyInformationPk) {
        this.iFacultyInformationPk = iFacultyInformationPk;
    }

    public String getStrTeacherInformationFirstName() {
        return strTeacherInformationFirstName;
    }

    public void setStrTeacherInformationFirstName(String strTeacherInformationFirstName) {
        this.strTeacherInformationFirstName = strTeacherInformationFirstName;
    }

    public String getStrTeacherInformationLastName() {
        return strTeacherInformationLastName;
    }

    public void setStrTeacherInformationLastName(String strTeacherInformationLastName) {
        this.strTeacherInformationLastName = strTeacherInformationLastName;
    }

    public Boolean getbTeacherInformationGender() {
        return bTeacherInformationGender;
    }

    public void setbTeacherInformationGender(Boolean bTeacherInformationGender) {
        this.bTeacherInformationGender = bTeacherInformationGender;
    }

    public String getStrTeacherInformationPhone() {
        return strTeacherInformationPhone;
    }

    public void setStrTeacherInformationPhone(String strTeacherInformationPhone) {
        this.strTeacherInformationPhone = strTeacherInformationPhone;
    }

    public Integer getiTeacherInformationPkEk() {
        return iTeacherInformationPkEk;
    }

    public void setiTeacherInformationPkEk(Integer iTeacherInformationPkEk) {
        this.iTeacherInformationPkEk = iTeacherInformationPkEk;
    }
}
