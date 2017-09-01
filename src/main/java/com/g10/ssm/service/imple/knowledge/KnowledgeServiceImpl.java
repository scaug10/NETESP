package com.g10.ssm.service.imple.knowledge;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.knowledge.KnowledgeMapper;
import com.g10.ssm.mapper.knowledge.KnowledgeQueryMapper;
import com.g10.ssm.po.knowledge.Knowledge;
import com.g10.ssm.po.knowledge.KnowledgeExt;
import com.g10.ssm.service.knowledge.KnowledgeService;

@Service("knowledgeService")
public class KnowledgeServiceImpl implements KnowledgeService {

	@Autowired
	private KnowledgeMapper knowledgeDao;
	@Autowired
	private KnowledgeQueryMapper knowledgeQueryDao;

	@Override
	public List<KnowledgeExt> queryKnowledge() throws Exception {
		List<KnowledgeExt> list = knowledgeQueryDao.selectAllKnowledge();
		return list;
	}

	@Override
	public int updateKnowledge(Knowledge knowledge) throws Exception {
		int result = knowledgeDao.updateByPrimaryKeySelective(knowledge);
		return result;
	}

	@Override
	public int saveKnowledge(Knowledge knowledge) throws Exception {
		int result = knowledgeDao.insertSelective(knowledge);
		return result;
	}

	@Override
	public int deleteKnowledgeByPrimaryKey(int knowledgeId) throws Exception {
		int result = knowledgeDao.deleteByPrimaryKey(knowledgeId);
		return result;
	}

	@Override
	public Knowledge queryKnowledgeById(Integer knowledgeId) throws Exception {
		Knowledge record = knowledgeDao.selectByPrimaryKey(knowledgeId);
		return record;
	}

	@Override
	public KnowledgeExt getKnowledge(Integer knowledgeId) throws Exception {
		KnowledgeExt record = knowledgeQueryDao.selectById(knowledgeId);
		return record;
	}

	@Override
	public KnowledgeExt selectByName(String name) throws Exception {
		KnowledgeExt record = knowledgeQueryDao.selectByName(name);
		return record;
	}

	@Override
	public List<KnowledgeExt> getKnowledgeByName(String name) throws Exception {
		List<KnowledgeExt> list = knowledgeQueryDao.selectKnowledgeByName(name);
		return list;
	}

	@Override
	public int deleteKnowledge(ArrayList<Integer> knowledgeArray) throws Exception {
		int result = knowledgeQueryDao.deleteKnowledge(knowledgeArray);
		return result;
	}
}
