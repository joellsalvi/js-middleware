package br.com.middleware.service.api;

import br.com.middleware.model.process.Test;
import br.com.middleware.model.to.TestTO;

/**
 * Created by Joel on 31/01/18.
 */
public interface ITestService {

    TestTO testWideNet(String cep, Test test);

    TestTO testViaCep(String cep, Test test);

}
