package org.bibliobarrio.reservation.infrastructure;

import org.bibliobarrio.reservation.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
