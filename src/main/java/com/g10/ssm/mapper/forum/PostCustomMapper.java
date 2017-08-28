package com.g10.ssm.mapper.forum;

import java.util.List;

import com.g10.ssm.po.forum.PostCustom;
import com.g10.ssm.po.forum.PostQueryVo;

public interface PostCustomMapper {

	public List<PostCustom> selectByPostCustom(PostCustom postCustom)
			throws Exception;

	public List<PostCustom> selectByThemeId(Integer themeId) throws Exception;

	public PostCustom selectLastPostByThemeId(Integer themeId) throws Exception;

	public Integer countPostsByThemeId(Integer themeId) throws Exception;

	public List<PostCustom> selectPostsByPagingAndThemeId(
			PostQueryVo postQueryVo) throws Exception;

}
