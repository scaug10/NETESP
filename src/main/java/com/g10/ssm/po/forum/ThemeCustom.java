package com.g10.ssm.po.forum;

import java.util.Date;

public class ThemeCustom extends Theme{
	private Integer offset;
	private Integer rowCount;
	private String boardName;
	private String lastPoster;
	private Date lastPostTime;
	private Integer postCount;

	public Integer getPostCount() {
		return postCount;
	}

	public void setPostCount(Integer postCount) {
		this.postCount = postCount;
	}

	public String getLastPoster() {
		return lastPoster;
	}

	public void setLastPoster(String lastPoster) {
		this.lastPoster = lastPoster;
	}

	public Date getLastPostTime() {
		return lastPostTime;
	}

	public void setLastPostTime(Date lastPostTime) {
		this.lastPostTime = lastPostTime;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getRowCount() {
		return rowCount;
	}

	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	
	
}
