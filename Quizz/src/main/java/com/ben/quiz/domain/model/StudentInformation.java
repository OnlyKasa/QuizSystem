package com.ben.quiz.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "student_information", schema = "public", catalog = "quizsystem")
public class StudentInformation extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 978512725467939282L;
    private int iStudentInformationPk;
    private String iStudentInformationCode;
    private Integer iFacultyInformationPk;
    private String strStudentInformationFirstName;
    private String strStudentInformationLastName;
    private Date dtStudentInformationBirthday;
    private Integer iStudentInformationPkEk;
    private Collection<ExaminationInformationDetail> examinationInformationDetailsByIStudentInformationPk;
    private Collection<Seiuser> seiusersByIStudentInformationPk;
    private FacultyInformation facultyInformationByIFacultyInformationPk;
    private Collection<TestInformation> testInformationsByIStudentInformationPk;

    @Id
    @Column(name = "i_student_information_pk", nullable = false)
    public int getiStudentInformationPk() {
        return iStudentInformationPk;
    }

    public void setiStudentInformationPk(int iStudentInformationPk) {
        this.iStudentInformationPk = iStudentInformationPk;
    }

    @Basic
    @Column(name = "i_student_information_code", nullable = false, length = 50)
    public String getiStudentInformationCode() {
        return iStudentInformationCode;
    }

    public void setiStudentInformationCode(String iStudentInformationCode) {
        this.iStudentInformationCode = iStudentInformationCode;
    }

    @Basic
    @Column(name = "i_faculty_information_pk", nullable = true)
    public Integer getiFacultyInformationPk() {
        return iFacultyInformationPk;
    }

    public void setiFacultyInformationPk(Integer iFacultyInformationPk) {
        this.iFacultyInformationPk = iFacultyInformationPk;
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
        if (iStudentInformationCode != null ? !iStudentInformationCode.equals(that.iStudentInformationCode) : that.iStudentInformationCode != null)
            return false;
        if (iFacultyInformationPk != null ? !iFacultyInformationPk.equals(that.iFacultyInformationPk) : that.iFacultyInformationPk != null)
            return false;
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
        result = 31 * result + (iStudentInformationCode != null ? iStudentInformationCode.hashCode() : 0);
        result = 31 * result + (iFacultyInformationPk != null ? iFacultyInformationPk.hashCode() : 0);
        result = 31 * result + (strStudentInformationFirstName != null ? strStudentInformationFirstName.hashCode() : 0);
        result = 31 * result + (strStudentInformationLastName != null ? strStudentInformationLastName.hashCode() : 0);
        result = 31 * result + (dtStudentInformationBirthday != null ? dtStudentInformationBirthday.hashCode() : 0);
        result = 31 * result + (iStudentInformationPkEk != null ? iStudentInformationPkEk.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "studentInformationByIStudentInformationPk")
    public Collection<ExaminationInformationDetail> getExaminationInformationDetailsByIStudentInformationPk() {
        return examinationInformationDetailsByIStudentInformationPk;
    }

    public void setExaminationInformationDetailsByIStudentInformationPk(Collection<ExaminationInformationDetail> examinationInformationDetailsByIStudentInformationPk) {
        this.examinationInformationDetailsByIStudentInformationPk = examinationInformationDetailsByIStudentInformationPk;
    }

    @OneToMany(mappedBy = "studentInformationByIStudentInformationPk")
    public Collection<Seiuser> getSeiusersByIStudentInformationPk() {
        return seiusersByIStudentInformationPk;
    }

    public void setSeiusersByIStudentInformationPk(Collection<Seiuser> seiusersByIStudentInformationPk) {
        this.seiusersByIStudentInformationPk = seiusersByIStudentInformationPk;
    }

    @ManyToOne
    @JoinColumn(name = "i_faculty_information_pk", referencedColumnName = "i_faculty_information_pk",insertable = false ,updatable = false)
    public FacultyInformation getFacultyInformationByIFacultyInformationPk() {
        return facultyInformationByIFacultyInformationPk;
    }

    public void setFacultyInformationByIFacultyInformationPk(FacultyInformation facultyInformationByIFacultyInformationPk) {
        this.facultyInformationByIFacultyInformationPk = facultyInformationByIFacultyInformationPk;
    }

    @OneToMany(mappedBy = "studentInformationByIStudentInformationPk")
    public Collection<TestInformation> getTestInformationsByIStudentInformationPk() {
        return testInformationsByIStudentInformationPk;
    }

    public void setTestInformationsByIStudentInformationPk(Collection<TestInformation> testInformationsByIStudentInformationPk) {
        this.testInformationsByIStudentInformationPk = testInformationsByIStudentInformationPk;
    }
}
