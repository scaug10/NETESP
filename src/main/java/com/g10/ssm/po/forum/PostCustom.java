package com.g10.ssm.po.forum;

public class PostCustom extends Post implements Comparable<Object>{
	
	private Integer postCommentCount;
	
	public Integer getPostCommentCount() {
		return postCommentCount;
	}

	public void setPostCommentCount(Integer postCommentCount) {
		this.postCommentCount = postCommentCount;
	}

	@Override
	public int compareTo(Object o) {
		if(this == o) {
			return 0;
		}
		else if(o != null && o instanceof PostCustom){
			PostCustom postCustom = (PostCustom) o;
			if(this.getCreateTime().getTime() < postCustom.getCreateTime().getTime())
				return -1;
			else return 1;
		}
		return 0;
	}

}
