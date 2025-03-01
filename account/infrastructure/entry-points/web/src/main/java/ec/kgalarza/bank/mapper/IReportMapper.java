package ec.kgalarza.bank.mapper;

import com.kgalarza.bank.entity.AccountStatementReport;
import ec.kgalarza.bank.dto.ReportOutDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IReportMapper {

    ReportOutDTO toDto(AccountStatementReport domain);

    List<ReportOutDTO> toDtoList(List<AccountStatementReport> domainList);
}
