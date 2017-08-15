package com.g10.ssm.controller.forum;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.g10.ssm.po.forum.Board;
import com.g10.ssm.po.forum.BoardCustom;
import com.g10.ssm.po.forum.PostCommentCustom;
import com.g10.ssm.po.forum.PostCustom;
import com.g10.ssm.po.forum.Theme;
import com.g10.ssm.po.forum.ThemeCustom;
import com.g10.ssm.service.forum.BoardService;
import com.g10.ssm.service.forum.PostCommentService;
import com.g10.ssm.service.forum.PostService;
import com.g10.ssm.service.forum.ThemeService;

/**
 * @ClassName ForumController
 * @Description <p>
 *              论坛控制器用于响应论坛板块、主题、帖子、评论的加载活动，用于响应用户的搜索活动。
 *              </p>
 *              <p>
 *              响应主题、帖子、评论的创建、修改活动。
 *              </p>
 * @author FYW
 * @date 2017年8月9日 上午11:45:40
 */

@Controller
@RequestMapping("/forum")
public class ForumController {

	@Autowired
	private BoardService boardService;

	@Autowired
	private ThemeService themeService;

	@Autowired
	private PostService postService;

	@Autowired
	private PostCommentService postCommentService;

	/**加载论坛首页信息，即板块信息*/
	@RequestMapping("/loadBoardInfo")
	public String loadBoardInfo(Model model) throws Exception {
		List<BoardCustom> boardList = null;
		// 读取所有的板块信息
		boardList = boardService.selectBoardsByBoard(null);
		if (boardList != null) {
			model.addAttribute("boardList", boardList);
			// 返回页面
			return "forum/forumIndex";
		} else {
			// 如果未从数据库加载出任何数据，做处理，尝试重新加载几次？
		}
		return "error";
	}

	/**加载主题信息和该主题下的所有帖子*/
	@RequestMapping("/loadThemeDetail")
	public String loadThemeDetail(Model model,
			@RequestParam("topicId") Integer themeId) throws Exception {
		Theme theme = themeService.selectThemeByPrimaryKey(themeId);
		if (theme != null) {
			List<PostCustom> postList = null;
			postList = postService.selectPostsByThemeId(themeId);

			model.addAttribute("theme", theme);
			if (postList != null)
				Collections.sort(postList);

			model.addAttribute("postList", postList);

			return "success";

		}
		return "error";
	}

	/**加载帖子评论信息*/
	@RequestMapping("/loadPostComment")
	public String loadPostComment(Model model,
			@RequestParam("postId") Integer postId) throws Exception {
		if (postId != null && postId != 0) {
			List<PostCommentCustom> postCommentList = null;
			postCommentList = postCommentService
					.selectPostCommentByPostId(postId);
			if (postCommentList != null) {
				// 排序帖子评论
				model.addAttribute("postCommentList", postCommentList);
				return "success";
			}
		}
		return "error";
	}

	/**创建主题*/
	@RequestMapping("/createTheme")
	public String createTheme(Model model, ThemeCustom themeCustom)
			throws Exception {

		if (themeCustom != null) {
			int result = themeService.createTheme(themeCustom);
			if (result != 0) {
				return "success";
			}
		}

		return "error";
	}

	/**创建帖子*/
	@RequestMapping("/createPost")
	public String createPost(Model model, PostCustom postCustom)
			throws Exception {

		if (postCustom != null) {
			int result = postService.createPost(postCustom);
			if (result != 0) {
				return "success";
			}
		}

		return "error";
	}

	/**创建帖子评论*/
	@RequestMapping("/createPostComment")
	public String createPostComment(Model model,
			PostCommentCustom postCommentCustom) throws Exception {
		if (postCommentCustom != null) {
			int result = postCommentService
					.insertPostCommentSelective(postCommentCustom);
			if (result != 0) {
				return "success";
			}
		}
		return "error";
	}

	/**加载主题，并跳转到修改主题页面*/
	@RequestMapping("/editTheme")
	public String editTheme(Model model,
			@RequestParam("topicId") Integer themeId) throws Exception {

		if (themeId != null && themeId != 0) {
			Theme theme = themeService.selectThemeByPrimaryKey(themeId);
			if (theme != null) {
				model.addAttribute(theme);
				return "success";
			}
		}

		return "error";
	}

	/**更新主题信息*/
	@RequestMapping("/updateTheme")
	public String updateBoard(Model model,
			@RequestParam("topicId") Integer themeId, ThemeCustom themeCustom)
			throws Exception {
		if (themeCustom != null) {
			int result = themeService.updateThemeByPrimaryKeySelective(themeId,
					themeCustom);
			if (result != 0) {
				return "success";
			}
		}
		return "error";
	}

	/**加载帖子，并跳转到帖子修改页面*/
	@RequestMapping("/editPost")
	public String editPost(Model model, Integer postId) throws Exception {
		if (postId != null && postId != 0) {
			PostCustom postCustom = postService.selectPostByPrimaryKey(postId);
			if (postCustom != null) {
				return "success";
			}
		}
		return "error";
	}

	/**更新帖子*/
	@RequestMapping("/updatePost")
	public String updatePost(Model model, Integer postId, PostCustom postCustom)
			throws Exception {
		if (postCustom != null) {
			int result = postService.updatePostByPrimaryKey(postId, postCustom);
			if (result != 0) {
				return "success";
			}
		}
		return "error";
	}

	/**加载帖子评论，并跳转到帖子修改页面*/
	@RequestMapping("/editPostComment")
	public String editPostComment(Model model, Integer postCommentId)
			throws Exception {
		if (postCommentId != null && postCommentId != 0) {
			PostCommentCustom postCommentCustom = null;
			postCommentCustom = postCommentService
					.selectPostCommentCustomByPrimaryKey(postCommentId);
			if (postCommentCustom != null) {
				model.addAttribute(postCommentCustom);
				return "success";
			}
		}
		return "error";
	}

	/**更新帖子评论*/
	@RequestMapping("/updatePostComment")
	public String updatePostComment(Model model, Integer postCommentId,
			PostCommentCustom postCommentCustom) throws Exception {
		if (postCommentId != null && postCommentId != 0) {
			if (postCommentCustom != null) {
				int result = postCommentService
						.updatePostCommentCustomByPrimaryKey(postCommentId,
								postCommentCustom);
				if (result != 0) {
					return "success";
				}
			}
		}
		return "error";
	}

}
