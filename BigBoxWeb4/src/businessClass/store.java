package businessClass;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class store implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	private int divisionID;
	private String storeNumber;
	private double sales;
	private String name;
	private String address;
	private String city;
	private String state;
	private String zip;

	public store() {
	}

	public store(int ID, int divisionID, String storeNumber, double sales, String name, String address, String city,
			String state, String zip) {
		this.ID = ID;
		this.divisionID = divisionID;
		this.storeNumber = storeNumber;
		this.sales = sales;
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

	public int getDivisionID() {
		return divisionID;
	}

	public void setDivisionID(int divisionID) {
		this.divisionID = divisionID;
	}

	public String getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}

	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
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
		return "Id = " + getID() + ", Division Number = " + getDivisionID() + "Store Number = " + getStoreNumber()
				+ "Sales = " + getSales() + "Name = " + getName() + "Address = " + getAddress() + "City = " + getCity()
				+ "State = " + getState() + "Zip = " + getZip();

	}

}
