package com.g10.ssm.service.forum;

import java.util.List;

import com.g10.ssm.po.forum.PostCustom;

public interface PostService {
	
	/**
	 * @Title: deletePostByPrimaryKey
	 * @Description: 根据postId删除帖子，如果要删除某个帖子，那么必须先删除当前帖子下的所有评论。
	 * @param postId
	 * @throws Exception
	 * @return int
	 */
	public int deletePostByPrimaryKey(Integer postId) throws Exception;

	/**
	 * @Title: selectPostsByPost
	 * @Description: 根据传入的postCustom查询帖子
	 * @param postCustom
	 * @throws Exception
	 * @return List<PostCustom>
	 */
	public List<PostCustom> selectPostsByPost(PostCustom postCustom)
			throws Exception;
	
	/**
	 * @Title: selectPostsByThemeId 
	 * @Description: 根据主题id查找该主题下的所有帖子
	 * @param themeId
	 * @throws Exception
	 * @return List<PostCustom>
	 */
	public List<PostCustom> selectPostsByThemeId(Integer themeId)
		throws Exception;
	
	public int createPost(PostCustom postCustom) throws Exception;
	
	public int updatePostByPrimaryKey(Integer postId, PostCustom postCustom) throws Exception;
	
	public PostCustom selectPostByPrimaryKey(Integer postId) throws Exception;
	
}
