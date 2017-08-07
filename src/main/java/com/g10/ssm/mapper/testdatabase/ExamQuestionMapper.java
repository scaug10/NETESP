package com.g10.ssm.mapper.testdatabase;

import com.g10.ssm.po.testdatabase.ExamQuestionExample;
import com.g10.ssm.po.testdatabase.ExamQuestionKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamQuestionMapper {
    int countByExample(ExamQuestionExample example);

    int deleteByExample(ExamQuestionExample example);

    int deleteByPrimaryKey(ExamQuestionKey key);

    int insert(ExamQuestionKey record);

    int insertSelective(ExamQuestionKey record);

    List<ExamQuestionKey> selectByExample(ExamQuestionExample example);

    int updateByExampleSelective(@Param("record") ExamQuestionKey record, @Param("example") ExamQuestionExample example);

    int updateByExample(@Param("record") ExamQuestionKey record, @Param("example") ExamQuestionExample example);
}