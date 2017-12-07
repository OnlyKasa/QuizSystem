package com.ben.quiz.domain.model;

import com.ben.quiz.domain.common.constant.SequenceConst;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "examination_information_detail", schema = "public", catalog = "quizsystem")
public class ExaminationInformationDetail extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -5859186290959780161L;
    private int iExaminationInformationDetailPk;
    private Integer iExaminationInformationDetailPkEk;
    private ExaminationInformation examinationInformationByIExaminationInformationPk;

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
        if (iExaminationInformationDetailPkEk != null ? !iExaminationInformationDetailPkEk.equals(that.iExaminationInformationDetailPkEk) : that.iExaminationInformationDetailPkEk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iExaminationInformationDetailPk;
        result = 31 * result + (iExaminationInformationDetailPkEk != null ? iExaminationInformationDetailPkEk.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "i_examination_information_pk", referencedColumnName = "i_examination_information_pk")
    public ExaminationInformation getExaminationInformationByIExaminationInformationPk() {
        return examinationInformationByIExaminationInformationPk;
    }

    public void setExaminationInformationByIExaminationInformationPk(ExaminationInformation examinationInformationByIExaminationInformationPk) {
        this.examinationInformationByIExaminationInformationPk = examinationInformationByIExaminationInformationPk;
    }
}
