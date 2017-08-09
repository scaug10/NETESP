package com.g10.ssm.mapper.forum;

import java.util.List;

import com.g10.ssm.po.forum.PostComment;
import com.g10.ssm.po.forum.PostCommentCustom;

public interface PostCommentCustomMapper {

	public List<PostCommentCustom> selectByPostComment(PostCommentCustom postCommentCustom) throws Exception;
	
}
