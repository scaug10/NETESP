package com.g10.ssm.mapper.testdatabase;

import com.g10.ssm.po.testdatabase.StrategyQuestionTypesExample;
import com.g10.ssm.po.testdatabase.StrategyQuestionTypesKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StrategyQuestionTypesMapper {
    int countByExample(StrategyQuestionTypesExample example);

    int deleteByExample(StrategyQuestionTypesExample example);

    int deleteByPrimaryKey(StrategyQuestionTypesKey key);

    int insert(StrategyQuestionTypesKey record);

    int insertSelective(StrategyQuestionTypesKey record);

    List<StrategyQuestionTypesKey> selectByExample(StrategyQuestionTypesExample example);

    int updateByExampleSelective(@Param("record") StrategyQuestionTypesKey record, @Param("example") StrategyQuestionTypesExample example);

    int updateByExample(@Param("record") StrategyQuestionTypesKey record, @Param("example") StrategyQuestionTypesExample example);
}