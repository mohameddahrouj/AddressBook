import lab.model.AddressBook;
import lab.model.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddressBookTest {

    private AddressBook addressBook;
    BuddyInfo buddy;

    @Before
    public void setUp(){
        addressBook = new AddressBook();
        buddy = new BuddyInfo("Homer","Simpson", "1375 Carleton Drive", "613-261-8765");
    }

    @Test
    public void addBuddy() throws Exception {
        addressBook.addBuddy(buddy);
        assertEquals("Size should be 1", 1, addressBook.getSize());
    }

    @Test
    public void printBook() throws Exception {
        addressBook.addBuddy(buddy);
        assertEquals("Print book failed", "Homer Simpson-1375 Carleton Drive-613-261-8765\n", addressBook.toString());
    }

    @Test
    public void removeBuddy() throws Exception {
        addressBook.addBuddy(buddy);
        addressBook.removeBuddy(buddy);
        assertEquals("Size should be 0", 0, addressBook.getSize());
    }

}