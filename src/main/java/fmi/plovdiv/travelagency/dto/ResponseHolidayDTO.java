package fmi.plovdiv.travelagency.dto;

import java.time.LocalDateTime;

import fmi.plovdiv.travelagency.model.Location;

public class ResponseHolidayDTO {

	private Long id;
	private Location location;
	private String title;
	private LocalDateTime startDate;
	private int duriation;
	private double price;
	private int freeSlots;

	public ResponseHolidayDTO() {

	}

//	public ResponseHolidayDTO(Long id) {
//
//		super();
//
//		this.id = id;
//	}

	public ResponseHolidayDTO(Long id, Location location, String title, LocalDateTime startDate, int duriation,
			double price, int freeSlots) {

		super();

		this.id = id;
		this.location = location;
		this.title = title;
		this.startDate = startDate;
		this.duriation = duriation;
		this.price = price;
		this.freeSlots = freeSlots;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public int getDuriation() {
		return duriation;
	}

	public void setDuriation(int duriation) {
		this.duriation = duriation;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getFreeSlots() {
		return freeSlots;
	}

	public void setFreeSlots(int freeSlots) {
		this.freeSlots = freeSlots;
	}
}