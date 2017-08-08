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
	 * @Description: 根据论坛的主键删除数据库论坛信息
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
	
	/**
	 * @Title: checkBoardByPrimaryKey
	 * @Description: 审核板块，记录审核的结果与审核状态
	 * @param boardId
	 * @param boardCustom
	 * @throws Exception
	 * @return int
	 */
	public int checkBoardByPrimaryKey(int boardId, BoardCustom boardCustom) throws Exception;
	
	/**
	 * @Title: checkPostByPrimaryKey 
	 * @Description: 审核帖子，记录审核结果与审核状态
	 * @param postId
	 * @param postCustom
	 * @throws Exception
	 * @return int
	 */
	public int checkPostByPrimaryKey(int postId, PostCustom postCustom) throws Exception;
	
	/**
	 * @Title: deleteThreadByPrimaryKey 
	 * @Description: 根据主题id删除主题
	 * @param topicId
	 * @throws Exception
	 * @return int
	 */
	public int deleteThreadByPrimaryKey(int topicId) throws Exception;
}
