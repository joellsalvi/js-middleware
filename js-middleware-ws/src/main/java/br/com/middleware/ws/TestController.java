package br.com.middleware.ws;

import br.com.middleware.model.process.Test;
import br.com.middleware.service.api.ITestService;
import br.com.middleware.ws.api.ITestController;
import br.com.middleware.ws.api.commons.HttpResponseWrapper;
import br.com.middleware.ws.api.response.TestResponse;
import br.com.middleware.ws.mapper.AddressTOMapper;
import br.com.middleware.ws.mapper.TestTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by joel on 31/01/18.
 */
@RestController
public class TestController implements ITestController {

    private TestTOMapper testTOMapper;
    private ITestService testService;
    private AddressTOMapper addressTOMapper;

    @Autowired
    public TestController(TestTOMapper testTOMapper, ITestService testService, AddressTOMapper addressTOMapper) {
        this.testTOMapper = testTOMapper;
        this.testService = testService;
        this.addressTOMapper = addressTOMapper;
    }

    @Override
    public HttpResponseWrapper<TestResponse> testWideNet(String cep, @RequestBody Test test) {
        TestResponse testResponse = testTOMapper.convertValue(testService.testWideNet(cep, test));
        return new HttpResponseWrapper(testResponse);
    }

    @Override
    public HttpResponseWrapper<TestResponse> testViaCep(String cep, @RequestBody Test test) {
        TestResponse testResponse = testTOMapper.convertValue(testService.testViaCep(cep, test));
        return new HttpResponseWrapper(testResponse);
    }

    @Override
    public HttpResponseWrapper<TestResponse> getAddress(String cep) {
//        AddressResponse address = addressTOMapper.fromTO(testService.getAddress(cep));
//        List<BankEntity> address = testService.getAddress(cep);


//        return new HttpResponseWrapper(address);
        return null;
    }

}
