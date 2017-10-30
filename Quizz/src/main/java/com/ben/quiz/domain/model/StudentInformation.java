package com.ben.quiz.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "student_information", schema = "public", catalog = "quizsystem")
public class StudentInformation extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 4094109657012183007L;
    private int iStudentInformationPk;
    private int iStudentInformationCode;
    private String strStudentInformationFirstName;
    private String strStudentInformationLastName;
    private Date dtStudentInformationBirthday;
    private Integer iStudentInformationPkEk;
    private Collection<ExaminationListDetail> examinationListDetailsByIStudentInformationPk;
    private Collection<ExaminationResult> examinationResultsByIStudentInformationPk;
    private FacultyInformation facultyInformationByIFacultyInformationPk;

    @Id
    @Column(name = "i_student_information_pk", nullable = false)
    public int getiStudentInformationPk() {
        return iStudentInformationPk;
    }

    public void setiStudentInformationPk(int iStudentInformationPk) {
        this.iStudentInformationPk = iStudentInformationPk;
    }

    @Basic
    @Column(name = "i_student_information_code", nullable = false)
    public int getiStudentInformationCode() {
        return iStudentInformationCode;
    }

    public void setiStudentInformationCode(int iStudentInformationCode) {
        this.iStudentInformationCode = iStudentInformationCode;
    }

    @Basic
    @Column(name = "str_student_information_first_name", nullable = true, length = 30)
    public String getStrStudentInformationFirstName() {
        return strStudentInformationFirstName;
    }

    public void setStrStudentInformationFirstName(String strStudentInformationFirstName) {
        this.strStudentInformationFirstName = strStudentInformationFirstName;
    }

    @Basic
    @Column(name = "str_student_information_last_name", nullable = true, length = 30)
    public String getStrStudentInformationLastName() {
        return strStudentInformationLastName;
    }

    public void setStrStudentInformationLastName(String strStudentInformationLastName) {
        this.strStudentInformationLastName = strStudentInformationLastName;
    }

    @Basic
    @Column(name = "dt_student_information_birthday", nullable = true)
    public Date getDtStudentInformationBirthday() {
        return dtStudentInformationBirthday;
    }

    public void setDtStudentInformationBirthday(Date dtStudentInformationBirthday) {
        this.dtStudentInformationBirthday = dtStudentInformationBirthday;
    }

    @Basic
    @Column(name = "i_student_information_pk_ek", nullable = true)
    public Integer getiStudentInformationPkEk() {
        return iStudentInformationPkEk;
    }

    public void setiStudentInformationPkEk(Integer iStudentInformationPkEk) {
        this.iStudentInformationPkEk = iStudentInformationPkEk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentInformation that = (StudentInformation) o;

        if (iStudentInformationPk != that.iStudentInformationPk) return false;
        if (iStudentInformationCode != that.iStudentInformationCode) return false;
        if (strStudentInformationFirstName != null ? !strStudentInformationFirstName.equals(that.strStudentInformationFirstName) : that.strStudentInformationFirstName != null)
            return false;
        if (strStudentInformationLastName != null ? !strStudentInformationLastName.equals(that.strStudentInformationLastName) : that.strStudentInformationLastName != null)
            return false;
        if (dtStudentInformationBirthday != null ? !dtStudentInformationBirthday.equals(that.dtStudentInformationBirthday) : that.dtStudentInformationBirthday != null)
            return false;
        if (iStudentInformationPkEk != null ? !iStudentInformationPkEk.equals(that.iStudentInformationPkEk) : that.iStudentInformationPkEk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iStudentInformationPk;
        result = 31 * result + iStudentInformationCode;
        result = 31 * result + (strStudentInformationFirstName != null ? strStudentInformationFirstName.hashCode() : 0);
        result = 31 * result + (strStudentInformationLastName != null ? strStudentInformationLastName.hashCode() : 0);
        result = 31 * result + (dtStudentInformationBirthday != null ? dtStudentInformationBirthday.hashCode() : 0);
        result = 31 * result + (iStudentInformationPkEk != null ? iStudentInformationPkEk.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "studentInformationByIStudentInformationPk")
    public Collection<ExaminationListDetail> getExaminationListDetailsByIStudentInformationPk() {
        return examinationListDetailsByIStudentInformationPk;
    }

    public void setExaminationListDetailsByIStudentInformationPk(Collection<ExaminationListDetail> examinationListDetailsByIStudentInformationPk) {
        this.examinationListDetailsByIStudentInformationPk = examinationListDetailsByIStudentInformationPk;
    }

    @OneToMany(mappedBy = "studentInformationByIStudentInformationPk")
    public Collection<ExaminationResult> getExaminationResultsByIStudentInformationPk() {
        return examinationResultsByIStudentInformationPk;
    }

    public void setExaminationResultsByIStudentInformationPk(Collection<ExaminationResult> examinationResultsByIStudentInformationPk) {
        this.examinationResultsByIStudentInformationPk = examinationResultsByIStudentInformationPk;
    }

    @ManyToOne
    @JoinColumn(name = "i_faculty_information_pk", referencedColumnName = "i_faculty_information_pk")
    public FacultyInformation getFacultyInformationByIFacultyInformationPk() {
        return facultyInformationByIFacultyInformationPk;
    }

    public void setFacultyInformationByIFacultyInformationPk(FacultyInformation facultyInformationByIFacultyInformationPk) {
        this.facultyInformationByIFacultyInformationPk = facultyInformationByIFacultyInformationPk;
    }
}
