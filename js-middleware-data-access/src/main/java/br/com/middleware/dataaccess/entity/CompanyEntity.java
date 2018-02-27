package br.com.middleware.dataaccess.entity;

import java.math.BigInteger;
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
@Table(name = "company", schema = "public", catalog = "js-middleware")
public class CompanyEntity {
    private String id;
    private String identification;
    private String identificationType;
    private String fantasyName;
    private String comercialName;
    private String businessSize;
    private Timestamp birthDate;
    private Timestamp registerDate;
    private Timestamp updateDate;
    private String companySector;
    private String customerId;
    private BigInteger nominalCapital;
    private String email;
    private String website;
    private Boolean isPrivate;
    private Boolean active;

    @Id
    @Column(name = "id", nullable = false, length = 255)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "identification", nullable = false, length = 100)
    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    @Basic
    @Column(name = "identification_type", nullable = false, length = 15)
    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    @Basic
    @Column(name = "fantasy_name", nullable = false, length = 100)
    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    @Basic
    @Column(name = "comercial_name", nullable = false, length = 100)
    public String getComercialName() {
        return comercialName;
    }

    public void setComercialName(String comercialName) {
        this.comercialName = comercialName;
    }

    @Basic
    @Column(name = "business_size", nullable = false, length = 100)
    public String getBusinessSize() {
        return businessSize;
    }

    public void setBusinessSize(String businessSize) {
        this.businessSize = businessSize;
    }

    @Basic
    @Column(name = "birth_date", nullable = false)
    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
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
    @Column(name = "update_date", nullable = true)
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    @Column(name = "company_sector", nullable = false, length = 100)
    public String getCompanySector() {
        return companySector;
    }

    public void setCompanySector(String companySector) {
        this.companySector = companySector;
    }

    @Basic
    @Column(name = "customer_id", nullable = false, length = 255)
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "nominal_capital", nullable = true, precision = 0)
    public BigInteger getNominalCapital() {
        return nominalCapital;
    }

    public void setNominalCapital(BigInteger nominalCapital) {
        this.nominalCapital = nominalCapital;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "website", nullable = false, length = 255)
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Basic
    @Column(name = "is_private", nullable = false)
    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    @Basic
    @Column(name = "active", nullable = false)
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompanyEntity that = (CompanyEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (identification != null ? !identification.equals(that.identification) : that.identification != null)
            return false;
        if (identificationType != null ? !identificationType.equals(that.identificationType) : that.identificationType != null)
            return false;
        if (fantasyName != null ? !fantasyName.equals(that.fantasyName) : that.fantasyName != null) return false;
        if (comercialName != null ? !comercialName.equals(that.comercialName) : that.comercialName != null)
            return false;
        if (businessSize != null ? !businessSize.equals(that.businessSize) : that.businessSize != null) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (registerDate != null ? !registerDate.equals(that.registerDate) : that.registerDate != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (companySector != null ? !companySector.equals(that.companySector) : that.companySector != null)
            return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (nominalCapital != null ? !nominalCapital.equals(that.nominalCapital) : that.nominalCapital != null)
            return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (website != null ? !website.equals(that.website) : that.website != null) return false;
        if (isPrivate != null ? !isPrivate.equals(that.isPrivate) : that.isPrivate != null) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (identification != null ? identification.hashCode() : 0);
        result = 31 * result + (identificationType != null ? identificationType.hashCode() : 0);
        result = 31 * result + (fantasyName != null ? fantasyName.hashCode() : 0);
        result = 31 * result + (comercialName != null ? comercialName.hashCode() : 0);
        result = 31 * result + (businessSize != null ? businessSize.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (registerDate != null ? registerDate.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (companySector != null ? companySector.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (nominalCapital != null ? nominalCapital.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (isPrivate != null ? isPrivate.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        return result;
    }
}
