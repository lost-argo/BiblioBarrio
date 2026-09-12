package org.bibliobarrio.reservation.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bibliobarrio.book.domain.Book;
import org.bibliobarrio.user.domain.User;

import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Reservation {
    @Id
    Integer id;
    Book bookId;
    User userId;
    ZonedDateTime reservedAt;
    ZonedDateTime expiresAt;
    String status;
}
