package com.ben.quiz.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "examination_list", schema = "public", catalog = "quizsystem")
public class ExaminationList extends BaseEntity implements Serializable{
    private static final long serialVersionUID = -3914521660802404844L;
    private int iExaminationListPk;
    private Integer iExaminationRoomPk;
    private Integer iSubjectInformationPk;
    private Integer iTeacherInformationPk;
    private Timestamp dtExaminationDay;
    private Integer iExaminationListPkEk;

    private ExaminationRoom examinationRoomByIExaminationRoomPk;
    private SubjectInformation subjectInformationByISubjectInformationPk;
    private TeacherInformation teacherInformationByITeacherInformationPk;
    private Collection<ExaminationListDetail> examinationListDetailsByIExaminationListPk;

    @Id
    @Column(name = "i_examination_list_pk", nullable = false)
    public int getiExaminationListPk() {
        return iExaminationListPk;
    }

    public void setiExaminationListPk(int iExaminationListPk) {
        this.iExaminationListPk = iExaminationListPk;
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
    @Column(name = "i_examination_list_pk_ek", nullable = true)
    public Integer getiExaminationListPkEk() {
        return iExaminationListPkEk;
    }

    public void setiExaminationListPkEk(Integer iExaminationListPkEk) {
        this.iExaminationListPkEk = iExaminationListPkEk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExaminationList that = (ExaminationList) o;

        if (iExaminationListPk != that.iExaminationListPk) return false;
        if (iExaminationRoomPk != null ? !iExaminationRoomPk.equals(that.iExaminationRoomPk) : that.iExaminationRoomPk != null)
            return false;
        if (iSubjectInformationPk != null ? !iSubjectInformationPk.equals(that.iSubjectInformationPk) : that.iSubjectInformationPk != null)
            return false;
        if (iTeacherInformationPk != null ? !iTeacherInformationPk.equals(that.iTeacherInformationPk) : that.iTeacherInformationPk != null)
            return false;
        if (dtExaminationDay != null ? !dtExaminationDay.equals(that.dtExaminationDay) : that.dtExaminationDay != null)
            return false;
        if (iExaminationListPkEk != null ? !iExaminationListPkEk.equals(that.iExaminationListPkEk) : that.iExaminationListPkEk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iExaminationListPk;
        result = 31 * result + (iExaminationRoomPk != null ? iExaminationRoomPk.hashCode() : 0);
        result = 31 * result + (iSubjectInformationPk != null ? iSubjectInformationPk.hashCode() : 0);
        result = 31 * result + (iTeacherInformationPk != null ? iTeacherInformationPk.hashCode() : 0);
        result = 31 * result + (dtExaminationDay != null ? dtExaminationDay.hashCode() : 0);
        result = 31 * result + (iExaminationListPkEk != null ? iExaminationListPkEk.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "i_examination_room_pk", referencedColumnName = "i_examination_room_pk")
    public ExaminationRoom getExaminationRoomByIExaminationRoomPk() {
        return examinationRoomByIExaminationRoomPk;
    }

    public void setExaminationRoomByIExaminationRoomPk(ExaminationRoom examinationRoomByIExaminationRoomPk) {
        this.examinationRoomByIExaminationRoomPk = examinationRoomByIExaminationRoomPk;
    }

    @ManyToOne
    @JoinColumn(name = "i_subject_information_pk", referencedColumnName = "i_subject_information_pk")
    public SubjectInformation getSubjectInformationByISubjectInformationPk() {
        return subjectInformationByISubjectInformationPk;
    }

    public void setSubjectInformationByISubjectInformationPk(SubjectInformation subjectInformationByISubjectInformationPk) {
        this.subjectInformationByISubjectInformationPk = subjectInformationByISubjectInformationPk;
    }

    @ManyToOne
    @JoinColumn(name = "i_teacher_information_pk", referencedColumnName = "i_teacher_information_pk")
    public TeacherInformation getTeacherInformationByITeacherInformationPk() {
        return teacherInformationByITeacherInformationPk;
    }

    public void setTeacherInformationByITeacherInformationPk(TeacherInformation teacherInformationByITeacherInformationPk) {
        this.teacherInformationByITeacherInformationPk = teacherInformationByITeacherInformationPk;
    }

    @OneToMany(mappedBy = "examinationListByIExaminationListPk")
    public Collection<ExaminationListDetail> getExaminationListDetailsByIExaminationListPk() {
        return examinationListDetailsByIExaminationListPk;
    }

    public void setExaminationListDetailsByIExaminationListPk(Collection<ExaminationListDetail> examinationListDetailsByIExaminationListPk) {
        this.examinationListDetailsByIExaminationListPk = examinationListDetailsByIExaminationListPk;
    }
}
