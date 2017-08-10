package com.g10.ssm.service.forum;

import java.util.List;

import com.g10.ssm.po.forum.Theme;
import com.g10.ssm.po.forum.ThemeCustom;

/**
 * @ClassName: ThemeService
 * @Description: 主题删除、创建、更新、查找操作
 * @author 	FYW
 * @date 	2017年8月10日 上午10:11:56
 */
public interface ThemeService {
	/**
	 * @Title: deleteThreadByPrimaryKey
	 * @Description: <p>
	 *               根据主题id删除主题,如果要删除一个主题，那么必须先删除当前主题下的所有帖子。
	 *               <p>
	 * @param topicId
	 * @throws Exception
	 * @return int
	 */
	public int deleteThemeByPrimaryKey(int topicId) throws Exception;

	/**
	 * @Title: selectThreadsByThread
	 * @Description: 根据传入的threadCustom查询主题
	 * @param threadCustom
	 * @throws Exception
	 * @return List<ThreadCustom>
	 */
	public List<ThemeCustom> selectThemesByTheme(ThemeCustom themeCustom)
			throws Exception;

	/**
	 * @Title: selectThemesByName
	 * @Description: 根据传入的topicName进行模糊查找
	 * @param topicName
	 * @throws Exception
	 * @return List<ThemeCustom>
	 */
	public List<ThemeCustom> selectThemesByName(String topicName)
			throws Exception;

	public Theme selectThemeByPrimaryKey(Integer themeId) throws Exception;

	public int createTheme(ThemeCustom themeCustom) throws Exception;

	public int updateThemeByPrimaryKeySelective(Integer themeId,
			ThemeCustom themeCustom) throws Exception;
}
