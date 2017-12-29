package cn.asdfz.diary.dao;

import cn.asdfz.diary.entity.dataObjects.Diary;
import cn.asdfz.diary.entity.queryObjects.DiaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryMapper {
    long countByExample(DiaryExample example);

    int deleteByExample(DiaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Diary record);

    int insertSelective(Diary record);

    List<Diary> selectByExample(DiaryExample example);

    Diary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Diary record, @Param("example") DiaryExample example);

    int updateByExample(@Param("record") Diary record, @Param("example") DiaryExample example);

    int updateByPrimaryKeySelective(Diary record);

    int updateByPrimaryKey(Diary record);
}