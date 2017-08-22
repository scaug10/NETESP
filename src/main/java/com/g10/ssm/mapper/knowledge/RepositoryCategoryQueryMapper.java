package com.g10.ssm.mapper.knowledge;

import java.util.List;

import com.g10.ssm.po.knowledge.RepositoryCategoryExt;

public interface RepositoryCategoryQueryMapper {
	List<RepositoryCategoryExt> selectAllRepositoryCategory();

	List<RepositoryCategoryExt> selectAll();

	RepositoryCategoryExt selectByName(String name);

	RepositoryCategoryExt selectById(int categoryId);
}
