package fmi.plovdiv.travelagency.dto;

import org.springframework.format.annotation.DateTimeFormat;

public class UpdateHolidayDTO {

	private Long id;
	private long location; // Long / ResponseLocationDTO(Location)
	private String title;
	private DateTimeFormat startDate;
	private int duriation;
	private String price; // String / double
	private int freeSlots;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getLocation() {
		return location;
	}

	public void setLocation(long location) {
		this.location = location;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public DateTimeFormat getStartDate() {
		return startDate;
	}

	public void setStartDate(DateTimeFormat startDate) {
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