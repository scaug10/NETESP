package com.g10.ssm.service.forum;

import java.util.List;

import com.g10.ssm.po.forum.PostCommentCustom;

public interface PostCommentService {
	/**
	 * @Title: selectPostCommentsByPostComment
	 * @Description: 根据传入的postCommentCustom查询帖子评论
	 * @param postCommentCustom
	 * @throws Exception
	 * @return List<PostCommentCustom>
	 */
	public List<PostCommentCustom> selectPostCommentsByPostComment(
			PostCommentCustom postCommentCustom) throws Exception;

	/**
	 * @Title: shieldPostCommentByPrimaryKey
	 * @Description: 根据传入的id更新评论信息（屏蔽评论）
	 * @param postCommentId
	 * @throws Exception
	 * @return int
	 */
	public int shieldPostCommentByPrimaryKey(int postCommentId)
			throws Exception;

	/**
	 * @Title: deletePostCommentByPrimaryKey
	 * @Description: 根据主键删除帖子评论
	 * @param postCommentId
	 * @param @throws Exception
	 * @return int
	 */
	public int deletePostCommentByPrimaryKey(int postCommentId)
			throws Exception;

	/**
	 * @Title: insertPostCommentSelective 
	 * @Description: 插入一条评论信息
	 * @param postCommentCustom
	 * @param @throws Exception
	 * @return int
	 */
	public int insertPostCommentSelective(PostCommentCustom postCommentCustom)
			throws Exception;
}
