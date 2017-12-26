package com.ben.quiz.domain.dto.result;

public class TestInformationDetailDto {

    private int iTestInformationDetailPk;
    private Integer iTestInformationPk;
    private Integer iQuestionInformationPk;
    private String strStudentAnswer;

    public int getiTestInformationDetailPk() {
        return iTestInformationDetailPk;
    }

    public void setiTestInformationDetailPk(int iTestInformationDetailPk) {
        this.iTestInformationDetailPk = iTestInformationDetailPk;
    }

    public Integer getiTestInformationPk() {
        return iTestInformationPk;
    }

    public void setiTestInformationPk(Integer iTestInformationPk) {
        this.iTestInformationPk = iTestInformationPk;
    }

    public Integer getiQuestionInformationPk() {
        return iQuestionInformationPk;
    }

    public void setiQuestionInformationPk(Integer iQuestionInformationPk) {
        this.iQuestionInformationPk = iQuestionInformationPk;
    }

    public String getStrStudentAnswer() {
        return strStudentAnswer;
    }

    public void setStrStudentAnswer(String strStudentAnswer) {
        this.strStudentAnswer = strStudentAnswer;
    }
}
