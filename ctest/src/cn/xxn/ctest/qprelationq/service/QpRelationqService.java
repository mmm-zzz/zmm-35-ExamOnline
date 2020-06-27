package cn.xxn.ctest.qprelationq.service;

import org.springframework.transaction.annotation.Transactional;

import cn.xxn.ctest.qprelationq.dao.QpRelationqDao;

@Transactional
public class QpRelationqService {
	private QpRelationqDao qprqDao;

	public void setQprqDao(QpRelationqDao qprqDao) {
		this.qprqDao = qprqDao;
	}
}
