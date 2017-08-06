package com.g10.ssm.mapper.knowledge;

import com.g10.ssm.po.knowledge.KnowledgeComment;
import com.g10.ssm.po.knowledge.KnowledgeCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KnowledgeCommentMapper {
    int countByExample(KnowledgeCommentExample example);

    int deleteByExample(KnowledgeCommentExample example);

    int deleteByPrimaryKey(Integer commentId);

    int insert(KnowledgeComment record);

    int insertSelective(KnowledgeComment record);

    List<KnowledgeComment> selectByExample(KnowledgeCommentExample example);

    KnowledgeComment selectByPrimaryKey(Integer commentId);

    int updateByExampleSelective(@Param("record") KnowledgeComment record, @Param("example") KnowledgeCommentExample example);

    int updateByExample(@Param("record") KnowledgeComment record, @Param("example") KnowledgeCommentExample example);

    int updateByPrimaryKeySelective(KnowledgeComment record);

    int updateByPrimaryKey(KnowledgeComment record);
}