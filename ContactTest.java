/**
 * 
 */
package AllServicesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import AllServicesClass.Contact;
/**
 * @author ashleydevenut_snhu
 *
 */
class ContactTest {

	@Test
	void testContactNullArgument() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact(null, null, null, null, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1928374650", null, null, null, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1928374650", "Sarah", null, null, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1928374650", "Sarah", "Smith", null, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1928374650", "Sarah", "Smith", "7321465980", null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1928374650", "Sarah", "Smith", "7321465980", "407 Violet Ln");
		});
	}
	
	@Test
	void testContactInvalidArguments() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("19283746501", "Sarah", "Smith", "7321465980", "407 Violet Ln");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1928374650", "SarahSmith1", "Smith", "7321465980", "407 Violet Ln");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1928374650", "Sarah", "SmithSarah2", "7321465980", "407 Violet Ln");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1928374650", "Sarah", "Smith", "7321465980123", "407 Violet Ln");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1928374650", "Sarah", "Smith", "732146598", "602 Elms");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1928374650", "Sarah", "Smith", "7321465980", "407_Violet_Ln_iswaytoolong_tobeValid_willcauseerror");
		});
	}

	@Test
	void testContactGetters() {
		Contact c = new Contact("1928374650", "Sarah", "Smith", "7321465980", "407 Violet Ln");
		Assertions.assertEquals(c.getId(), "1928374650");
		Assertions.assertEquals(c.getFullName(), "Sarah Smith");
		Assertions.assertEquals(c.getPhoneNumber(), "7321465980");
		Assertions.assertEquals(c.getAddress(), "407 Violet Ln");
	}
	
}
