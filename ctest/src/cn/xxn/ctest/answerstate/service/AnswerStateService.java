package cn.xxn.ctest.answerstate.service;

import org.springframework.transaction.annotation.Transactional;

import cn.xxn.ctest.answerstate.dao.AnswerStateDao;
import cn.xxn.ctest.answerstate.entity.AnswerState;
import cn.xxn.ctest.question.entity.Question;
import cn.xxn.ctest.testnote.entity.TestNote;

@Transactional
public class AnswerStateService {
	private AnswerStateDao asDao;

	public void setAsDao(AnswerStateDao asDao) {
		this.asDao = asDao;
	}
	//±£¥Ê ‘Ã‚¥∞∏
	public void saveAnswerState(Integer tnid, Integer qid, String qas) {
		AnswerState a = asDao.hqAnswerState(tnid,qid);
		Question q = asDao.hqQuestion(qid);
		TestNote tn = asDao.hqTestNote(tnid);
		if(qas.equals(q.getQanswer())){
			a.setState(1);
		}else{
			a.setState(2);
		}
		a.setQuestion(q);
		a.setTestNote(tn);
		asDao.saveAnswerState(a);
	}
}
