package cc.goworks.lifeditor.tunnel.dao;

import cc.goworks.lifeditor.tunnel.model.TaskDO;
import cc.goworks.lifeditor.tunnel.model.TaskDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskDOMapper {
    long countByExample(TaskDOExample example);

    int deleteByExample(TaskDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TaskDO record);

    int insertSelective(TaskDO record);

    List<TaskDO> selectByExample(TaskDOExample example);

    TaskDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TaskDO record, @Param("example") TaskDOExample example);

    int updateByExample(@Param("record") TaskDO record, @Param("example") TaskDOExample example);

    int updateByPrimaryKeySelective(TaskDO record);

    int updateByPrimaryKey(TaskDO record);
}