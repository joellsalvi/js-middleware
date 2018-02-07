package br.com.middleware.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.middleware.api.address.widenet.ApiWideNet;
import br.com.middleware.mapper.AddressMapper;
import br.com.middleware.mapper.TestMapper;
import br.com.middleware.model.process.Test;
import br.com.middleware.model.to.AddressTO;
import br.com.middleware.model.to.TestTO;
import br.com.middlewareservice.api.ITestService;

/**
 * Created by joel on 31/01/18.
 */
@Service
public class TestService implements ITestService {

    @Autowired
    private TestMapper testMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private ApiWideNet apiWideNet;

    public TestTO testar(String cep, Test test) {
        AddressTO addressTO = addressMapper.from(apiWideNet.getAddressByCep(cep));
        return testMapper.convertValue(test, addressTO);
    }

}
