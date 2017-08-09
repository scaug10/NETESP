package com.g10.ssm.service.knowledge;

import java.util.List;

import com.g10.ssm.po.knowledge.RepositoryCategory;

public interface RepositoryCategoryService {
	public List<RepositoryCategory> queryRepositoryCategory() throws Exception;

	public int updateRepositoryCategory(RepositoryCategory repositoryCategory) throws Exception;

	public int saveRepositoryCategory(RepositoryCategory repositoryCategory) throws Exception;

	public int deleteRepositoryCategoryByPrimaryKey(int categoryId) throws Exception;

	public RepositoryCategory queryRepositoryCategoryById(Integer categoryId) throws Exception;
}
