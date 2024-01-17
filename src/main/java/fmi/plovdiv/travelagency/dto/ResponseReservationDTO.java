package fmi.plovdiv.travelagency.dto;

public class ResponseReservationDTO {

	private long id;
	private String contactName;
	private String phoneNumber;
	private long holiday;

	public ResponseReservationDTO() {

	}

	public ResponseReservationDTO(long id, String contactName, String phoneNumber, long holiday) {

		super();

		this.id = id;
		this.contactName = contactName;
		this.phoneNumber = phoneNumber;
		this.holiday = holiday;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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