package com.g10.ssm.service.imple.forum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.forum.PostCommentMapper;
import com.g10.ssm.po.ReviewType;
import com.g10.ssm.po.forum.PostComment;
import com.g10.ssm.po.forum.PostCommentCustom;
import com.g10.ssm.service.forum.PostCommentService;

@Service
public class PostCommentServiceImple implements PostCommentService {

	@Autowired
	private PostCommentMapper postCommentMapper;

	@Override
	public int shieldPostCommentByPrimaryKey(int postCommentId)
			throws Exception {
		if (postCommentId != 0) {
			PostComment postComment = new PostComment();
			postComment.setPostCommentId(postCommentId);
			postComment
					.setReviewType(ReviewType.ReviewedAndShieldStatusOfReviewType);
			int result = postCommentMapper.updateByPrimaryKey(postComment);
			return result;
		}
		return 0;
	}

	@Override
	public List<PostCommentCustom> selectPostCommentsByPostComment(
			PostCommentCustom postCommentCustom) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deletePostCommentByPrimaryKey(int postCommentId)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertPostCommentSelective(PostCommentCustom postCommentCustom)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}
