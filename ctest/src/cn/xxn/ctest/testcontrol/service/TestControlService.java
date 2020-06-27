package cn.xxn.ctest.testcontrol.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.xxn.ctest.answerstate.entity.AnswerState;
import cn.xxn.ctest.bj.entity.BJ;
import cn.xxn.ctest.qprelationq.entity.QpRelationq;
import cn.xxn.ctest.question.entity.Question;
import cn.xxn.ctest.questionpaper.entity.QuestionPaper;
import cn.xxn.ctest.student.entity.Students;
import cn.xxn.ctest.testcontrol.dao.TestControlDao;
import cn.xxn.ctest.testcontrol.entity.TestControl;
import cn.xxn.ctest.testnote.entity.TestNote;

@Transactional
public class TestControlService {
	private TestControlDao tcDao;

	public void setTcDao(TestControlDao tcDao) {
		this.tcDao = tcDao;
	}
	//查看试卷
	public List<QuestionPaper> ckQuestionPaper() {
		return tcDao.ckQuestionPaper();
	}
	//添加考试信息
	public void addTestControl(TestControl testControl, Integer qpid) {
		tcDao.addTestControl(testControl,qpid);
	}
	//打开考场
	public void openTest() {
		tcDao.openTest();
	}
	//关闭考场
	public void closeTest() {
		tcDao.closeTest();
	}
	//查看考场信息
	public TestControl ckTestControl() {
		return tcDao.ckTestControl();
	}
	//查询考试记录
	public TestNote ckTestNote(Integer sid) {
		return tcDao.ckTestNote(sid);
	}
	//随机抽取试卷
	public QuestionPaper cqQuestionPaper() {
		
		return tcDao.cqQuestionPaper();
	}
	//根据学号查询学生
	public Students ckStudents(Integer sid) {
		return tcDao.ckStudents(sid);
	}
	//保存考试记录
	public void saveTestNote(TestNote tn1) {
		tcDao.saveTestNote(tn1);
	}
	
	//根据试卷id获取试卷信息
	public QuestionPaper hqQuestionPaper(Integer qpid) {
		return tcDao.hqQuestionPaper(qpid);
	}
	//根据试卷id查询选择题
	public List<QpRelationq> ckxzQpRelationq(Integer qpid) {
		return tcDao.ckxzQpRelationq(qpid);
	}
	//根据试卷id查询判断题
	public List<QpRelationq> ckpdQpRelationq(Integer qpid) {
		return tcDao.ckpdQpRelationq(qpid);
	}
	//根据试卷id查询填空题
	public List<QpRelationq> cktkQpRelationq(Integer qpid) {
		return tcDao.cktkQpRelationq(qpid);
	}
	//将试题id和testnote保存到answerState中
	public void saveQuestionTN(QuestionPaper qp, TestNote tn2) {
		List<QpRelationq> listqpq = tcDao.getQpq(qp.getQpid());
		Question q = null;
		for(int i=0; i<listqpq.size(); i++){
			AnswerState a = new AnswerState();
			a.setTestNote(tn2);
			a.setState(3);
			q = tcDao.czQuestion(listqpq.get(i).getQuestion().getQid());
			a.setQuestion(q);
			tcDao.saveAnswerState(a);
		}
	}
	public List<TestControl> lsks() {
		List<TestControl> list = tcDao.lsks();
		return list;
	}
}
