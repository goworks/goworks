package kim.xiaom.work.dao;

import java.util.List;
import kim.xiaom.work.entity.dataObjects.TicketDO;
import kim.xiaom.work.entity.queryObjects.TicketDOExample;
import org.apache.ibatis.annotations.Param;

public interface TicketDOMapper {
    long countByExample(TicketDOExample example);

    int deleteByExample(TicketDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TicketDO record);

    int insertSelective(TicketDO record);

    List<TicketDO> selectByExampleWithBLOBs(TicketDOExample example);

    List<TicketDO> selectByExample(TicketDOExample example);

    TicketDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TicketDO record, @Param("example") TicketDOExample example);

    int updateByExampleWithBLOBs(@Param("record") TicketDO record, @Param("example") TicketDOExample example);

    int updateByExample(@Param("record") TicketDO record, @Param("example") TicketDOExample example);

    int updateByPrimaryKeySelective(TicketDO record);

    int updateByPrimaryKeyWithBLOBs(TicketDO record);

    int updateByPrimaryKey(TicketDO record);
}