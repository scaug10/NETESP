package com.g10.ssm.mapper.testdatabase;

import com.g10.ssm.po.testdatabase.ExamTypeWeightExample;
import com.g10.ssm.po.testdatabase.ExamTypeWeightKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamTypeWeightMapper {
    int countByExample(ExamTypeWeightExample example);

    int deleteByExample(ExamTypeWeightExample example);

    int deleteByPrimaryKey(ExamTypeWeightKey key);

    int insert(ExamTypeWeightKey record);

    int insertSelective(ExamTypeWeightKey record);

    List<ExamTypeWeightKey> selectByExample(ExamTypeWeightExample example);

    int updateByExampleSelective(@Param("record") ExamTypeWeightKey record, @Param("example") ExamTypeWeightExample example);

    int updateByExample(@Param("record") ExamTypeWeightKey record, @Param("example") ExamTypeWeightExample example);
}