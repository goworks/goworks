package kim.xiaom.work.service;

import com.github.pagehelper.PageInfo;
import kim.xiaom.work.entity.dataObjects.TicketDO;

/**
 * Created by ge on 12/05/2018.
 */
public interface TicketService {
    TicketDO getTicketByTicketId(String ticketId);
    PageInfo<TicketDO> findPage(String title, int current, int pageSize);
    void updateTicket(TicketDO ticketDO);
    void createTicket(TicketDO ticketDO);
}
