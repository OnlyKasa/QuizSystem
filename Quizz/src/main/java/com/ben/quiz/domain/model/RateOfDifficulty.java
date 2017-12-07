package com.ben.quiz.domain.model;

import com.ben.quiz.domain.common.constant.SequenceConst;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rate_of_difficulty", schema = "public", catalog = "quizsystem")
public class RateOfDifficulty extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -5660510559481877660L;
    private int iRateOfDifficultyPk;
    private String strRateDifficultyName;
    private Integer iNumQuestionLevel1;
    private Integer iNumQuestionLevel2;
    private Integer iNumQuestionLevel3;
    private Integer iNumQuestionLevel4;
    private Integer iRateOfDifficultyPkEk;

    @Id
    @GenericGenerator(
            name = SequenceConst.RATE_OF_DIFFICULTY_SEQ_GEN,
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = "initial_value", value = "1"),
            @Parameter(name = "sequence_name", value = SequenceConst.RATE_OF_DIFFICULTY_SEQ)}
    )
    @Column(name = "i_rate_of_difficulty_pk", nullable = false)
    public int getiRateOfDifficultyPk() {
        return iRateOfDifficultyPk;
    }

    public void setiRateOfDifficultyPk(int iRateOfDifficultyPk) {
        this.iRateOfDifficultyPk = iRateOfDifficultyPk;
    }

    @Basic
    @Column(name = "str_rate_difficulty_name", nullable = false)
    public String getStrRateDifficultyName() {
        return strRateDifficultyName;
    }

    public void setStrRateDifficultyName(String strRateDifficultyName) {
        this.strRateDifficultyName = strRateDifficultyName;
    }

    @Basic
    @Column(name = "i_num_question_level_1", nullable = true)
    public Integer getiNumQuestionLevel1() {
        return iNumQuestionLevel1;
    }

    public void setiNumQuestionLevel1(Integer iNumQuestionLevel1) {
        this.iNumQuestionLevel1 = iNumQuestionLevel1;
    }

    @Basic
    @Column(name = "i_num_question_level_2", nullable = true)
    public Integer getiNumQuestionLevel2() {
        return iNumQuestionLevel2;
    }

    public void setiNumQuestionLevel2(Integer iNumQuestionLevel2) {
        this.iNumQuestionLevel2 = iNumQuestionLevel2;
    }

    @Basic
    @Column(name = "i_num_question_level_3", nullable = true)
    public Integer getiNumQuestionLevel3() {
        return iNumQuestionLevel3;
    }

    public void setiNumQuestionLevel3(Integer iNumQuestionLevel3) {
        this.iNumQuestionLevel3 = iNumQuestionLevel3;
    }

    @Basic
    @Column(name = "i_num_question_level_4", nullable = true)
    public Integer getiNumQuestionLevel4() {
        return iNumQuestionLevel4;
    }

    public void setiNumQuestionLevel4(Integer iNumQuestionLevel4) {
        this.iNumQuestionLevel4 = iNumQuestionLevel4;
    }

    @Basic
    @Column(name = "i_rate_of_difficulty_pk_ek", nullable = true)
    public Integer getiRateOfDifficultyPkEk() {
        return iRateOfDifficultyPkEk;
    }

    public void setiRateOfDifficultyPkEk(Integer iRateOfDifficultyPkEk) {
        this.iRateOfDifficultyPkEk = iRateOfDifficultyPkEk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RateOfDifficulty that = (RateOfDifficulty) o;

        if (iRateOfDifficultyPk != that.iRateOfDifficultyPk) return false;
        if (iNumQuestionLevel1 != null ? !iNumQuestionLevel1.equals(that.iNumQuestionLevel1) : that.iNumQuestionLevel1 != null)
            return false;
        if (iNumQuestionLevel2 != null ? !iNumQuestionLevel2.equals(that.iNumQuestionLevel2) : that.iNumQuestionLevel2 != null)
            return false;
        if (iNumQuestionLevel3 != null ? !iNumQuestionLevel3.equals(that.iNumQuestionLevel3) : that.iNumQuestionLevel3 != null)
            return false;
        if (iNumQuestionLevel4 != null ? !iNumQuestionLevel4.equals(that.iNumQuestionLevel4) : that.iNumQuestionLevel4 != null)
            return false;
        if (iRateOfDifficultyPkEk != null ? !iRateOfDifficultyPkEk.equals(that.iRateOfDifficultyPkEk) : that.iRateOfDifficultyPkEk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iRateOfDifficultyPk;
        result = 31 * result + (iNumQuestionLevel1 != null ? iNumQuestionLevel1.hashCode() : 0);
        result = 31 * result + (iNumQuestionLevel2 != null ? iNumQuestionLevel2.hashCode() : 0);
        result = 31 * result + (iNumQuestionLevel3 != null ? iNumQuestionLevel3.hashCode() : 0);
        result = 31 * result + (iNumQuestionLevel4 != null ? iNumQuestionLevel4.hashCode() : 0);
        result = 31 * result + (iRateOfDifficultyPkEk != null ? iRateOfDifficultyPkEk.hashCode() : 0);
        return result;
    }
}
