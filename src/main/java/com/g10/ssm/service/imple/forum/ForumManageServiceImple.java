package com.g10.ssm.service.imple.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.forum.BoardCustomMapper;
import com.g10.ssm.mapper.forum.BoardMapper;
import com.g10.ssm.mapper.forum.PostCommentMapper;
import com.g10.ssm.mapper.forum.ThemeCustomMapper;
import com.g10.ssm.mapper.forum.ThemeMapper;
import com.g10.ssm.po.ReviewType;
import com.g10.ssm.po.forum.BoardCustom;
import com.g10.ssm.po.forum.PostComment;
import com.g10.ssm.po.forum.PostCustom;
import com.g10.ssm.po.forum.Theme;
import com.g10.ssm.service.forum.ForumManageService;

@Service
public class ForumManageServiceImple implements ForumManageService {

	@Autowired
	private BoardCustomMapper boardCustomMapper;

	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private PostCommentMapper postCommentMapper;
	
	@Autowired
	private ThemeMapper themeMapper;

	@Autowired
	private ThemeCustomMapper themeCustomMapper;

	@Override
	public int createBoard(BoardCustom boardCustom) throws Exception {
		if (boardCustom != null) {
			int result = boardMapper.insertSelective(boardCustom);
			return result;
		}
		return 0;
	}

	@Override
	public int updateBoardBoardNumByPrimaryKey(int boardId,
			BoardCustom boardCustom) throws Exception {
		if (boardCustom != null && boardCustom.getBoardId() == boardId) {
			if (boardCustom.getBoardNum() != null) {
				//可能清除其它信息
				
				int result = boardMapper.updateByPrimaryKeySelective(boardCustom);
				
				return result;
			}
		}
		return 0;
	}

	@Override
	public int updateBoardByPrimaryKeySelective(int boardId,
			BoardCustom boardCustom) throws Exception {
		if (boardCustom != null && boardCustom.getBoardId() == boardId) {
			int result = boardMapper.updateByPrimaryKeySelective(boardCustom);
			return result;
		}
		return 0;
	}

	@Override
	public int deleteBoardByPrimaryKey(int boardId) throws Exception {
		if(boardId != 0){
			int result = boardMapper.deleteByPrimaryKey(boardId);
			return result;
		}
		return 0;
	}

	@Override
	public int shieldPostCommentByPrimaryKey(int postCommentId)
			throws Exception {
		if(postCommentId != 0){
			PostComment postComment = new PostComment();
			postComment.setPostCommentId(postCommentId);
			postComment.setReviewType(ReviewType.ReviewedAndShieldStatusOfReviewType);
			int result = postCommentMapper.updateByPrimaryKey(postComment);
			return result;
		}
		return 0;
	}

	@Override
	public int deleteThemeByPrimaryKey(int topicId) throws Exception {
		if(topicId != 0){
			//先从数据库找到这条信息
			Theme theme = themeMapper.selectByPrimaryKey(topicId);
			
			//如果未找到该主题，返回未找到主题的数据库的错误信息
			if(theme != null){
				//先删除该主题里的所有帖子信息
				
				//如果删除成功则删除该主题
				int result = themeMapper.deleteByPrimaryKey(topicId);
				//返回信息
				return result;
			}
		}
		return 0;
	}

	@Override
	public int deletePostByPrimaryKey(int postId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePostCommentByPrimaryKey(int postCommentId)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}