package br.com.middleware.api.address.widenet;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.netflix.feign.FeignClient;

import br.com.middleware.api.address.widenet.response.WideNetAddressResponse;
import feign.RequestLine;

/**
 * Created by zup134 on 05/02/18.
 */
@FeignClient("${widenet-busca-cep-url}")
@Qualifier("ApiWideNet")
public interface ApiWideNet {

//    @RequestLine("GET /{cep}.json")
//    WideNetAddressResponse getAddressByCep(@PathVariable("cep") String cep);
    @RequestLine("GET /38406-580.json")
    WideNetAddressResponse getAddressByCep(String cep);

}
