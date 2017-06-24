package it.polito.tdp.formula1.model;

import java.time.LocalDate;

public class Driver {
	
	private int driverId ;
	private String driverRef ;
	private int number ;
	private String code ;
	private String forename ;
	private String surname ;
	private LocalDate dob ; // date of birth
	private String nationality ;
	private String url ;
	public Driver(int driverId, String driverRef, int number, String code, String forename, String surname,
			LocalDate dob, String nationality, String url) {
		super();
		this.driverId = driverId;
		this.driverRef = driverRef;
		this.number = number;
		this.code = code;
		this.forename = forename;
		this.surname = surname;
		this.dob = dob;
		this.nationality = nationality;
		this.url = url;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getDriverRef() {
		return driverRef;
	}
	public void setDriverRef(String driverRef) {
		this.driverRef = driverRef;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getForename() {
		return forename;
	}
	public void setForename(String forename) {
		this.forename = forename;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + driverId;
		result = prime * result + ((driverRef == null) ? 0 : driverRef.hashCode());
		result = prime * result + ((forename == null) ? 0 : forename.hashCode());
		result = prime * result + ((nationality == null) ? 0 : nationality.hashCode());
		result = prime * result + number;
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (driverId != other.driverId)
			return false;
		if (driverRef == null) {
			if (other.driverRef != null)
				return false;
		} else if (!driverRef.equals(other.driverRef))
			return false;
		if (forename == null) {
			if (other.forename != null)
				return false;
		} else if (!forename.equals(other.forename))
			return false;
		if (nationality == null) {
			if (other.nationality != null)
				return false;
		} else if (!nationality.equals(other.nationality))
			return false;
		if (number != other.number)
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", driverRef=" + driverRef + ", number=" + number + ", code=" + code
				+ ", forename=" + forename + ", surname=" + surname + ", dob=" + dob + ", nationality=" + nationality
				+ ", url=" + url + "]";
	}
	
	
	
	
	

}
