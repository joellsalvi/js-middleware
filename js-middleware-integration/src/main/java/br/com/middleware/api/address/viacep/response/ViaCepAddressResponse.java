package br.com.middleware.api.address.viacep.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by zup134 on 08/02/18.
 */
public class ViaCepAddressResponse {

    @JsonProperty("cep")
    private String code;

    @JsonProperty("logradouro")
    private String address;

    @JsonProperty("complemento")
    private String complement;

    @JsonProperty("bairro")
    private String district;

    @JsonProperty("localidade")
    private String city;

    @JsonProperty("uf")
    private String state;

    private String unidade;
    private String ibge;
    private String gia;

    public ViaCepAddressResponse(){}

    public ViaCepAddressResponse(String code, String address, String complement, String district, String city,
            String state, String unidade, String ibge, String gia) {
        this.code = code;
        this.address = address;
        this.complement = complement;
        this.district = district;
        this.city = city;
        this.state = state;
        this.unidade = unidade;
        this.ibge = ibge;
        this.gia = gia;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}
