package businessClass;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private boolean IsReviewer;
	private boolean IsAdmin;

	public User() {
	}

	public User(int ID, String userName, String password, String firstName, String lastName, String phone, String email,
			boolean IsReviewer, boolean IsAdmin) {
		this.ID = ID;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.IsReviewer = IsReviewer;
		this.IsAdmin = IsAdmin;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isIsReviewer() {
		return IsReviewer;
	}

	public void setIsReviewer(boolean isReviewer) {
		IsReviewer = isReviewer;
	}

	public boolean isIsAdmin() {
		return IsAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		IsAdmin = isAdmin;
	}

}
