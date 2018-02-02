package br.com.middleware.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.middleware.mapper.TestMapper;
import br.com.middleware.model.process.Test;
import br.com.middleware.model.to.TestTO;
import br.com.middlewareservice.api.ITestService;

/**
 * Created by joel on 31/01/18.
 */
@Service
public class TestService implements ITestService {

    @Autowired
    private TestMapper testMapper;

    public TestTO testar(Long id, Test test) {
        return testMapper.convertValue(test);
    }

}
