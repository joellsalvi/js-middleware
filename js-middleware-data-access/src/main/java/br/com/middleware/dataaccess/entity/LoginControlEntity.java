package br.com.middleware.dataaccess.entity;

import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Joel on 27/02/18.
 */
@Entity
@Table(name = "login_control", catalog = "js-middleware")
public class LoginControlEntity {

    @Id
    @Column(name = "id_login", nullable = false)
    private Integer idLogin;

    @Column(name = "username", nullable = false, length = 100)
    private String username;

    @Column(name = "attempts", nullable = true)
    private Short attempts;

    @Column(name = "last_try_date", nullable = true)
    private Timestamp lastTryDate;

    public Integer getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Integer idLogin) {
        this.idLogin = idLogin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Short getAttempts() {
        return attempts;
    }

    public void setAttempts(Short attempts) {
        this.attempts = attempts;
    }

    public Timestamp getLastTryDate() {
        return lastTryDate;
    }

    public void setLastTryDate(Timestamp lastTryDate) {
        this.lastTryDate = lastTryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginControlEntity that = (LoginControlEntity) o;

        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (attempts != null ? !attempts.equals(that.attempts) : that.attempts != null) return false;
        if (lastTryDate != null ? !lastTryDate.equals(that.lastTryDate) : that.lastTryDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (attempts != null ? attempts.hashCode() : 0);
        result = 31 * result + (lastTryDate != null ? lastTryDate.hashCode() : 0);
        return result;
    }
}
