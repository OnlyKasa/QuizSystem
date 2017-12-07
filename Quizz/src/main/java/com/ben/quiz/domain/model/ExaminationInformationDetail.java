package com.ben.quiz.domain.model;

import com.ben.quiz.domain.common.constant.SequenceConst;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "examination_information_detail", schema = "public", catalog = "quizsystem")
public class ExaminationInformationDetail  extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -4519399836976070223L;
    private int iExaminationInformationDetailPk;
    private Integer iExaminationInformationPk;
    private Integer iStudentInformationPk;
    private Integer iExaminationInformationDetailPkEk;
    private ExaminationInformation examinationInformationByIExaminationInformationPk;
    private StudentInformation studentInformationByIStudentInformationPk;

    @Id
    @GenericGenerator(
            name = SequenceConst.EXAMINATION_INFORMATION_DETAIL_SEQ_GEN,
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
            @org.hibernate.annotations.Parameter(name = "sequence_name", value = SequenceConst.EXAMINATION_INFORMATION_DETAIL_SEQ)}
    )
    @Column(name = "i_examination_information_detail_pk", nullable = false)
    public int getiExaminationInformationDetailPk() {
        return iExaminationInformationDetailPk;
    }

    public void setiExaminationInformationDetailPk(int iExaminationInformationDetailPk) {
        this.iExaminationInformationDetailPk = iExaminationInformationDetailPk;
    }

    @Basic
    @Column(name = "i_examination_information_pk", nullable = true)
    public Integer getiExaminationInformationPk() {
        return iExaminationInformationPk;
    }

    public void setiExaminationInformationPk(Integer iExaminationInformationPk) {
        this.iExaminationInformationPk = iExaminationInformationPk;
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
    @Column(name = "i_examination_information_detail_pk_ek", nullable = true)
    public Integer getiExaminationInformationDetailPkEk() {
        return iExaminationInformationDetailPkEk;
    }

    public void setiExaminationInformationDetailPkEk(Integer iExaminationInformationDetailPkEk) {
        this.iExaminationInformationDetailPkEk = iExaminationInformationDetailPkEk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExaminationInformationDetail that = (ExaminationInformationDetail) o;

        if (iExaminationInformationDetailPk != that.iExaminationInformationDetailPk) return false;
        if (iExaminationInformationPk != null ? !iExaminationInformationPk.equals(that.iExaminationInformationPk) : that.iExaminationInformationPk != null)
            return false;
        if (iStudentInformationPk != null ? !iStudentInformationPk.equals(that.iStudentInformationPk) : that.iStudentInformationPk != null)
            return false;
        if (iExaminationInformationDetailPkEk != null ? !iExaminationInformationDetailPkEk.equals(that.iExaminationInformationDetailPkEk) : that.iExaminationInformationDetailPkEk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iExaminationInformationDetailPk;
        result = 31 * result + (iExaminationInformationPk != null ? iExaminationInformationPk.hashCode() : 0);
        result = 31 * result + (iStudentInformationPk != null ? iStudentInformationPk.hashCode() : 0);
        result = 31 * result + (iExaminationInformationDetailPkEk != null ? iExaminationInformationDetailPkEk.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "i_examination_information_pk", referencedColumnName = "i_examination_information_pk",insertable = false ,updatable = false)
    public ExaminationInformation getExaminationInformationByIExaminationInformationPk() {
        return examinationInformationByIExaminationInformationPk;
    }

    public void setExaminationInformationByIExaminationInformationPk(ExaminationInformation examinationInformationByIExaminationInformationPk) {
        this.examinationInformationByIExaminationInformationPk = examinationInformationByIExaminationInformationPk;
    }

    @ManyToOne
    @JoinColumn(name = "i_student_information_pk", referencedColumnName = "i_student_information_pk",insertable = false ,updatable = false)
    public StudentInformation getStudentInformationByIStudentInformationPk() {
        return studentInformationByIStudentInformationPk;
    }

    public void setStudentInformationByIStudentInformationPk(StudentInformation studentInformationByIStudentInformationPk) {
        this.studentInformationByIStudentInformationPk = studentInformationByIStudentInformationPk;
    }
}
