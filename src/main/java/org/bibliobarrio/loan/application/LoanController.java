package org.bibliobarrio.loan.application;

import org.bibliobarrio.loan.domain.Loan;
import org.bibliobarrio.loan.domain.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {
    @Autowired
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        return ResponseEntity.ok(loanService.getAllLoans());
    }

    @PostMapping
    public ResponseEntity<Void> createLoan(@RequestBody Loan newLoan) {
        loanService.addLoan(newLoan);
        return ResponseEntity.status(HttpStatus.valueOf(201)).build();
    }
}
