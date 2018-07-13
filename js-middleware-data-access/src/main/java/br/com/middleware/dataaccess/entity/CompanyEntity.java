package br.com.middleware.dataaccess.entity;

import java.math.BigInteger;
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
@Table(name = "company", catalog = "js-middleware")
public class CompanyEntity {

    @Id
    @Column(name = "id", nullable = false, length = 255)
    private String id;

    @Column(name = "identification", nullable = false, length = 100)
    private String identification;

    @Column(name = "identification_type", nullable = false, length = 15)
    private String identificationType;

    @Column(name = "fantasy_name", nullable = false, length = 100)
    private String fantasyName;

    @Column(name = "comercial_name", nullable = false, length = 100)
    private String comercialName;

    @Column(name = "business_size", nullable = false, length = 100)
    private String businessSize;

    @Column(name = "birth_date", nullable = false)
    private Timestamp birthDate;

    @Column(name = "register_date", nullable = false)
    private Timestamp registerDate;

    @Column(name = "update_date", nullable = true)
    private Timestamp updateDate;

    @Column(name = "company_sector", nullable = false, length = 100)
    private String companySector;

    @Column(name = "customer_id", nullable = false, length = 255)
    private String customerId;

    @Column(name = "nominal_capital", nullable = true, precision = 0)
    private BigInteger nominalCapital;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "website", nullable = false, length = 255)
    private String website;

    @Column(name = "is_private", nullable = false)
    private Boolean isPrivate;

    @Column(name = "active", nullable = false)
    private Boolean active;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public String getComercialName() {
        return comercialName;
    }

    public void setComercialName(String comercialName) {
        this.comercialName = comercialName;
    }

    public String getBusinessSize() {
        return businessSize;
    }

    public void setBusinessSize(String businessSize) {
        this.businessSize = businessSize;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
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

    public String getCompanySector() {
        return companySector;
    }

    public void setCompanySector(String companySector) {
        this.companySector = companySector;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public BigInteger getNominalCapital() {
        return nominalCapital;
    }

    public void setNominalCapital(BigInteger nominalCapital) {
        this.nominalCapital = nominalCapital;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

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
