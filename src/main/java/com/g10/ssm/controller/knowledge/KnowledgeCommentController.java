package com.g10.ssm.controller.knowledge;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.knowledge.KnowledgeComment;
import com.g10.ssm.service.knowledge.KnowledgeCommentService;

@Controller
public class KnowledgeCommentController {
	@Autowired
	private KnowledgeCommentService knowledgeCommentService;

	@RequestMapping("/queryKnowledgeComment")
	public ModelAndView queryKnowledgeComment(@Param("commentId") int commentId, ModelAndView modelAndView)
			throws Exception {
		KnowledgeComment record = knowledgeCommentService.queryKnowledgeCommentById(commentId);
		modelAndView.addObject("KLCM", record);
		return modelAndView;
	}

	@RequestMapping("/editKnowledgeComment")
	@ResponseBody
	public int editKnowledgeComment(KnowledgeComment knowledgeComment) throws Exception {
		int result = knowledgeCommentService.updateKnowledgeComment(knowledgeComment);
		return result;
	}

	@RequestMapping("/saveKnowledgeComment")
	@ResponseBody
	public int saveKnowledgeComment(KnowledgeComment knowledgeComment) throws Exception {
		knowledgeComment.setCreateDate(new java.sql.Date(System.currentTimeMillis()));
		int result = knowledgeCommentService.saveKnowledgeComment(knowledgeComment);
		return result;
	}

	@RequestMapping("/deleteKnowledgeComment")
	@ResponseBody
	public int deleteKnowledgeComment(@Param("commentId") int commentId) throws Exception {
		int result = knowledgeCommentService.deleteKnowledgeCommentByPrimaryKey(commentId);
		return result;
	}

	@RequestMapping("/getAllKnowledgeComment")
	public ModelAndView getAllKnowledgeComment(ModelAndView modelAndView) throws Exception {
		List<KnowledgeComment> list = knowledgeCommentService.queryKnowledgeComment();
		modelAndView.addObject("list", list);
		return modelAndView;
	}
}
