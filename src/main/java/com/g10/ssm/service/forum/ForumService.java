package com.g10.ssm.service.forum;

import java.util.List;

import com.g10.ssm.po.forum.BoardCustom;
import com.g10.ssm.po.forum.PostCommentCustom;
import com.g10.ssm.po.forum.PostCustom;
import com.g10.ssm.po.forum.ThemeCustom;

public interface ForumService {
	
	/**
	 * @Title: selectBoardsByBoard 
	 * @Description: 根据查询条件查询板块
	 * @param boardCustom
	 * @throws Exception
	 * @return List<BoardCustom>
	 */
	public List<BoardCustom> selectBoardsByBoard(BoardCustom boardCustom) throws Exception;
	
	/**
	 * @Title: selectPostsByPost 
	 * @Description: 根据传入的postCustom查询帖子
	 * @param postCustom
	 * @throws Exception
	 * @return List<PostCustom>
	 */
	public List<PostCustom> selectPostsByPost(PostCustom postCustom) throws Exception;
	
	/**
	 * @Title: selectThreadsByThread 
	 * @Description: 根据传入的threadCustom查询主题
	 * @param threadCustom
	 * @throws Exception
	 * @return List<ThreadCustom>
	 */
	public List<ThemeCustom> selectThreadsByThread(ThemeCustom threadCustom) throws Exception;
	
	/**
	 * @Title: selectPostCommentsByPostComment 
	 * @Description: 根据传入的postCommentCustom查询帖子评论
	 * @param postCommentCustom
	 * @throws Exception
	 * @return List<PostCommentCustom>
	 */
	public List<PostCommentCustom> selectPostCommentsByPostComment(PostCommentCustom postCommentCustom) throws Exception;
	
	
}
