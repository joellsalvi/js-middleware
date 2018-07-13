package br.com.middleware.integration.api.address.widenet.response;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Joel on 05/02/18.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WideNetAddressResponse {

    private String status;
    private String code;
    private String state;
    private String city;
    private String district;
    private String address;

    public WideNetAddressResponse(){}

    public WideNetAddressResponse(String status, String code, String state, String city, String district, String address) {
        this.status = status;
        this.code = code;
        this.state = state;
        this.city = city;
        this.district = district;
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
