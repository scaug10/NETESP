package com.g10.ssm.service.knowledge;

import java.util.List;

import com.g10.ssm.po.knowledge.KnowledgeComment;

public interface KnowledgeCommentService {
	public List<KnowledgeComment> queryKnowledgeComment() throws Exception;

	public int updateKnowledgeComment(KnowledgeComment testTable) throws Exception;

	public int saveKnowledgeComment(KnowledgeComment testTable) throws Exception;

	public int deleteKnowledgeCommentByPrimaryKey(int commentId) throws Exception;

	public KnowledgeComment queryKnowledgeCommentById(Integer commentId) throws Exception;
}
