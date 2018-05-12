package kim.xiaom.work.service;

import kim.xiaom.work.XiaomWorkApplicationTests;
import kim.xiaom.work.entity.dataObjects.TicketDO;
import kim.xiaom.work.utils.TestDataUtils;
import kim.xiaom.work.utils.XiaomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ge on 12/05/2018.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = XiaomWorkApplicationTests.class)
@Transactional
public class TicketServiceIntegrationTest {
    @Autowired
    private TicketService ticketService;

    @Test
    public void should_insert_ticket_successful() {
        String ticketId = XiaomUtils.uuid();
        TicketDO ticketDO = TestDataUtils.generateTicketDO(ticketId, "title", "text");

        ticketService.createTicket(ticketDO);

        TicketDO fetchedTicketDO = ticketService.getTicketByTicketId(ticketId);
        assertThat(fetchedTicketDO).isNotNull();
        assertThat(fetchedTicketDO.getTicketId()).isEqualTo(ticketId);
        assertThat(fetchedTicketDO.getTitle()).isEqualTo("title");
        assertThat(fetchedTicketDO.getText()).isEqualTo("text");
    }
}
