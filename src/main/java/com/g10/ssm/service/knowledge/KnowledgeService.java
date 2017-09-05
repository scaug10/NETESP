package com.g10.ssm.service.knowledge;

import java.util.ArrayList;
import java.util.List;

import com.g10.ssm.po.knowledge.Knowledge;
import com.g10.ssm.po.knowledge.KnowledgeExt;

public interface KnowledgeService {
	public List<KnowledgeExt> queryKnowledge() throws Exception;

	public List<KnowledgeExt> getKnowledgeByName(String name) throws Exception;

	public int updateKnowledge(Knowledge knowledge) throws Exception;

	public int saveKnowledge(Knowledge knowledge) throws Exception;

	public int deleteKnowledgeByPrimaryKey(int knowledgeId) throws Exception;

	public int deleteKnowledge(ArrayList<Integer> knowledgeArray) throws Exception;

	public Knowledge queryKnowledgeById(Integer knowledgeId) throws Exception;

	public KnowledgeExt selectByName(String name) throws Exception;

	public KnowledgeExt getKnowledge(Integer knowledgeId) throws Exception;
}
