package cn.xxn.ctest.testnote.service;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import cn.xxn.ctest.testnote.dao.TestNoteDao;
import cn.xxn.ctest.testnote.entity.TestNote;
@Transactional
public class TestNoteService {
	private TestNoteDao tnDao;

	public void setTnDao(TestNoteDao tnDao) {
		this.tnDao = tnDao;
	}
	//插入考试结束时间
	public void upEndTime(Integer tnid) {
		TestNote tn = tnDao.getTestNote(tnid);
		tn.setEtime(new Date());
		tnDao.saveTestNote(tn);
	}
}
