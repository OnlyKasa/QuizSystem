package com.ben.quiz.domain.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "test_information", schema = "public", catalog = "quizsystem")
public class TestInformation extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -3032544100982809089L;
    private int iTestInformationPk;
    private Double fExaminationResultScore;
    private Integer iExaminationResultNumAnswerTrue;
    private Integer iTestInformationPkEk;
    private StudentInformation studentInformationByIStudentInformationPk;
    private ExaminationInformation examinationInformationByIExaminationInformationPk;

    @Id
    @Column(name = "i_test_information_pk", nullable = false)
    public int getiTestInformationPk() {
        return iTestInformationPk;
    }

    public void setiTestInformationPk(int iTestInformationPk) {
        this.iTestInformationPk = iTestInformationPk;
    }

    @Basic
    @Column(name = "f_examination_result_score", nullable = true, precision = 0)
    public Double getfExaminationResultScore() {
        return fExaminationResultScore;
    }

    public void setfExaminationResultScore(Double fExaminationResultScore) {
        this.fExaminationResultScore = fExaminationResultScore;
    }

    @Basic
    @Column(name = "i_examination_result_num_answer_true", nullable = true)
    public Integer getiExaminationResultNumAnswerTrue() {
        return iExaminationResultNumAnswerTrue;
    }

    public void setiExaminationResultNumAnswerTrue(Integer iExaminationResultNumAnswerTrue) {
        this.iExaminationResultNumAnswerTrue = iExaminationResultNumAnswerTrue;
    }

    @Basic
    @Column(name = "i_test_information_pk_ek", nullable = true)
    public Integer getiTestInformationPkEk() {
        return iTestInformationPkEk;
    }

    public void setiTestInformationPkEk(Integer iTestInformationPkEk) {
        this.iTestInformationPkEk = iTestInformationPkEk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestInformation that = (TestInformation) o;

        if (iTestInformationPk != that.iTestInformationPk) return false;
        if (fExaminationResultScore != null ? !fExaminationResultScore.equals(that.fExaminationResultScore) : that.fExaminationResultScore != null)
            return false;
        if (iExaminationResultNumAnswerTrue != null ? !iExaminationResultNumAnswerTrue.equals(that.iExaminationResultNumAnswerTrue) : that.iExaminationResultNumAnswerTrue != null)
            return false;
        if (iTestInformationPkEk != null ? !iTestInformationPkEk.equals(that.iTestInformationPkEk) : that.iTestInformationPkEk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iTestInformationPk;
        result = 31 * result + (fExaminationResultScore != null ? fExaminationResultScore.hashCode() : 0);
        result = 31 * result + (iExaminationResultNumAnswerTrue != null ? iExaminationResultNumAnswerTrue.hashCode() : 0);
        result = 31 * result + (iTestInformationPkEk != null ? iTestInformationPkEk.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "i_student_information_pk", referencedColumnName = "i_student_information_pk")
    public StudentInformation getStudentInformationByIStudentInformationPk() {
        return studentInformationByIStudentInformationPk;
    }

    public void setStudentInformationByIStudentInformationPk(StudentInformation studentInformationByIStudentInformationPk) {
        this.studentInformationByIStudentInformationPk = studentInformationByIStudentInformationPk;
    }

    @ManyToOne
    @JoinColumn(name = "i_examination_information_pk", referencedColumnName = "i_examination_information_pk", nullable = false)
    public ExaminationInformation getExaminationInformationByIExaminationInformationPk() {
        return examinationInformationByIExaminationInformationPk;
    }

    public void setExaminationInformationByIExaminationInformationPk(ExaminationInformation examinationInformationByIExaminationInformationPk) {
        this.examinationInformationByIExaminationInformationPk = examinationInformationByIExaminationInformationPk;
    }
}
