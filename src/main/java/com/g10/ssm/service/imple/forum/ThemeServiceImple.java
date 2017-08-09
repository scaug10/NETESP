package com.g10.ssm.service.imple.forum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.g10.ssm.mapper.forum.ThemeCustomMapper;
import com.g10.ssm.mapper.forum.ThemeMapper;
import com.g10.ssm.po.forum.Theme;
import com.g10.ssm.po.forum.ThemeCustom;
import com.g10.ssm.service.forum.ThemeService;

public class ThemeServiceImple implements ThemeService{

	@Autowired
	private ThemeMapper themeMapper;

	@Autowired
	private ThemeCustomMapper themeCustomMapper;
	
	@Override
	public int deleteThemeByPrimaryKey(int topicId) throws Exception {
		if (topicId != 0) {
			// 先从数据库找到这条信息
			Theme theme = themeMapper.selectByPrimaryKey(topicId);

			// 如果未找到该主题，返回未找到主题的数据库的错误信息
			if (theme != null) {
				// 先删除该主题里的所有帖子信息

				// 如果删除成功则删除该主题
				int result = themeMapper.deleteByPrimaryKey(topicId);
				// 返回信息
				return result;
			}
		}
		return 0;
	}

	@Override
	public List<ThemeCustom> selectThemesByTheme(ThemeCustom themeCustom)
			throws Exception {
		if(themeCustom != null){
			List<ThemeCustom> themeCustoms = themeCustomMapper.selectByTheme(themeCustom);
			return themeCustoms;
		}
		return null;
	}

	@Override
	public List<ThemeCustom> selectThemesByName(String topicName)
			throws Exception {
		if(topicName != null){
			List<ThemeCustom> themeCustoms = themeCustomMapper.selectByTopicName(topicName);
			return themeCustoms;
		}
		return null;
	}

}
