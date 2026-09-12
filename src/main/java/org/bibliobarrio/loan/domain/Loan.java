package org.bibliobarrio.loan.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bibliobarrio.book.domain.Book;
import org.bibliobarrio.user.domain.User;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Loan {
    @Id
    private Integer id;
    Book bookId;
    User userId;
    LocalDate borrowDate;
    LocalDate dueDate;
    String status;
}
