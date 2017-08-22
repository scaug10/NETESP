package com.g10.ssm.controller.knowledge;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.g10.ssm.po.knowledge.RepositoryCategory;
import com.g10.ssm.po.knowledge.RepositoryCategoryExt;
import com.g10.ssm.service.knowledge.RepositoryCategoryService;

@Controller
public class RepositoryCategoryController {
	@Autowired
	private RepositoryCategoryService repositoryCategoryService;

	@RequestMapping("/modifyRepositoryCategory")
	public String modifyRepositoryCategory(@Param("categoryId") int categoryId, Model model) throws Exception {
		RepositoryCategory record = repositoryCategoryService.queryRepositoryCategoryById(categoryId);
		model.addAttribute("RC", record);
		List<RepositoryCategoryExt> list = repositoryCategoryService.getAllRepositoryCategory();
		model.addAttribute("list", list);
		return "KnowledgeClassification/knowledgeclassificationModify";
	}

	@RequestMapping("/editRepositoryCategory")
	@ResponseBody
	public int editRepositoryCategory(RepositoryCategory repositoryCategory) throws Exception {
		int result = repositoryCategoryService.updateRepositoryCategory(repositoryCategory);
		return result;
	}

	@RequestMapping("/addRepositoryCategory")
	public String add(Model model) throws Exception {
		List<RepositoryCategoryExt> list = repositoryCategoryService.getAllRepositoryCategory();
		model.addAttribute("list", list);
		return "KnowledgeClassification/knowledgeclassificationAdd";
	}

	@RequestMapping("/checkName")
	@ResponseBody
	public int checkName(@Param("name") String name) throws Exception {
		int result = repositoryCategoryService.checkName(name);
		return result;
	}

	@RequestMapping("/saveRepositoryCategory")
	@ResponseBody
	public int saveRepositoryCategory(RepositoryCategory repositoryCategory) throws Exception {
		int result = repositoryCategoryService.saveRepositoryCategory(repositoryCategory);
		return result;
	}

	@RequestMapping("/verifyRepositoryCategory")
	public String verifyRepositoryCategory(@Param("categoryId") int categoryId, Model model) throws Exception {
		RepositoryCategoryExt record = repositoryCategoryService.getRepositoryCategoryExt(categoryId);
		record.setParentName(repositoryCategoryService.getParentName(record.getParentId()));
		model.addAttribute("RC", record);
		return "KnowledgeClassification/knowledgeclassificationVerify";
	}

	@RequestMapping("/deleteRepositoryCategory")
	@ResponseBody
	public int deleteRepositoryCategory(@Param("categoryId") int categoryId) throws Exception {
		int result = repositoryCategoryService.deleteRepositoryCategoryByPrimaryKey(categoryId);
		return result;
	}

	@RequestMapping("/getAllRepositoryCategory")
	public String getAllRepositoryCategory(Model model) throws Exception {
		List<RepositoryCategoryExt> list = repositoryCategoryService.queryRepositoryCategory();
		for (int i = 0; i < list.size(); i++) {
			RepositoryCategory record = repositoryCategoryService
					.queryRepositoryCategoryById(list.get(i).getParentId());
			if (record != null) {
				list.get(i).setParentName(record.getName());
			}
		}
		model.addAttribute("list", list);
		return "KnowledgeClassification/knowledgeclassification";
	}
}
