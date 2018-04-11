package br.com.middleware.service.mapper;

import br.com.middleware.dataaccess.entity.BankEntity;
import br.com.middleware.model.BaseMapper;
import br.com.middleware.model.to.BankTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BankMapper extends BaseMapper {

    BankTO fromEntity(BankEntity bankEntity);

    List<BankTO> fromEntity(List<BankEntity> bankEntity);

    BankEntity toEntity(BankTO bankTO);
}
