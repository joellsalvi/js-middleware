package br.com.middlewareservice.api;

import br.com.middleware.model.process.Test;
import br.com.middleware.model.to.TestTO;

/**
 * Created by joel on 31/01/18.
 */
public interface ITestService {

    TestTO testar(Long id, Test test);

}
