package com.g10.ssm.mapper.knowledge;

import com.g10.ssm.po.knowledge.RepositoryCategory;
import com.g10.ssm.po.knowledge.RepositoryCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepositoryCategoryMapper {
    int countByExample(RepositoryCategoryExample example);

    int deleteByExample(RepositoryCategoryExample example);

    int deleteByPrimaryKey(Integer categoryId);

    int insert(RepositoryCategory record);

    int insertSelective(RepositoryCategory record);

    List<RepositoryCategory> selectByExample(RepositoryCategoryExample example);

    RepositoryCategory selectByPrimaryKey(Integer categoryId);

    int updateByExampleSelective(@Param("record") RepositoryCategory record, @Param("example") RepositoryCategoryExample example);

    int updateByExample(@Param("record") RepositoryCategory record, @Param("example") RepositoryCategoryExample example);

    int updateByPrimaryKeySelective(RepositoryCategory record);

    int updateByPrimaryKey(RepositoryCategory record);
}