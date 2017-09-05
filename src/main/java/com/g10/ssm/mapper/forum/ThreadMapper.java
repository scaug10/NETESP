package com.g10.ssm.mapper.forum;

import com.g10.ssm.po.forum.Thread;
import com.g10.ssm.po.forum.ThreadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThreadMapper {
    int countByExample(ThreadExample example);

    int deleteByExample(ThreadExample example);

    int deleteByPrimaryKey(Integer topicId);

    int insert(Thread record);

    int insertSelective(Thread record);

    List<Thread> selectByExample(ThreadExample example);

    Thread selectByPrimaryKey(Integer topicId);

    int updateByExampleSelective(@Param("record") Thread record, @Param("example") ThreadExample example);

    int updateByExample(@Param("record") Thread record, @Param("example") ThreadExample example);

    int updateByPrimaryKeySelective(Thread record);

    int updateByPrimaryKey(Thread record);
}