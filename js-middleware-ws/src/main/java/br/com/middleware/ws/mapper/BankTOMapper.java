package br.com.middleware.ws.mapper;

import br.com.middleware.model.BaseMapper;
import br.com.middleware.model.to.BankTO;
import br.com.middleware.ws.api.response.BankResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BankTOMapper  extends BaseMapper {

    BankResponse fromTO(BankTO bankTO);

    List<BankResponse> fromTO(List<BankTO> bankTO);

}
