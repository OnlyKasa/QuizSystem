package com.ben.quiz.domain.model;

import com.ben.quiz.domain.common.constant.SequenceConst;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "examination_information", schema = "public", catalog = "quizsystem")
public class ExaminationInformation  extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -7361216345485402763L;
    private int iExaminationInformationPk;
    private String strExaminationInformationCode;
    private Integer iExaminationRoomPk;
    private Integer iSubjectInformationPk;
    private Integer iTeacherInformationPk;
    private Timestamp dtExaminationDay;
    private Integer iRateOfDifficultyPk;
    private int iTestInformationTime;
    private Integer iExaminationInformationPkEk;
    private ExaminationRoom examinationRoomByIExaminationRoomPk;
    private SubjectInformation subjectInformationByISubjectInformationPk;
    private TeacherInformation teacherInformationByITeacherInformationPk;
    private RateOfDifficulty rateOfDifficultyByIRateOfDifficultyPk;
    private Collection<ExaminationInformationDetail> examinationInformationDetailsByIExaminationInformationPk;
    private Collection<TestInformation> testInformationsByIExaminationInformationPk;

    @Id
    @GenericGenerator(
            name = SequenceConst.EXAMINATION_INFORMATION_SEQ_GEN,
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
            @org.hibernate.annotations.Parameter(name = "sequence_name", value = SequenceConst.EXAMINATION_INFORMATION_SEQ)}
    )
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
    @Column(name = "i_examination_room_pk", nullable = true)
    public Integer getiExaminationRoomPk() {
        return iExaminationRoomPk;
    }

    public void setiExaminationRoomPk(Integer iExaminationRoomPk) {
        this.iExaminationRoomPk = iExaminationRoomPk;
    }

    @Basic
    @Column(name = "i_subject_information_pk", nullable = true)
    public Integer getiSubjectInformationPk() {
        return iSubjectInformationPk;
    }

    public void setiSubjectInformationPk(Integer iSubjectInformationPk) {
        this.iSubjectInformationPk = iSubjectInformationPk;
    }

    @Basic
    @Column(name = "i_teacher_information_pk", nullable = true)
    public Integer getiTeacherInformationPk() {
        return iTeacherInformationPk;
    }

    public void setiTeacherInformationPk(Integer iTeacherInformationPk) {
        this.iTeacherInformationPk = iTeacherInformationPk;
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
    @Column(name = "i_rate_of_difficulty_pk", nullable = true)
    public Integer getiRateOfDifficultyPk() {
        return iRateOfDifficultyPk;
    }

    public void setiRateOfDifficultyPk(Integer iRateOfDifficultyPk) {
        this.iRateOfDifficultyPk = iRateOfDifficultyPk;
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
        if (iExaminationRoomPk != null ? !iExaminationRoomPk.equals(that.iExaminationRoomPk) : that.iExaminationRoomPk != null)
            return false;
        if (iSubjectInformationPk != null ? !iSubjectInformationPk.equals(that.iSubjectInformationPk) : that.iSubjectInformationPk != null)
            return false;
        if (iTeacherInformationPk != null ? !iTeacherInformationPk.equals(that.iTeacherInformationPk) : that.iTeacherInformationPk != null)
            return false;
        if (dtExaminationDay != null ? !dtExaminationDay.equals(that.dtExaminationDay) : that.dtExaminationDay != null)
            return false;
        if (iRateOfDifficultyPk != null ? !iRateOfDifficultyPk.equals(that.iRateOfDifficultyPk) : that.iRateOfDifficultyPk != null)
            return false;
        if (iExaminationInformationPkEk != null ? !iExaminationInformationPkEk.equals(that.iExaminationInformationPkEk) : that.iExaminationInformationPkEk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iExaminationInformationPk;
        result = 31 * result + (strExaminationInformationCode != null ? strExaminationInformationCode.hashCode() : 0);
        result = 31 * result + (iExaminationRoomPk != null ? iExaminationRoomPk.hashCode() : 0);
        result = 31 * result + (iSubjectInformationPk != null ? iSubjectInformationPk.hashCode() : 0);
        result = 31 * result + (iTeacherInformationPk != null ? iTeacherInformationPk.hashCode() : 0);
        result = 31 * result + (dtExaminationDay != null ? dtExaminationDay.hashCode() : 0);
        result = 31 * result + (iRateOfDifficultyPk != null ? iRateOfDifficultyPk.hashCode() : 0);
        result = 31 * result + iTestInformationTime;
        result = 31 * result + (iExaminationInformationPkEk != null ? iExaminationInformationPkEk.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "i_examination_room_pk", referencedColumnName = "i_examination_room_pk",insertable = false ,updatable = false)
    public ExaminationRoom getExaminationRoomByIExaminationRoomPk() {
        return examinationRoomByIExaminationRoomPk;
    }

    public void setExaminationRoomByIExaminationRoomPk(ExaminationRoom examinationRoomByIExaminationRoomPk) {
        this.examinationRoomByIExaminationRoomPk = examinationRoomByIExaminationRoomPk;
    }

    @ManyToOne
    @JoinColumn(name = "i_subject_information_pk", referencedColumnName = "i_subject_information_pk",insertable = false ,updatable = false)
    public SubjectInformation getSubjectInformationByISubjectInformationPk() {
        return subjectInformationByISubjectInformationPk;
    }

    public void setSubjectInformationByISubjectInformationPk(SubjectInformation subjectInformationByISubjectInformationPk) {
        this.subjectInformationByISubjectInformationPk = subjectInformationByISubjectInformationPk;
    }

    @ManyToOne
    @JoinColumn(name = "i_teacher_information_pk", referencedColumnName = "i_teacher_information_pk",insertable = false ,updatable = false)
    public TeacherInformation getTeacherInformationByITeacherInformationPk() {
        return teacherInformationByITeacherInformationPk;
    }

    public void setTeacherInformationByITeacherInformationPk(TeacherInformation teacherInformationByITeacherInformationPk) {
        this.teacherInformationByITeacherInformationPk = teacherInformationByITeacherInformationPk;
    }

    @ManyToOne
    @JoinColumn(name = "i_rate_of_difficulty_pk", referencedColumnName = "i_rate_of_difficulty_pk",insertable = false ,updatable = false)
    public RateOfDifficulty getRateOfDifficultyByIRateOfDifficultyPk() {
        return rateOfDifficultyByIRateOfDifficultyPk;
    }

    public void setRateOfDifficultyByIRateOfDifficultyPk(RateOfDifficulty rateOfDifficultyByIRateOfDifficultyPk) {
        this.rateOfDifficultyByIRateOfDifficultyPk = rateOfDifficultyByIRateOfDifficultyPk;
    }

    @OneToMany(mappedBy = "examinationInformationByIExaminationInformationPk")
    public Collection<ExaminationInformationDetail> getExaminationInformationDetailsByIExaminationInformationPk() {
        return examinationInformationDetailsByIExaminationInformationPk;
    }

    public void setExaminationInformationDetailsByIExaminationInformationPk(Collection<ExaminationInformationDetail> examinationInformationDetailsByIExaminationInformationPk) {
        this.examinationInformationDetailsByIExaminationInformationPk = examinationInformationDetailsByIExaminationInformationPk;
    }

    @OneToMany(mappedBy = "examinationInformationByIExaminationInformationPk")
    public Collection<TestInformation> getTestInformationsByIExaminationInformationPk() {
        return testInformationsByIExaminationInformationPk;
    }

    public void setTestInformationsByIExaminationInformationPk(Collection<TestInformation> testInformationsByIExaminationInformationPk) {
        this.testInformationsByIExaminationInformationPk = testInformationsByIExaminationInformationPk;
    }
}
