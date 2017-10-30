package com.ben.quiz.domain.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "examination_result", schema = "public", catalog = "quizsystem")
public class ExaminationResult extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -5706448501421868135L;
    private int iExaminationResultPk;
    private Integer iTestInformationPk;
    private Integer iStudentInformationPk;
    private Double fExaminationResultScore;
    private Integer iExaminationResultNumAnswerTrue;
    private Integer iExaminationResultPkEk;
    private TestInformation testInformationByITestInformationPk;
    private StudentInformation studentInformationByIStudentInformationPk;

    @Id
    @Column(name = "i_examination_result_pk", nullable = false)
    public int getiExaminationResultPk() {
        return iExaminationResultPk;
    }

    public void setiExaminationResultPk(int iExaminationResultPk) {
        this.iExaminationResultPk = iExaminationResultPk;
    }

    @Basic
    @Column(name = "i_test_information_pk", nullable = true)
    public Integer getiTestInformationPk() {
        return iTestInformationPk;
    }

    public void setiTestInformationPk(Integer iTestInformationPk) {
        this.iTestInformationPk = iTestInformationPk;
    }

    @Basic
    @Column(name = "i_student_information_pk", nullable = true)
    public Integer getiStudentInformationPk() {
        return iStudentInformationPk;
    }

    public void setiStudentInformationPk(Integer iStudentInformationPk) {
        this.iStudentInformationPk = iStudentInformationPk;
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
    @Column(name = "i_examination_result_pk_ek", nullable = true)
    public Integer getiExaminationResultPkEk() {
        return iExaminationResultPkEk;
    }

    public void setiExaminationResultPkEk(Integer iExaminationResultPkEk) {
        this.iExaminationResultPkEk = iExaminationResultPkEk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExaminationResult that = (ExaminationResult) o;

        if (iExaminationResultPk != that.iExaminationResultPk) return false;
        if (iTestInformationPk != null ? !iTestInformationPk.equals(that.iTestInformationPk) : that.iTestInformationPk != null)
            return false;
        if (iStudentInformationPk != null ? !iStudentInformationPk.equals(that.iStudentInformationPk) : that.iStudentInformationPk != null)
            return false;
        if (fExaminationResultScore != null ? !fExaminationResultScore.equals(that.fExaminationResultScore) : that.fExaminationResultScore != null)
            return false;
        if (iExaminationResultNumAnswerTrue != null ? !iExaminationResultNumAnswerTrue.equals(that.iExaminationResultNumAnswerTrue) : that.iExaminationResultNumAnswerTrue != null)
            return false;
        if (iExaminationResultPkEk != null ? !iExaminationResultPkEk.equals(that.iExaminationResultPkEk) : that.iExaminationResultPkEk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iExaminationResultPk;
        result = 31 * result + (iTestInformationPk != null ? iTestInformationPk.hashCode() : 0);
        result = 31 * result + (iStudentInformationPk != null ? iStudentInformationPk.hashCode() : 0);
        result = 31 * result + (fExaminationResultScore != null ? fExaminationResultScore.hashCode() : 0);
        result = 31 * result + (iExaminationResultNumAnswerTrue != null ? iExaminationResultNumAnswerTrue.hashCode() : 0);
        result = 31 * result + (iExaminationResultPkEk != null ? iExaminationResultPkEk.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "i_test_information_pk", referencedColumnName = "i_test_information_pk")
    public TestInformation getTestInformationByITestInformationPk() {
        return testInformationByITestInformationPk;
    }

    public void setTestInformationByITestInformationPk(TestInformation testInformationByITestInformationPk) {
        this.testInformationByITestInformationPk = testInformationByITestInformationPk;
    }

    @ManyToOne
    @JoinColumn(name = "i_student_information_pk", referencedColumnName = "i_student_information_pk")
    public StudentInformation getStudentInformationByIStudentInformationPk() {
        return studentInformationByIStudentInformationPk;
    }

    public void setStudentInformationByIStudentInformationPk(StudentInformation studentInformationByIStudentInformationPk) {
        this.studentInformationByIStudentInformationPk = studentInformationByIStudentInformationPk;
    }
}
