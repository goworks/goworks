package cn.asdfz.diary.dao;

import cn.asdfz.diary.entity.dataObjects.Dream;
import cn.asdfz.diary.entity.queryObjects.DreamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DreamMapper {
    long countByExample(DreamExample example);

    int deleteByExample(DreamExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dream record);

    int insertSelective(Dream record);

    List<Dream> selectByExample(DreamExample example);

    Dream selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dream record, @Param("example") DreamExample example);

    int updateByExample(@Param("record") Dream record, @Param("example") DreamExample example);

    int updateByPrimaryKeySelective(Dream record);

    int updateByPrimaryKey(Dream record);
}