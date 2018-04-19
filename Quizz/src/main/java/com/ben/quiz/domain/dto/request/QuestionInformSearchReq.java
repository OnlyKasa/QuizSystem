package com.ben.quiz.domain.dto.request;

public class QuestionInformSearchReq {

    private Integer iQuestionInformationPk;
    private String strQuestionContentInformation;
    private String strSubjectInformationName;
    private int iSubjectInformationCreditsNum;
    private String strTeacherInformationFirstName;
    private String strTeacherInformationLastName;
    private Integer iQuestionInformationLevel;

    public Integer getiQuestionInformationLevel() {
        return iQuestionInformationLevel;
    }

    public void setiQuestionInformationLevel(Integer iQuestionInformationLevel) {
        this.iQuestionInformationLevel = iQuestionInformationLevel;
    }

    public Integer getiQuestionInformationPk() {
        return iQuestionInformationPk;
    }

    public void setiQuestionInformationPk(Integer iQuestionInformationPk) {
        this.iQuestionInformationPk = iQuestionInformationPk;
    }

    public String getStrQuestionContentInformation() {
        return strQuestionContentInformation;
    }

    public void setStrQuestionContentInformation(String strQuestionContentInformation) {
        this.strQuestionContentInformation = strQuestionContentInformation;
    }

    public String getStrSubjectInformationName() {
        return strSubjectInformationName;
    }

    public void setStrSubjectInformationName(String strSubjectInformationName) {
        this.strSubjectInformationName = strSubjectInformationName;
    }

    public int getiSubjectInformationCreditsNum() {
        return iSubjectInformationCreditsNum;
    }

    public void setiSubjectInformationCreditsNum(int iSubjectInformationCreditsNum) {
        this.iSubjectInformationCreditsNum = iSubjectInformationCreditsNum;
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
}
