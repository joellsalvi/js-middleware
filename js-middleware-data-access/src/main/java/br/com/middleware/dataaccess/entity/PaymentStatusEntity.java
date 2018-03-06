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
@Table(name = "payment_status", catalog = "js-middleware")
public class PaymentStatusEntity {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "payment", nullable = false)
    private Long payment;

    @Column(name = "status", nullable = false, length = -1)
    private String status;

    @Column(name = "register_date", nullable = false)
    private Timestamp registerDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getPayment() {
        return payment;
    }

    public void setPayment(Long payment) {
        this.payment = payment;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentStatusEntity that = (PaymentStatusEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (payment != null ? !payment.equals(that.payment) : that.payment != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (registerDate != null ? !registerDate.equals(that.registerDate) : that.registerDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (payment != null ? payment.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (registerDate != null ? registerDate.hashCode() : 0);
        return result;
    }
}
