package com.g10.ssm.service.imple.forum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.forum.PostCustomMapper;
import com.g10.ssm.mapper.forum.PostMapper;
import com.g10.ssm.po.forum.PostCustom;
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

}
