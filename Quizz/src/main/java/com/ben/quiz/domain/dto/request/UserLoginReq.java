package com.ben.quiz.domain.dto.request;


import javax.validation.constraints.NotNull;
public class UserLoginReq {

    @NotNull
    private String userid;

    @NotNull
    private String password;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

