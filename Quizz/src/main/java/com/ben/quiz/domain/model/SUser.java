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
/**
 * User Session
 *
 * @author QuangNV
 *
 */
public class SUser extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -4825071876591193746L;
    /**
     *
     */
    private String strUsername;
    private boolean asTeacher;
    private boolean asStudent;
    private boolean asAdministrator;
    private String strFullName;
    private String strPasswordHash;
    private Long dtTosConfirm;
    private String strTopMenu;

    public String getStrTopMenu() {
        return strTopMenu;
    }

    public void setStrTopMenu(String strTopMenu) {
        this.strTopMenu = strTopMenu;
    }

    public void clear() {
        strUsername = null;
        strFullName = null;
        asStudent= false;
        asTeacher=false;
        asAdministrator = false;
        strPasswordHash = null;
        dtTosConfirm = null;
        strTopMenu = null;
    }

    /**
     * @return the strPasswordHash
     */
    public String getstrPasswordHash() {
        return strPasswordHash;
    }

    /**
     * @param strPasswordHash the strPasswordHash to set
     */
    public void setsPasswordHash(String strPasswordHash) {
        this.strPasswordHash = strPasswordHash;
    }

    /**
     * @return the strUsername
     */
    public String getStrUsername() {
        return strUsername;
    }

    /**
     * @param strUsername the strUsername to set
     */
    public void setStrUsername(String strUsername) {
        this.strUsername = strUsername;
    }

    public boolean isAsTeacher() {
        return asTeacher;
    }

    public void setAsTeacher(boolean asTeacher) {
        this.asTeacher = asTeacher;
    }

    public boolean isAsStudent() {
        return asStudent;
    }

    public void setAsStudent(boolean asStudent) {
        this.asStudent = asStudent;
    }

    /**
     * @return the strFullName
     */
    public String getStrFullName() {
        return strFullName;
    }

    /**
     * @param strFullName the strFullName to set
     */
    public void setStrFullName(String strFullName) {
        this.strFullName = strFullName;
    }

    public String getStrPasswordHash() {
        return strPasswordHash;
    }

    public void setStrPasswordHash(String strPasswordHash) {
        this.strPasswordHash = strPasswordHash;
    }

    public Long getDtTosConfirm() {
        return dtTosConfirm;
    }

    public void setDtTosConfirm(Long dtTosConfirm) {
        this.dtTosConfirm = dtTosConfirm;
    }

    public boolean isAsAdministrator() {
        return asAdministrator;
    }

    public void setAsAdministrator(boolean asAdministrator) {
        this.asAdministrator = asAdministrator;
    }
}
