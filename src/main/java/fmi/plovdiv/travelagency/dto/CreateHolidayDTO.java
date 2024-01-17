package fmi.plovdiv.travelagency.dto;

import java.time.LocalDateTime;

import fmi.plovdiv.travelagency.model.Location;

public class CreateHolidayDTO {

	private Location location;
	private String title;
	private LocalDateTime startDate;
	private int duriation;
	private String price; // String / long
	private int freeSlots;

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

	public String getPrice() { // String / long
		return price;
	}

	public void setPrice(String price) { // String / long
		this.price = price;
	}

	public double getPriceAsDouble() { // Parse to double
		try {
			return Double.parseDouble(price);
		} catch (NumberFormatException e) {
			System.out.println("The string is not a valid double value.");
			return 0.0;
		}
	}

	public int getFreeSlots() {
		return freeSlots;
	}

	public void setFreeSlots(int freeSlots) {
		this.freeSlots = freeSlots;
	}
}