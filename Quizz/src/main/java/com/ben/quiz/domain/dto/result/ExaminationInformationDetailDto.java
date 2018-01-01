package com.ben.quiz.domain.dto.result;

public class ExaminationInformationDetailDto {

    private Integer iTestInformationPk;
    private Integer iExaminationInformationPk;
    private Integer iStudentInformationPk;



    public Integer getiTestInformationPk() {
        return iTestInformationPk;
    }

    public void setiTestInformationPk(Integer iTestInformationPk) {
        this.iTestInformationPk = iTestInformationPk;
    }

    public Integer getiExaminationInformationPk() {
        return iExaminationInformationPk;
    }

    public void setiExaminationInformationPk(Integer iExaminationInformationPk) {
        this.iExaminationInformationPk = iExaminationInformationPk;
    }

    public Integer getiStudentInformationPk() {
        return iStudentInformationPk;
    }

    public void setiStudentInformationPk(Integer iStudentInformationPk) {
        this.iStudentInformationPk = iStudentInformationPk;
    }
}
