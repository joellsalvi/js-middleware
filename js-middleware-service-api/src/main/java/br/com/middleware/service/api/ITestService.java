package br.com.middleware.service.api;

import org.springframework.stereotype.Service;

import br.com.middleware.model.process.Test;
import br.com.middleware.model.to.TestTO;

/**
 * Created by joel on 31/01/18.
 */
@Service
public interface ITestService {

    TestTO testWideNet(String cep, Test test);

    TestTO testViaCep(String cep, Test test);

}
