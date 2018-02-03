package kim.xiaom.work.dao;

import java.util.List;
import kim.xiaom.work.entity.dataObjects.TagDO;
import kim.xiaom.work.entity.queryObjects.TagDOExample;
import org.apache.ibatis.annotations.Param;

public interface TagDOMapper {
    long countByExample(TagDOExample example);

    int deleteByExample(TagDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TagDO record);

    int insertSelective(TagDO record);

    List<TagDO> selectByExample(TagDOExample example);

    TagDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TagDO record, @Param("example") TagDOExample example);

    int updateByExample(@Param("record") TagDO record, @Param("example") TagDOExample example);

    int updateByPrimaryKeySelective(TagDO record);

    int updateByPrimaryKey(TagDO record);
}