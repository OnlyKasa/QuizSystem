package com.ben.quiz.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "examination_information", schema = "public", catalog = "quizsystem")
public class ExaminationInformation extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -5002395903128117867L;
    private int iExaminationInformationPk;
    private String strExaminationInformationCode;
    private Timestamp dtExaminationDay;
    private int iTestInformationTime;
    private Integer iExaminationInformationPkEk;

    @Id
    @Column(name = "i_examination_information_pk", nullable = false)
    public int getiExaminationInformationPk() {
        return iExaminationInformationPk;
    }

    public void setiExaminationInformationPk(int iExaminationInformationPk) {
        this.iExaminationInformationPk = iExaminationInformationPk;
    }

    @Basic
    @Column(name = "str_examination_information_code", nullable = false, length = 50)
    public String getStrExaminationInformationCode() {
        return strExaminationInformationCode;
    }

    public void setStrExaminationInformationCode(String strExaminationInformationCode) {
        this.strExaminationInformationCode = strExaminationInformationCode;
    }

    @Basic
    @Column(name = "dt_examination_day", nullable = true)
    public Timestamp getDtExaminationDay() {
        return dtExaminationDay;
    }

    public void setDtExaminationDay(Timestamp dtExaminationDay) {
        this.dtExaminationDay = dtExaminationDay;
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
    @Column(name = "i_examination_information_pk_ek", nullable = true)
    public Integer getiExaminationInformationPkEk() {
        return iExaminationInformationPkEk;
    }

    public void setiExaminationInformationPkEk(Integer iExaminationInformationPkEk) {
        this.iExaminationInformationPkEk = iExaminationInformationPkEk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExaminationInformation that = (ExaminationInformation) o;

        if (iExaminationInformationPk != that.iExaminationInformationPk) return false;
        if (iTestInformationTime != that.iTestInformationTime) return false;
        if (strExaminationInformationCode != null ? !strExaminationInformationCode.equals(that.strExaminationInformationCode) : that.strExaminationInformationCode != null)
            return false;
        if (dtExaminationDay != null ? !dtExaminationDay.equals(that.dtExaminationDay) : that.dtExaminationDay != null)
            return false;
        if (iExaminationInformationPkEk != null ? !iExaminationInformationPkEk.equals(that.iExaminationInformationPkEk) : that.iExaminationInformationPkEk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iExaminationInformationPk;
        result = 31 * result + (strExaminationInformationCode != null ? strExaminationInformationCode.hashCode() : 0);
        result = 31 * result + (dtExaminationDay != null ? dtExaminationDay.hashCode() : 0);
        result = 31 * result + iTestInformationTime;
        result = 31 * result + (iExaminationInformationPkEk != null ? iExaminationInformationPkEk.hashCode() : 0);
        return result;
    }
}
