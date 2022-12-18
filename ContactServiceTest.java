/**
 * 
 */
package AllServicesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import AllServicesClass.Contact;
import AllServicesClass.ContactService;
/**
 * @author ashleydevenut_snhu
 *
 */
class ContactServiceTest {

	@Test
	void testAddContact() {
		
		ContactService c = new ContactService();
		c.AddContact("Frank", "Lawrance", "7321465980", "405 Bennett Rd");
		Assertions.assertTrue(!c.getContactList().isEmpty());
		c.printContactList();
		
	}

	@Test
	void testUpdateContact() {
		ContactService c = new ContactService();
		
		String id = "";
		
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			c.UpdateContact(null, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			c.UpdateContact("192283746501010", null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			c.UpdateContact("192837465", null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			c.UpdateContact("192837465", new Contact("13", "Sarah", "Smith", "7321465980", "407 Violet Ln"));
		});
		
		c.AddContact("Frank", "Lawrance", "7321465980", "405 Bennette Rd");
		for(Contact d : c.getContactList().values()) {
			id = d.getId();
		}
		
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			c.UpdateContact("192837465", new Contact("13", "Sarah", "Smith", "7321465980", "407 Violet Ln"));
		});
		
		c.UpdateContact(id, new Contact(id, "Sarah", "Smith", "7321465980", "407 Violet Ln"));
		
	}
	
	@Test
	void testDeleteContact() {
		ContactService c = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			c.DeleteContact(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			c.DeleteContact("19283746501010");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			c.DeleteContact("1928374650");
		});
		
		String id = null;
		c.AddContact("Frank", "Lawrance", "7321465980", "405 Bennette Rd");
		for(Contact d : c.getContactList().values()) {
			id = d.getId();
		}
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			c.DeleteContact("1928374650");
		});
		
		c.DeleteContact(id);
		Assertions.assertTrue(c.getContactList().isEmpty());
		
	}
	
}
