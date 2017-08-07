package com.g10.ssm.mapper.testdatabase;

import com.g10.ssm.po.testdatabase.ClassificationOfTestdatabase;
import com.g10.ssm.po.testdatabase.ClassificationOfTestdatabaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassificationOfTestdatabaseMapper {
    int countByExample(ClassificationOfTestdatabaseExample example);

    int deleteByExample(ClassificationOfTestdatabaseExample example);

    int deleteByPrimaryKey(Integer testDatabaseId);

    int insert(ClassificationOfTestdatabase record);

    int insertSelective(ClassificationOfTestdatabase record);

    List<ClassificationOfTestdatabase> selectByExample(ClassificationOfTestdatabaseExample example);

    ClassificationOfTestdatabase selectByPrimaryKey(Integer testDatabaseId);

    int updateByExampleSelective(@Param("record") ClassificationOfTestdatabase record, @Param("example") ClassificationOfTestdatabaseExample example);

    int updateByExample(@Param("record") ClassificationOfTestdatabase record, @Param("example") ClassificationOfTestdatabaseExample example);

    int updateByPrimaryKeySelective(ClassificationOfTestdatabase record);

    int updateByPrimaryKey(ClassificationOfTestdatabase record);
}