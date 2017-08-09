package com.g10.ssm.controller.forum;

import java.util.List;

import org.apache.commons.io.CopyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.g10.ssm.po.forum.Board;
import com.g10.ssm.po.forum.BoardCustom;
import com.g10.ssm.po.forum.Theme;
import com.g10.ssm.service.forum.BoardService;
import com.g10.ssm.service.forum.PostCommentService;
import com.g10.ssm.service.forum.PostService;
import com.g10.ssm.service.forum.ThemeService;

/**
 * 
 * @ClassName: FormManageController
 * @Description 论坛管理控制器，用于响应板块、主题、帖子、帖子评论的删除操作，同时可响应板块的创建，修改和排序操作
 * @author FYW
 * @date 2017年8月7日 上午10:04:59
 */
@Controller
@RequestMapping("/forumManage")
public class ForumManageController {
	@Autowired
	private BoardService boardService;

	@Autowired
	private ThemeService themeService;

	@Autowired
	private PostService postService;

	@Autowired
	private PostCommentService postCommentService;

	@RequestMapping("deleteBoard")
	public String deleteBoard(Model model, Integer boardId) throws Exception {
		if (boardId != null && boardId != 0) {
			Board board = boardService.selectBoardByPrimaryKey(boardId);
			if (board != null) {
				model.addAttribute("board", board);
				return "success";
			}
		}
		return "error";
	}

	@RequestMapping("deleteTheme")
	public String deleteTheme(Model model,
			@RequestParam("topicId") Integer themeId) throws Exception {
		if (themeId != null && themeId != 0) {
			Theme theme = themeService.selectThemeByPrimaryKey(themeId);
			if (theme != null) {
				int result = themeService.deleteThemeByPrimaryKey(themeId);
				if (result != 0) {
					return "success";
				}
			}
		}
		return "error";
	}

	@RequestMapping("/deletePost")
	public String deletePost(Model model, Integer postId) throws Exception {
		if (postId != null && postId != 0) {
			int result = postService.deletePostByPrimaryKey(postId);
			if (result != 0) {
				return "success";
			}
		}
		return "error";
	}

	@RequestMapping("/deletePostComment")
	public String deletePostComment(Model model, Integer postCommentId)
			throws Exception {
		if (postCommentId != null && postCommentId != 0) {
			int result = postCommentService
					.deletePostCommentByPrimaryKey(postCommentId);
			if (result != 0) {
				return "success";
			}
		}

		return "error";
	}

	@RequestMapping("/createBoard")
	public String createBoard(Model model, BoardCustom boardCustom)
			throws Exception {
		if (boardCustom != null) {
			int result = boardService.createBoard(boardCustom);
			if (result != 0) {
				return "success";
			}
		}
		return "error";
	}

	@RequestMapping("/editBoard")
	public String editBoard(Model model, Integer boardId) throws Exception {

		if (boardId != null && boardId != 0) {
			Board board = boardService.selectBoardByPrimaryKey(boardId);
			if (board != null) {
				model.addAttribute(board);
				return "success";
			}
		}

		return "error";
	}

	@RequestMapping("/updateBoard")
	public String updateBoard(Model model, Integer boardId,
			BoardCustom boardCustom) throws Exception {
		if (boardCustom != null) {
			int result = boardService.updateBoardByPrimaryKeySelective(boardId,
					boardCustom);
			if (result != 0) {
				return "success";
			}
		}
		return "error";
	}

	@RequestMapping("/sortBoard")
	public String sortBoard(Model model, Integer[] boardIdList)
			throws Exception {
		if (boardIdList != null) {
			for (int i = 0; i < boardIdList.length; ++i) {
				Board board = boardService
						.selectBoardByPrimaryKey(boardIdList[i]);
				if (board != null) {
					board.setBoardNum(i);
					BoardCustom boardCustom = new BoardCustom();
					BeanUtils.copyProperties(board, boardCustom);
					int result = boardService.updateBoardBoardNumByPrimaryKey(
							boardCustom.getBoardId(), boardCustom);
					if (result == 0) {
						System.out
								.println("error in ForumManageController: sortBoard");
						return "success";
					}
				} else {
					System.out
							.println("error in ForumManageController: sortBoard");
					return "error";
				}
			}
			return "success";
		}
		return "error";
	}

}
