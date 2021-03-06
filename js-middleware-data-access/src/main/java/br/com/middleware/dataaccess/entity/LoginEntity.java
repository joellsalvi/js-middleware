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
@Table(name = "login", catalog = "js-middleware")
public class LoginEntity {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "owner_id", nullable = false, length = 255)
    private String ownerId;

    @Column(name = "owner_type", nullable = false, length = -1)
    private String ownerType;

    @Column(name = "username", nullable = false, length = 100)
    private String username;

    @Column(name = "old_username", nullable = true, length = 100)
    private String oldUsername;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "old_password", nullable = true, length = 255)
    private String oldPassword;

    @Column(name = "register_date", nullable = false)
    private Timestamp registerDate;

    @Column(name = "update_date", nullable = true)
    private Timestamp updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOldUsername() {
        return oldUsername;
    }

    public void setOldUsername(String oldUsername) {
        this.oldUsername = oldUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginEntity that = (LoginEntity) o;

        if (ownerId != null ? !ownerId.equals(that.ownerId) : that.ownerId != null) return false;
        if (ownerType != null ? !ownerType.equals(that.ownerType) : that.ownerType != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (oldUsername != null ? !oldUsername.equals(that.oldUsername) : that.oldUsername != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (oldPassword != null ? !oldPassword.equals(that.oldPassword) : that.oldPassword != null) return false;
        if (registerDate != null ? !registerDate.equals(that.registerDate) : that.registerDate != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ownerId != null ? ownerId.hashCode() : 0;
        result = 31 * result + (ownerType != null ? ownerType.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (oldUsername != null ? oldUsername.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (oldPassword != null ? oldPassword.hashCode() : 0);
        result = 31 * result + (registerDate != null ? registerDate.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        return result;
    }
}
