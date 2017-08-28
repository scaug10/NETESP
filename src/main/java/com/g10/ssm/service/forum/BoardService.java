package com.g10.ssm.service.forum;

import java.util.List;

import com.g10.ssm.po.forum.Board;
import com.g10.ssm.po.forum.BoardCustom;

/**
 * @ClassName: BoardService
 * @Description: 板块创建、删除、更新、查找处理
 * @author 	FYW
 * @date 	2017年8月10日 上午10:11:03
 */
public interface BoardService {
	/**
	 * @Title: createBoard
	 * @Description: 创建板块
	 * @param boardCustom
	 *            论坛版块
	 * @throws Exception
	 * @return int 是否创建成功
	 */
	public int createBoard(BoardCustom boardCustom) throws Exception;

	/**
	 * @Title: updateBoardBoardNumByPrimaryKey
	 * @Description: 通过主键更新论坛排序的序号
	 * @param boardId
	 * @param boardCustom
	 * @throws Exception
	 * @return int 是否更新成功
	 */
	public int updateBoardBoardNumByPrimaryKey(Integer boardId,
			BoardCustom boardCustom) throws Exception;

	/**
	 * @Title: updateBoardByPrimaryKeySelective
	 * @Description: 根据板块id更新板块
	 * @param boardId
	 * @param boardCustom
	 * @throws Exception
	 * @return int
	 */
	public int updateBoardByPrimaryKeySelective(Integer boardId,
			BoardCustom boardCustom) throws Exception;

	/**
	 * @Title: deleteBoardByPrimaryKey
	 * @Description: 根据论坛的主键删除论坛，如果要删除论坛，必须先删除论坛下的所有主题。
	 * @param boardId
	 * @throws Exception
	 * @return int
	 */
	public int deleteBoardByPrimaryKey(Integer boardId) throws Exception;

	/**
	 * @Title: selectBoardsByBoard
	 * @Description: 根据查询条件查询板块
	 * @param boardCustom
	 * @throws Exception
	 * @return List<BoardCustom>
	 */
	public List<BoardCustom> selectBoardsByBoard(BoardCustom boardCustom)
			throws Exception;

	public Board selectBoardByPrimaryKey(Integer boardId) throws Exception;
	
	public Integer selectBoardIdByBoardName(String boardName) throws Exception;


}
