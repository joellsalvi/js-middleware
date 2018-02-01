package br.com.middleware.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.middleware.model.process.Test;
import br.com.middleware.ws.api.commons.HttpResponseWrapper;
import br.com.middlewareservice.api.ITestService;
import br.com.middleware.ws.api.ITestController;
import br.com.middleware.ws.api.response.TestResponse;

/**
 * Created by joel on 31/01/18.
 */
@RestController
public class TestController implements ITestController {

    private ITestService testService;
    private ObjectMapper objectMapper;

    @Autowired
    public TestController(ITestService testService, ObjectMapper objectMapper) {
        this.testService = testService;
        this.objectMapper = objectMapper;
    }

    @Override
    public HttpResponseWrapper<TestResponse> testarController(Long key, @RequestBody Test test) {
        TestResponse testResponse = objectMapper.convertValue(testService.testar(key, test), TestResponse.class);
        return new HttpResponseWrapper(testResponse);
    }
}
