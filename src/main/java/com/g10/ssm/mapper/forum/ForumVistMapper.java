package com.g10.ssm.mapper.forum;

import com.g10.ssm.po.forum.ForumVist;
import com.g10.ssm.po.forum.ForumVistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ForumVistMapper {
    int countByExample(ForumVistExample example);

    int deleteByExample(ForumVistExample example);

    int deleteByPrimaryKey(Integer forumVisitId);

    int insert(ForumVist record);

    int insertSelective(ForumVist record);

    List<ForumVist> selectByExample(ForumVistExample example);

    ForumVist selectByPrimaryKey(Integer forumVisitId);

    int updateByExampleSelective(@Param("record") ForumVist record, @Param("example") ForumVistExample example);

    int updateByExample(@Param("record") ForumVist record, @Param("example") ForumVistExample example);

    int updateByPrimaryKeySelective(ForumVist record);

    int updateByPrimaryKey(ForumVist record);
}