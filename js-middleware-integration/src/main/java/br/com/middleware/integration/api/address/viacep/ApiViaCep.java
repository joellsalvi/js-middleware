package br.com.middleware.integration.api.address.viacep;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.middleware.integration.api.address.viacep.response.ViaCepAddressResponse;
import feign.Param;
import feign.RequestLine;

/**
 * Created by Joel on 08/02/18.
 */
@FeignClient("${viacep-busca-cep-url}")
@Qualifier("ApiViaCep")
public interface ApiViaCep {

    @RequestLine("GET /{cep}/json/")
    ViaCepAddressResponse getAddressByCep(@Param("cep") String cep);

}
