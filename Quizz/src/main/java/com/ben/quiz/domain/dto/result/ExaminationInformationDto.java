package com.ben.quiz.domain.dto.result;

import com.ben.quiz.domain.model.ExaminationRoom;
import com.ben.quiz.domain.model.RateOfDifficulty;
import com.ben.quiz.domain.model.SubjectInformation;
import com.ben.quiz.domain.model.TeacherInformation;

import java.sql.Date;
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


    private ExaminationRoom examinationRoomByIExaminationRoomPk;
    private SubjectInformation subjectInformationByISubjectInformationPk;
    private TeacherInformation teacherInformationByITeacherInformationPk;
    private RateOfDifficulty rateOfDifficultyByIRateOfDifficultyPk;

    public ExaminationRoom getExaminationRoomByIExaminationRoomPk() {
        return examinationRoomByIExaminationRoomPk;
    }

    public void setExaminationRoomByIExaminationRoomPk(ExaminationRoom examinationRoomByIExaminationRoomPk) {
        this.examinationRoomByIExaminationRoomPk = examinationRoomByIExaminationRoomPk;
    }

    public SubjectInformation getSubjectInformationByISubjectInformationPk() {
        return subjectInformationByISubjectInformationPk;
    }

    public void setSubjectInformationByISubjectInformationPk(SubjectInformation subjectInformationByISubjectInformationPk) {
        this.subjectInformationByISubjectInformationPk = subjectInformationByISubjectInformationPk;
    }

    public TeacherInformation getTeacherInformationByITeacherInformationPk() {
        return teacherInformationByITeacherInformationPk;
    }

    public void setTeacherInformationByITeacherInformationPk(TeacherInformation teacherInformationByITeacherInformationPk) {
        this.teacherInformationByITeacherInformationPk = teacherInformationByITeacherInformationPk;
    }

    public RateOfDifficulty getRateOfDifficultyByIRateOfDifficultyPk() {
        return rateOfDifficultyByIRateOfDifficultyPk;
    }

    public void setRateOfDifficultyByIRateOfDifficultyPk(RateOfDifficulty rateOfDifficultyByIRateOfDifficultyPk) {
        this.rateOfDifficultyByIRateOfDifficultyPk = rateOfDifficultyByIRateOfDifficultyPk;
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
