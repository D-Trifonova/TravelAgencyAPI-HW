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

import fmi.plovdiv.travelagency.dto.CreateHolidayDTO;
import fmi.plovdiv.travelagency.dto.ResponseHolidayDTO;
import fmi.plovdiv.travelagency.dto.UpdateHolidayDTO;
import fmi.plovdiv.travelagency.service.HolidayService;

@RestController
@RequestMapping("/holidays")
public class HolidayController {

	@Autowired
	private HolidayService holidayServise;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseHolidayDTO> createHoliday(@RequestBody CreateHolidayDTO holidayDto) {
		return ResponseEntity.ok(holidayServise.createHoliday(holidayDto));
	}
	// HolidayController

	// post /holidays
	// delete /holidays/{holidayId}
	// get /holidays
	// get /holidays/{holidayId}
	// put /holidays
	@GetMapping
	public ResponseEntity<List<ResponseHolidayDTO>> getHolidays() {
		return ResponseEntity.ok(holidayServise.getHolidays());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseHolidayDTO> getHolidayId(@PathVariable Long id) {
		ResponseHolidayDTO responce = holidayServise.getHolidayId(id);
		return ResponseEntity.ofNullable(responce);
	}

	// PUT and DEL
	@PutMapping
	public ResponseEntity<List<ResponseHolidayDTO>> putHolidays(@RequestBody List<UpdateHolidayDTO> updateDto) {

		return ResponseEntity.ok(holidayServise.putHolidays(updateDto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseHolidayDTO> delHolidayById(@PathVariable Long id) {

		ResponseHolidayDTO responce = holidayServise.delHolidayId(id);

		return ResponseEntity.ofNullable(responce);
	}
}