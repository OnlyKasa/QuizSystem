package com.ben.quiz.domain.dto.request;

import com.ben.quiz.domain.model.FacultyInformation;

import java.sql.Date;

public class StudentInformationSaveReq {

    private int iStudentInformationPk;
    private String iStudentInformationCode;
    private Integer iFacultyInformationPk;
    private String strStudentInformationFirstName;
    private String strStudentInformationLastName;
    private Date dtStudentInformationBirthday;
    private Integer iStudentInformationPkEk;

    private FacultyInformation facultyInformationByIFacultyInformationPk;

    private String userId ;
    private String password;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getiStudentInformationPk() {
        return iStudentInformationPk;
    }

    public void setiStudentInformationPk(int iStudentInformationPk) {
        this.iStudentInformationPk = iStudentInformationPk;
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

    public Date getDtStudentInformationBirthday() {
        return dtStudentInformationBirthday;
    }

    public void setDtStudentInformationBirthday(Date dtStudentInformationBirthday) {
        this.dtStudentInformationBirthday = dtStudentInformationBirthday;
    }

    public Integer getiStudentInformationPkEk() {
        return iStudentInformationPkEk;
    }

    public void setiStudentInformationPkEk(Integer iStudentInformationPkEk) {
        this.iStudentInformationPkEk = iStudentInformationPkEk;
    }

    public FacultyInformation getFacultyInformationByIFacultyInformationPk() {
        return facultyInformationByIFacultyInformationPk;
    }

    public void setFacultyInformationByIFacultyInformationPk(FacultyInformation facultyInformationByIFacultyInformationPk) {
        this.facultyInformationByIFacultyInformationPk = facultyInformationByIFacultyInformationPk;
    }
}
