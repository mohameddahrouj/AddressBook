import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import lab.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import lab.repository.BuddyInfoRepository;
import lab.model.BuddyInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = Application.class)
public class BuddyInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    private String baseURL = "/buddy";

    private static String firstName = "Mohamed";
    private static String lastName = "Dahrouj";
    private static String phone = "613-123-4564";
    private static String address = "Carleton";


    @Test
    public void createBuddyTest() throws Exception
    {
        String url = this.baseURL + "?firstName=" + firstName + "&lastName=" + lastName + "&address=" + address + "&phone=" + phone;
//        this.mockMvc.perform(post(url).
//                contentType(MediaType.APPLICATION_JSON)).
//                andExpect(jsonPath("firstName", is(firstName))).
//                andExpect(jsonPath("lastName", is(lastName)));
    }

    @Test
    public void getBuddyTest() throws Exception
    {
        BuddyInfo buddyInfo = new BuddyInfo(firstName, lastName, phone,address);
        BuddyInfo createdBuddy = buddyInfoRepository.save(buddyInfo);
        String url = this.baseURL + "/" + createdBuddy.getId();
        this.mockMvc.perform(get(url).
                contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).
                andExpect(jsonPath("firstName", is(createdBuddy.getFirstName()))).
                andExpect(jsonPath("lastName", is(createdBuddy.getLastName()))).
                andExpect(jsonPath("id", is((int)createdBuddy.getId())));
    }

}
