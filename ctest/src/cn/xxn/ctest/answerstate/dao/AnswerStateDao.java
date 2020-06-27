package cn.xxn.ctest.answerstate.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.xxn.ctest.answerstate.entity.AnswerState;
import cn.xxn.ctest.question.entity.Question;
import cn.xxn.ctest.testnote.entity.TestNote;

public class AnswerStateDao extends HibernateDaoSupport{
	
	//��������id��tnid��ѯanswerState
	public AnswerState hqAnswerState(Integer tnid, Integer qid) {
		String hql = "from AnswerState a where a.question.qid = ? and a.testNote.tnid = ?";
		List<AnswerState> listas = (List<AnswerState>) this.getHibernateTemplate().find(hql, qid,tnid);
		if(listas != null && listas.size() > 0){
			return listas.get(0);
		}
		return null;
	}
	//���������Ų�ѯ����
	public Question hqQuestion(Integer qid) {
		String hql = "from Question where qid = ?";
		List<Question> listq = (List<Question>) this.getHibernateTemplate().find(hql, qid);
		if(listq != null && listq.size() > 0){
			return listq.get(0);
		}
		return null;
	}
	//���ݿ��Լ�¼��Ų�ѯ���Լ�¼
	public TestNote hqTestNote(Integer tnid) {
		String hql = "from TestNote where tnid = ?";
		List<TestNote> list = (List<TestNote>) this.getHibernateTemplate().find(hql, tnid);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	//����ѧ���������
	public void saveAnswerState(AnswerState a) {
		this.getHibernateTemplate().save(a);
	}

}
