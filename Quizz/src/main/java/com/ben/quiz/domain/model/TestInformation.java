package com.ben.quiz.domain.model;

import com.ben.quiz.domain.common.constant.SequenceConst;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "test_information", schema = "public", catalog = "quizsystem")
public class TestInformation extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -5571546540217494879L;
    private int iTestInformationPk;
    private int iTestInformationTime;
    private Integer iRateOfDifficultyPk;
    private Integer iTestInformationPkEk;
    private Collection<ExaminationResult> examinationResultsByITestInformationPk;
    private Collection<TestDetailInformation> testDetailInformationsByITestInformationPk;
    private RateOfDifficulty rateOfDifficultyByIRateOfDifficultyPk;

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
    @Column(name = "i_test_information_time", nullable = false)
    public int getiTestInformationTime() {
        return iTestInformationTime;
    }

    public void setiTestInformationTime(int iTestInformationTime) {
        this.iTestInformationTime = iTestInformationTime;
    }

    @Basic
    @Column(name = "i_rate_of_difficulty_pk", nullable = true)
    public Integer getiRateOfDifficultyPk() {
        return iRateOfDifficultyPk;
    }

    public void setiRateOfDifficultyPk(Integer iRateOfDifficultyPk) {
        this.iRateOfDifficultyPk = iRateOfDifficultyPk;
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
        if (iTestInformationTime != that.iTestInformationTime) return false;
        if (iRateOfDifficultyPk != null ? !iRateOfDifficultyPk.equals(that.iRateOfDifficultyPk) : that.iRateOfDifficultyPk != null)
            return false;
        if (iTestInformationPkEk != null ? !iTestInformationPkEk.equals(that.iTestInformationPkEk) : that.iTestInformationPkEk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iTestInformationPk;
        result = 31 * result + iTestInformationTime;
        result = 31 * result + (iRateOfDifficultyPk != null ? iRateOfDifficultyPk.hashCode() : 0);
        result = 31 * result + (iTestInformationPkEk != null ? iTestInformationPkEk.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "testInformationByITestInformationPk")
    public Collection<ExaminationResult> getExaminationResultsByITestInformationPk() {
        return examinationResultsByITestInformationPk;
    }

    public void setExaminationResultsByITestInformationPk(Collection<ExaminationResult> examinationResultsByITestInformationPk) {
        this.examinationResultsByITestInformationPk = examinationResultsByITestInformationPk;
    }

    @OneToMany(mappedBy = "testInformationByITestInformationPk")
    public Collection<TestDetailInformation> getTestDetailInformationsByITestInformationPk() {
        return testDetailInformationsByITestInformationPk;
    }

    public void setTestDetailInformationsByITestInformationPk(Collection<TestDetailInformation> testDetailInformationsByITestInformationPk) {
        this.testDetailInformationsByITestInformationPk = testDetailInformationsByITestInformationPk;
    }

    @ManyToOne
    @JoinColumn(name = "i_rate_of_difficulty_pk", referencedColumnName = "i_rate_of_difficulty_pk")
    public RateOfDifficulty getRateOfDifficultyByIRateOfDifficultyPk() {
        return rateOfDifficultyByIRateOfDifficultyPk;
    }

    public void setRateOfDifficultyByIRateOfDifficultyPk(RateOfDifficulty rateOfDifficultyByIRateOfDifficultyPk) {
        this.rateOfDifficultyByIRateOfDifficultyPk = rateOfDifficultyByIRateOfDifficultyPk;
    }
}
