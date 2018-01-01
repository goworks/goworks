package kim.xiaom.blog.dao;

import java.util.List;
import kim.xiaom.blog.entity.dataObjects.CommentDO;
import kim.xiaom.blog.entity.queryObjects.CommentExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentMapper {
    long countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CommentDO record);

    int insertSelective(CommentDO record);

    List<CommentDO> selectByExample(CommentExample example);

    CommentDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommentDO record, @Param("example") CommentExample example);

    int updateByExample(@Param("record") CommentDO record, @Param("example") CommentExample example);

    int updateByPrimaryKeySelective(CommentDO record);

    int updateByPrimaryKey(CommentDO record);
}