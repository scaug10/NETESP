package com.g10.ssm.mapper;

import com.g10.ssm.po.ExamineTable;
import com.g10.ssm.po.ExamineTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamineTableMapper {
    int countByExample(ExamineTableExample example);

    int deleteByExample(ExamineTableExample example);

    int deleteByPrimaryKey(Integer reviewId);

    int insert(ExamineTable record);

    int insertSelective(ExamineTable record);

    List<ExamineTable> selectByExample(ExamineTableExample example);

    ExamineTable selectByPrimaryKey(Integer reviewId);

    int updateByExampleSelective(@Param("record") ExamineTable record, @Param("example") ExamineTableExample example);

    int updateByExample(@Param("record") ExamineTable record, @Param("example") ExamineTableExample example);

    int updateByPrimaryKeySelective(ExamineTable record);

    int updateByPrimaryKey(ExamineTable record);
}