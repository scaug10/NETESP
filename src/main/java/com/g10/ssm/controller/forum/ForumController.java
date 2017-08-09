package com.g10.ssm.controller.forum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.g10.ssm.po.forum.BoardCustom;
import com.g10.ssm.service.forum.BoardService;
import com.g10.ssm.service.forum.PostCommentService;
import com.g10.ssm.service.forum.PostService;
import com.g10.ssm.service.forum.ThemeService;

/**
 * @ClassName: ForumController
 * @Description: <p>
 *               论坛控制器用于响应论坛板块、主题、帖子、评论的加载活动，用于响应用户的搜索活动。
 *               </p>
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
	
	@RequestMapping("")
	public String loadBoardInfo(Model model) throws Exception{
		List<BoardCustom> boardList = null;
		boardList = boardService.selectBoardsByBoard(null);
		return "success";
	}
	
	
}
