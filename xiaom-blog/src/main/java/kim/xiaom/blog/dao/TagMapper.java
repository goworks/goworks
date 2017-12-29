package kim.xiaom.blog.dao;

import java.util.List;
import kim.xiaom.blog.entity.dataObjects.Tag;
import kim.xiaom.blog.entity.queryObjects.TagExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TagMapper {
    long countByExample(TagExample example);

    int deleteByExample(TagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tag record);

    int insertSelective(Tag record);

    List<Tag> selectByExample(TagExample example);

    Tag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tag record, @Param("example") TagExample example);

    int updateByExample(@Param("record") Tag record, @Param("example") TagExample example);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
}