package com.ben.quiz.domain.dto.result;

import java.sql.Timestamp;

public class ExaminationInformationDto {
    private int iExaminationInformationPk;
    private String strExaminationInformationCode;
    private Integer iExaminationRoomPk;
    private Integer iSubjectInformationPk;
    private Integer iTeacherInformationPk;
    private Timestamp dtExaminationDay;
    private Integer iRateOfDifficultyPk;
    private int iTestInformationTime;
    private Integer iExaminationInformationPkEk;

    private String strExaminationRoomName;
    private String strSubjectInformationName;
    private String strTeacherInformationFirstName;
    private String strTeacherInformationLastName;
    private String strRateDifficultyName;

    private Integer iTestInformationPk ;

    public Integer getiTestInformationPk() {
        return iTestInformationPk;
    }

    public void setiTestInformationPk(Integer iTestInformationPk) {
        this.iTestInformationPk = iTestInformationPk;
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

    public String getStrRateDifficultyName() {
        return strRateDifficultyName;
    }

    public void setStrRateDifficultyName(String strRateDifficultyName) {
        this.strRateDifficultyName = strRateDifficultyName;
    }

    public int getiExaminationInformationPk() {
        return iExaminationInformationPk;
    }

    public void setiExaminationInformationPk(int iExaminationInformationPk) {
        this.iExaminationInformationPk = iExaminationInformationPk;
    }

    public String getStrExaminationInformationCode() {
        return strExaminationInformationCode;
    }

    public void setStrExaminationInformationCode(String strExaminationInformationCode) {
        this.strExaminationInformationCode = strExaminationInformationCode;
    }

    public Integer getiExaminationRoomPk() {
        return iExaminationRoomPk;
    }

    public void setiExaminationRoomPk(Integer iExaminationRoomPk) {
        this.iExaminationRoomPk = iExaminationRoomPk;
    }

    public Integer getiSubjectInformationPk() {
        return iSubjectInformationPk;
    }

    public void setiSubjectInformationPk(Integer iSubjectInformationPk) {
        this.iSubjectInformationPk = iSubjectInformationPk;
    }

    public Integer getiTeacherInformationPk() {
        return iTeacherInformationPk;
    }

    public void setiTeacherInformationPk(Integer iTeacherInformationPk) {
        this.iTeacherInformationPk = iTeacherInformationPk;
    }

    public Timestamp getDtExaminationDay() {
        return dtExaminationDay;
    }

    public void setDtExaminationDay(Timestamp dtExaminationDay) {
        this.dtExaminationDay = dtExaminationDay;
    }

    public Integer getiRateOfDifficultyPk() {
        return iRateOfDifficultyPk;
    }

    public void setiRateOfDifficultyPk(Integer iRateOfDifficultyPk) {
        this.iRateOfDifficultyPk = iRateOfDifficultyPk;
    }

    public int getiTestInformationTime() {
        return iTestInformationTime;
    }

    public void setiTestInformationTime(int iTestInformationTime) {
        this.iTestInformationTime = iTestInformationTime;
    }

    public Integer getiExaminationInformationPkEk() {
        return iExaminationInformationPkEk;
    }

    public void setiExaminationInformationPkEk(Integer iExaminationInformationPkEk) {
        this.iExaminationInformationPkEk = iExaminationInformationPkEk;
    }
}
