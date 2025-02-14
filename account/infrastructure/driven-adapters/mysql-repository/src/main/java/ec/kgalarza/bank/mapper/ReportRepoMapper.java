package ec.kgalarza.bank.mapper;

import com.kgalarza.bank.entity.AccountStatementReport;
import ec.kgalarza.bank.model.dto.AccountStatementReportDto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReportRepoMapper {

    public static AccountStatementReport toDomain(AccountStatementReportDto dto) {
        if (dto == null) {
            return null;
        }
        return new AccountStatementReport(
                dto.getTransactionDate(),
                dto.getCustomerName(),
                dto.getAccountNumber(),
                dto.getAccountType(),
                dto.getInitialBalance(),
                dto.getTransactionAmount(),
                dto.getAvailableBalance(),
                dto.getTransactionDescription(),
                dto.getAccountStatus()
        );
    }

    public static AccountStatementReportDto toDto(AccountStatementReport domain) {
        if (domain == null) {
            return null;
        }
        return new AccountStatementReportDto(
                domain.getTransactionDate(),
                domain.getCustomerName(),
                domain.getAccountNumber(),
                domain.getAccountType(),
                domain.getInitialBalance(),
                domain.getTransactionAmount(),
                domain.getAvailableBalance(),
                domain.getTransactionDescription(),
                domain.getAccountStatus()
        );
    }

    public static List<AccountStatementReport> toDomainList(List<AccountStatementReportDto> dtoList) {
        if (dtoList == null) {
            return Collections.emptyList();
        }
        return dtoList.stream()
                .map(ReportRepoMapper::toDomain)
                .collect(Collectors.toList());
    }

    public static List<AccountStatementReportDto> toDtoList(List<AccountStatementReport> domainList) {
        if (domainList == null) {
            return Collections.emptyList();
        }
        return domainList.stream()
                .map(ReportRepoMapper::toDto)
                .collect(Collectors.toList());
    }
}
