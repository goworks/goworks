package cc.goworks.work.service;

import cc.goworks.work.entity.dataObjects.TicketDO;
import com.github.pagehelper.PageInfo;

/**
 * Created by ge on 12/05/2018.
 */
public interface TicketService {
    TicketDO getTicketByTicketId(String ticketId);
    PageInfo<TicketDO> findPage(String title, int current, int pageSize);
    void updateTicket(TicketDO ticketDO);
    void createTicket(TicketDO ticketDO);
}
