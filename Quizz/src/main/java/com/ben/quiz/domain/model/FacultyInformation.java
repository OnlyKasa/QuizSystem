package com.ben.quiz.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "faculty_information", schema = "public", catalog = "quizsystem")
public class FacultyInformation extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -4668360173111055052L;
    private int iFacultyInformationPk;
    private String strFacultyInformationShortName;
    private String strFacultyInformationFullName;
    private Integer iFacultyInformationPkEk;
    private Collection<StudentInformation> studentInformationsByIFacultyInformationPk;
    private Collection<TeacherInformation> teacherInformationsByIFacultyInformationPk;

    @Id
    @Column(name = "i_faculty_information_pk", nullable = false)
    public int getiFacultyInformationPk() {
        return iFacultyInformationPk;
    }

    public void setiFacultyInformationPk(int iFacultyInformationPk) {
        this.iFacultyInformationPk = iFacultyInformationPk;
    }

    @Basic
    @Column(name = "str_faculty_information_short_name", nullable = true, length = 10)
    public String getStrFacultyInformationShortName() {
        return strFacultyInformationShortName;
    }

    public void setStrFacultyInformationShortName(String strFacultyInformationShortName) {
        this.strFacultyInformationShortName = strFacultyInformationShortName;
    }

    @Basic
    @Column(name = "str_faculty_information_full_name", nullable = true, length = 100)
    public String getStrFacultyInformationFullName() {
        return strFacultyInformationFullName;
    }

    public void setStrFacultyInformationFullName(String strFacultyInformationFullName) {
        this.strFacultyInformationFullName = strFacultyInformationFullName;
    }

    @Basic
    @Column(name = "i_faculty_information_pk_ek", nullable = true)
    public Integer getiFacultyInformationPkEk() {
        return iFacultyInformationPkEk;
    }

    public void setiFacultyInformationPkEk(Integer iFacultyInformationPkEk) {
        this.iFacultyInformationPkEk = iFacultyInformationPkEk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FacultyInformation that = (FacultyInformation) o;

        if (iFacultyInformationPk != that.iFacultyInformationPk) return false;
        if (strFacultyInformationShortName != null ? !strFacultyInformationShortName.equals(that.strFacultyInformationShortName) : that.strFacultyInformationShortName != null)
            return false;
        if (strFacultyInformationFullName != null ? !strFacultyInformationFullName.equals(that.strFacultyInformationFullName) : that.strFacultyInformationFullName != null)
            return false;
        if (iFacultyInformationPkEk != null ? !iFacultyInformationPkEk.equals(that.iFacultyInformationPkEk) : that.iFacultyInformationPkEk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iFacultyInformationPk;
        result = 31 * result + (strFacultyInformationShortName != null ? strFacultyInformationShortName.hashCode() : 0);
        result = 31 * result + (strFacultyInformationFullName != null ? strFacultyInformationFullName.hashCode() : 0);
        result = 31 * result + (iFacultyInformationPkEk != null ? iFacultyInformationPkEk.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "facultyInformationByIFacultyInformationPk")
    public Collection<StudentInformation> getStudentInformationsByIFacultyInformationPk() {
        return studentInformationsByIFacultyInformationPk;
    }

    public void setStudentInformationsByIFacultyInformationPk(Collection<StudentInformation> studentInformationsByIFacultyInformationPk) {
        this.studentInformationsByIFacultyInformationPk = studentInformationsByIFacultyInformationPk;
    }

    @OneToMany(mappedBy = "facultyInformationByIFacultyInformationPk")
    public Collection<TeacherInformation> getTeacherInformationsByIFacultyInformationPk() {
        return teacherInformationsByIFacultyInformationPk;
    }

    public void setTeacherInformationsByIFacultyInformationPk(Collection<TeacherInformation> teacherInformationsByIFacultyInformationPk) {
        this.teacherInformationsByIFacultyInformationPk = teacherInformationsByIFacultyInformationPk;
    }
}
