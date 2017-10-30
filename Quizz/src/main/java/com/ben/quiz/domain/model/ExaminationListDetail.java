package com.ben.quiz.domain.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "examination_list_detail", schema = "public", catalog = "quizsystem")
public class ExaminationListDetail extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -2674183125823746033L;
    private int iExaminationListDetailPk;
    private Integer iExaminationListPk;
    private Integer iExaminationListDetailPkEk;
    private Integer iStudentInformationPk;
    private ExaminationList examinationListByIExaminationListPk;
    private StudentInformation studentInformationByIStudentInformationPk;

    @Id
    @Column(name = "i_examination_list_detail_pk", nullable = false)
    public int getiExaminationListDetailPk() {
        return iExaminationListDetailPk;
    }

    public void setiExaminationListDetailPk(int iExaminationListDetailPk) {
        this.iExaminationListDetailPk = iExaminationListDetailPk;
    }

    @Basic
    @Column(name = "i_examination_list_pk", nullable = true)
    public Integer getiExaminationListPk() {
        return iExaminationListPk;
    }

    public void setiExaminationListPk(Integer iExaminationListPk) {
        this.iExaminationListPk = iExaminationListPk;
    }

    @Basic
    @Column(name = "i_examination_list_detail_pk_ek", nullable = true)
    public Integer getiExaminationListDetailPkEk() {
        return iExaminationListDetailPkEk;
    }

    public void setiExaminationListDetailPkEk(Integer iExaminationListDetailPkEk) {
        this.iExaminationListDetailPkEk = iExaminationListDetailPkEk;
    }

    @Basic
    @Column(name = "i_student_information_pk", nullable = true)
    public Integer getiStudentInformationPk() {
        return iStudentInformationPk;
    }

    public void setiStudentInformationPk(Integer iStudentInformationPk) {
        this.iStudentInformationPk = iStudentInformationPk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExaminationListDetail that = (ExaminationListDetail) o;

        if (iExaminationListDetailPk != that.iExaminationListDetailPk) return false;
        if (iExaminationListPk != null ? !iExaminationListPk.equals(that.iExaminationListPk) : that.iExaminationListPk != null)
            return false;
        if (iExaminationListDetailPkEk != null ? !iExaminationListDetailPkEk.equals(that.iExaminationListDetailPkEk) : that.iExaminationListDetailPkEk != null)
            return false;
        if (iStudentInformationPk != null ? !iStudentInformationPk.equals(that.iStudentInformationPk) : that.iStudentInformationPk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iExaminationListDetailPk;
        result = 31 * result + (iExaminationListPk != null ? iExaminationListPk.hashCode() : 0);
        result = 31 * result + (iExaminationListDetailPkEk != null ? iExaminationListDetailPkEk.hashCode() : 0);
        result = 31 * result + (iStudentInformationPk != null ? iStudentInformationPk.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "i_examination_list_pk", referencedColumnName = "i_examination_list_pk")
    public ExaminationList getExaminationListByIExaminationListPk() {
        return examinationListByIExaminationListPk;
    }

    public void setExaminationListByIExaminationListPk(ExaminationList examinationListByIExaminationListPk) {
        this.examinationListByIExaminationListPk = examinationListByIExaminationListPk;
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
