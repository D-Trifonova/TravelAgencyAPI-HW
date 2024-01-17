package fmi.plovdiv.travelagency.dto;

public class CreateReservationDTO {

	private String contactName;
	private String phoneNumber;
	private long holiday;

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public long getHoliday() {
		return holiday;
	}

	public void setHoliday(long holiday) {
		this.holiday = holiday;
	}
}