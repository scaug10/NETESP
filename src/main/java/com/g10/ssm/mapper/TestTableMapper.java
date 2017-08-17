package com.g10.ssm.mapper;

import com.g10.ssm.po.TestTable;
import com.g10.ssm.po.TestTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestTableMapper {
    int countByExample(TestTableExample example);

    int deleteByExample(TestTableExample example);

    int deleteByPrimaryKey(Integer testId);

    int insert(TestTable record);

    int insertSelective(TestTable record);

    List<TestTable> selectByExample(TestTableExample example);

    TestTable selectByPrimaryKey(Integer testId);

    int updateByExampleSelective(@Param("record") TestTable record, @Param("example") TestTableExample example);

    int updateByExample(@Param("record") TestTable record, @Param("example") TestTableExample example);

    int updateByPrimaryKeySelective(TestTable record);

    int updateByPrimaryKey(TestTable record);
}