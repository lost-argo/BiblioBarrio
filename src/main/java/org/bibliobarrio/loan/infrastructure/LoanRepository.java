package org.bibliobarrio.loan.infrastructure;

import org.bibliobarrio.loan.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
