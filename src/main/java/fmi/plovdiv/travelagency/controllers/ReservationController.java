package fmi.plovdiv.travelagency.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fmi.plovdiv.travelagency.dto.CreateReservationDTO;
import fmi.plovdiv.travelagency.dto.ResponseReservationDTO;
import fmi.plovdiv.travelagency.dto.UpdateReservationDTO;
import fmi.plovdiv.travelagency.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

	@Autowired
	private ReservationService reservationServise;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseReservationDTO> createReservation(@RequestBody CreateReservationDTO reservationDto) {

		return ResponseEntity.ok(reservationServise.createReservation(reservationDto));
	}
	// ReservationController

	// post /reservations
	// delete /reservations/{reservationsId}
	// get /reservations
	// get /reservations/{reservationId}
	// put /reservations
	@GetMapping
	public ResponseEntity<List<ResponseReservationDTO>> getReservations() {
		return ResponseEntity.ok(reservationServise.getReservations());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseReservationDTO> getReservationId(@PathVariable Long id) {
		ResponseReservationDTO responce = reservationServise.getReservationId(id);
		return ResponseEntity.ofNullable(responce);
	}

	// PUT and DEL
	public ResponseEntity<List<ResponseReservationDTO>> putReservations(
			@RequestBody List<UpdateReservationDTO> updateDto) {

		return ResponseEntity.ok(reservationServise.putReservations(updateDto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseReservationDTO> delReservationById(@PathVariable Long id) {

		ResponseReservationDTO responce = reservationServise.delReservationId(id);

		return ResponseEntity.ofNullable(responce);
	}
}