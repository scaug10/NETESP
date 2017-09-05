package com.g10.ssm.service.imple.forum;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.forum.PostCommentCustomMapper;
import com.g10.ssm.mapper.forum.PostCommentMapper;
import com.g10.ssm.mapper.forum.PostMapper;
import com.g10.ssm.po.ReviewType;
import com.g10.ssm.po.forum.PostComment;
import com.g10.ssm.po.forum.PostCommentCustom;
import com.g10.ssm.service.forum.PostCommentService;

@Service
public class PostCommentServiceImple implements PostCommentService {

	@Autowired
	private PostCommentMapper postCommentMapper;

	@Autowired
	PostCommentCustomMapper postCommentCustomMapper;

	@Override
	public int shieldPostCommentByPrimaryKey(Integer postCommentId)
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
		if (postCommentCustom != null) {
			List<PostCommentCustom> postCommentCustomList = null;
			postCommentCustomList = postCommentCustomMapper
					.selectByPostComment(postCommentCustom);
			return postCommentCustomList;
		}
		return null;
	}

	@Override
	public int deletePostCommentByPrimaryKey(Integer postCommentId)
			throws Exception {
		if (postCommentId != null && postCommentId != 0) {
			int result = postCommentMapper.deleteByPrimaryKey(postCommentId);
			return result;
		}
		return 0;
	}

	@Override
	public int insertPostCommentSelective(PostComment postCommentCustom)
			throws Exception {
		if (postCommentCustom != null) {
			postCommentCustom
					.setCreateTime(new Date(System.currentTimeMillis()));
			int result = postCommentMapper.insertSelective(postCommentCustom);
			return result;
		}
		return 0;
	}

	@Override
	public List<PostCommentCustom> selectPostCommentByPostId(Integer postId)
			throws Exception {
		if (postId != null && postId != 0) {
			List<PostCommentCustom> postCommentList = null;
			PostCommentCustom postCommentCustom = new PostCommentCustom();
			postCommentCustom.setPostId(postId);
			postCommentList = postCommentCustomMapper
					.selectByPostComment(postCommentCustom);
			return postCommentList;
		}
		return null;
	}

	@Override
	public PostCommentCustom selectPostCommentCustomByPrimaryKey(
			Integer postCommentId) throws Exception {
		if (postCommentId != null && postCommentId != 0) {
			PostComment postComment = postCommentMapper
					.selectByPrimaryKey(postCommentId);
			if (postComment != null) {
				PostCommentCustom postCommentCustom = new PostCommentCustom();
				BeanUtils.copyProperties(postComment, postCommentCustom);
				return postCommentCustom;
			}
		}
		return null;
	}

	@Override
	public int updatePostCommentCustomByPrimaryKey(Integer postCommentId,
			PostCommentCustom postCommentCustom) throws Exception {
		if (postCommentId != null && postCommentId != 0) {
			if (postCommentCustom != null) {
				int result = postCommentMapper
						.updateByPrimaryKeySelective(postCommentCustom);
				return result;
			}
		}
		return 0;
	}

	@Override
	public Integer countPostCommentByPostId(Integer postId) throws Exception {
		if (postId != null && postId != 0) {
			Integer number = postCommentCustomMapper
					.countPostCommentByPostId(postId);
			return number;
		}
		return null;
	}
}
