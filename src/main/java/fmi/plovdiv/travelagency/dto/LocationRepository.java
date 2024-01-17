package fmi.plovdiv.travelagency.dto;

import org.springframework.data.repository.ListCrudRepository;

import fmi.plovdiv.travelagency.model.Location;

public interface LocationRepository extends ListCrudRepository<Location, Long> {

}