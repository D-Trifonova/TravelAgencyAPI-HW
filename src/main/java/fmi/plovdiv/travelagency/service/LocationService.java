package fmi.plovdiv.travelagency.service;

import java.util.List;
import java.util.Optional;

import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fmi.plovdiv.travelagency.dto.CreateLocationDTO;
import fmi.plovdiv.travelagency.dto.LocationRepository;
import fmi.plovdiv.travelagency.dto.ResponseLocationDTO;
import fmi.plovdiv.travelagency.dto.UpdateLocationDTO;
import fmi.plovdiv.travelagency.model.Location;

@Service
public class LocationService {

	@Autowired
	private LocationRepository repo;

	public ResponseLocationDTO createLocation(CreateLocationDTO locationDto) {

		Location location = new Location();

		location.setNumber(locationDto.getNumber());
		location.setCity(locationDto.getCity());
		location.setStreet(locationDto.getStreet());
		location.setCountry(locationDto.getCountry());
		location.setImageUrl(locationDto.getImageUrl());

		Location toSave = repo.save(location);

		return new ResponseLocationDTO(toSave.getId(), toSave.getNumber(), toSave.getCountry(), toSave.getCity(),
				toSave.getStreet(), toSave.getImageUrl());
	}

	private ResponseLocationDTO mapLocationToDto(Location l) {
		return new ResponseLocationDTO(l.getId(), l.getNumber(), l.getCountry(), l.getCity(), l.getStreet(),
				l.getImageUrl());
	}

	public List<ResponseLocationDTO> getLocations() {
		List<Location> locations = repo.findAll();

		return locations.stream().map(l -> mapLocationToDto(l)).toList();
	}

	public ResponseLocationDTO getLocationId(Long id) {
		Optional<Location> toReturn = repo.findById(id);

		return toReturn.isPresent() ? mapLocationToDto(toReturn.get()) : null;
	}

	public List<ResponseLocationDTO> putLocations(List<UpdateLocationDTO> updateDto) {

		for (UpdateLocationDTO dto : updateDto) {

			Optional<Location> location = repo.findById(dto.getId());

			if (location.isPresent()) {

				Location locations = location.get();

				locations.getId();

				locations.setCity(dto.getCity());
				locations.setCountry(dto.getCountry());
				locations.setImageUrl(dto.getImageUrl());
				locations.setNumber(dto.getNumber());
				locations.setStreet(dto.getStreet());

				repo.save(locations);
			} else {
				throw new OpenApiResourceNotFoundException("not found");
			}
		}

		return repo.findAll().stream().map(l -> mapLocationToDto(l)).toList(); // === this::mapLocationToDto
	}

	public ResponseLocationDTO delLocationId(Long id) {

		Optional<Location> toReturn = repo.findById(id);

		if (!toReturn.isPresent()) {
			throw new OpenApiResourceNotFoundException("Location not found with id: " + id);
		}

		Location location = toReturn.get();
		repo.delete(location);

		return mapLocationToDto(location);
	}
}

//if (toReturn.isPresent()) {
//Location location = toReturn.get();
//repo.delete(location);
//return mapLocationToDto(location);
//}
//
//return null;
//-----------------------------------------------------------------------------------------------------------------
//public List<ResponseLocationDTO> putLocations(List<fmi.plovdiv.travelagency.dto.UpdateLocationDTO> updateDto) {
//
//List<Location> locations = repo.findAll();
//
//for (Location location : locations) {
//location.setCity("Updated city ");
//location.setCountry("Updated country ");
//location.setImageUrl("Updated URL image ");
//location.setNumber("Updated number ");
//location.setStreet("Updated street ");
//}
//repo.saveAll(locations); // Update locations in DB
//
//return locations.stream().map(l -> mapLocationToDto(l)).toList();
//}