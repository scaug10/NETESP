package com.g10.ssm.service.forum;

import com.g10.ssm.po.forum.Board;

public interface ForumManageService {
	
	/**
	 * @Title: createBoard
	 * @Description: 创建板块
	 * @param board 论坛版块
	 * @throws Exception
	 * @return int 是否创建成功
	 */
	public int createBoard(Board board) throws Exception;
	
	/**
	 * @Title: updateBoardBoardNumByPrimaryKey
	 * @Description:  通过主键更新论坛排序的序号
	 * @param boardId
	 * @param board
	 * @throws Exception
	 * @return int 是否更新成功
	 */
	public int updateBoardBoardNumByPrimaryKey(int boardId, Board board) throws Exception;
	
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
	 * @Title: checkBoardByPrimary 
	 * @Description: 审核板块，记录审核的结果与审核状态
	 * @param boardId
	 * @param board
	 * @param @throws Exception
	 * @return int
	 */
	public int checkBoardByPrimary(int boardId, Board board) throws Exception;
	
	
}
