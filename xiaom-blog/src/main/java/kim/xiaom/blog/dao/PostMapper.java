package kim.xiaom.blog.dao;

import java.util.List;
import kim.xiaom.blog.entity.dataObjects.Post;
import kim.xiaom.blog.entity.queryObjects.PostExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostMapper {
    long countByExample(PostExample example);

    int deleteByExample(PostExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Post record);

    int insertSelective(Post record);

    List<Post> selectByExample(PostExample example);

    Post selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Post record, @Param("example") PostExample example);

    int updateByExample(@Param("record") Post record, @Param("example") PostExample example);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);
}