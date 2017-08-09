package com.g10.ssm.mapper.forum;

import java.util.List;

import com.g10.ssm.po.forum.PostCustom;

public interface PostCustomMapper {

	public List<PostCustom> selectByPostCustom(PostCustom postCustom)
			throws Exception;

	public List<PostCustom> selectByThemeId(Integer themeId) throws Exception;

}
