package br.com.middleware.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.middleware.model.process.Test;
import br.com.middleware.ws.mapper.TestTOMapper;
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
    private TestTOMapper testTOMapper;

    @Autowired
    public TestController(ITestService testService, TestTOMapper testTOMapper) {
        this.testService = testService;
        this.testTOMapper = testTOMapper;
    }

    @Override
    public HttpResponseWrapper<TestResponse> testarController(String cep, @RequestBody Test test) {
        TestResponse testResponse = testTOMapper.convertValue(testService.testar(cep, test));
        return new HttpResponseWrapper(testResponse);
    }
}
