package com.g10.ssm.mapper.forum;

import java.util.List;

import com.g10.ssm.po.forum.Theme;
import com.g10.ssm.po.forum.ThemeCustom;

public interface ThemeCustomMapper {
	
	public List<ThemeCustom> selectByTheme(ThemeCustom themeCustom) throws Exception;
	
	public List<ThemeCustom> selectByTopicName(String topicName) throws Exception;
	
}
