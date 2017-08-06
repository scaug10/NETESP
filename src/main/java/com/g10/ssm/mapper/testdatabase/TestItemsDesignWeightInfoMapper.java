package com.g10.ssm.mapper.testdatabase;

import com.g10.ssm.po.testdatabase.TestItemsDesignWeightInfo;
import com.g10.ssm.po.testdatabase.TestItemsDesignWeightInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestItemsDesignWeightInfoMapper {
    int countByExample(TestItemsDesignWeightInfoExample example);

    int deleteByExample(TestItemsDesignWeightInfoExample example);

    int deleteByPrimaryKey(Integer weightId);

    int insert(TestItemsDesignWeightInfo record);

    int insertSelective(TestItemsDesignWeightInfo record);

    List<TestItemsDesignWeightInfo> selectByExample(TestItemsDesignWeightInfoExample example);

    TestItemsDesignWeightInfo selectByPrimaryKey(Integer weightId);

    int updateByExampleSelective(@Param("record") TestItemsDesignWeightInfo record, @Param("example") TestItemsDesignWeightInfoExample example);

    int updateByExample(@Param("record") TestItemsDesignWeightInfo record, @Param("example") TestItemsDesignWeightInfoExample example);

    int updateByPrimaryKeySelective(TestItemsDesignWeightInfo record);

    int updateByPrimaryKey(TestItemsDesignWeightInfo record);
}