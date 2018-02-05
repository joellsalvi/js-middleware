package br.com.middleware.mapper;

import org.mapstruct.Mapper;

import br.com.middleware.api.address.response.AddressResponse;
import br.com.middleware.model.BaseMapper;
import br.com.middleware.model.to.AddressTO;

/**
 * Created by zup134 on 05/02/18.
 */
@Mapper
public interface AddressMapper extends BaseMapper {

    AddressTO from(AddressResponse addressResponse);

}
