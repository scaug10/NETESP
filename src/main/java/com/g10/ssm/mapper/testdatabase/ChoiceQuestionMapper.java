package com.g10.ssm.mapper.testdatabase;

import com.g10.ssm.po.testdatabase.ChoiceQuestion;
import com.g10.ssm.po.testdatabase.ChoiceQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChoiceQuestionMapper {
    int countByExample(ChoiceQuestionExample example);

    int deleteByExample(ChoiceQuestionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ChoiceQuestion record);

    int insertSelective(ChoiceQuestion record);

    List<ChoiceQuestion> selectByExample(ChoiceQuestionExample example);

    ChoiceQuestion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ChoiceQuestion record, @Param("example") ChoiceQuestionExample example);

    int updateByExample(@Param("record") ChoiceQuestion record, @Param("example") ChoiceQuestionExample example);

    int updateByPrimaryKeySelective(ChoiceQuestion record);

    int updateByPrimaryKey(ChoiceQuestion record);
}