/*******************************************************************************
 * •Copyright 2017
 ******************************************************************************/
package com.ben.quiz.domain.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)

public class SForgotPassword extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -2345736488126402967L;
    private String loginID;
    private String email;

    public void clear() {
        loginID = null;
        email = null;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
