package kim.xiaom.work.converter;

import kim.xiaom.work.entity.dataObjects.UserDO;
import kim.xiaom.work.entity.viewObjects.TicketVO;
import kim.xiaom.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created by ge on 12/05/2018.
 */
@Component
public class TicketConverter {
    @Autowired
    private UserService userService;

    public TicketVO convert(kim.xiaom.work.entity.dataObjects.TicketDO ticketDO) {
        if (Objects.isNull(ticketDO)) {
            return null;
        }
        TicketVO ticketVO = new TicketVO();
        ticketVO.setId(ticketDO.getTicketId());
        ticketVO.setTitle(ticketDO.getTitle());
        ticketVO.setText(ticketDO.getText());
        ticketVO.setQuizzer(ticketDO.getCreator());

        UserDO quizzer = userService.getUserById(ticketDO.getCreator());
        if (!Objects.isNull(quizzer)) {
            ticketVO.setQuizzerName(quizzer.getUsername());
        }

        return ticketVO;
    }

    public kim.xiaom.work.entity.dataObjects.TicketDO convert(TicketVO ticketVO) {
        if (Objects.isNull(ticketVO)) {
            return null;
        }
        kim.xiaom.work.entity.dataObjects.TicketDO ticketDO = new kim.xiaom.work.entity.dataObjects.TicketDO();
        ticketDO.setTicketId(ticketVO.getId());
        ticketDO.setTitle(ticketVO.getTitle());
        ticketDO.setText(ticketVO.getText());

        return ticketDO;
    }
}
