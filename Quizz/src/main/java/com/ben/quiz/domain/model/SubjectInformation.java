package com.ben.quiz.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "subject_information", schema = "public", catalog = "quizsystem")
public class SubjectInformation extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -5995867655798813062L;
    private int iSubjectInformationPk;
    private String strSubjectInformationName;
    private int iSubjectInformationCreditsNum;
    private Integer iSubjectInformationPkEk;
    private Collection<ExaminationInformation> examinationInformationsByISubjectInformationPk;
    private Collection<QuestionInformation> questionInformationsByISubjectInformationPk;

    @Id
    @Column(name = "i_subject_information_pk", nullable = false)
    public int getiSubjectInformationPk() {
        return iSubjectInformationPk;
    }

    public void setiSubjectInformationPk(int iSubjectInformationPk) {
        this.iSubjectInformationPk = iSubjectInformationPk;
    }

    @Basic
    @Column(name = "str_subject_information_name", nullable = false, length = 100)
    public String getStrSubjectInformationName() {
        return strSubjectInformationName;
    }

    public void setStrSubjectInformationName(String strSubjectInformationName) {
        this.strSubjectInformationName = strSubjectInformationName;
    }

    @Basic
    @Column(name = "i_subject_information_credits_num", nullable = false)
    public int getiSubjectInformationCreditsNum() {
        return iSubjectInformationCreditsNum;
    }

    public void setiSubjectInformationCreditsNum(int iSubjectInformationCreditsNum) {
        this.iSubjectInformationCreditsNum = iSubjectInformationCreditsNum;
    }

    @Basic
    @Column(name = "i_subject_information_pk_ek", nullable = true)
    public Integer getiSubjectInformationPkEk() {
        return iSubjectInformationPkEk;
    }

    public void setiSubjectInformationPkEk(Integer iSubjectInformationPkEk) {
        this.iSubjectInformationPkEk = iSubjectInformationPkEk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubjectInformation that = (SubjectInformation) o;

        if (iSubjectInformationPk != that.iSubjectInformationPk) return false;
        if (iSubjectInformationCreditsNum != that.iSubjectInformationCreditsNum) return false;
        if (strSubjectInformationName != null ? !strSubjectInformationName.equals(that.strSubjectInformationName) : that.strSubjectInformationName != null)
            return false;
        if (iSubjectInformationPkEk != null ? !iSubjectInformationPkEk.equals(that.iSubjectInformationPkEk) : that.iSubjectInformationPkEk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iSubjectInformationPk;
        result = 31 * result + (strSubjectInformationName != null ? strSubjectInformationName.hashCode() : 0);
        result = 31 * result + iSubjectInformationCreditsNum;
        result = 31 * result + (iSubjectInformationPkEk != null ? iSubjectInformationPkEk.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "subjectInformationByISubjectInformationPk")
    public Collection<ExaminationInformation> getExaminationInformationsByISubjectInformationPk() {
        return examinationInformationsByISubjectInformationPk;
    }

    public void setExaminationInformationsByISubjectInformationPk(Collection<ExaminationInformation> examinationInformationsByISubjectInformationPk) {
        this.examinationInformationsByISubjectInformationPk = examinationInformationsByISubjectInformationPk;
    }

    @OneToMany(mappedBy = "subjectInformationByISubjectInformationPk")
    public Collection<QuestionInformation> getQuestionInformationsByISubjectInformationPk() {
        return questionInformationsByISubjectInformationPk;
    }

    public void setQuestionInformationsByISubjectInformationPk(Collection<QuestionInformation> questionInformationsByISubjectInformationPk) {
        this.questionInformationsByISubjectInformationPk = questionInformationsByISubjectInformationPk;
    }
}
