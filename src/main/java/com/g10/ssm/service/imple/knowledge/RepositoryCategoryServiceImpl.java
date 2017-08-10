package com.g10.ssm.service.imple.knowledge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.knowledge.RepositoryCategoryMapper;
import com.g10.ssm.mapper.knowledge.RepositoryCategoryQueryMapper;
import com.g10.ssm.po.knowledge.RepositoryCategory;
import com.g10.ssm.service.knowledge.RepositoryCategoryService;

@Service("repositoryCategoryService")
public class RepositoryCategoryServiceImpl implements RepositoryCategoryService {

	@Autowired
	private RepositoryCategoryMapper repositoryCategoryDao;
	@Autowired
	private RepositoryCategoryQueryMapper repositoryCategoryQueryDao;

	@Override
	public List<RepositoryCategory> queryRepositoryCategory() throws Exception {
		List<RepositoryCategory> list = repositoryCategoryQueryDao.selectAllRepositoryCategory();
		return list;
	}

	@Override
	public int updateRepositoryCategory(RepositoryCategory repositoryCategory) throws Exception {
		int result = repositoryCategoryDao.updateByPrimaryKeySelective(repositoryCategory);
		return result;
	}

	@Override
	public int saveRepositoryCategory(RepositoryCategory repositoryCategory) throws Exception {
		int result = repositoryCategoryDao.insertSelective(repositoryCategory);
		return result;
	}

	@Override
	public int deleteRepositoryCategoryByPrimaryKey(int categoryId) throws Exception {
		int result = repositoryCategoryDao.deleteByPrimaryKey(categoryId);
		return result;
	}

	@Override
	public RepositoryCategory queryRepositoryCategoryById(Integer categoryId) throws Exception {
		RepositoryCategory record = repositoryCategoryDao.selectByPrimaryKey(categoryId);
		return record;
	}

}
