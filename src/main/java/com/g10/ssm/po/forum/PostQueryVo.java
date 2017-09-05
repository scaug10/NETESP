package com.g10.ssm.po.forum;

import com.g10.ssm.po.forum.PostCustom;

public class PostQueryVo {
	private PostCustom postCustom;
	private Integer topicId;
	private int upperPostsNum;
	private int lowerPostsNum;

	public int getLowerPostsNum() {
		return lowerPostsNum;
	}

	public void setLowerPostsNum(int lowerPostsNum) {
		this.lowerPostsNum = lowerPostsNum;
	}

	public int getUpperPostsNum() {
		return upperPostsNum;
	}

	public void setUpperPostsNum(int upperPostsNum) {
		this.upperPostsNum = upperPostsNum;
	}


	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public PostCustom getPostCustom() {
		return postCustom;
	}

	public void setPostCustom(PostCustom postCustom) {
		this.postCustom = postCustom;
	}

}
