package com.ben.quiz.domain.dto.request;

public class TeacherInformationSaveReq {

    private int iTeacherInformationPk;
    private Integer iFacultyInformationPk;
    private String strTeacherInformationFirstName;
    private String strTeacherInformationLastName;
    private Boolean bTeacherInformationGender;
    private String strTeacherInformationPhone;
    private Integer iTeacherInformationPkEk;

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
