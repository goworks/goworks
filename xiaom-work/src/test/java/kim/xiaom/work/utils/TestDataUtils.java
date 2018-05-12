package kim.xiaom.work.utils;

import kim.xiaom.work.entity.dataObjects.TicketDO;

/**
 * Created by ge on 12/05/2018.
 */
public class TestDataUtils {
    public static TicketDO generateTicketDO(String ticketId, String title, String text) {
        TicketDO ticketDO = new TicketDO();
        ticketDO.setTicketId(ticketId);
        ticketDO.setTitle(title);
        ticketDO.setText(text);
        return ticketDO;
    }
}
