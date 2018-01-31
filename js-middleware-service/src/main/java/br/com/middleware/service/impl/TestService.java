package br.com.middleware.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.middleware.model.process.Test;
import br.com.middleware.model.to.TestTO;
import br.com.middlewareservice.api.ITestService;

/**
 * Created by joel on 31/01/18.
 */
@Service
public class TestService implements ITestService {

    @Autowired
    private ObjectMapper objectMapper;

    public TestTO testar(Long id, Test test) {
        return objectMapper.convertValue(test, TestTO.class);
    }

}
