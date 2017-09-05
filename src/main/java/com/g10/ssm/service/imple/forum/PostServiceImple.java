package com.g10.ssm.service.imple.forum;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.forum.PostCustomMapper;
import com.g10.ssm.mapper.forum.PostMapper;
import com.g10.ssm.po.forum.Post;
import com.g10.ssm.po.forum.PostCustom;
import com.g10.ssm.po.forum.PostQueryVo;
import com.g10.ssm.service.forum.PostService;

@Service
public class PostServiceImple implements PostService{

	@Autowired
	private PostMapper postMapper;
	
	@Autowired
	private PostCustomMapper postCustomMapper;
	
	@Override
	public int deletePostByPrimaryKey(Integer postId) throws Exception {
		if(postId != null && postId != 0){
			int result = postMapper.deleteByPrimaryKey(postId);
			return result;
		}
		return 0;
	}

	@Override
	public List<PostCustom> selectPostsByPost(PostCustom postCustom)
			throws Exception {
		if(postCustom != null){
			List<PostCustom> postCustoms = null;
			postCustoms = postCustomMapper.selectByPostCustom(postCustom);
			return postCustoms;
		}
		return null;
	}

	@Override
	public List<PostCustom> selectPostsByThemeId(Integer themeId)
			throws Exception {
		if(themeId != null && themeId != 0){
			List<PostCustom> postCustoms = null;
			postCustoms = postCustomMapper.selectByThemeId(themeId);
			return postCustoms;
		}
		return null;
	}

	@Override
	public int createPost(Post postCustom) throws Exception {
		if(postCustom != null){
			int result = postMapper.insertSelective(postCustom);
			return result;
		}
		return 0;
	}

	@Override
	public int updatePostByPrimaryKey(Integer postId, PostCustom postCustom)
			throws Exception {
		if(postId != null && postId != 0){
			int result = postMapper.updateByPrimaryKeySelective(postCustom);
			return result;
		}
		return 0;
	}

	@Override
	public PostCustom selectPostByPrimaryKey(Integer postId) throws Exception {
		if(postId != null && postId != 0){
			Post post = postMapper.selectByPrimaryKey(postId);
			if(post != null){
				PostCustom postCustom = new PostCustom();
				BeanUtils.copyProperties(post, postCustom);
				return postCustom;
			}
		}
		return null;
	}

	@Override
	public PostCustom selectLastPostByThemeId(Integer themeId) throws Exception {
		if(themeId != null && themeId != 0){
			return postCustomMapper.selectLastPostByThemeId(themeId);
		}
		return null;
	}

	@Override
	public Integer countPostsByThemeId(Integer themeId) throws Exception {
		if(themeId != null && themeId != 0){
			Integer count = postCustomMapper.countPostsByThemeId(themeId);
			return count;
		}
		return null;
	}

	@Override
	public List<PostCustom> selectPostsByPagingAndThemeId(PostQueryVo postVo)
			throws Exception {
		if(postVo.getTopicId() != null && postVo.getTopicId() != 0){
			List<PostCustom> postList = null;
			postList = postCustomMapper.selectPostsByPagingAndThemeId(postVo);
			return postList;
		}
		return null;
	}
	
	

}
