package com.g10.ssm.service.forum;

import java.util.List;

import com.g10.ssm.po.forum.PostComment;
import com.g10.ssm.po.forum.PostCommentCustom;

/**
 * @ClassName: PostCommentService
 * @Description: 帖子评论创建、更新、查找、删除、审核操作
 * @author FYW
 * @date 2017年8月10日 上午10:13:35
 */
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
	public int shieldPostCommentByPrimaryKey(Integer postCommentId)
			throws Exception;

	/**
	 * @Title: deletePostCommentByPrimaryKey
	 * @Description: 根据主键删除帖子评论
	 * @param postCommentId
	 * @param @throws Exception
	 * @return int
	 */
	public int deletePostCommentByPrimaryKey(Integer postCommentId)
			throws Exception;

	/**
	 * @Title: insertPostCommentSelective
	 * @Description: 插入一条评论信息
	 * @param postCommentCustom
	 * @param @throws Exception
	 * @return int
	 */
	public int insertPostCommentSelective(PostComment postCommentCustom)
			throws Exception;

	public List<PostCommentCustom> selectPostCommentByPostId(Integer postId)
			throws Exception;

	public PostCommentCustom selectPostCommentCustomByPrimaryKey(
			Integer postCommentId) throws Exception;

	public int updatePostCommentCustomByPrimaryKey(Integer postCommentId,
			PostCommentCustom postCommentCustom) throws Exception;

	public Integer countPostCommentByPostId(Integer postId) throws Exception;

}
