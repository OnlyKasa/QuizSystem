package com.ben.quiz.domain.model;

import com.ben.quiz.domain.common.constant.SequenceConst;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "question_information", schema = "public", catalog = "quizsystem")
public class QuestionInformation extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -3291839400515863612L;
    private int iQuestionInformationPk;
    private Integer iTeacherInformationPk;
    private Integer iSubjectInformationPk;
    private Integer iQuestionInformationLevel;
    private String strQuestionContentInformation;
    private String strAnswer1;
    private String strAnswer2;
    private String strAnswer3;
    private String strAnswer4;
    private String strAnswer5;
    private String strTrueAnswer;
    private Integer iQuestionInformationPkEk;
    private TeacherInformation teacherInformationByITeacherInformationPk;
    private SubjectInformation subjectInformationByISubjectInformationPk;
    private Collection<TestInformationDetail> testInformationDetailsByIQuestionInformationPk;

    @Id
    @GenericGenerator(
            name = SequenceConst.QUESTION_INFORMATION_SEQ_GEN,
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
            @org.hibernate.annotations.Parameter(name = "sequence_name", value = SequenceConst.QUESTION_INFORMATION_SEQ)}
    )
    @Column(name = "i_question_information_pk", nullable = false)
    public int getiQuestionInformationPk() {
        return iQuestionInformationPk;
    }

    public void setiQuestionInformationPk(int iQuestionInformationPk) {
        this.iQuestionInformationPk = iQuestionInformationPk;
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
    @Column(name = "i_subject_information_pk", nullable = true)
    public Integer getiSubjectInformationPk() {
        return iSubjectInformationPk;
    }

    public void setiSubjectInformationPk(Integer iSubjectInformationPk) {
        this.iSubjectInformationPk = iSubjectInformationPk;
    }

    @Basic
    @Column(name = "i_question_information_level", nullable = true)
    public Integer getiQuestionInformationLevel() {
        return iQuestionInformationLevel;
    }

    public void setiQuestionInformationLevel(Integer iQuestionInformationLevel) {
        this.iQuestionInformationLevel = iQuestionInformationLevel;
    }

    @Basic
    @Column(name = "str_question_content_information", nullable = false, length = 1000)
    public String getStrQuestionContentInformation() {
        return strQuestionContentInformation;
    }

    public void setStrQuestionContentInformation(String strQuestionContentInformation) {
        this.strQuestionContentInformation = strQuestionContentInformation;
    }

    @Basic
    @Column(name = "str_answer_1", nullable = true, length = 500)
    public String getStrAnswer1() {
        return strAnswer1;
    }

    public void setStrAnswer1(String strAnswer1) {
        this.strAnswer1 = strAnswer1;
    }

    @Basic
    @Column(name = "str_answer_2", nullable = true, length = 500)
    public String getStrAnswer2() {
        return strAnswer2;
    }

    public void setStrAnswer2(String strAnswer2) {
        this.strAnswer2 = strAnswer2;
    }

    @Basic
    @Column(name = "str_answer_3", nullable = true, length = 500)
    public String getStrAnswer3() {
        return strAnswer3;
    }

    public void setStrAnswer3(String strAnswer3) {
        this.strAnswer3 = strAnswer3;
    }

    @Basic
    @Column(name = "str_answer_4", nullable = true, length = 500)
    public String getStrAnswer4() {
        return strAnswer4;
    }

    public void setStrAnswer4(String strAnswer4) {
        this.strAnswer4 = strAnswer4;
    }

    @Basic
    @Column(name = "str_answer_5", nullable = true, length = 500)
    public String getStrAnswer5() {
        return strAnswer5;
    }

    public void setStrAnswer5(String strAnswer5) {
        this.strAnswer5 = strAnswer5;
    }

    @Basic
    @Column(name = "str_true_answer", nullable = false, length = 500)
    public String getStrTrueAnswer() {
        return strTrueAnswer;
    }

    public void setStrTrueAnswer(String strTrueAnswer) {
        this.strTrueAnswer = strTrueAnswer;
    }

    @Basic
    @Column(name = "i_question_information_pk_ek", nullable = true)
    public Integer getiQuestionInformationPkEk() {
        return iQuestionInformationPkEk;
    }

    public void setiQuestionInformationPkEk(Integer iQuestionInformationPkEk) {
        this.iQuestionInformationPkEk = iQuestionInformationPkEk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionInformation that = (QuestionInformation) o;

        if (iQuestionInformationPk != that.iQuestionInformationPk) return false;
        if (iTeacherInformationPk != null ? !iTeacherInformationPk.equals(that.iTeacherInformationPk) : that.iTeacherInformationPk != null)
            return false;
        if (iSubjectInformationPk != null ? !iSubjectInformationPk.equals(that.iSubjectInformationPk) : that.iSubjectInformationPk != null)
            return false;
        if (iQuestionInformationLevel != null ? !iQuestionInformationLevel.equals(that.iQuestionInformationLevel) : that.iQuestionInformationLevel != null)
            return false;
        if (strQuestionContentInformation != null ? !strQuestionContentInformation.equals(that.strQuestionContentInformation) : that.strQuestionContentInformation != null)
            return false;
        if (strAnswer1 != null ? !strAnswer1.equals(that.strAnswer1) : that.strAnswer1 != null) return false;
        if (strAnswer2 != null ? !strAnswer2.equals(that.strAnswer2) : that.strAnswer2 != null) return false;
        if (strAnswer3 != null ? !strAnswer3.equals(that.strAnswer3) : that.strAnswer3 != null) return false;
        if (strAnswer4 != null ? !strAnswer4.equals(that.strAnswer4) : that.strAnswer4 != null) return false;
        if (strAnswer5 != null ? !strAnswer5.equals(that.strAnswer5) : that.strAnswer5 != null) return false;
        if (strTrueAnswer != null ? !strTrueAnswer.equals(that.strTrueAnswer) : that.strTrueAnswer != null)
            return false;
        if (iQuestionInformationPkEk != null ? !iQuestionInformationPkEk.equals(that.iQuestionInformationPkEk) : that.iQuestionInformationPkEk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iQuestionInformationPk;
        result = 31 * result + (iTeacherInformationPk != null ? iTeacherInformationPk.hashCode() : 0);
        result = 31 * result + (iSubjectInformationPk != null ? iSubjectInformationPk.hashCode() : 0);
        result = 31 * result + (iQuestionInformationLevel != null ? iQuestionInformationLevel.hashCode() : 0);
        result = 31 * result + (strQuestionContentInformation != null ? strQuestionContentInformation.hashCode() : 0);
        result = 31 * result + (strAnswer1 != null ? strAnswer1.hashCode() : 0);
        result = 31 * result + (strAnswer2 != null ? strAnswer2.hashCode() : 0);
        result = 31 * result + (strAnswer3 != null ? strAnswer3.hashCode() : 0);
        result = 31 * result + (strAnswer4 != null ? strAnswer4.hashCode() : 0);
        result = 31 * result + (strAnswer5 != null ? strAnswer5.hashCode() : 0);
        result = 31 * result + (strTrueAnswer != null ? strTrueAnswer.hashCode() : 0);
        result = 31 * result + (iQuestionInformationPkEk != null ? iQuestionInformationPkEk.hashCode() : 0);
        return result;
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
    @JoinColumn(name = "i_subject_information_pk", referencedColumnName = "i_subject_information_pk",insertable = false ,updatable = false)
    public SubjectInformation getSubjectInformationByISubjectInformationPk() {
        return subjectInformationByISubjectInformationPk;
    }

    public void setSubjectInformationByISubjectInformationPk(SubjectInformation subjectInformationByISubjectInformationPk) {
        this.subjectInformationByISubjectInformationPk = subjectInformationByISubjectInformationPk;
    }

    @OneToMany(mappedBy = "questionInformationByIQuestionInformationPk")
    public Collection<TestInformationDetail> getTestInformationDetailsByIQuestionInformationPk() {
        return testInformationDetailsByIQuestionInformationPk;
    }

    public void setTestInformationDetailsByIQuestionInformationPk(Collection<TestInformationDetail> testInformationDetailsByIQuestionInformationPk) {
        this.testInformationDetailsByIQuestionInformationPk = testInformationDetailsByIQuestionInformationPk;
    }
}
