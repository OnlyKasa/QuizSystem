package com.ben.quiz.domain.model;

import com.ben.quiz.domain.common.constant.SequenceConst;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "test_information_detail", schema = "public", catalog = "quizsystem")
public class TestInformationDetail extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -8659873741977132494L;
    private int iTestInformationDetailPk;
    private Integer iTestInformationPk;
    private Integer iQuestionInformationPk;
    private String strStudentAnswer;
    private Integer iTestDetailInformationPkEk;
    private TestInformation testInformationByITestInformationPk;
    private QuestionInformation questionInformationByIQuestionInformationPk;

    @Id
    @GenericGenerator(
            name = SequenceConst.TEST_INFORMATION_DETAIL_SEQ_GEN,
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
            @org.hibernate.annotations.Parameter(name = "sequence_name", value = SequenceConst.TEST_INFORMATION_DETAIL_SEQ)}
    )
    @Column(name = "i_test_information_detail_pk", nullable = false)
    public int getiTestInformationDetailPk() {
        return iTestInformationDetailPk;
    }

    public void setiTestInformationDetailPk(int iTestInformationDetailPk) {
        this.iTestInformationDetailPk = iTestInformationDetailPk;
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
    @Column(name = "i_question_information_pk", nullable = true)
    public Integer getiQuestionInformationPk() {
        return iQuestionInformationPk;
    }

    public void setiQuestionInformationPk(Integer iQuestionInformationPk) {
        this.iQuestionInformationPk = iQuestionInformationPk;
    }

    @Basic
    @Column(name = "str_student_answer", nullable = true, length = 500)
    public String getStrStudentAnswer() {
        return strStudentAnswer;
    }

    public void setStrStudentAnswer(String strStudentAnswer) {
        this.strStudentAnswer = strStudentAnswer;
    }

    @Basic
    @Column(name = "i_test_detail_information_pk_ek", nullable = true)
    public Integer getiTestDetailInformationPkEk() {
        return iTestDetailInformationPkEk;
    }

    public void setiTestDetailInformationPkEk(Integer iTestDetailInformationPkEk) {
        this.iTestDetailInformationPkEk = iTestDetailInformationPkEk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestInformationDetail that = (TestInformationDetail) o;

        if (iTestInformationDetailPk != that.iTestInformationDetailPk) return false;
        if (iTestInformationPk != null ? !iTestInformationPk.equals(that.iTestInformationPk) : that.iTestInformationPk != null)
            return false;
        if (iQuestionInformationPk != null ? !iQuestionInformationPk.equals(that.iQuestionInformationPk) : that.iQuestionInformationPk != null)
            return false;
        if (strStudentAnswer != null ? !strStudentAnswer.equals(that.strStudentAnswer) : that.strStudentAnswer != null)
            return false;
        if (iTestDetailInformationPkEk != null ? !iTestDetailInformationPkEk.equals(that.iTestDetailInformationPkEk) : that.iTestDetailInformationPkEk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iTestInformationDetailPk;
        result = 31 * result + (iTestInformationPk != null ? iTestInformationPk.hashCode() : 0);
        result = 31 * result + (iQuestionInformationPk != null ? iQuestionInformationPk.hashCode() : 0);
        result = 31 * result + (strStudentAnswer != null ? strStudentAnswer.hashCode() : 0);
        result = 31 * result + (iTestDetailInformationPkEk != null ? iTestDetailInformationPkEk.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "i_test_information_pk", referencedColumnName = "i_test_information_pk",insertable = false ,updatable = false)
    public TestInformation getTestInformationByITestInformationPk() {
        return testInformationByITestInformationPk;
    }

    public void setTestInformationByITestInformationPk(TestInformation testInformationByITestInformationPk) {
        this.testInformationByITestInformationPk = testInformationByITestInformationPk;
    }

    @ManyToOne
    @JoinColumn(name = "i_question_information_pk", referencedColumnName = "i_question_information_pk",insertable = false ,updatable = false)
    public QuestionInformation getQuestionInformationByIQuestionInformationPk() {
        return questionInformationByIQuestionInformationPk;
    }

    public void setQuestionInformationByIQuestionInformationPk(QuestionInformation questionInformationByIQuestionInformationPk) {
        this.questionInformationByIQuestionInformationPk = questionInformationByIQuestionInformationPk;
    }
}
