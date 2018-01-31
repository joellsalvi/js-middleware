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

/**
 * Created by joel on 31/01/18.
 */
@RequestMapping("/test")
public interface ITestController {

    @RequestMapping(method = RequestMethod.POST, value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    HttpResponseWrapper<TestResponse> testarController(@PathVariable("id") Long id, @RequestBody Test test);

}
