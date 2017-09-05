package com.g10.ssm.service.knowledge;

import java.util.List;

import com.g10.ssm.po.knowledge.RepositoryCategory;
import com.g10.ssm.po.knowledge.RepositoryCategoryExt;

public interface RepositoryCategoryService {
	public List<RepositoryCategoryExt> queryRepositoryCategory() throws Exception;

	public List<RepositoryCategoryExt> getAllRepositoryCategory() throws Exception;

	public List<RepositoryCategoryExt> getRepositoryCategoryByName(String name) throws Exception;

	public int updateRepositoryCategory(RepositoryCategory repositoryCategory) throws Exception;

	public int saveRepositoryCategory(RepositoryCategory repositoryCategory) throws Exception;

	public int deleteRepositoryCategoryByPrimaryKey(int categoryId) throws Exception;

	public RepositoryCategory queryRepositoryCategoryById(Integer categoryId) throws Exception;

	public int checkName(String name) throws Exception;

	public String getParentName(Integer categoryId) throws Exception;

	public RepositoryCategoryExt getRepositoryCategoryExt(Integer categoryId) throws Exception;
}
