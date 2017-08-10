package com.g10.ssm.mapper;

import java.util.List;

import com.g10.ssm.po.Notice;

public interface NoticeQueryMapper {
	List<Notice> selectAllNotice();
}
