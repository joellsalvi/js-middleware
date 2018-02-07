package br.com.middleware.api.address.widenet;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.middleware.api.address.response.AddressResponse;

/**
 * Created by zup134 on 05/02/18.
 */
@FeignClient("#{widenet-busca-cep-url}")
@Qualifier("ApiWideNet")
public interface ApiWideNet {

    @RequestMapping( method = RequestMethod.GET, value = "/{cep}.json")
    AddressResponse getAddressByCep(@PathVariable("cep") String cep);

}
