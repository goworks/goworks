package kim.xiaom.work.dao;

import kim.xiaom.work.XiaomWorkApplicationTests;
import kim.xiaom.work.entity.dataObjects.TicketDO;
import kim.xiaom.work.entity.queryObjects.TicketDOExample;
import kim.xiaom.work.enums.ActiveEnum;
import kim.xiaom.work.utils.XiaomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = XiaomWorkApplicationTests.class)
@Transactional
public class TicketIntegrationTest {
    @Autowired
    private TicketDOMapper ticketDOMapper;

    @Test
    public void should_insert_post_successfully() {
        String ticketId = XiaomUtils.uuid();
        TicketDO ticketDO = new TicketDO();
        ticketDO.setTicketId(ticketId);
        ticketDO.setActive(ActiveEnum.ACTIVE.getValue());
        ticketDO.setTitle("title");
        ticketDO.setText("text");
        ticketDOMapper.insert(ticketDO);

        TicketDO fetchedTicketDO = getByTicketId(ticketId);

        assertThat(fetchedTicketDO.getTicketId()).isEqualTo(ticketId);
        assertThat(fetchedTicketDO.getTitle()).isEqualTo("title");
        assertThat(fetchedTicketDO.getText()).isEqualTo("text");
    }

    private TicketDO getByTicketId(String ticketId) {
        TicketDOExample ticketDOExample = new TicketDOExample();
        ticketDOExample.createCriteria()
                .andTicketIdEqualTo(ticketId);
        List<TicketDO> ticketDOs = ticketDOMapper.selectByExampleWithBLOBs(ticketDOExample);

        assertThat(ticketDOs).isNotNull();
        assertThat(ticketDOs.size()).isEqualTo(1);
        return ticketDOs.get(0);
    }
}