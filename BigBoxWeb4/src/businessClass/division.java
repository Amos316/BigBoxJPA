package businessClass;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class division implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	private String divisionNumber;
	private String name;
	private String address;
	private String city;
	private String state;
	private String zip;

	public division() {
	}

	public division(int ID, String divisionNumber, String name, String address, String city, String state, String zip) {
		this.ID = ID;
		this.divisionNumber = divisionNumber;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDivisionNumber() {
		return divisionNumber;
	}

	public void setDivisionNumber(String divisionNumber) {
		this.divisionNumber = divisionNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String toString() {
		return "ID = " + getID() + "Division Number = " + getDivisionNumber() + "Name = " + getName() + "Address = "
				+ getAddress() + "City = " + getCity() + "State = " + getState() + " Zip = " + getZip();
	}

}
