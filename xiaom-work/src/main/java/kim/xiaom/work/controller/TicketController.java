package kim.xiaom.work.controller;

import com.github.pagehelper.PageInfo;
import kim.xiaom.work.common.Constants;
import kim.xiaom.work.controller.wrapper.PageVO;
import kim.xiaom.work.controller.wrapper.StatusVO;
import kim.xiaom.work.converter.TicketConverter;
import kim.xiaom.work.entity.viewObjects.TicketVO;
import kim.xiaom.work.service.TicketService;
import kim.xiaom.work.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ge on 27/01/2018.
 */
@CrossOrigin(origins = {"http://localhost:*", "*"})
@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private TicketConverter ticketConverter;

    @RequestMapping("/ticket/:id")
    public TicketVO getTicket(@RequestParam String id) {
        kim.xiaom.work.entity.dataObjects.TicketDO ticketDO = ticketService.getTicketByTicketId(id);
        return ticketConverter.convert(ticketDO);
    }

    @RequestMapping(value = "/ticket/:id", method = RequestMethod.PUT)
    public StatusVO updateTicket(@RequestBody TicketVO ticketVO) {
        kim.xiaom.work.entity.dataObjects.TicketDO ticketDO = ticketConverter.convert(ticketVO);
        ticketService.updateTicket(ticketDO);
        return ResponseUtils.ok();
    }

    @RequestMapping(value = "/tickets", method = RequestMethod.GET)
    public PageVO<TicketVO> queryTicketsPage(@RequestParam(defaultValue = "0") int current,
                                             @RequestParam(defaultValue = Constants.PAGE_SIZE_STRING) int pageSize,
                                             @RequestParam(required = false) String title) {
        PageInfo<kim.xiaom.work.entity.dataObjects.TicketDO> pageInfo = ticketService.findPage(title, current, pageSize);
        return (PageVO<TicketVO>) ResponseUtils.create(pageInfo);
    }

    @RequestMapping(value = "/tickets", method = RequestMethod.POST)
    public StatusVO createTicket(@RequestBody TicketVO ticketVO) {
        ticketService.createTicket(ticketConverter.convert(ticketVO));
        return ResponseUtils.ok();
    }
}
