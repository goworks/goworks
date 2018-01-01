package kim.xiaom.blog.dao;

import java.util.List;
import kim.xiaom.blog.entity.dataObjects.UserDO;
import kim.xiaom.blog.entity.queryObjects.UserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    List<UserDO> selectByExample(UserExample example);

    UserDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserDO record, @Param("example") UserExample example);

    int updateByExample(@Param("record") UserDO record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);
}