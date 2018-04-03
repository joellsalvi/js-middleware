package br.com.middleware.ws.mapper;

import br.com.middleware.model.BaseMapper;
import br.com.middleware.model.to.AddressTO;
import br.com.middleware.ws.api.response.AddressResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressTOMapper extends BaseMapper {

    AddressResponse fromTO(AddressTO addressTO);

}
