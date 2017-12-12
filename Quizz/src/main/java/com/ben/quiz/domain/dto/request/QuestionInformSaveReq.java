package com.ben.quiz.domain.dto.request;

import com.ben.quiz.domain.model.SubjectInformation;
import com.ben.quiz.domain.model.TeacherInformation;

public class QuestionInformSaveReq {
    private int iQuestionInformationPk;
    private Integer iTeacherInformationPk;
    private Integer iSubjectInformationPk;
    private Integer iQuestionInformationLevel;
    private String strQuestionContentInformation;
    private String strAnswer1;
    private String strAnswer2;
    private String strAnswer3;
    private String strAnswer4;
    private String strAnswer5;
    private String strTrueAnswer;
    private Integer iQuestionInformationPkEk;
    private TeacherInformation teacherInformationByITeacherInformationPk;
    private SubjectInformation subjectInformationByISubjectInformationPk;

    public int getiQuestionInformationPk() {
        return iQuestionInformationPk;
    }

    public void setiQuestionInformationPk(int iQuestionInformationPk) {
        this.iQuestionInformationPk = iQuestionInformationPk;
    }

    public Integer getiTeacherInformationPk() {
        return iTeacherInformationPk;
    }

    public void setiTeacherInformationPk(Integer iTeacherInformationPk) {
        this.iTeacherInformationPk = iTeacherInformationPk;
    }

    public Integer getiSubjectInformationPk() {
        return iSubjectInformationPk;
    }

    public void setiSubjectInformationPk(Integer iSubjectInformationPk) {
        this.iSubjectInformationPk = iSubjectInformationPk;
    }

    public Integer getiQuestionInformationLevel() {
        return iQuestionInformationLevel;
    }

    public void setiQuestionInformationLevel(Integer iQuestionInformationLevel) {
        this.iQuestionInformationLevel = iQuestionInformationLevel;
    }

    public String getStrQuestionContentInformation() {
        return strQuestionContentInformation;
    }

    public void setStrQuestionContentInformation(String strQuestionContentInformation) {
        this.strQuestionContentInformation = strQuestionContentInformation;
    }

    public String getStrAnswer1() {
        return strAnswer1;
    }

    public void setStrAnswer1(String strAnswer1) {
        this.strAnswer1 = strAnswer1;
    }

    public String getStrAnswer2() {
        return strAnswer2;
    }

    public void setStrAnswer2(String strAnswer2) {
        this.strAnswer2 = strAnswer2;
    }

    public String getStrAnswer3() {
        return strAnswer3;
    }

    public void setStrAnswer3(String strAnswer3) {
        this.strAnswer3 = strAnswer3;
    }

    public String getStrAnswer4() {
        return strAnswer4;
    }

    public void setStrAnswer4(String strAnswer4) {
        this.strAnswer4 = strAnswer4;
    }

    public String getStrAnswer5() {
        return strAnswer5;
    }

    public void setStrAnswer5(String strAnswer5) {
        this.strAnswer5 = strAnswer5;
    }

    public String getStrTrueAnswer() {
        return strTrueAnswer;
    }

    public void setStrTrueAnswer(String strTrueAnswer) {
        this.strTrueAnswer = strTrueAnswer;
    }

    public Integer getiQuestionInformationPkEk() {
        return iQuestionInformationPkEk;
    }

    public void setiQuestionInformationPkEk(Integer iQuestionInformationPkEk) {
        this.iQuestionInformationPkEk = iQuestionInformationPkEk;
    }

    public TeacherInformation getTeacherInformationByITeacherInformationPk() {
        return teacherInformationByITeacherInformationPk;
    }

    public void setTeacherInformationByITeacherInformationPk(TeacherInformation teacherInformationByITeacherInformationPk) {
        this.teacherInformationByITeacherInformationPk = teacherInformationByITeacherInformationPk;
    }

    public SubjectInformation getSubjectInformationByISubjectInformationPk() {
        return subjectInformationByISubjectInformationPk;
    }

    public void setSubjectInformationByISubjectInformationPk(SubjectInformation subjectInformationByISubjectInformationPk) {
        this.subjectInformationByISubjectInformationPk = subjectInformationByISubjectInformationPk;
    }
}
