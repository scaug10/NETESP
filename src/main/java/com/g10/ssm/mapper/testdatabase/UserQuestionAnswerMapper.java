package com.g10.ssm.mapper.testdatabase;

import com.g10.ssm.po.testdatabase.UserQuestionAnswer;
import com.g10.ssm.po.testdatabase.UserQuestionAnswerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserQuestionAnswerMapper {
    int countByExample(UserQuestionAnswerExample example);

    int deleteByExample(UserQuestionAnswerExample example);

    int deleteByPrimaryKey(Integer userAnswerId);

    int insert(UserQuestionAnswer record);

    int insertSelective(UserQuestionAnswer record);

    List<UserQuestionAnswer> selectByExample(UserQuestionAnswerExample example);

    UserQuestionAnswer selectByPrimaryKey(Integer userAnswerId);

    int updateByExampleSelective(@Param("record") UserQuestionAnswer record, @Param("example") UserQuestionAnswerExample example);

    int updateByExample(@Param("record") UserQuestionAnswer record, @Param("example") UserQuestionAnswerExample example);

    int updateByPrimaryKeySelective(UserQuestionAnswer record);

    int updateByPrimaryKey(UserQuestionAnswer record);
}