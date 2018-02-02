package br.com.middleware.mapper;

import org.mapstruct.Mapper;

import br.com.middleware.model.BaseMapper;
import br.com.middleware.model.process.Test;
import br.com.middleware.model.to.TestTO;

/**
 * Created by zup134 on 02/02/18.
 */
@Mapper(componentModel = "spring")
public interface TestMapper extends BaseMapper {

    TestTO convertValue(Test test);

}
