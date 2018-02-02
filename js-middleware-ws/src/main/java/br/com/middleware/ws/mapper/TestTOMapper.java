package br.com.middleware.ws.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.middleware.model.BaseMapper;
import br.com.middleware.model.to.TestTO;
import br.com.middleware.ws.api.response.TestResponse;

/**
 * Created by zup134 on 02/02/18.
 */
@Mapper(componentModel = "spring")
public abstract class TestTOMapper implements BaseMapper {

    @Mapping(expression = "java(resolveName(to))", target = "fullName")
    public abstract TestResponse convertValue(TestTO to);

    protected String resolveName(TestTO to) {
        return to.getName() + " " + to.getLastName();
    }

}
