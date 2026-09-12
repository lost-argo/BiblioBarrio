package org.bibliobarrio.reservation.domain;

import org.bibliobarrio.reservation.infrastructure.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation with id " + id +" not found"));
    }

    public void addReservation(Reservation newReservation) {
        ZonedDateTime reservedAt = ZonedDateTime.now();
        ZonedDateTime expiresAt = reservedAt.plusHours(48);
        newReservation.setReservedAt(reservedAt);
        newReservation.setExpiresAt(expiresAt);
        reservationRepository.save(newReservation);
    }
}