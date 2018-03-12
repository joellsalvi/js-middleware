package br.com.middleware.ws.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.middleware.model.process.Test;
import br.com.middleware.ws.api.commons.HttpResponseWrapper;
import br.com.middleware.ws.api.response.TestResponse;

import java.util.Map;

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

    @RequestMapping("/hello")
    String hello(Map<String, Object> model);

}
