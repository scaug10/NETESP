package com.g10.ssm.mapper;

import com.g10.ssm.po.Practice;
import com.g10.ssm.po.PracticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PracticeMapper {
    int countByExample(PracticeExample example);

    int deleteByExample(PracticeExample example);

    int deleteByPrimaryKey(Integer practiceId);

    int insert(Practice record);

    int insertSelective(Practice record);

    List<Practice> selectByExample(PracticeExample example);

    Practice selectByPrimaryKey(Integer practiceId);

    int updateByExampleSelective(@Param("record") Practice record, @Param("example") PracticeExample example);

    int updateByExample(@Param("record") Practice record, @Param("example") PracticeExample example);

    int updateByPrimaryKeySelective(Practice record);

    int updateByPrimaryKey(Practice record);
}