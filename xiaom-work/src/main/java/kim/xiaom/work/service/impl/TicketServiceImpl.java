package kim.xiaom.work.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import kim.xiaom.work.converter.TicketConverter;
import kim.xiaom.work.dao.TicketDOMapper;
import kim.xiaom.work.entity.dataObjects.TicketDO;
import kim.xiaom.work.entity.queryObjects.TicketDOExample;
import kim.xiaom.work.service.TicketService;
import kim.xiaom.work.utils.XiaomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by ge on 12/05/2018.
 */
@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketDOMapper ticketDOMapper;
    @Autowired
    private TicketConverter ticketConverter;

    @Override
    public TicketDO getTicketByTicketId(String ticketId) {
        TicketDOExample ticketDOExample = new TicketDOExample();
        ticketDOExample.createCriteria().andTicketIdEqualTo(ticketId);
        List<TicketDO> ticketDOs = ticketDOMapper.selectByExampleWithBLOBs(ticketDOExample);
        if (CollectionUtils.isEmpty(ticketDOs)) {
            return null;
        }
        return ticketDOs.get(0);
    }

    @Override
    public PageInfo<TicketDO> findPage(String title, int current, int pageSize) {
        PageHelper.startPage(current, pageSize);
        TicketDOExample ticketDOExample = new TicketDOExample();
        TicketDOExample.Criteria criteria = ticketDOExample.createCriteria();
        if (!StringUtils.isEmpty(title)) {
            criteria.andTitleLike(title);
        }
        ticketDOExample.setOrderByClause("gmt_create desc");
        Page<TicketDO> ticketDOs = (Page<TicketDO>) ticketDOMapper.selectByExample(ticketDOExample);

        return ticketDOs.toPageInfo();
    }

    @Override
    public void updateTicket(TicketDO ticketDO) {
        TicketDOExample ticketDOExample = new TicketDOExample();
        ticketDOExample.createCriteria()
                .andTicketIdEqualTo(ticketDO.getTicketId());

        // TODO set modifier
        // TODO set gmtModify
        ticketDOMapper.updateByExampleSelective(ticketDO, ticketDOExample);
    }

    @Override
    public void createTicket(TicketDO ticketDO) {
        ticketDO.setGmtCreate(new Date());
        ticketDO.setGmtModify(new Date());
        ticketDO.setTicketId(XiaomUtils.uuid());
        ticketDOMapper.insert(ticketDO);
    }
}
