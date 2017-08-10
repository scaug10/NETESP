package com.g10.ssm.controller.knowledge;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.knowledge.RepositoryCategory;
import com.g10.ssm.service.knowledge.RepositoryCategoryService;

@Controller
public class RepositoryCategoryController {
	@Autowired
	private RepositoryCategoryService repositoryCategoryService;

	@RequestMapping("/queryRepositoryCategory")
	public ModelAndView queryRepositoryCategory(@Param("categoryId") int categoryId, ModelAndView modelAndView)
			throws Exception {
		RepositoryCategory record = repositoryCategoryService.queryRepositoryCategoryById(categoryId);
		modelAndView.addObject("RC", record);
		return modelAndView;
	}

	@RequestMapping("/editRepositoryCategory")
	@ResponseBody
	public int editRepositoryCategory(RepositoryCategory repositoryCategory) throws Exception {
		int result = repositoryCategoryService.updateRepositoryCategory(repositoryCategory);
		return result;
	}

	@RequestMapping("/saveRepositoryCategory")
	@ResponseBody
	public int saveRepositoryCategory(RepositoryCategory repositoryCategory) throws Exception {
		int result = repositoryCategoryService.saveRepositoryCategory(repositoryCategory);
		return result;
	}

	@RequestMapping("/deleteRepositoryCategory")
	@ResponseBody
	public int deleteRepositoryCategory(@Param("categoryId") int categoryId) throws Exception {
		int result = repositoryCategoryService.deleteRepositoryCategoryByPrimaryKey(categoryId);
		return result;
	}

	@RequestMapping("/getAllRepositoryCategory")
	public ModelAndView getAllRepositoryCategory(ModelAndView modelAndView) throws Exception {
		List<RepositoryCategory> list = repositoryCategoryService.queryRepositoryCategory();
		modelAndView.addObject("list", list);
		return modelAndView;
	}
}
