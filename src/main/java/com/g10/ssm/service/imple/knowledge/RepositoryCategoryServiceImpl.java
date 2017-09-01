package com.g10.ssm.service.imple.knowledge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.knowledge.RepositoryCategoryMapper;
import com.g10.ssm.mapper.knowledge.RepositoryCategoryQueryMapper;
import com.g10.ssm.po.knowledge.RepositoryCategory;
import com.g10.ssm.po.knowledge.RepositoryCategoryExt;
import com.g10.ssm.service.knowledge.RepositoryCategoryService;

@Service("repositoryCategoryService")
public class RepositoryCategoryServiceImpl implements RepositoryCategoryService {

	@Autowired
	private RepositoryCategoryMapper repositoryCategoryDao;
	@Autowired
	private RepositoryCategoryQueryMapper repositoryCategoryQueryDao;

	@Override
	public List<RepositoryCategoryExt> queryRepositoryCategory() throws Exception {
		List<RepositoryCategoryExt> list = repositoryCategoryQueryDao.selectAllRepositoryCategory();
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

	@Override
	public int checkName(String name) throws Exception {
		if (repositoryCategoryQueryDao.selectByName(name) != null) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public List<RepositoryCategoryExt> getAllRepositoryCategory() throws Exception {
		List<RepositoryCategoryExt> list = repositoryCategoryQueryDao.selectAll();
		return list;
	}

	@Override
	public String getParentName(Integer categoryId) throws Exception {
		RepositoryCategory record = repositoryCategoryDao.selectByPrimaryKey(categoryId);
		String parentName = record.getName();
		return parentName;
	}

	@Override
	public RepositoryCategoryExt getRepositoryCategoryExt(Integer categoryId) throws Exception {
		RepositoryCategoryExt record = repositoryCategoryQueryDao.selectById(categoryId);
		return record;
	}

	@Override
	public List<RepositoryCategoryExt> getRepositoryCategoryByName(String name) throws Exception {
		List<RepositoryCategoryExt> list = repositoryCategoryQueryDao.selectAllByName(name);
		return list;
	}

}
