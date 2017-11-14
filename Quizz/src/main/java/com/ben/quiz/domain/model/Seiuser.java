package com.ben.quiz.domain.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Seiuser extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -8880566675546531788L;

    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    private String userId;
    private String password;
    private String topMenu;

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
        this.password = PASSWORD_ENCODER.encode(password);
    }

    @Basic
    @Column(name = "top_menu", nullable = true, length = 5)
    public String getTopMenu() {
        return topMenu;
    }

    public void setTopMenu(String topMenu) {
        this.topMenu = topMenu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seiuser Seiuser = (Seiuser) o;

        if (userId != null ? !userId.equals(Seiuser.userId) : Seiuser.userId != null) return false;
        if (password != null ? !password.equals(Seiuser.password) : Seiuser.password != null) return false;
        if (topMenu != null ? !topMenu.equals(Seiuser.topMenu) : Seiuser.topMenu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (topMenu != null ? topMenu.hashCode() : 0);
        return result;
    }
}
