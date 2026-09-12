package org.bibliobarrio.reservation.application;

import org.bibliobarrio.reservation.domain.Reservation;
import org.bibliobarrio.reservation.domain.ReservationService;
import org.bibliobarrio.reservation.infrastructure.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {this.reservationService = reservationService;}

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @PostMapping
    public ResponseEntity<Void> createReservation(@RequestBody Reservation newReservation) {
        reservationService.addReservation(newReservation);
        return ResponseEntity.status(HttpStatus.valueOf(201)).build();
    }
}
