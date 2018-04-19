package com.ben.quiz.domain.dto.request;

public class TeacherInformationSearchReq {

    private String strTeacherInformationFirstName;
    private String strTeacherInformationLastName;

    private String strFacultyInformationShortName;
    private String strFacultyInformationFullName;
    private String strTeacherInformationPhone;


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

    public String getStrTeacherInformationPhone() {
        return strTeacherInformationPhone;
    }

    public void setStrTeacherInformationPhone(String strTeacherInformationPhone) {
        this.strTeacherInformationPhone = strTeacherInformationPhone;
    }
}
