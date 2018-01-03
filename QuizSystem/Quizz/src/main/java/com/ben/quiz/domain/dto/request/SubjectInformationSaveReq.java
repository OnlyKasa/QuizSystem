package com.ben.quiz.domain.dto.request;

public class SubjectInformationSaveReq {

    private int iSubjectInformationPk;
    private String strSubjectInformationName;
    private int iSubjectInformationCreditsNum;
    private Integer iSubjectInformationPkEk;

    public int getiSubjectInformationPk() {
        return iSubjectInformationPk;
    }

    public void setiSubjectInformationPk(int iSubjectInformationPk) {
        this.iSubjectInformationPk = iSubjectInformationPk;
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

    public Integer getiSubjectInformationPkEk() {
        return iSubjectInformationPkEk;
    }

    public void setiSubjectInformationPkEk(Integer iSubjectInformationPkEk) {
        this.iSubjectInformationPkEk = iSubjectInformationPkEk;
    }
}
