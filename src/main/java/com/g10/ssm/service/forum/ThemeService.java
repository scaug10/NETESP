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

	/**
	 * @Title: selectThemeByPrimaryKey 
	 * @Description: 根据主键获取主题内容
	 * @param themeId
	 * @throws Exception
	 * @return Theme
	 */
	public Theme selectThemeByPrimaryKey(Integer themeId) throws Exception;

	/**
	 * @Title: createTheme 
	 * @Description: 保存创建的主题
	 * @param themeCustom 创建的主题
	 * @throws Exception
	 * @return int
	 */
	public int createTheme(Theme themeCustom) throws Exception;

	/**
	 * @Title: updateThemeByPrimaryKeySelective 
	 * @Description: 根据主键更新主题
	 * @param themeId
	 * @param themeCustom
	 * @throws Exception
	 * @return int
	 */
	public int updateThemeByPrimaryKeySelective(Integer themeId,
			Theme themeCustom) throws Exception;
	
	/**
	 * @Title: selectThemesByPaging 
	 * @Description: 通过分页获取板块内的主题信息
	 * @param pageNum 分页号
	 * @throws Exception
	 * @return List<ThemeCustom>
	 */
	public List<ThemeCustom> selectThemesByPaging(ThemeCustom themeCustom) throws Exception;
	
	public Integer countThemesByBoardId(Integer boardId) throws Exception;
	
}
