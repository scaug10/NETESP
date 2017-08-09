package com.g10.ssm.service.imple.forum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.forum.BoardCustomMapper;
import com.g10.ssm.mapper.forum.BoardMapper;
import com.g10.ssm.po.forum.Board;
import com.g10.ssm.po.forum.BoardCustom;
import com.g10.ssm.service.forum.BoardService;

@Service
public class BoardServiceImple implements BoardService{

	@Autowired
	private BoardCustomMapper boardCustomMapper;

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public int createBoard(BoardCustom boardCustom) throws Exception {
		if (boardCustom != null) {
			int result = boardMapper.insertSelective(boardCustom);
			return result;
		}
		return 0;
	}

	@Override
	public int updateBoardBoardNumByPrimaryKey(int boardId,
			BoardCustom boardCustom) throws Exception {
		if (boardCustom != null && boardCustom.getBoardId() == boardId) {
			if (boardCustom.getBoardNum() != null) {
				//可能清除其它信息
				
				int result = boardMapper.updateByPrimaryKeySelective(boardCustom);
				
				return result;
			}
		}
		return 0;
	}

	@Override
	public int updateBoardByPrimaryKeySelective(int boardId,
			BoardCustom boardCustom) throws Exception {
		if (boardCustom != null && boardCustom.getBoardId() == boardId) {
			int result = boardMapper.updateByPrimaryKeySelective(boardCustom);
			return result;
		}
		return 0;
	}

	@Override
	public int deleteBoardByPrimaryKey(int boardId) throws Exception {
		if(boardId != 0){
			int result = boardMapper.deleteByPrimaryKey(boardId);
			return result;
		}
		return 0;
	}

	@Override
	public List<BoardCustom> selectBoardsByBoard(BoardCustom boardCustom)
			throws Exception {
		List<BoardCustom> boardList = null;
		boardList = boardCustomMapper.selectByBoard(boardCustom);
		return boardList;
	}

	@Override
	public Board selectBoardByPrimaryKey(Integer boardId) throws Exception {
		if(boardId != null && boardId != 0){
			return boardMapper.selectByPrimaryKey(boardId);
		}
		return null;
	}

}
