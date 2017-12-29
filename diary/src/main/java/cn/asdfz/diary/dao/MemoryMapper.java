package cn.asdfz.diary.dao;

import cn.asdfz.diary.entity.dataObjects.Memory;
import cn.asdfz.diary.entity.queryObjects.MemoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoryMapper {
    long countByExample(MemoryExample example);

    int deleteByExample(MemoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Memory record);

    int insertSelective(Memory record);

    List<Memory> selectByExample(MemoryExample example);

    Memory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Memory record, @Param("example") MemoryExample example);

    int updateByExample(@Param("record") Memory record, @Param("example") MemoryExample example);

    int updateByPrimaryKeySelective(Memory record);

    int updateByPrimaryKey(Memory record);
}