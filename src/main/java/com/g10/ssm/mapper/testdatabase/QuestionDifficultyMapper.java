package com.g10.ssm.mapper.testdatabase;

import com.g10.ssm.po.testdatabase.QuestionDifficulty;
import com.g10.ssm.po.testdatabase.QuestionDifficultyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionDifficultyMapper {
    int countByExample(QuestionDifficultyExample example);

    int deleteByExample(QuestionDifficultyExample example);

    int deleteByPrimaryKey(Integer difficultyId);

    int insert(QuestionDifficulty record);

    int insertSelective(QuestionDifficulty record);

    List<QuestionDifficulty> selectByExample(QuestionDifficultyExample example);

    QuestionDifficulty selectByPrimaryKey(Integer difficultyId);

    int updateByExampleSelective(@Param("record") QuestionDifficulty record, @Param("example") QuestionDifficultyExample example);

    int updateByExample(@Param("record") QuestionDifficulty record, @Param("example") QuestionDifficultyExample example);

    int updateByPrimaryKeySelective(QuestionDifficulty record);

    int updateByPrimaryKey(QuestionDifficulty record);
}