package kim.xiaom.blog.dao;

import java.util.List;
import kim.xiaom.blog.entity.dataObjects.PostDO;
import kim.xiaom.blog.entity.queryObjects.PostExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostMapper {
    long countByExample(PostExample example);

    int deleteByExample(PostExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PostDO record);

    int insertSelective(PostDO record);

    List<PostDO> selectByExample(PostExample example);

    PostDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PostDO record, @Param("example") PostExample example);

    int updateByExample(@Param("record") PostDO record, @Param("example") PostExample example);

    int updateByPrimaryKeySelective(PostDO record);

    int updateByPrimaryKey(PostDO record);
}