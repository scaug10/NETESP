package com.g10.ssm.po.testdatabase;

import java.util.List;

/**
 * @ClassName: SubjectQueryVo
 * @Description: 试卷题型Vo类，保存单类题型的每道题和每题分数
 * @author 	FYW
 * @date 	2017年9月3日 下午3:09:03
 */
public class SubjectQueryVo {
	private List<SubjectCustom> list;
	private Integer singleScore;

	public List<SubjectCustom> getList() {
		return list;
	}

	public void setList(List<SubjectCustom> list) {
		this.list = list;
	}

	public Integer getSingleScore() {
		return singleScore;
	}

	public void setSingleScore(Integer singleScore) {
		this.singleScore = singleScore;
	}

}
