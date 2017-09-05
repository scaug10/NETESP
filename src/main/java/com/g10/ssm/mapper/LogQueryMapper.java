package com.g10.ssm.mapper;

import java.util.List;

import com.g10.ssm.po.Log;

public interface LogQueryMapper {
	List<Log> selectAllLog();
}
