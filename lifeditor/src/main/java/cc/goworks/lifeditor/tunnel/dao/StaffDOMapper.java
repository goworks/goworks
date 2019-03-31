package cc.goworks.lifeditor.tunnel.dao;

import cc.goworks.lifeditor.tunnel.model.StaffDO;
import cc.goworks.lifeditor.tunnel.model.StaffDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaffDOMapper {
    long countByExample(StaffDOExample example);

    int deleteByExample(StaffDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StaffDO record);

    int insertSelective(StaffDO record);

    List<StaffDO> selectByExample(StaffDOExample example);

    StaffDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StaffDO record, @Param("example") StaffDOExample example);

    int updateByExample(@Param("record") StaffDO record, @Param("example") StaffDOExample example);

    int updateByPrimaryKeySelective(StaffDO record);

    int updateByPrimaryKey(StaffDO record);
}