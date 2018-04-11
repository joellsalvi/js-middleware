package br.com.middleware.service.api;

import br.com.middleware.model.process.Test;
import br.com.middleware.model.to.BankTO;
import br.com.middleware.model.to.TestTO;

import java.util.List;

/**
 * Created by joel on 31/01/18.
 */
public interface ITestService {

    TestTO testWideNet(String cep, Test test);

    TestTO testViaCep(String cep, Test test);

    List<BankTO> getBanks();
}
