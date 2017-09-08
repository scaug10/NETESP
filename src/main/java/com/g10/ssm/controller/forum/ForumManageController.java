package com.g10.ssm.controller.forum;

import java.util.List;

import org.apache.commons.io.CopyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.forum.Board;
import com.g10.ssm.po.forum.BoardCustom;
import com.g10.ssm.po.forum.Theme;
import com.g10.ssm.po.forum.ThemeCustom;
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

	/**删除板块，同时删除板块下的所有主题*/
	@RequestMapping("/board/delete")
	public String deleteBoard(Integer boardId) throws Exception {
		if (boardId != null && boardId != 0) {
			int result = boardService.deleteBoardByPrimaryKey(boardId);
			if (result == 1) {
				// model.addAttribute("board", board);
				return "success";
			}
		}
		return "error";
	}

	/**删除主题，同时删除主题下的所有帖子*/
	@RequestMapping("/theme/delete")
	@ResponseBody
	public Integer deleteTheme(
			@RequestParam("topicId") Integer themeId) throws Exception {
		if (themeId != null && themeId != 0) {
			Theme theme = themeService.selectThemeByPrimaryKey(themeId);
			if (theme != null) {
				int result = themeService.deleteThemeByPrimaryKey(themeId);
				return result;
			}
		}
		return 0;
	}

	/**删除帖子，同时删除帖子下的所有评论*/
	@RequestMapping("/deletePost")
	@ResponseBody
	public int deletePost(@RequestParam("postNum")Integer postId) throws Exception {
		int result = 0;
		if (postId != null && postId != 0) {
			result = postService.deletePostByPrimaryKey(postId);
			return result;
		}
		return result;
	}

	/**删除帖子*/
	@RequestMapping("/deletePostComment")
	public String deletePostComment(Integer postCommentId)
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
	
	private int isTop(Integer topicId, boolean top) throws Exception{
		Theme themeCustom = new ThemeCustom();
		themeCustom.setIsTop(top);
		themeCustom.setTopicId(topicId);
		int result=themeService.updateThemeByPrimaryKeySelective(topicId, themeCustom);
		return result;
	}
	
	/**置顶主题*/
	@RequestMapping("/topTheme")
	@ResponseBody
	public int topTheme(@RequestParam("topicId") Integer topicId) throws Exception{
		int result = isTop(topicId, true);
		return result;
	}
	
	/**取消主题置顶*/
	@RequestMapping("/cancelTopTheme")
	@ResponseBody
	public int cancelTopTheme(@RequestParam("topicId") Integer topicId) throws Exception{
		int result = isTop(topicId, false);
		return result;
	}

	/**屏蔽帖子*/
	@RequestMapping("shieldPostComment")
	public String shieldPostComment(Model model, Integer postCommentId,
			@RequestParam("topicId") Integer themeId) throws Exception {
		if (postCommentId != null && postCommentId != 0) {
			int result = postCommentService
					.shieldPostCommentByPrimaryKey(postCommentId);
			if (result != 0) {
				model.addAttribute(themeId);
				return "forum/loadThemeDetail";
			}
		}
		return "error";
	}

	/**创建板块*/
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

	/**编辑板块，加载板块信息，并跳转到板块编辑页面*/
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

	/**更新板块*/
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

	/**排序板块*/
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
