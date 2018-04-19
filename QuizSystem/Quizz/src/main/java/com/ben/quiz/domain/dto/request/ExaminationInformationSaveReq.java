package com.ben.quiz.domain.dto.request;

import java.sql.Timestamp;
import java.util.List;

public class ExaminationInformationSaveReq {
    private int iExaminationInformationPk;
    private String strExaminationInformationCode;
    private Integer iExaminationRoomPk;
    private Integer iSubjectInformationPk;
    private Integer iTeacherInformationPk;
    private Timestamp dtExaminationDay;
    private Integer iRateOfDifficultyPk;
    private int iTestInformationTime;
    private Integer iExaminationInformationPkEk;

    private List<Integer> ListiStudentInformationPk ;
    private List<Integer> ListDeleteiStudentInformationPk;


    public List<Integer> getListDeleteiStudentInformationPk() {
        return ListDeleteiStudentInformationPk;
    }

    public void setListDeleteiStudentInformationPk(List<Integer> listDeleteiStudentInformationPk) {
        ListDeleteiStudentInformationPk = listDeleteiStudentInformationPk;
    }

    public List<Integer> getListiStudentInformationPk() {
        return ListiStudentInformationPk;
    }

    public void setListiStudentInformationPk(List<Integer> listiStudentInformationPk) {
        ListiStudentInformationPk = listiStudentInformationPk;
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
