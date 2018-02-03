package kim.xiaom.work.dao;

import java.util.List;
import kim.xiaom.work.entity.dataObjects.TicketTagDO;
import kim.xiaom.work.entity.queryObjects.TicketTagDOExample;
import org.apache.ibatis.annotations.Param;

public interface TicketTagDOMapper {
    long countByExample(TicketTagDOExample example);

    int deleteByExample(TicketTagDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TicketTagDO record);

    int insertSelective(TicketTagDO record);

    List<TicketTagDO> selectByExample(TicketTagDOExample example);

    TicketTagDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TicketTagDO record, @Param("example") TicketTagDOExample example);

    int updateByExample(@Param("record") TicketTagDO record, @Param("example") TicketTagDOExample example);

    int updateByPrimaryKeySelective(TicketTagDO record);

    int updateByPrimaryKey(TicketTagDO record);
}