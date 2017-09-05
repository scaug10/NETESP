package com.g10.ssm.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.LogMapper;
import com.g10.ssm.mapper.LogQueryMapper;
import com.g10.ssm.po.Log;
import com.g10.ssm.service.LogService;

@Service("logService")
public class LogServiceImpl implements LogService {

	@Autowired
	private LogMapper logDao;
	@Autowired
	private LogQueryMapper logQueryDao;

	@Override
	public List<Log> queryLog() throws Exception {
		List<Log> list = logQueryDao.selectAllLog();
		return list;
	}

	@Override
	public int updateTestTable(Log log) throws Exception {
		int result = logDao.updateByPrimaryKeySelective(log);
		return result;
	}

	@Override
	public int saveLog(Log log) throws Exception {
		int result = logDao.insertSelective(log);
		return result;
	}

	@Override
	public int deleteLogByPrimaryKey(int logId) throws Exception {
		int result = logDao.deleteByPrimaryKey(logId);
		return result;
	}

	@Override
	public Log queryLogById(Integer logId) throws Exception {
		Log record = logDao.selectByPrimaryKey(logId);
		return record;
	}

}
