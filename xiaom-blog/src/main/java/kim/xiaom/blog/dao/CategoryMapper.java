package kim.xiaom.blog.dao;

import java.util.List;
import kim.xiaom.blog.entity.dataObjects.CategoryDO;
import kim.xiaom.blog.entity.queryObjects.CategoryExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryMapper {
    long countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CategoryDO record);

    int insertSelective(CategoryDO record);

    List<CategoryDO> selectByExample(CategoryExample example);

    CategoryDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CategoryDO record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") CategoryDO record, @Param("example") CategoryExample example);

    int updateByPrimaryKeySelective(CategoryDO record);

    int updateByPrimaryKey(CategoryDO record);
}