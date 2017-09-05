package com.g10.ssm.service;

import java.util.List;

import com.g10.ssm.po.Log;

public interface LogService {
	public List<Log> queryLog() throws Exception;

	public int updateTestTable(Log log) throws Exception;

	public int saveLog(Log log) throws Exception;

	public int deleteLogByPrimaryKey(int logId) throws Exception;

	public Log queryLogById(Integer logId) throws Exception;
}
