package br.com.middleware.dataaccess.entity;

import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by zup134 on 27/02/18.
 */
@Entity
@Table(name = "card", schema = "public", catalog = "js-middleware")
public class CardEntity {
    private Integer id;
    private String number;
    private Timestamp validity;
    private String name;
    private String brand;
    private String agency;
    private String agencyDigit;
    private String account;
    private String accountDigit;
    private Long bankId;
    private Long cvv;
    private String function;
    private String status;
    private Timestamp registerDate;
    private Timestamp updateDate;
    private String ownerId;
    private String ownerType;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 45)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "validity", nullable = false)
    public Timestamp getValidity() {
        return validity;
    }

    public void setValidity(Timestamp validity) {
        this.validity = validity;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "brand", nullable = false, length = 45)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "agency", nullable = false, length = 20)
    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    @Basic
    @Column(name = "agency_digit", nullable = true, length = -1)
    public String getAgencyDigit() {
        return agencyDigit;
    }

    public void setAgencyDigit(String agencyDigit) {
        this.agencyDigit = agencyDigit;
    }

    @Basic
    @Column(name = "account", nullable = false, length = 20)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Basic
    @Column(name = "account_digit", nullable = true, length = -1)
    public String getAccountDigit() {
        return accountDigit;
    }

    public void setAccountDigit(String accountDigit) {
        this.accountDigit = accountDigit;
    }

    @Basic
    @Column(name = "bank_id", nullable = false)
    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    @Basic
    @Column(name = "cvv", nullable = true)
    public Long getCvv() {
        return cvv;
    }

    public void setCvv(Long cvv) {
        this.cvv = cvv;
    }

    @Basic
    @Column(name = "function", nullable = false, length = -1)
    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Basic
    @Column(name = "status", nullable = false, length = -1)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "register_date", nullable = false)
    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    @Basic
    @Column(name = "update_date", nullable = false)
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    @Column(name = "owner_id", nullable = false, length = 255)
    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @Basic
    @Column(name = "owner_type", nullable = false, length = -1)
    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardEntity that = (CardEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (validity != null ? !validity.equals(that.validity) : that.validity != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (brand != null ? !brand.equals(that.brand) : that.brand != null) return false;
        if (agency != null ? !agency.equals(that.agency) : that.agency != null) return false;
        if (agencyDigit != null ? !agencyDigit.equals(that.agencyDigit) : that.agencyDigit != null) return false;
        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        if (accountDigit != null ? !accountDigit.equals(that.accountDigit) : that.accountDigit != null) return false;
        if (bankId != null ? !bankId.equals(that.bankId) : that.bankId != null) return false;
        if (cvv != null ? !cvv.equals(that.cvv) : that.cvv != null) return false;
        if (function != null ? !function.equals(that.function) : that.function != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (registerDate != null ? !registerDate.equals(that.registerDate) : that.registerDate != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (ownerId != null ? !ownerId.equals(that.ownerId) : that.ownerId != null) return false;
        if (ownerType != null ? !ownerType.equals(that.ownerType) : that.ownerType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (validity != null ? validity.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (agency != null ? agency.hashCode() : 0);
        result = 31 * result + (agencyDigit != null ? agencyDigit.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (accountDigit != null ? accountDigit.hashCode() : 0);
        result = 31 * result + (bankId != null ? bankId.hashCode() : 0);
        result = 31 * result + (cvv != null ? cvv.hashCode() : 0);
        result = 31 * result + (function != null ? function.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (registerDate != null ? registerDate.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
        result = 31 * result + (ownerType != null ? ownerType.hashCode() : 0);
        return result;
    }
}
