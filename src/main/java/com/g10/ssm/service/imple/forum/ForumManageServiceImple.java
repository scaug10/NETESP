package com.g10.ssm.service.imple.forum;

import com.g10.ssm.po.forum.BoardCustom;
import com.g10.ssm.po.forum.PostCustom;
import com.g10.ssm.service.forum.ForumManageService;

public class ForumManageServiceImple implements ForumManageService{

	@Override
	public int createBoard(BoardCustom boardCustom) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoardBoardNumByPrimaryKey(int boardId,
			BoardCustom boardCustom) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoardByPrimaryKeySelective(int boardId,
			BoardCustom boardCustom) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoardByPrimaryKey(int boardId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int shieldPostCommentByPrimaryKey(int postCommentId)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int checkBoardByPrimaryKey(int boardId, BoardCustom boardCustom)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int checkPostByPrimaryKey(int postId, PostCustom postCustom)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteThreadByPrimaryKey(int topicId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
