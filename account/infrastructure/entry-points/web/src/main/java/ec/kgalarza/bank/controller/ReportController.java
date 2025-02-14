package ec.kgalarza.bank.controller;


import ec.kgalarza.bank.dto.ReportOutDTO;
import ec.kgalarza.bank.handler.ReportHandler;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("v1/reportes")
public class ReportController {

    private final ReportHandler reportHandler;

    public ReportController(ReportHandler reportHandler) {
        this.reportHandler = reportHandler;
    }

    @GetMapping("/account-statement")
    public ResponseEntity<List<ReportOutDTO>> getAccountStatementReport(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate endDate) {
        List<ReportOutDTO> reports = reportHandler.getAccountStatementReport(startDate, endDate);
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/all-statements")
    public ResponseEntity<List<ReportOutDTO>> getAllAccountStatements() {
        List<ReportOutDTO> reports = reportHandler.getAllAccountStatements();
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/user-statement")
    public ResponseEntity<List<ReportOutDTO>> getAccountStatementReportByUser(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate endDate,
            @RequestParam Long userId) {
        List<ReportOutDTO> reports = reportHandler.getAccountStatementReportByUser(startDate, endDate, userId);
        return ResponseEntity.ok(reports);
    }
}
