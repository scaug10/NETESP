package com.g10.ssm.controller.knowledge;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.g10.ssm.po.knowledge.Knowledge;
import com.g10.ssm.po.knowledge.KnowledgeExt;
import com.g10.ssm.po.knowledge.RepositoryCategoryExt;
import com.g10.ssm.service.knowledge.KnowledgeService;
import com.g10.ssm.service.knowledge.RepositoryCategoryService;

@Controller
public class KnowledgeController {
	@Autowired
	private KnowledgeService knowledgeService;
	@Autowired
	private RepositoryCategoryService repositoryCategoryService;

	@RequestMapping("/queryKnowledge")
	public String queryKnowledge(@Param("knowledgeId") int knowledgeId, Model model) throws Exception {
		KnowledgeExt record = knowledgeService.getKnowledge(knowledgeId);
		record.setCategoryName(repositoryCategoryService.getParentName(record.getCategoryId()));
		model.addAttribute("Knowledge", record);
		return "Knowledge/knowledgePreview";
	}

	@RequestMapping("/verifyKnowledge")
	public String verifyKnowledge(@Param("knowledgeId") int knowledgeId, Model model) throws Exception {
		KnowledgeExt record = knowledgeService.getKnowledge(knowledgeId);
		record.setCategoryName(repositoryCategoryService.getParentName(record.getCategoryId()));
		model.addAttribute("Knowledge", record);
		return "Knowledge/knowledgeVerify";
	}

	@RequestMapping("/checkKnowledgeName")
	@ResponseBody
	public int checkName(@Param("name") String name) throws Exception {
		KnowledgeExt record = knowledgeService.selectByName(name);
		if (record == null) {
			return 0;
		} else {
			return 1;
		}
	}

	@RequestMapping("/editKnowledge")
	@ResponseBody
	public int editKnowledge(Knowledge knowledge) throws Exception {
		int result = knowledgeService.updateKnowledge(knowledge);
		return result;
	}

	@RequestMapping("/modifyKnowledge")
	public String modifyKnowledge(@Param("knowledgeId") int knowledgeId, Model model) throws Exception {
		KnowledgeExt record = knowledgeService.getKnowledge(knowledgeId);
		record.setCategoryName(repositoryCategoryService.getParentName(record.getCategoryId()));
		model.addAttribute("Knowledge", record);
		List<RepositoryCategoryExt> list = repositoryCategoryService.getAllRepositoryCategory();
		model.addAttribute("list", list);
		return "Knowledge/knowledgeModify";
	}

	@RequestMapping("/saveKnowledge")
	@ResponseBody
	public int saveKnowledge(Knowledge knowledge) throws Exception {
		int result = knowledgeService.saveKnowledge(knowledge);
		return result;
	}

	@RequestMapping("/deleteKnowledge")
	@ResponseBody
	public int deleteKnowledge(@Param("knowledgeId") Integer[] knowledgeId) throws Exception {
		ArrayList<Integer> knowledgeArray = new ArrayList<>();
		for (int i = 0; i < knowledgeId.length; i++) {
			knowledgeArray.add(knowledgeId[i]);
		}
		int result = knowledgeService.deleteKnowledge(knowledgeArray);
		return result;
	}

	@RequestMapping("/getKnowledgeByName")
	public String getKnowledgeByName(@Param("name") String name, Model model) throws Exception {
		List<KnowledgeExt> list = knowledgeService.getKnowledgeByName(name);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setCategoryName(repositoryCategoryService.getParentName(list.get(i).getCategoryId()));
		}
		model.addAttribute("list", list);
		return "Knowledge/knowledge";
	}

	@RequestMapping("/getAllKnowledge")
	public String getAllKnowledge(Model model) throws Exception {
		List<KnowledgeExt> list = knowledgeService.queryKnowledge();
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setCategoryName(repositoryCategoryService.getParentName(list.get(i).getCategoryId()));
		}
		model.addAttribute("list", list);
		return "Knowledge/knowledge";
	}
}
