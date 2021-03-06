package br.com.middleware.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.com.middleware.integration.api.address.viacep.response.ViaCepAddressResponse;
import br.com.middleware.integration.api.address.widenet.response.WideNetAddressResponse;
import br.com.middleware.model.BaseMapper;
import br.com.middleware.model.to.AddressTO;

/**
 * Created by Joel on 05/02/18.
 */
@Mapper(componentModel = "spring")
public interface AddressMapper extends BaseMapper {

    AddressTO from(WideNetAddressResponse wideNetAddressResponse);

    AddressTO from(ViaCepAddressResponse viaCepAddressResponse);

}
