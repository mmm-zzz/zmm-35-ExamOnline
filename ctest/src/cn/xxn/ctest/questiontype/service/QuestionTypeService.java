package cn.xxn.ctest.questiontype.service;

import org.springframework.transaction.annotation.Transactional;

import cn.xxn.ctest.questiontype.dao.QuestionTypeDao;

@Transactional
public class QuestionTypeService {

	private QuestionTypeDao qtDao;

	public void setQtDao(QuestionTypeDao qtDao) {
		this.qtDao = qtDao;
	}
}
