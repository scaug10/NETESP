package com.g10.ssm.mapper.knowledge;

import java.util.ArrayList;
import java.util.List;

import com.g10.ssm.po.knowledge.KnowledgeExt;

public interface KnowledgeQueryMapper {
	List<KnowledgeExt> selectAllKnowledge();

	List<KnowledgeExt> selectKnowledgeByName(String name);

	KnowledgeExt selectById(int knowledgeId);

	KnowledgeExt selectByName(String name);

	int deleteKnowledge(ArrayList<Integer> knowledgeArray);
}
