package com.ben.quiz.domain.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "examination_room", schema = "public", catalog = "quizsystem")
public class ExaminationRoom extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -2166181014264686934L;
    private int iExaminationRoomPk;
    private String strExaminationRoomName;
    private Integer iExaminationRoomPkEk;

    @Id
    @Column(name = "i_examination_room_pk", nullable = false)
    public int getiExaminationRoomPk() {
        return iExaminationRoomPk;
    }

    public void setiExaminationRoomPk(int iExaminationRoomPk) {
        this.iExaminationRoomPk = iExaminationRoomPk;
    }

    @Basic
    @Column(name = "str_examination_room_name", nullable = true, length = 100)
    public String getStrExaminationRoomName() {
        return strExaminationRoomName;
    }

    public void setStrExaminationRoomName(String strExaminationRoomName) {
        this.strExaminationRoomName = strExaminationRoomName;
    }

    @Basic
    @Column(name = "i_examination_room_pk_ek", nullable = true)
    public Integer getiExaminationRoomPkEk() {
        return iExaminationRoomPkEk;
    }

    public void setiExaminationRoomPkEk(Integer iExaminationRoomPkEk) {
        this.iExaminationRoomPkEk = iExaminationRoomPkEk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExaminationRoom that = (ExaminationRoom) o;

        if (iExaminationRoomPk != that.iExaminationRoomPk) return false;
        if (strExaminationRoomName != null ? !strExaminationRoomName.equals(that.strExaminationRoomName) : that.strExaminationRoomName != null)
            return false;
        if (iExaminationRoomPkEk != null ? !iExaminationRoomPkEk.equals(that.iExaminationRoomPkEk) : that.iExaminationRoomPkEk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iExaminationRoomPk;
        result = 31 * result + (strExaminationRoomName != null ? strExaminationRoomName.hashCode() : 0);
        result = 31 * result + (iExaminationRoomPkEk != null ? iExaminationRoomPkEk.hashCode() : 0);
        return result;
    }
}
