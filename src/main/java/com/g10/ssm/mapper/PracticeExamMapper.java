package com.g10.ssm.mapper;

import com.g10.ssm.po.PracticeExamExample;
import com.g10.ssm.po.PracticeExamKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PracticeExamMapper {
    int countByExample(PracticeExamExample example);

    int deleteByExample(PracticeExamExample example);

    int deleteByPrimaryKey(PracticeExamKey key);

    int insert(PracticeExamKey record);

    int insertSelective(PracticeExamKey record);

    List<PracticeExamKey> selectByExample(PracticeExamExample example);

    int updateByExampleSelective(@Param("record") PracticeExamKey record, @Param("example") PracticeExamExample example);

    int updateByExample(@Param("record") PracticeExamKey record, @Param("example") PracticeExamExample example);
}