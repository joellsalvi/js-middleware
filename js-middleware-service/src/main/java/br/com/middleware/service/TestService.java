package br.com.middleware.service;

import br.com.middleware.dataaccess.entity.BankEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.middleware.integration.api.address.viacep.ApiViaCep;
import br.com.middleware.integration.api.address.widenet.ApiWideNet;
import br.com.middleware.dataaccess.repository.BankRepository;
import br.com.middleware.model.process.Test;
import br.com.middleware.model.to.AddressTO;
import br.com.middleware.model.to.TestTO;
import br.com.middleware.service.api.ITestService;
import br.com.middleware.service.mapper.AddressMapper;
import br.com.middleware.service.mapper.TestMapper;

import java.util.List;

/**
 * Created by joel on 31/01/18.
 */
@Service
@Transactional
public class TestService implements ITestService {

    private TestMapper testMapper;
    private AddressMapper addressMapper;
    private ApiWideNet apiWideNet;
    private ApiViaCep apiViaCep;
    private BankRepository bankRepository;

    @Autowired
    public TestService(TestMapper testMapper, AddressMapper addressMapper, ApiWideNet apiWideNet, ApiViaCep apiViaCep,
            BankRepository bankRepository) {
        this.testMapper = testMapper;
        this.addressMapper = addressMapper;
        this.apiWideNet = apiWideNet;
        this.apiViaCep = apiViaCep;
        this.bankRepository = bankRepository;
    }

    @Override
    public TestTO testWideNet(String cep, Test test) {
        bankRepository.findAll().forEach(b -> System.out.println(b.toString()));
        AddressTO addressTO = addressMapper.from(apiWideNet.getAddressByCep(cep));
        return testMapper.convertValue(test, addressTO);
    }

    @Override
    public TestTO testViaCep(String cep, Test test) {
        AddressTO addressTO = addressMapper.from(apiViaCep.getAddressByCep(cep));
        return testMapper.convertValue(test, addressTO);
    }

    @Override
    public AddressTO getAddress(String cep) {
        List<BankEntity> bankList = bankRepository.findAll();
        bankList.forEach(b -> System.out.println(b.toString()));


        return addressMapper.from(apiWideNet.getAddressByCep(cep));
    }

}
