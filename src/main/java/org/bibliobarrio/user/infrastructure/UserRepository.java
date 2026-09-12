package org.bibliobarrio.user.infrastructure;

import org.bibliobarrio.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
