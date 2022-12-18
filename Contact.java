/**
 * 
 */
package AllServicesClass;

/**
 * @author ashleydevenut_snhu
 *
 */
public class Contact {
	
	private String id;				//cannot be >10 char
	private String firstName;		//cannot be >10 char
	private String lastName;		//cannot be >10 char
	private String phoneNumber;	//must be exactly 10 char
	private String address;		//cannot be >30 char
	
	//none of the above can be null
	
	
	public Contact(String id, String first, String last, String phone, String add) {
				
		id = id;
		setFirstName(first);
		setLastName(last);
		setPhoneNumber(phone);
		setAddress(add);
		}
	
	public String getId() {
		return id;
	}
	public String getFullName() {
		return firstName + " " + lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	
	public void setFirstName(String first) {
		if(first == null || first.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		firstName = first;
	}
	public void setLastName (String last){
		if(last == null || last.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		lastName = last;
	}
	public void setPhoneNumber (String phone) {
		if(phone == null || phone.length() > 10 || phone.length() < 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		phoneNumber = phone;
	}
	public void setAddress(String add) {
		if(add == null || add.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		address = add;
	}

}
