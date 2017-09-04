package com.g10.ssm.mapper.testdatabase;

import com.g10.ssm.po.testdatabase.StrategyTestDatabaseClassificationExample;
import com.g10.ssm.po.testdatabase.StrategyTestDatabaseClassificationKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StrategyTestDatabaseClassificationMapper {
    int countByExample(StrategyTestDatabaseClassificationExample example);

    int deleteByExample(StrategyTestDatabaseClassificationExample example);

    int deleteByPrimaryKey(StrategyTestDatabaseClassificationKey key);

    int insert(StrategyTestDatabaseClassificationKey record);

    int insertSelective(StrategyTestDatabaseClassificationKey record);

    List<StrategyTestDatabaseClassificationKey> selectByExample(StrategyTestDatabaseClassificationExample example);

    int updateByExampleSelective(@Param("record") StrategyTestDatabaseClassificationKey record, @Param("example") StrategyTestDatabaseClassificationExample example);

    int updateByExample(@Param("record") StrategyTestDatabaseClassificationKey record, @Param("example") StrategyTestDatabaseClassificationExample example);
}