package br.com.middleware.dataaccess.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Joel on 27/02/18.
 */
@Entity
@Table(name = "payment", catalog = "js-middleware")
public class PaymentEntity {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "token", nullable = false, length = 255)
    private String token;

    @Column(name = "qr_code", nullable = true)
    private byte[] qrCode;

    @Column(name = "price", nullable = false, precision = 0)
    private BigInteger price;

    @Column(name = "currency_iso_code", nullable = false, length = 5)
    private String currencyIsoCode;

    @Column(name = "description", nullable = true, length = 45)
    private String description;

    @Column(name = "payment_date", nullable = false)
    private Timestamp paymentDate;

    @Column(name = "status", nullable = false)
    private Long status;

    @Column(name = "register_date", nullable = false)
    private Timestamp registerDate;

    @Column(name = "update_date", nullable = true)
    private Timestamp updateDate;

    @Column(name = "expiration_date", nullable = true)
    private Timestamp expirationDate;

    @Column(name = "owner_id", nullable = false, length = 255)
    private String ownerId;

    @Column(name = "owner_type", nullable = false, length = -1)
    private String ownerType;

    @Column(name = "payer_id", nullable = true, length = 255)
    private String payerId;

    @Column(name = "payer_type", nullable = true, length = -1)
    private String payerType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public byte[] getQrCode() {
        return qrCode;
    }

    public void setQrCode(byte[] qrCode) {
        this.qrCode = qrCode;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public String getCurrencyIsoCode() {
        return currencyIsoCode;
    }

    public void setCurrencyIsoCode(String currencyIsoCode) {
        this.currencyIsoCode = currencyIsoCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
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

    public Timestamp getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Timestamp expirationDate) {
        this.expirationDate = expirationDate;
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

    public String getPayerId() {
        return payerId;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    public String getPayerType() {
        return payerType;
    }

    public void setPayerType(String payerType) {
        this.payerType = payerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentEntity that = (PaymentEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;
        if (!Arrays.equals(qrCode, that.qrCode)) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (currencyIsoCode != null ? !currencyIsoCode.equals(that.currencyIsoCode) : that.currencyIsoCode != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (paymentDate != null ? !paymentDate.equals(that.paymentDate) : that.paymentDate != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (registerDate != null ? !registerDate.equals(that.registerDate) : that.registerDate != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (expirationDate != null ? !expirationDate.equals(that.expirationDate) : that.expirationDate != null)
            return false;
        if (ownerId != null ? !ownerId.equals(that.ownerId) : that.ownerId != null) return false;
        if (ownerType != null ? !ownerType.equals(that.ownerType) : that.ownerType != null) return false;
        if (payerId != null ? !payerId.equals(that.payerId) : that.payerId != null) return false;
        if (payerType != null ? !payerType.equals(that.payerType) : that.payerType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(qrCode);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (currencyIsoCode != null ? currencyIsoCode.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (paymentDate != null ? paymentDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (registerDate != null ? registerDate.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (expirationDate != null ? expirationDate.hashCode() : 0);
        result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
        result = 31 * result + (ownerType != null ? ownerType.hashCode() : 0);
        result = 31 * result + (payerId != null ? payerId.hashCode() : 0);
        result = 31 * result + (payerType != null ? payerType.hashCode() : 0);
        return result;
    }
}
