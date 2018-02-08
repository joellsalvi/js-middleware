package br.com.middleware.mapper;

import org.mapstruct.Mapper;

import br.com.middleware.api.address.widenet.response.WideNetAddressResponse;
import br.com.middleware.model.BaseMapper;
import br.com.middleware.model.to.AddressTO;

/**
 * Created by zup134 on 05/02/18.
 */
@Mapper(componentModel = "spring")
public interface AddressMapper extends BaseMapper {

    AddressTO from(WideNetAddressResponse wideNetAddressResponse);

}
