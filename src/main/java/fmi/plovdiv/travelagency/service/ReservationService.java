package fmi.plovdiv.travelagency.service;

import java.util.List;
import java.util.Optional;

import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fmi.plovdiv.travelagency.dto.CreateReservationDTO;
import fmi.plovdiv.travelagency.dto.ReservationRepository;
import fmi.plovdiv.travelagency.dto.ResponseReservationDTO;
import fmi.plovdiv.travelagency.dto.UpdateReservationDTO;
import fmi.plovdiv.travelagency.model.Reservation;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository repo;

	public ResponseReservationDTO createReservation(CreateReservationDTO reservationDto) {

		Reservation reservation = new Reservation();

		reservationDto.getContactName();
		reservationDto.getHoliday();
		reservationDto.getPhoneNumber();

		Reservation toSave = repo.save(reservation);

		return new ResponseReservationDTO(toSave.getId(), toSave.getContactName(), toSave.getPhoneNumber(),
				toSave.getHoliday());
	}

	private ResponseReservationDTO mapReservationToDto(Reservation r) {
		return new ResponseReservationDTO(r.getId(), r.getContactName(), r.getPhoneNumber(), r.getHoliday());
	}

	public List<ResponseReservationDTO> getReservations() {

		List<Reservation> reservations = repo.findAll();
		return reservations.stream().map(h -> mapReservationToDto(h)).toList();
	}

	public ResponseReservationDTO getReservationId(Long id) {

		Optional<Reservation> toReturn = repo.findById(id);

		return toReturn.isPresent() ? mapReservationToDto(toReturn.get()) : null;
	}

	// PUT and DEL
	public List<ResponseReservationDTO> putReservations(List<UpdateReservationDTO> updateDto) {

		for (UpdateReservationDTO dto : updateDto) {

			Optional<Reservation> reservation = repo.findById(dto.getId());

			if (reservation.isPresent()) {

				Reservation reservations = reservation.get();

				reservations.getId();

				reservations.setContactName(dto.getContactName());
				reservations.setHoliday(dto.getHoliday());
				reservations.setPhoneNumber(dto.getPhoneNumeber());

				repo.save(reservations);
			} else {
				throw new OpenApiResourceNotFoundException("not found");
			}
		}

		return repo.findAll().stream().map(l -> mapReservationToDto(l)).toList(); // === this::mapLocationToDto
	}

	public ResponseReservationDTO delReservationId(Long id) {

		Optional<Reservation> toReturn = repo.findById(id);

		if (!toReturn.isPresent()) {
			throw new OpenApiResourceNotFoundException("Location not found with id: " + id);
		}

		Reservation reservation = toReturn.get();
		repo.delete(reservation);

		return mapReservationToDto(reservation);
	}
}