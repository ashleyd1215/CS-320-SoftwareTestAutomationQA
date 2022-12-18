/**
 * 
 */
package AllServicesClass;

import java.util.HashMap;

/**
 * @author ashleydevenut_snhu
 *
 */
public class ContactService {
	

	private HashMap<String, Contact> contactList = new HashMap<String, Contact>();
	
	public HashMap<String, Contact> getContactList(){
		return contactList;
	}
	
	public void printContactList() {
		for(Contact c : contactList.values()) {
			System.out.println(c.getFullName());
		}
	}
	
	public void AddContact(String first, String last, String phone, String add) {
		String id = UniqueIDGenerator.generateUniqueID();
		if (contactList.size() >= UniqueIDGenerator.getMaxEntries()) {
			throw new IllegalArgumentException("Contact list is full!");
		}
		while (contactList.containsKey(id)) {
			id = UniqueIDGenerator.generateUniqueID();
		}
		Contact contact = new Contact(id, first, last, phone, add);
		contactList.put(contact.getId(), contact);		
	}
	
	
	public void DeleteContact(String id) {
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		if(contactList.isEmpty()) {
			throw new IllegalArgumentException("No contacts to delete");
		}
		
		if(!contactList.containsKey(id)) {
			throw new IllegalArgumentException("Contact does not exist");
		}
		
		else{
			contactList.remove(id);
			System.out.println("Contact removed from list.");
		}
		
	}
	
		public void UpdateContact(String id, Contact contact) {
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		if(contact == null) {
			throw new IllegalArgumentException("Invalid contacts");
		}
		
		if(contactList.isEmpty()) {
			throw new IllegalArgumentException("No contacts exist in list");
		}
		
		if(!contactList.containsKey(id)) {
			throw new IllegalArgumentException("That contact is not in the list");
		}
		
		else {
			contactList.replace(id, contact);
		}
			
	}

}
