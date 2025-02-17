package ec.kgalarza.bank.handler;

import com.kgalarza.bank.report.FindReportUseCase;
import ec.kgalarza.bank.dto.ReportOutDTO;
import ec.kgalarza.bank.mapper.ReportMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Component
public class ReportHandler {

    private final FindReportUseCase findReportUseCase;

    public ReportHandler(FindReportUseCase findReportUseCase) {
        this.findReportUseCase = findReportUseCase;
    }

    public List<ReportOutDTO> getAccountStatementReport(LocalDate startDate, LocalDate endDate) {
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(LocalTime.MAX);
        return ReportMapper.toDtoList(findReportUseCase.getAccountStatementReport(startDateTime, endDateTime));
    }

    public List<ReportOutDTO> getAllAccountStatements() {
        return ReportMapper.toDtoList(findReportUseCase.getAllAccountStatements());
    }

    public List<ReportOutDTO> getAccountStatementReportByUser(LocalDate startDate, LocalDate endDate, Long userId) {
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(LocalTime.MAX);
        return ReportMapper.toDtoList(findReportUseCase.getAccountStatementReportByUser(startDateTime, endDateTime, userId));
    }
}
