import lab.model.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuddyInfoTest {

    BuddyInfo buddy;
    @Before
    public void setUp(){
        buddy = new BuddyInfo("Homer", "Simpson", "1375 Carleton Drive", "613-261-8765");
    }

    @Test
    public void getFirstName() throws Exception {
        assertEquals("First name is not correct", "Homer", buddy.getFirstName());
    }

    @Test
    public void setFirstName() throws Exception {
        buddy.setFirstName("Homey");
        assertEquals("First name is not correct", "Homey", buddy.getFirstName());
    }

    @Test
    public void getLastName() throws Exception {
        assertEquals("Last name is not correct", "Simpson", buddy.getLastName());
    }

    @Test
    public void setLastName() throws Exception {
        buddy.setLastName("Smith");
        assertEquals("Last name is not correct", "Smith", buddy.getLastName());
    }

    @Test
    public void getAddress() throws Exception {
        assertEquals("Address is not correct", "1375 Carleton Drive", buddy.getAddress());
    }

    @Test
    public void setAddress() throws Exception {
        buddy.setAddress("The Park");
        assertEquals("Address is not correct", "The Park", buddy.getAddress());
    }

    @Test
    public void getPhoneNumber() throws Exception {
        assertEquals("Phone number is not correct", "613-261-8765", buddy.getPhoneNumber());
    }

    @Test
    public void setPhoneNumber() throws Exception {
        buddy.setPhoneNumber("819-261-8765");
        assertEquals("Phone number is not correct", "819-261-8765", buddy.getPhoneNumber());
    }

    @Test
    public void toStringBuddy() throws Exception {
        assertEquals("Output does not match", buddy.toString(), "Homer Simpson-1375 Carleton Drive-613-261-8765");
    }

}