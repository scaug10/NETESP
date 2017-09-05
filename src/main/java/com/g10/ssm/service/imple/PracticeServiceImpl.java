package com.g10.ssm.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.PracticeMapper;
import com.g10.ssm.mapper.PracticeQueryMapper;
import com.g10.ssm.po.Practice;
import com.g10.ssm.service.PracticeService;

@Service("practiceService")
public class PracticeServiceImpl implements PracticeService {

	@Autowired
	private PracticeMapper practiceDao;
	@Autowired
	private PracticeQueryMapper practiceQueryDao;

	@Override
	public List<Practice> queryPractice() throws Exception {
		List<Practice> list = practiceQueryDao.selectAllPractice();
		return list;
	}

	@Override
	public int updatePractice(Practice practice) throws Exception {
		int result = practiceDao.updateByPrimaryKeySelective(practice);
		return result;
	}

	@Override
	public int savePractice(Practice practice) throws Exception {
		int result = practiceDao.insertSelective(practice);
		return result;
	}

	@Override
	public int deletePracticeByPrimaryKey(int practiceId) throws Exception {
		int result = practiceDao.deleteByPrimaryKey(practiceId);
		return result;
	}

	@Override
	public Practice queryPracticeById(Integer practiceId) throws Exception {
		Practice record = practiceDao.selectByPrimaryKey(practiceId);
		return record;
	}

}
