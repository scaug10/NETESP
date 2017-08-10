package com.g10.ssm.service.knowledge;

import java.util.List;

import com.g10.ssm.po.knowledge.Knowledge;

public interface KnowledgeService {
	public List<Knowledge> queryKnowledge() throws Exception;

	public int updateKnowledge(Knowledge knowledge) throws Exception;

	public int saveKnowledge(Knowledge knowledge) throws Exception;

	public int deleteKnowledgeByPrimaryKey(int knowledgeId) throws Exception;

	public Knowledge queryKnowledgeById(Integer knowledgeId) throws Exception;
}
