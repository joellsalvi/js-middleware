package br.com.middleware.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.middleware.model.BaseMapper;
import br.com.middleware.model.process.Test;
import br.com.middleware.model.to.AddressTO;
import br.com.middleware.model.to.TestTO;

/**
 * Created by joel on 02/02/18.
 */
@Mapper(componentModel = "spring")
public abstract class TestMapper implements BaseMapper {

    public abstract TestTO convertValue(Test test);

    @Mapping(source = "addressTO", target = "address")
    public abstract TestTO convertValue(Test test, AddressTO addressTO);

}
