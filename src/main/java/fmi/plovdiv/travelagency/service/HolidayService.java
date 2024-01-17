package fmi.plovdiv.travelagency.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fmi.plovdiv.travelagency.dto.CreateHolidayDTO;
import fmi.plovdiv.travelagency.dto.HolidayRepository;
import fmi.plovdiv.travelagency.dto.ResponseHolidayDTO;
import fmi.plovdiv.travelagency.dto.UpdateHolidayDTO;
import fmi.plovdiv.travelagency.model.Holiday;

@Service
public class HolidayService {

	@Autowired
	private HolidayRepository repo;

	public ResponseHolidayDTO createHoliday(CreateHolidayDTO holidayDto) {

		Holiday holiday = new Holiday();

		holiday.setLocation(holidayDto.getLocation());
		holiday.setFreeSlots(holidayDto.getFreeSlots());
		holiday.setPrice(holidayDto.getPriceAsDouble()); // getPrice()
		holiday.setStartDate(holidayDto.getStartDate());
		holiday.setTitle(holidayDto.getTitle());

		Holiday toSave = repo.save(holiday);

		return new ResponseHolidayDTO(toSave.getId(), toSave.getLocation(), toSave.getTitle(), toSave.getStartDate(),
				toSave.getDuriation(), toSave.getPrice(), toSave.getFreeSlots());
	}

	private ResponseHolidayDTO mapHolidayToDto(Holiday h) {
		return new ResponseHolidayDTO(h.getId(), h.getLocation(), h.getTitle(), h.getStartDate(), h.getDuriation(),
				h.getPrice(), h.getFreeSlots());
	}

	public List<ResponseHolidayDTO> getHolidays() {

		List<Holiday> holidays = repo.findAll();
		return holidays.stream().map(h -> mapHolidayToDto(h)).toList();
	}

	public ResponseHolidayDTO getHolidayId(Long id) {

		Optional<Holiday> toReturn = repo.findById(id);

		return toReturn.isPresent() ? mapHolidayToDto(toReturn.get()) : null;
	}

	public List<ResponseHolidayDTO> putHolidays(List<UpdateHolidayDTO> updateDto) {

		for (UpdateHolidayDTO dto : updateDto) {
			Optional<Holiday> holiday = repo.findById(dto.getId());

			if (holiday.isPresent()) {

				Holiday holidays = holiday.get();

				holidays.getId();
				holidays.getLocation();

				holidays.setDuriation(dto.getDuriation());
				holidays.setFreeSlots(dto.getFreeSlots());
				// holidays.setLocation(dto.getLocation()); // ERR
				holidays.setPrice(dto.getPriceAsDouble()); // getPrice()
				holidays.setStartDate(LocalDateTime.now());
				holidays.setTitle(dto.getTitle());
			}
		}

		return repo.findAll().stream().map(l -> mapHolidayToDto(l)).toList();
	}

	public ResponseHolidayDTO delHolidayId(Long id) {

		Optional<Holiday> toReturn = repo.findById(id);

		if (!toReturn.isPresent()) {

			throw new OpenApiResourceNotFoundException("Holiday not found with id: " + id);
		}

		Holiday holiday = toReturn.get();
		repo.delete(holiday);

		return mapHolidayToDto(holiday);
	}
}