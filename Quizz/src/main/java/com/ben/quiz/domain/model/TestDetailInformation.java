package com.ben.quiz.domain.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "test_detail_information", schema = "public", catalog = "quizsystem")
public class TestDetailInformation extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 5326344222745428914L;
    private int iTestDetailInformationPk;
    private Integer iTestInformationPk;
    private Integer iQuestionInformationPk;
    private Integer iTestDetailInformationPkEk;
    private TestInformation testInformationByITestInformationPk;
    private QuestionInformation questionInformationByIQuestionInformationPk;

    @Id
    @Column(name = "i_test_detail_information_pk", nullable = false)
    public int getiTestDetailInformationPk() {
        return iTestDetailInformationPk;
    }

    public void setiTestDetailInformationPk(int iTestDetailInformationPk) {
        this.iTestDetailInformationPk = iTestDetailInformationPk;
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

        TestDetailInformation that = (TestDetailInformation) o;

        if (iTestDetailInformationPk != that.iTestDetailInformationPk) return false;
        if (iTestInformationPk != null ? !iTestInformationPk.equals(that.iTestInformationPk) : that.iTestInformationPk != null)
            return false;
        if (iQuestionInformationPk != null ? !iQuestionInformationPk.equals(that.iQuestionInformationPk) : that.iQuestionInformationPk != null)
            return false;
        if (iTestDetailInformationPkEk != null ? !iTestDetailInformationPkEk.equals(that.iTestDetailInformationPkEk) : that.iTestDetailInformationPkEk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iTestDetailInformationPk;
        result = 31 * result + (iTestInformationPk != null ? iTestInformationPk.hashCode() : 0);
        result = 31 * result + (iQuestionInformationPk != null ? iQuestionInformationPk.hashCode() : 0);
        result = 31 * result + (iTestDetailInformationPkEk != null ? iTestDetailInformationPkEk.hashCode() : 0);
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
    @JoinColumn(name = "i_question_information_pk", referencedColumnName = "i_question_information_pk")
    public QuestionInformation getQuestionInformationByIQuestionInformationPk() {
        return questionInformationByIQuestionInformationPk;
    }

    public void setQuestionInformationByIQuestionInformationPk(QuestionInformation questionInformationByIQuestionInformationPk) {
        this.questionInformationByIQuestionInformationPk = questionInformationByIQuestionInformationPk;
    }
}
