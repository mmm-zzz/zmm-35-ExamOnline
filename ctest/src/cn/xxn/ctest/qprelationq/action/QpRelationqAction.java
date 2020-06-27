package cn.xxn.ctest.qprelationq.action;

import cn.xxn.ctest.qprelationq.entity.QpRelationq;
import cn.xxn.ctest.qprelationq.service.QpRelationqService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class QpRelationqAction extends ActionSupport implements ModelDriven<QpRelationq>{
	
	private QpRelationq qpRelationq = new QpRelationq();
	public QpRelationq getModel() {
		return qpRelationq;
	}
	
	private QpRelationqService qprqService;
	public void setQprqService(QpRelationqService qprqService) {
		this.qprqService = qprqService;
	}
}
