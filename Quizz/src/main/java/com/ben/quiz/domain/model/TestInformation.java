package com.ben.quiz.domain.model;

import com.ben.quiz.domain.common.constant.SequenceConst;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "test_information", schema = "public", catalog = "quizsystem")
public class TestInformation extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -2467038328910086539L;
    private int iTestInformationPk;
    private Integer iStudentInformationPk;
    private Double fExaminationResultScore;
    private Integer iExaminationResultNumAnswerTrue;
    private Integer iTestInformationPkEk;
    private int iExaminationInformationPk;
    private StudentInformation studentInformationByIStudentInformationPk;
    private ExaminationInformation examinationInformationByIExaminationInformationPk;
    private Collection<TestInformationDetail> testInformationDetailsByITestInformationPk;

    @Id
    @GenericGenerator(
            name = SequenceConst.TEST_INFORMATION_SEQ_GEN,
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
            @org.hibernate.annotations.Parameter(name = "sequence_name", value = SequenceConst.TEST_INFORMATION_SEQ)}
    )
    @Column(name = "i_test_information_pk", nullable = false)
    public int getiTestInformationPk() {
        return iTestInformationPk;
    }

    public void setiTestInformationPk(int iTestInformationPk) {
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
    @Column(name = "i_test_information_pk_ek", nullable = true)
    public Integer getiTestInformationPkEk() {
        return iTestInformationPkEk;
    }

    public void setiTestInformationPkEk(Integer iTestInformationPkEk) {
        this.iTestInformationPkEk = iTestInformationPkEk;
    }

    @Basic
    @Column(name = "i_examination_information_pk", nullable = false)
    public int getiExaminationInformationPk() {
        return iExaminationInformationPk;
    }

    public void setiExaminationInformationPk(int iExaminationInformationPk) {
        this.iExaminationInformationPk = iExaminationInformationPk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestInformation that = (TestInformation) o;

        if (iTestInformationPk != that.iTestInformationPk) return false;
        if (iExaminationInformationPk != that.iExaminationInformationPk) return false;
        if (iStudentInformationPk != null ? !iStudentInformationPk.equals(that.iStudentInformationPk) : that.iStudentInformationPk != null)
            return false;
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
        result = 31 * result + (iStudentInformationPk != null ? iStudentInformationPk.hashCode() : 0);
        result = 31 * result + (fExaminationResultScore != null ? fExaminationResultScore.hashCode() : 0);
        result = 31 * result + (iExaminationResultNumAnswerTrue != null ? iExaminationResultNumAnswerTrue.hashCode() : 0);
        result = 31 * result + (iTestInformationPkEk != null ? iTestInformationPkEk.hashCode() : 0);
        result = 31 * result + iExaminationInformationPk;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "i_student_information_pk", referencedColumnName = "i_student_information_pk",insertable = false ,updatable = false)
    public StudentInformation getStudentInformationByIStudentInformationPk() {
        return studentInformationByIStudentInformationPk;
    }

    public void setStudentInformationByIStudentInformationPk(StudentInformation studentInformationByIStudentInformationPk) {
        this.studentInformationByIStudentInformationPk = studentInformationByIStudentInformationPk;
    }

    @ManyToOne
    @JoinColumn(name = "i_examination_information_pk", referencedColumnName = "i_examination_information_pk", nullable = false ,insertable = false ,updatable = false)
    public ExaminationInformation getExaminationInformationByIExaminationInformationPk() {
        return examinationInformationByIExaminationInformationPk;
    }

    public void setExaminationInformationByIExaminationInformationPk(ExaminationInformation examinationInformationByIExaminationInformationPk) {
        this.examinationInformationByIExaminationInformationPk = examinationInformationByIExaminationInformationPk;
    }

    @OneToMany(mappedBy = "testInformationByITestInformationPk")
    public Collection<TestInformationDetail> getTestInformationDetailsByITestInformationPk() {
        return testInformationDetailsByITestInformationPk;
    }

    public void setTestInformationDetailsByITestInformationPk(Collection<TestInformationDetail> testInformationDetailsByITestInformationPk) {
        this.testInformationDetailsByITestInformationPk = testInformationDetailsByITestInformationPk;
    }
}
