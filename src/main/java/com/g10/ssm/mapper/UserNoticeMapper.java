package com.g10.ssm.mapper;

import com.g10.ssm.po.UserNoticeExample;
import com.g10.ssm.po.UserNoticeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserNoticeMapper {
    int countByExample(UserNoticeExample example);

    int deleteByExample(UserNoticeExample example);

    int deleteByPrimaryKey(UserNoticeKey key);

    int insert(UserNoticeKey record);

    int insertSelective(UserNoticeKey record);

    List<UserNoticeKey> selectByExample(UserNoticeExample example);

    int updateByExampleSelective(@Param("record") UserNoticeKey record, @Param("example") UserNoticeExample example);

    int updateByExample(@Param("record") UserNoticeKey record, @Param("example") UserNoticeExample example);
}