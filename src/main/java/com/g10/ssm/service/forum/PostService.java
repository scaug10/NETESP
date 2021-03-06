package com.g10.ssm.service.forum;

import java.util.List;

import com.g10.ssm.po.forum.Post;
import com.g10.ssm.po.forum.PostCustom;
import com.g10.ssm.po.forum.PostQueryVo;

/**
 * @ClassName: PostService
 * @Description: 帖子删除、创建、更新、查找操作
 * @author FYW
 * @date 2017年8月10日 上午10:13:08
 */
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

	public int createPost(Post postCustom) throws Exception;

	public int updatePostByPrimaryKey(Integer postId, PostCustom postCustom)
			throws Exception;

	public PostCustom selectPostByPrimaryKey(Integer postId) throws Exception;

	public PostCustom selectLastPostByThemeId(Integer themeId) throws Exception;

	public Integer countPostsByThemeId(Integer themeId) throws Exception;

	public List<PostCustom> selectPostsByPagingAndThemeId(PostQueryVo postVo)
			throws Exception;

}
