package fmi.plovdiv.travelagency.dto;

import org.springframework.data.repository.ListCrudRepository;

import fmi.plovdiv.travelagency.model.Holiday;

public interface HolidayRepository extends ListCrudRepository<Holiday, Long> {

}