package com.g10.ssm.controller.forum;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.g10.ssm.mapper.forum.BoardCustomMapper;
import com.g10.ssm.po.forum.Board;
import com.g10.ssm.po.forum.BoardCustom;
import com.g10.ssm.po.forum.Post;
import com.g10.ssm.po.forum.PostComment;
import com.g10.ssm.po.forum.PostCommentCustom;
import com.g10.ssm.po.forum.PostCustom;
import com.g10.ssm.po.forum.PostQueryVo;
import com.g10.ssm.po.forum.Theme;
import com.g10.ssm.po.forum.ThemeCustom;
import com.g10.ssm.po.forum.ThemeQueryVo;
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

	@RequestMapping("/intoForum")
	public String intoForum() throws Exception {
		// 跳转到论坛主页
		return "forum/forumIndex";
	}

	/** 加载论坛首页信息，即板块信息 */
	@RequestMapping("/index")
	public String loadBoardInfo(Model model) throws Exception {
		List<BoardCustom> boardList = null;
		// 读取所有的板块信息
		boardList = boardService.selectBoardsByBoard(null);
		if (boardList != null) {
			// model.addAttribute("boardList", boardList);
			// 返回页面
			model.addAttribute("boardList", boardList);
			return "forum/forumIndex";
		} else {
			// 如果未从数据库加载出任何数据，做处理，尝试重新加载几次？
		}
		return null;
	}

	/** 跳转到相应板块下面 */
	@RequestMapping("/boardThemes")
	public String boardThemes(Model model, String boardName) throws Exception {
		// 跳转某个板块的页面下
		model.addAttribute("boardName", boardName);
		return "forum/forumPosts";
	}

	/** 加载板块下的普通主题信息 */
	@RequestMapping("/loadThemes")
	@ResponseBody
	public ThemeQueryVo loadThemes(ThemeCustom themeCustom,
			@RequestParam("pageNum") Integer pageNum,
			@RequestParam("boardName") String boardName,
			@RequestParam("isScream") Integer isTop) throws Exception {
		List<ThemeCustom> themeList = null;
		if (themeCustom != null && boardName != null) {
			if (pageNum != 0 || pageNum != null) {
				ThemeQueryVo themeQueryVo = new ThemeQueryVo();
				Integer boardId = boardService
						.selectBoardIdByBoardName(boardName);
				if (boardId != null && boardId != 0) {
					// themeQueryVo.setThemeCount(themeService.countThemesByBoardId(boardId));

					// 设置查询条件
					themeCustom.setBoardId(boardId);
					themeCustom.setOffset((pageNum - 1) * 20);
					themeCustom.setRowCount(pageNum * 20 - 1);
					themeCustom.setTopicName(boardName);
					themeCustom.setIsTop(isTop == 1);

					themeList = (List<ThemeCustom>) themeService
							.selectThemesByPaging(themeCustom);
					if (themeList != null) {
						// 获取每个主题最后发帖的人和时间
						for (ThemeCustom theme : themeList) {
							PostCustom postCustom = postService
									.selectLastPostByThemeId(theme.getTopicId());
							if(postCustom != null){
								theme.setLastPoster(postCustom.getPublisher());
								theme.setLastPostTime(postCustom.getCreateTime());
								theme.setPostCount(postService
										.countPostsByThemeId(theme.getTopicId()));
							}
						}
						themeQueryVo.setList(themeList);
						return themeQueryVo;
					}
				}
			}

		}
		return null;
	}

	/** 获取某个板块下的普通主题数量 */
	@RequestMapping("/normalThemeNum")
	@ResponseBody
	public Integer normalThemeNum(String boardName) throws Exception {
		if (boardName != null && boardName != "") {
			Integer boardId = boardService.selectBoardIdByBoardName(boardName);
			if (boardId != null && boardId != 0) {
				Integer count = themeService.countThemesByBoardId(boardId);
				return count;
			}
		}
		return 0;
	}

	/** 跳转到主题页面 */
	@RequestMapping("/themeDetail")
	public String themeDetail(@RequestParam("topicName") String topicName,
			@RequestParam("topicId") Integer topicId, Model model)
			throws Exception {
		model.addAttribute("topicId", topicId);
		model.addAttribute("topicName", topicName);
		return "forum/postsDetail";
	}

	/** 加载主题信息和该主题下的所有帖子 */
	@RequestMapping("/loadThemeDetail")
	@ResponseBody
	public Theme loadThemeDetail(Integer topicId) throws Exception {
		Theme theme = themeService.selectThemeByPrimaryKey(topicId);
		if (theme != null) {
			return theme;

		}
		return null;
	}
	
	@RequestMapping("/hostTheme")
	@ResponseBody
	public List<ThemeCustom> loadHostTheme(String name) throws Exception{
		ThemeCustom themeCustom = new ThemeCustom();
		themeCustom.setIsTop(true);
		List<ThemeCustom> themes = themeService.selectThemesByTheme(themeCustom);
		return themes;
	}

	@RequestMapping("/postNum")
	@ResponseBody
	public Integer getPostNum(@RequestParam("topicId") Integer topicId)
			throws Exception {
		if (topicId != null && topicId != 0) {
			Integer number = postService.countPostsByThemeId(topicId);
			return number;
		}
		return null;
	}

	/** 根据页面获取某个主题下帖子 */
	@RequestMapping("/posts")
	@ResponseBody
	public List<PostCustom> postsDetail(
			@RequestParam("topicId") Integer topicId, int pageNum)
			throws Exception {
		if (topicId != null && topicId != 0) {
			List<PostCustom> postList = null;
			PostQueryVo postVo = new PostQueryVo();
			postVo.setTopicId(topicId);
			postVo.setLowerPostsNum((pageNum - 1) * 20);
			postVo.setUpperPostsNum(pageNum * 20 - 1);
			postList = postService.selectPostsByPagingAndThemeId(postVo);
			if (postList != null) {
				for (PostCustom post : postList) {
					post.setPostCommentCount(postCommentService
							.countPostCommentByPostId(post.getPostId()));
				}
				return postList;
			}
		}
		return null;
	}

	/** 加载帖子评论信息 */
	@RequestMapping("/postComments")
	@ResponseBody
	public List<PostCommentCustom> loadPostComment(
			@RequestParam("postId") Integer postId) throws Exception {
		if (postId != null && postId != 0) {
			List<PostCommentCustom> postCommentList = null;
			PostCommentCustom post = new PostCommentCustom();
			post.setPostId(postId);
			postCommentList = postCommentService
					.selectPostCommentsByPostComment(post);
			if (postCommentList != null) {
				// 排序帖子评论
//				model.addAttribute("postCommentList", postCommentList);
				return postCommentList;
			}
		}
		return null;
	}

	/**跳转到主题发布页面*/
	@RequestMapping("/postTheme")
	public String postTheme(String boardName, Model model) throws Exception{
		model.addAttribute("boardName", boardName);
		return "forum/postTheme";
	}
	
	/** 创建主题 */
	@RequestMapping("/createTheme")
	@ResponseBody
	public int createTheme(Theme themeCustom, String boardName, String username)
			throws Exception {
		int result = 0;
		if (themeCustom != null && boardName != null && username != null) {
			themeCustom.setCreateTime(new Date(System.currentTimeMillis()));
			themeCustom.setIsTop(false);
			themeCustom.setCreator(username);
			Integer boardId = boardService.selectBoardIdByBoardName(boardName);
			themeCustom.setBoardId(boardId);
			result = themeService.createTheme(themeCustom);
			return result;
		}
		return result;
	}

	/** 创建帖子 */
	@RequestMapping("/createPost")
	@ResponseBody
	public Integer createPost(Post postCustom, String username)
			throws Exception {
		
		int result = 0;
		if (postCustom != null) {
			postCustom.setPublisher(username);
			postCustom.setCreateTime(new Date(System.currentTimeMillis()));
			result = postService.createPost(postCustom);
			return result;
		}

		return result;
	}

	/** 创建帖子评论 */
	@RequestMapping("/createPostComment")
	@ResponseBody
	public Integer createPostComment(
			PostComment postCommentCustom,
			Integer postId,
			String username) throws Exception {
		int result = 0;
		if (postCommentCustom != null && postId != null && postId != 0) {
			postCommentCustom.setPostId(postId);
			postCommentCustom.setPublisher(username);
			postCommentCustom.setCreateTime(new Date(System.currentTimeMillis()));
			result = postCommentService
					.insertPostCommentSelective(postCommentCustom);
			return result;
		}
		return result;
	}

	/** 加载主题，并跳转到修改主题页面 */
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

	/** 更新主题信息 */
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

	/** 加载帖子，并跳转到帖子修改页面 */
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

	/** 更新帖子 */
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

	/** 加载帖子评论，并跳转到帖子修改页面 */
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

	/** 更新帖子评论 */
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
