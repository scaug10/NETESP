package com.g10.ssm.service.forum;

import com.g10.ssm.po.forum.BoardCustom;
import com.g10.ssm.po.forum.PostCustom;

public interface ForumManageService {
	
	/**
	 * @Title: createBoard
	 * @Description: 创建板块
	 * @param boardCustom 论坛版块
	 * @throws Exception
	 * @return int 是否创建成功
	 */
	public int createBoard(BoardCustom boardCustom) throws Exception;
	
	/**
	 * @Title: updateBoardBoardNumByPrimaryKey
	 * @Description:  通过主键更新论坛排序的序号
	 * @param boardId
	 * @param boardCustom
	 * @throws Exception
	 * @return int 是否更新成功
	 */
	public int updateBoardBoardNumByPrimaryKey(int boardId, BoardCustom boardCustom) throws Exception;
	
	/**
	 * @Title: updateBoardByPrimaryKeySelective 
	 * @Description: 根据板块id更新板块
	 * @param boardId
	 * @param boardCustom
	 * @throws Exception
	 * @return int
	 */
	public int updateBoardByPrimaryKeySelective(int boardId, BoardCustom boardCustom) throws Exception;
	
	/**
	 * @Title: deleteBoardByPrimaryKey 
	 * @Description: 根据论坛的主键删除论坛，如果要删除论坛，必须先删除论坛下的所有主题。
	 * @param boardId
	 * @throws Exception
	 * @return int
	 */
	public int deleteBoardByPrimaryKey(int boardId) throws Exception;
	
	/**
	 * @Title: shieldPostCommentByPrimaryKey 
	 * @Description: 根据传入的id更新评论信息（屏蔽评论）
	 * @param postCommentId
	 * @throws Exception
	 * @return int
	 */
	public int shieldPostCommentByPrimaryKey(int postCommentId) throws Exception;
	
//	/**
//	 * @Title: checkBoardByPrimaryKey
//	 * @Description: 审核板块，记录审核的结果与审核状态
//	 * @param boardId
//	 * @param boardCustom
//	 * @throws Exception
//	 * @return int
//	 */
//	public int checkBoardByPrimaryKey(int boardId, BoardCustom boardCustom) throws Exception;
	
//	/**
//	 * @Title: checkPostByPrimaryKey 
//	 * @Description: 审核帖子，记录审核结果与审核状态
//	 * @param postId
//	 * @param postCustom
//	 * @throws Exception
//	 * @return int
//	 */
//	public int checkPostByPrimaryKey(int postId, PostCustom postCustom) throws Exception;
	
	/**
	 * @Title: deleteThreadByPrimaryKey 
	 * @Description: <p>根据主题id删除主题,如果要删除一个主题，那么必须先删除当前主题下的所有帖子。<p>
	 * @param topicId
	 * @throws Exception
	 * @return int
	 */
	public int deleteThemeByPrimaryKey(int topicId) throws Exception;
	
	/**
	 * @Title: deletePostByPrimaryKey 
	 * @Description: 根据postId删除帖子，如果要删除某个帖子，那么必须先删除当前帖子下的所有评论。
	 * @param postId
	 * @param @throws Exception
	 * @return int
	 */
	public int deletePostByPrimaryKey(int postId) throws Exception;
	
	/**
	 * @Title: deletePostCommentByPrimaryKey 
	 * @Description: 根据主键删除帖子评论
	 * @param postCommentId
	 * @param @throws Exception
	 * @return int
	 */
	public int deletePostCommentByPrimaryKey(int postCommentId) throws Exception;
}
