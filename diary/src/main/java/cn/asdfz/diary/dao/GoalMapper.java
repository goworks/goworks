package cn.asdfz.diary.dao;

import cn.asdfz.diary.entity.dataObjects.Goal;
import cn.asdfz.diary.entity.queryObjects.GoalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalMapper {
    long countByExample(GoalExample example);

    int deleteByExample(GoalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Goal record);

    int insertSelective(Goal record);

    List<Goal> selectByExample(GoalExample example);

    Goal selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Goal record, @Param("example") GoalExample example);

    int updateByExample(@Param("record") Goal record, @Param("example") GoalExample example);

    int updateByPrimaryKeySelective(Goal record);

    int updateByPrimaryKey(Goal record);
}