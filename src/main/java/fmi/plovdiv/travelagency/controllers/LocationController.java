package fmi.plovdiv.travelagency.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fmi.plovdiv.travelagency.dto.CreateLocationDTO;
import fmi.plovdiv.travelagency.dto.ResponseLocationDTO;
import fmi.plovdiv.travelagency.dto.UpdateLocationDTO;
import fmi.plovdiv.travelagency.service.LocationService;

@RestController
@RequestMapping("/locations")
public class LocationController {

	@Autowired
	private LocationService locationService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseLocationDTO> createLocation(@RequestBody CreateLocationDTO locationDto) {
		return ResponseEntity.ok(locationService.createLocation(locationDto));
	}
	// LocationController

	// post /locations
	// delete /locations/{locationId}
	// get /locations
	// get /locations/{locationId}
	// put /locations
	@GetMapping
	public ResponseEntity<List<ResponseLocationDTO>> getLocations() {
		return ResponseEntity.ok(locationService.getLocations());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseLocationDTO> getLocationById(@PathVariable Long id) {
		ResponseLocationDTO response = locationService.getLocationId(id);
		return ResponseEntity.ofNullable(response);
	}

	// PUT and DEL
	@PutMapping
	public ResponseEntity<List<ResponseLocationDTO>> putLocations(@RequestBody List<UpdateLocationDTO> updateDto) {

		return ResponseEntity.ok(locationService.putLocations(updateDto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseLocationDTO> delLocationById(@PathVariable Long id) {
		ResponseLocationDTO responce = locationService.delLocationId(id);
		return ResponseEntity.ofNullable(responce);
	}
}