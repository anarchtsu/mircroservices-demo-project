package ru.gontarenko.fraud.rest.mapper;

import org.mapstruct.Mapper;
import ru.gontarenko.clients.fraud.dto.FraudCheckHistoryDto;
import ru.gontarenko.fraud.domain.FraudCheckHistory;

@Mapper
public interface FraudCheckHistoryWebMapper {
    FraudCheckHistoryDto dto(FraudCheckHistory fraudCheckHistory);
}
