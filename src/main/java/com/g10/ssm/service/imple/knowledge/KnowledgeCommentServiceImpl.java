package com.g10.ssm.service.imple.knowledge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.knowledge.KnowledgeCommentMapper;
import com.g10.ssm.mapper.knowledge.KnowledgeCommentQueryMapper;
import com.g10.ssm.po.knowledge.KnowledgeComment;
import com.g10.ssm.service.knowledge.KnowledgeCommentService;

@Service("knowledgeCommentService")
public class KnowledgeCommentServiceImpl implements KnowledgeCommentService {

	@Autowired
	private KnowledgeCommentMapper knowledgeCommentDao;
	@Autowired
	private KnowledgeCommentQueryMapper knowledgeCommentQueryDao;

	@Override
	public List<KnowledgeComment> queryKnowledgeComment() throws Exception {
		List<KnowledgeComment> list = knowledgeCommentQueryDao.selectAllKnowledgeComment();
		return list;
	}

	@Override
	public int updateKnowledgeComment(KnowledgeComment testTable) throws Exception {
		int result = knowledgeCommentDao.updateByPrimaryKeySelective(testTable);
		return result;
	}

	@Override
	public int saveKnowledgeComment(KnowledgeComment testTable) throws Exception {
		int result = knowledgeCommentDao.insertSelective(testTable);
		return result;
	}

	@Override
	public int deleteKnowledgeCommentByPrimaryKey(int commentId) throws Exception {
		int result = knowledgeCommentDao.deleteByPrimaryKey(commentId);
		return result;
	}

	@Override
	public KnowledgeComment queryKnowledgeCommentById(Integer commentId) throws Exception {
		KnowledgeComment record = knowledgeCommentDao.selectByPrimaryKey(commentId);
		return record;
	}

}
