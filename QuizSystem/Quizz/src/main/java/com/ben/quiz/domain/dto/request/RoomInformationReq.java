package com.ben.quiz.domain.dto.request;

public class RoomInformationReq {

    private int iExaminationRoomPk;
    private String strExaminationRoomName;
    private Integer iExaminationRoomPkEk;



    public int getiExaminationRoomPk() {
        return iExaminationRoomPk;
    }

    public void setiExaminationRoomPk(int iExaminationRoomPk) {
        this.iExaminationRoomPk = iExaminationRoomPk;
    }

    public String getStrExaminationRoomName() {
        return strExaminationRoomName;
    }

    public void setStrExaminationRoomName(String strExaminationRoomName) {
        this.strExaminationRoomName = strExaminationRoomName;
    }

    public Integer getiExaminationRoomPkEk() {
        return iExaminationRoomPkEk;
    }

    public void setiExaminationRoomPkEk(Integer iExaminationRoomPkEk) {
        this.iExaminationRoomPkEk = iExaminationRoomPkEk;
    }
}
