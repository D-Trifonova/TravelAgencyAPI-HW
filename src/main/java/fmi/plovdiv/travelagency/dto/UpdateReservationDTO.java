package fmi.plovdiv.travelagency.dto;

public class UpdateReservationDTO {

	private long id;
	private String contactName;
	private String phoneNumeber;
	private long holiday;

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

	public String getPhoneNumeber() {
		return phoneNumeber;
	}

	public void setPhoneNumeber(String phoneNumeber) {
		this.phoneNumeber = phoneNumeber;
	}

	public long getHoliday() {
		return holiday;
	}

	public void setHoliday(long holiday) {
		this.holiday = holiday;
	}
}