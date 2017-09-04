package com.g10.ssm.mapper.testdatabase;

import com.g10.ssm.po.testdatabase.Strategy;
import com.g10.ssm.po.testdatabase.StrategyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StrategyMapper {
    int countByExample(StrategyExample example);

    int deleteByExample(StrategyExample example);

    int deleteByPrimaryKey(Integer strategyId);

    int insert(Strategy record);

    int insertSelective(Strategy record);

    List<Strategy> selectByExample(StrategyExample example);

    Strategy selectByPrimaryKey(Integer strategyId);

    int updateByExampleSelective(@Param("record") Strategy record, @Param("example") StrategyExample example);

    int updateByExample(@Param("record") Strategy record, @Param("example") StrategyExample example);

    int updateByPrimaryKeySelective(Strategy record);

    int updateByPrimaryKey(Strategy record);
}