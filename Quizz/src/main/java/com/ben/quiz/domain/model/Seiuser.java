package com.ben.quiz.domain.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Seiuser extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 4400480016892813146L;
    private String userId;
    private String password;
    private String topMenu;
    private Integer iStudentInformationPk;
    private Integer iTeacherInformationPk;
    private StudentInformation studentInformationByIStudentInformationPk;
    private TeacherInformation teacherInformationByITeacherInformationPk;

    @Id
    @Column(name = "user_id", nullable = false, length = 50)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "top_menu", nullable = true, length = 5)
    public String getTopMenu() {
        return topMenu;
    }

    public void setTopMenu(String topMenu) {
        this.topMenu = topMenu;
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
    @Column(name = "i_teacher_information_pk", nullable = true)
    public Integer getiTeacherInformationPk() {
        return iTeacherInformationPk;
    }

    public void setiTeacherInformationPk(Integer iTeacherInformationPk) {
        this.iTeacherInformationPk = iTeacherInformationPk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seiuser seiuser = (Seiuser) o;

        if (userId != null ? !userId.equals(seiuser.userId) : seiuser.userId != null) return false;
        if (password != null ? !password.equals(seiuser.password) : seiuser.password != null) return false;
        if (topMenu != null ? !topMenu.equals(seiuser.topMenu) : seiuser.topMenu != null) return false;
        if (iStudentInformationPk != null ? !iStudentInformationPk.equals(seiuser.iStudentInformationPk) : seiuser.iStudentInformationPk != null)
            return false;
        if (iTeacherInformationPk != null ? !iTeacherInformationPk.equals(seiuser.iTeacherInformationPk) : seiuser.iTeacherInformationPk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (topMenu != null ? topMenu.hashCode() : 0);
        result = 31 * result + (iStudentInformationPk != null ? iStudentInformationPk.hashCode() : 0);
        result = 31 * result + (iTeacherInformationPk != null ? iTeacherInformationPk.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "i_student_information_pk", referencedColumnName = "i_student_information_pk" ,insertable = false ,updatable = false)
    public StudentInformation getStudentInformationByIStudentInformationPk() {
        return studentInformationByIStudentInformationPk;
    }

    public void setStudentInformationByIStudentInformationPk(StudentInformation studentInformationByIStudentInformationPk) {
        this.studentInformationByIStudentInformationPk = studentInformationByIStudentInformationPk;
    }

    @ManyToOne
    @JoinColumn(name = "i_teacher_information_pk", referencedColumnName = "i_teacher_information_pk",insertable = false ,updatable = false)
    public TeacherInformation getTeacherInformationByITeacherInformationPk() {
        return teacherInformationByITeacherInformationPk;
    }

    public void setTeacherInformationByITeacherInformationPk(TeacherInformation teacherInformationByITeacherInformationPk) {
        this.teacherInformationByITeacherInformationPk = teacherInformationByITeacherInformationPk;
    }
}
