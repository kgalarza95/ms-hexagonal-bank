package ec.kgalarza.bank.mapper;

import com.kgalarza.bank.entity.AccountStatementReport;
import ec.kgalarza.bank.model.dto.AccountStatementReportDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IReportRepoMapper {

    AccountStatementReport toDomain(AccountStatementReportDto dto);

    AccountStatementReportDto toDto(AccountStatementReport domain);
}
