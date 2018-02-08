package buddy;

import static org.assertj.core.api.Assertions.assertThat;

import lab.Application;
import lab.controller.AddressBookController;
import lab.controller.BuddyInfoController;
import lab.model.BuddyInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SmokeTest {

    @Autowired
    private BuddyInfoController buddyController;

    @Autowired
    private AddressBookController bookController;

    @Test
    public void bookControllerLoads() throws Exception {
        assertThat(bookController).isNotNull();
    }
    @Test
    public void buddyControllerLoads() throws Exception {
        assertThat(buddyController).isNotNull();
    }
}