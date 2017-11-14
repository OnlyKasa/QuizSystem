package com.ben.quiz.domain.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "teacher_information", schema = "public", catalog = "quizsystem")
public class TeacherInformation extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -2232639122558709739L;
    private int iTeacherInformationPk;
    private String strTeacherInformationFirstName;
    private String strTeacherInformationLastName;
    private Boolean bTeacherInformationGender;
    private String strTeacherInformationPhone;
    private Integer iTeacherInformationPkEk;
    private FacultyInformation facultyInformationByIFacultyInformationPk;

    @Id
    @Column(name = "i_teacher_information_pk", nullable = false)
    public int getiTeacherInformationPk() {
        return iTeacherInformationPk;
    }

    public void setiTeacherInformationPk(int iTeacherInformationPk) {
        this.iTeacherInformationPk = iTeacherInformationPk;
    }

    @Basic
    @Column(name = "str_teacher_information_first_name", nullable = true, length = 30)
    public String getStrTeacherInformationFirstName() {
        return strTeacherInformationFirstName;
    }

    public void setStrTeacherInformationFirstName(String strTeacherInformationFirstName) {
        this.strTeacherInformationFirstName = strTeacherInformationFirstName;
    }

    @Basic
    @Column(name = "str_teacher_information_last_name", nullable = true, length = 30)
    public String getStrTeacherInformationLastName() {
        return strTeacherInformationLastName;
    }

    public void setStrTeacherInformationLastName(String strTeacherInformationLastName) {
        this.strTeacherInformationLastName = strTeacherInformationLastName;
    }

    @Basic
    @Column(name = "b_teacher_information_gender", nullable = true)
    public Boolean getbTeacherInformationGender() {
        return bTeacherInformationGender;
    }

    public void setbTeacherInformationGender(Boolean bTeacherInformationGender) {
        this.bTeacherInformationGender = bTeacherInformationGender;
    }

    @Basic
    @Column(name = "str_teacher_information_phone", nullable = true, length = 15)
    public String getStrTeacherInformationPhone() {
        return strTeacherInformationPhone;
    }

    public void setStrTeacherInformationPhone(String strTeacherInformationPhone) {
        this.strTeacherInformationPhone = strTeacherInformationPhone;
    }

    @Basic
    @Column(name = "i_teacher_information_pk_ek", nullable = true)
    public Integer getiTeacherInformationPkEk() {
        return iTeacherInformationPkEk;
    }

    public void setiTeacherInformationPkEk(Integer iTeacherInformationPkEk) {
        this.iTeacherInformationPkEk = iTeacherInformationPkEk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherInformation that = (TeacherInformation) o;

        if (iTeacherInformationPk != that.iTeacherInformationPk) return false;
        if (strTeacherInformationFirstName != null ? !strTeacherInformationFirstName.equals(that.strTeacherInformationFirstName) : that.strTeacherInformationFirstName != null)
            return false;
        if (strTeacherInformationLastName != null ? !strTeacherInformationLastName.equals(that.strTeacherInformationLastName) : that.strTeacherInformationLastName != null)
            return false;
        if (bTeacherInformationGender != null ? !bTeacherInformationGender.equals(that.bTeacherInformationGender) : that.bTeacherInformationGender != null)
            return false;
        if (strTeacherInformationPhone != null ? !strTeacherInformationPhone.equals(that.strTeacherInformationPhone) : that.strTeacherInformationPhone != null)
            return false;
        if (iTeacherInformationPkEk != null ? !iTeacherInformationPkEk.equals(that.iTeacherInformationPkEk) : that.iTeacherInformationPkEk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iTeacherInformationPk;
        result = 31 * result + (strTeacherInformationFirstName != null ? strTeacherInformationFirstName.hashCode() : 0);
        result = 31 * result + (strTeacherInformationLastName != null ? strTeacherInformationLastName.hashCode() : 0);
        result = 31 * result + (bTeacherInformationGender != null ? bTeacherInformationGender.hashCode() : 0);
        result = 31 * result + (strTeacherInformationPhone != null ? strTeacherInformationPhone.hashCode() : 0);
        result = 31 * result + (iTeacherInformationPkEk != null ? iTeacherInformationPkEk.hashCode() : 0);
        return result;
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
