package br.com.middleware.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.middleware.api.address.viacep.ApiViaCep;
import br.com.middleware.api.address.widenet.ApiWideNet;
import br.com.middleware.service.mapper.AddressMapper;
import br.com.middleware.service.mapper.TestMapper;
import br.com.middleware.model.process.Test;
import br.com.middleware.model.to.AddressTO;
import br.com.middleware.model.to.TestTO;
import br.com.middleware.service.api.ITestService;

/**
 * Created by joel on 31/01/18.
 */
@Transactional
public class TestService implements ITestService {

    private TestMapper testMapper;
    private AddressMapper addressMapper;
    private ApiWideNet apiWideNet;
    private ApiViaCep apiViaCep;

    @Autowired
    public TestService(TestMapper testMapper, AddressMapper addressMapper, ApiWideNet apiWideNet, ApiViaCep apiViaCep) {
        this.testMapper = testMapper;
        this.addressMapper = addressMapper;
        this.apiWideNet = apiWideNet;
        this.apiViaCep = apiViaCep;
    }

    public TestTO testWideNet(String cep, Test test) {
        AddressTO addressTO = addressMapper.from(apiWideNet.getAddressByCep(cep));
        return testMapper.convertValue(test, addressTO);
    }

    public TestTO testViaCep(String cep, Test test) {
        AddressTO addressTO = addressMapper.from(apiViaCep.getAddressByCep(cep));
        return testMapper.convertValue(test, addressTO);
    }

}
