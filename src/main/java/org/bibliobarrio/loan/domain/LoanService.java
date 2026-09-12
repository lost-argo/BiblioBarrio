package org.bibliobarrio.loan.domain;

import org.bibliobarrio.loan.infrastructure.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanService {
    @Autowired
    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<Loan> getAllLoans(){
        return loanRepository.findAll();
    }

    public Loan findLoanById(Long id){
        return loanRepository.findById(id).orElseThrow(() -> new RuntimeException("Loan with id " + id + " not found"));
    }

    public void addLoan(Loan newLoan){
        LocalDate borrowDate = LocalDate.now();
        LocalDate dueDate = borrowDate.plusDays(14);
        newLoan.setBorrowDate(borrowDate);
        newLoan.setDueDate(dueDate);
        loanRepository.save(newLoan);
    }
}