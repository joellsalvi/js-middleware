package br.com.middleware.api.address.widenet;

import br.com.middleware.api.address.response.AddressResponse;
import feign.RequestLine;

/**
 * Created by zup134 on 05/02/18.
 */
public interface ApiWideNet {

    @RequestLine("GET /{cep}.json")
    AddressResponse getAddressByCep(String cep);

}
