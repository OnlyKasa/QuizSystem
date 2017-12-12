package com.ben.quiz.domain.dto.request;

import java.sql.Timestamp;

public class ExaminationInformationSearchReq {
    private String strExaminationInformationCode;
    private Timestamp dtExaminationDay;
    private String strRateDifficultyName;
    private String strExaminationRoomName;
    private String strSubjectInformationName;
//    private String iStudentInformationCode;
//    private String strStudentInformationFirstName;
//    private String strStudentInformationLastName;
    private String strTeacherInformationFirstName;
    private String strTeacherInformationLastName;

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

    public String getStrRateDifficultyName() {
        return strRateDifficultyName;
    }

    public void setStrRateDifficultyName(String strRateDifficultyName) {
        this.strRateDifficultyName = strRateDifficultyName;
    }

    public String getStrExaminationRoomName() {
        return strExaminationRoomName;
    }

    public void setStrExaminationRoomName(String strExaminationRoomName) {
        this.strExaminationRoomName = strExaminationRoomName;
    }

    public String getStrSubjectInformationName() {
        return strSubjectInformationName;
    }

    public void setStrSubjectInformationName(String strSubjectInformationName) {
        this.strSubjectInformationName = strSubjectInformationName;
    }

//    public String getiStudentInformationCode() {
//        return iStudentInformationCode;
//    }
//
//    public void setiStudentInformationCode(String iStudentInformationCode) {
//        this.iStudentInformationCode = iStudentInformationCode;
//    }
//
//    public String getStrStudentInformationFirstName() {
//        return strStudentInformationFirstName;
//    }
//
//    public void setStrStudentInformationFirstName(String strStudentInformationFirstName) {
//        this.strStudentInformationFirstName = strStudentInformationFirstName;
//    }
//
//    public String getStrStudentInformationLastName() {
//        return strStudentInformationLastName;
//    }
//
//    public void setStrStudentInformationLastName(String strStudentInformationLastName) {
//        this.strStudentInformationLastName = strStudentInformationLastName;
//    }

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
}
