package org.bibliobarrio.book.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.bibliobarrio.book.domain.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
}
