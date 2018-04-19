package com.ben.quiz.domain.dto.request;

import java.util.List;

public class CreateListTestsReq {

    private List<Integer> iStudentInformationPk;
    private Integer iExaminationInformationPk;
    private List<List<Integer>>iQuestionInformationPk;

    public List<Integer> getiStudentInformationPk() {
        return iStudentInformationPk;
    }

    public void setiStudentInformationPk(List<Integer> iStudentInformationPk) {
        this.iStudentInformationPk = iStudentInformationPk;
    }

    public Integer getiExaminationInformationPk() {
        return iExaminationInformationPk;
    }

    public void setiExaminationInformationPk(Integer iExaminationInformationPk) {
        this.iExaminationInformationPk = iExaminationInformationPk;
    }

    public List<List<Integer>> getiQuestionInformationPk() {
        return iQuestionInformationPk;
    }

    public void setiQuestionInformationPk(List<List<Integer>> iQuestionInformationPk) {
        this.iQuestionInformationPk = iQuestionInformationPk;
    }
}
