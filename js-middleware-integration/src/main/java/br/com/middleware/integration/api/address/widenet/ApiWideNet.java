package br.com.middleware.integration.api.address.widenet;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.netflix.feign.FeignClient;

import br.com.middleware.integration.api.address.widenet.response.WideNetAddressResponse;
import feign.Param;
import feign.RequestLine;

/**
 * Created by Joel on 05/02/18.
 */
@FeignClient("${widenet-busca-cep-url}")
@Qualifier("ApiWideNet")
public interface ApiWideNet {

    @RequestLine("GET /{cep}.json")
    WideNetAddressResponse getAddressByCep(@Param("cep") String cep);

}
