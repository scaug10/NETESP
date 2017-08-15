package com.g10.ssm.mapper.forum;

import com.g10.ssm.po.forum.Theme;
import com.g10.ssm.po.forum.ThemeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThemeMapper {
    int countByExample(ThemeExample example);

    int deleteByExample(ThemeExample example);

    int deleteByPrimaryKey(Integer topicId);

    int insert(Theme record);

    int insertSelective(Theme record);

    List<Theme> selectByExample(ThemeExample example);

    Theme selectByPrimaryKey(Integer topicId);

    int updateByExampleSelective(@Param("record") Theme record, @Param("example") ThemeExample example);

    int updateByExample(@Param("record") Theme record, @Param("example") ThemeExample example);

    int updateByPrimaryKeySelective(Theme record);

    int updateByPrimaryKey(Theme record);
}