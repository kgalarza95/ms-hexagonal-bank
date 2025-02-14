package ec.kgalarza.bank.mapper;

import com.kgalarza.bank.entity.AccountStatementReport;
import ec.kgalarza.bank.dto.ReportOutDTO;

import java.util.Collections;
import java.util.List;

public class ReportMapper {

    public static ReportOutDTO toDto(AccountStatementReport domain) {
        if (domain == null) {
            return null;
        }
        return new ReportOutDTO(
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

    public static AccountStatementReport toDomain(ReportOutDTO dto) {
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

    public static List<ReportOutDTO> toDtoList(List<AccountStatementReport> domainList) {
        if (domainList == null) {
            return Collections.emptyList();
        }
        return domainList.stream()
                .map(ReportMapper::toDto)
                .toList();
    }

    public static List<AccountStatementReport> toDomainList(List<ReportOutDTO> dtoList) {
        if (dtoList == null) {
            return Collections.emptyList();
        }
        return dtoList.stream()
                .map(ReportMapper::toDomain)
                .toList();
    }
}
