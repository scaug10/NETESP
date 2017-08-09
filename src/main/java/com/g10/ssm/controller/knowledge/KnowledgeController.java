package com.g10.ssm.controller.knowledge;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.knowledge.Knowledge;
import com.g10.ssm.service.knowledge.KnowledgeService;

@Controller
public class KnowledgeController {
	@Autowired
	private KnowledgeService knowledgeService;

	@RequestMapping("/queryKnowledge")
	public ModelAndView queryKnowledge(@Param("knowledgeId") int knowledgeId, ModelAndView modelAndView)
			throws Exception {
		Knowledge record = knowledgeService.queryKnowledgeById(knowledgeId);
		modelAndView.addObject("Knowledge", record);
		return modelAndView;
	}

	@RequestMapping("/editKnowledge")
	@ResponseBody
	public int editKnowledge(Knowledge knowledge) throws Exception {
		int result = knowledgeService.updateKnowledge(knowledge);
		return result;
	}

	@RequestMapping("/saveKnowledge")
	@ResponseBody
	public int saveKnowledge(Knowledge knowledge) throws Exception {
		int result = knowledgeService.saveKnowledge(knowledge);
		return result;
	}

	@RequestMapping("/deleteKnowledge")
	@ResponseBody
	public int deleteKnowledge(@Param("knowledgeId") int knowledgeId) throws Exception {
		int result = knowledgeService.deleteKnowledgeByPrimaryKey(knowledgeId);
		return result;
	}

	@RequestMapping("/getAllKnowledge")
	public ModelAndView getAllKnowledge(ModelAndView modelAndView) throws Exception {
		List<Knowledge> list = knowledgeService.queryKnowledge();
		modelAndView.addObject("list", list);
		return modelAndView;
	}
}
