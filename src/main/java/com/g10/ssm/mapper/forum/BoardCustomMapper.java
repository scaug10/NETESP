package com.g10.ssm.mapper.forum;

import java.util.List;

import com.g10.ssm.po.forum.Board;
import com.g10.ssm.po.forum.BoardCustom;

public interface BoardCustomMapper {

	public List<Board> selectByBoard(BoardCustom boardCustom) throws Exception;
	
}
