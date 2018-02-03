package kim.xiaom.work.dao;

import java.util.List;
import kim.xiaom.work.entity.dataObjects.GuestDO;
import kim.xiaom.work.entity.queryObjects.GuestDOExample;
import org.apache.ibatis.annotations.Param;

public interface GuestDOMapper {
    long countByExample(GuestDOExample example);

    int deleteByExample(GuestDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GuestDO record);

    int insertSelective(GuestDO record);

    List<GuestDO> selectByExample(GuestDOExample example);

    GuestDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GuestDO record, @Param("example") GuestDOExample example);

    int updateByExample(@Param("record") GuestDO record, @Param("example") GuestDOExample example);

    int updateByPrimaryKeySelective(GuestDO record);

    int updateByPrimaryKey(GuestDO record);
}