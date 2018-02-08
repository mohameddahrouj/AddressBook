import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import lab.Application;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import lab.repository.AddressBookRepository;
import lab.repository.BuddyInfoRepository;
import lab.model.AddressBook;
import lab.model.BuddyInfo;

import java.util.HashSet;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = Application.class)
public class AddressBookControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    @Autowired
    private AddressBookRepository addressBookRepository;

    private static String baseURL = "/book";

    @Autowired
    ObjectMapper objectMapper;

    private static String firstName = "Mohamed";
    private static String lastName = "Dahrouj";
    private static String phone = "613-123-4564";
    private static String address = "Carleton";

    @Test
    public void getAddressBookTest() throws Exception
    {
        AddressBook addressBook =  addressBookRepository.save(new AddressBook());

        this.mockMvc.perform(get(baseURL + "/" + addressBook.getId())).
                andExpect(jsonPath("id", is((int)addressBook.getId())));
    }

    @Test
    public void addBuddyToAddressBookTest() throws Exception
    {
        AddressBook addressBook = new AddressBook();
        BuddyInfo buddyInfo = buddyInfoRepository.save(new BuddyInfo(firstName, lastName,phone,address));
        AddressBook createdAddressBook =  addressBookRepository.save(new AddressBook());
        addressBook.addBuddy(buddyInfo);

        this.mockMvc.perform(
                patch(baseURL + "/" + createdAddressBook.getId() + "/buddies/" + buddyInfo.getId()).
                        contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(addressBook)));
    }

    @Test
    public void removeBuddyToAddressBookTest() throws Exception
    {
        AddressBook addressBook = new AddressBook();
        BuddyInfo buddyInfo = buddyInfoRepository.save(new BuddyInfo(firstName, lastName,phone,address));
        addressBook.addBuddy(buddyInfo);
        AddressBook createdAddressBook =  addressBookRepository.save(new AddressBook());

        //remove buddy
        addressBook.removeBuddy(buddyInfo);
        this.mockMvc.perform(
                patch(baseURL + "/" + createdAddressBook.getId() + "/buddies/" + buddyInfo.getId()).
                        contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(addressBook)));
    }
}
