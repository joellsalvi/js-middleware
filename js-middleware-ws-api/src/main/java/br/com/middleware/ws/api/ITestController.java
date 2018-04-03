package br.com.middleware.ws.api;

import br.com.middleware.model.process.Test;
import br.com.middleware.ws.api.commons.HttpResponseWrapper;
import br.com.middleware.ws.api.response.TestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by joel on 31/01/18.
 */
@RequestMapping("/test")
public interface ITestController {

    @RequestMapping(method = RequestMethod.POST, value = "/widenet/{cep}",
            consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    HttpResponseWrapper<TestResponse> testWideNet(@PathVariable("cep") String cep, @RequestBody Test test);

    @RequestMapping(method = RequestMethod.POST, value = "/viacep/{cep}",
            consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    HttpResponseWrapper<TestResponse> testViaCep(@PathVariable("cep") String cep, @RequestBody Test test);

    @RequestMapping(method = RequestMethod.GET, value = "/widenet/{cep}")
    @ResponseStatus(HttpStatus.OK)
    HttpResponseWrapper<TestResponse> getAddress(@PathVariable("cep") String cep);

}
