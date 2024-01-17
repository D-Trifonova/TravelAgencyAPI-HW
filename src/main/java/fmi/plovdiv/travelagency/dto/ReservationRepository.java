package fmi.plovdiv.travelagency.dto;

import org.springframework.data.repository.ListCrudRepository;

import fmi.plovdiv.travelagency.model.Reservation;

public interface ReservationRepository extends ListCrudRepository<Reservation, Long> {

}