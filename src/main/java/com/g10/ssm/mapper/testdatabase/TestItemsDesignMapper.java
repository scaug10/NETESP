package com.g10.ssm.mapper.testdatabase;

import com.g10.ssm.po.testdatabase.TestItemsDesign;
import com.g10.ssm.po.testdatabase.TestItemsDesignExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestItemsDesignMapper {
    int countByExample(TestItemsDesignExample example);

    int deleteByExample(TestItemsDesignExample example);

    int deleteByPrimaryKey(Integer testItemsDesignId);

    int insert(TestItemsDesign record);

    int insertSelective(TestItemsDesign record);

    List<TestItemsDesign> selectByExample(TestItemsDesignExample example);

    TestItemsDesign selectByPrimaryKey(Integer testItemsDesignId);

    int updateByExampleSelective(@Param("record") TestItemsDesign record, @Param("example") TestItemsDesignExample example);

    int updateByExample(@Param("record") TestItemsDesign record, @Param("example") TestItemsDesignExample example);

    int updateByPrimaryKeySelective(TestItemsDesign record);

    int updateByPrimaryKey(TestItemsDesign record);
}