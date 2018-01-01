package kim.xiaom.blog.dao;

import java.util.List;
import kim.xiaom.blog.entity.dataObjects.TagDO;
import kim.xiaom.blog.entity.queryObjects.TagExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TagMapper {
    long countByExample(TagExample example);

    int deleteByExample(TagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TagDO record);

    int insertSelective(TagDO record);

    List<TagDO> selectByExample(TagExample example);

    TagDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TagDO record, @Param("example") TagExample example);

    int updateByExample(@Param("record") TagDO record, @Param("example") TagExample example);

    int updateByPrimaryKeySelective(TagDO record);

    int updateByPrimaryKey(TagDO record);
}