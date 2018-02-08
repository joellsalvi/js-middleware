package br.com.middleware.api.address.viacep;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.middleware.api.address.viacep.response.ViaCepAddressResponse;
import feign.RequestLine;

/**
 * Created by zup134 on 08/02/18.
 */
@FeignClient("${viacep-busca-cep-url}")
@Qualifier("ApiViaCep")
public interface ApiViaCep {

    @RequestLine("GET /{cep}/json/")
    ViaCepAddressResponse getAddress(@PathVariable("cep") String cep);

}
