package ru.gontarenko.fraud.rest.mapper;

import org.mapstruct.Mapper;
import ru.gontarenko.fraud.domain.FraudCheckHistory;
import ru.gontarenko.fraud.rest.dto.FraudCheckHistoryDto;

@Mapper
public interface FraudCheckHistoryWebMapper {
    FraudCheckHistoryDto dto(FraudCheckHistory fraudCheckHistory);
}
