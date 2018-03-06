package br.com.middleware.dataaccess.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by zup134 on 27/02/18.
 */
@Entity
@Table(name = "card", catalog = "js-middleware")
public class CardEntity {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "number", nullable = false, length = 45)
    private String number;

    @Column(name = "validity", nullable = false)
    private Timestamp validity;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "brand", nullable = false, length = 45)
    private String brand;

    @Column(name = "agency", nullable = false, length = 20)
    private String agency;

    @Column(name = "agency_digit", nullable = true, length = -1)
    private String agencyDigit;

    @Column(name = "account", nullable = false, length = 20)
    private String account;

    @Column(name = "account_digit", nullable = true, length = -1)
    private String accountDigit;

    @ManyToOne
    @JoinColumn(name = "bank_id", nullable = false)
    private BankEntity bank;

    @Column(name = "cvv", nullable = true)
    private Long cvv;

    @Column(name = "function", nullable = false, length = -1)
    private String function;

    @Column(name = "status", nullable = false, length = -1)
    private String status;

    @Column(name = "register_date", nullable = false)
    private Timestamp registerDate;

    @Column(name = "update_date", nullable = false)
    private Timestamp updateDate;

    @Column(name = "owner_id", nullable = false, length = 255)
    private String ownerId;

    @Column(name = "owner_type", nullable = false, length = -1)
    private String ownerType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Timestamp getValidity() {
        return validity;
    }

    public void setValidity(Timestamp validity) {
        this.validity = validity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAgencyDigit() {
        return agencyDigit;
    }

    public void setAgencyDigit(String agencyDigit) {
        this.agencyDigit = agencyDigit;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccountDigit() {
        return accountDigit;
    }

    public void setAccountDigit(String accountDigit) {
        this.accountDigit = accountDigit;
    }

    public BankEntity getBank() {
        return bank;
    }

    public void setBank(BankEntity bank) {
        this.bank = bank;
    }

    public Long getCvv() {
        return cvv;
    }

    public void setCvv(Long cvv) {
        this.cvv = cvv;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        if (bank != null ? !bank.equals(that.bank) : that.bank != null) return false;
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
        result = 31 * result + (bank != null ? bank.hashCode() : 0);
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
