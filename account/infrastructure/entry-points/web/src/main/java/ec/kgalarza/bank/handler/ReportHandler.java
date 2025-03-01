package ec.kgalarza.bank.handler;

import com.kgalarza.bank.report.FindReportUseCase;
import ec.kgalarza.bank.dto.ReportOutDTO;
import ec.kgalarza.bank.mapper.IReportMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Component
public class ReportHandler {

    private final FindReportUseCase findReportUseCase;
    private final IReportMapper reportMapper;

    public ReportHandler(FindReportUseCase findReportUseCase, IReportMapper reportMapper) {
        this.findReportUseCase = findReportUseCase;
        this.reportMapper = reportMapper;
    }

    public List<ReportOutDTO> getAccountStatementReport(LocalDate startDate, LocalDate endDate) {
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(LocalTime.MAX);
        return reportMapper.toDtoList(findReportUseCase.getAccountStatementReport(startDateTime, endDateTime));
    }

    public List<ReportOutDTO> getAllAccountStatements() {
        return reportMapper.toDtoList(findReportUseCase.getAllAccountStatements());
    }

    public List<ReportOutDTO> getAccountStatementReportByUser(LocalDate startDate, LocalDate endDate, Long userId) {
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(LocalTime.MAX);
        return reportMapper.toDtoList(findReportUseCase.getAccountStatementReportByUser(startDateTime, endDateTime, userId));
    }
}
