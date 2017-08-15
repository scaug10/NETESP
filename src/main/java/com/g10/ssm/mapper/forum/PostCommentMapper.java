package com.g10.ssm.mapper.forum;

import com.g10.ssm.po.forum.PostComment;
import com.g10.ssm.po.forum.PostCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostCommentMapper {
    int countByExample(PostCommentExample example);

    int deleteByExample(PostCommentExample example);

    int deleteByPrimaryKey(Integer postCommentId);

    int insert(PostComment record);

    int insertSelective(PostComment record);

    List<PostComment> selectByExample(PostCommentExample example);

    PostComment selectByPrimaryKey(Integer postCommentId);

    int updateByExampleSelective(@Param("record") PostComment record, @Param("example") PostCommentExample example);

    int updateByExample(@Param("record") PostComment record, @Param("example") PostCommentExample example);

    int updateByPrimaryKeySelective(PostComment record);

    int updateByPrimaryKey(PostComment record);
}