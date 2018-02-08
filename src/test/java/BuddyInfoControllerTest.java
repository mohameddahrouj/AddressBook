import lab.Application;
import lab.model.BuddyInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;


import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
public class BuddyInfoControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    private String baseURL;

    private static String firstName = "Mohamed";
    private static String lastName = "Dahrouj";
    private static String address = "Carleton";
    private static String phone = "613-123-4564";

    @Before
    public void setUp() throws Exception {
        this.baseURL = "http://localhost:" + port + "/buddy";
    }

    @Test
    public void createBuddy() throws Exception
    {
        String url = this.baseURL + "?firstName=" + firstName + "&lastName=" + lastName + "&address=" + address + "&phone=" + phone;
    }
}
