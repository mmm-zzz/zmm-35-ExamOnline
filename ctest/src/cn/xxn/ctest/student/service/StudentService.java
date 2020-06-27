package cn.xxn.ctest.student.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.xxn.ctest.answerstate.entity.AnswerState;
import cn.xxn.ctest.bj.entity.BJ;
import cn.xxn.ctest.student.dao.StudentDao;
import cn.xxn.ctest.student.entity.Students;
import cn.xxn.ctest.teacheruser.entity.Teacher;
import cn.xxn.ctest.testnote.entity.TestNote;
import cn.xxn.ctest.utils.PageBean;

@Transactional
public class StudentService {
	private StudentDao studentDao;

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	//根据教师编号查询属于该教师的学生
	public PageBean<Students> ckStudent(Integer tid, int page) {
		PageBean<Students> pageBean = new PageBean<Students>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示的记录数
		int limit = 3;
		pageBean.setLimit(limit);
		//设置总的记录数
		int totalCount = 0;
		totalCount = studentDao.findCountTid(tid);
		pageBean.setTotalCount(totalCount);
		//设置总的页数
		int totalPage = 0;
		if(totalCount % limit == 0 ){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit +1;
		}
		pageBean.setTotalPage(totalPage);
		//每页显示的数据集合
		//从哪条记录开始
		int begin = (page - 1) * limit;
		List<Students> list = studentDao.findByPageTid(tid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	public PageBean<Students> ckStudentAdmin(int page) {
		PageBean<Students> pageBean = new PageBean<Students>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示的记录数
		int limit = 3;
		pageBean.setLimit(limit);
		//设置总的记录数
		int totalCount = 0;
		totalCount = studentDao.findCountAdmin();
		pageBean.setTotalCount(totalCount);
		//设置总的页数
		int totalPage = 0;
		if(totalCount % limit == 0 ){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit +1;
		}
		pageBean.setTotalPage(totalPage);
		//每页显示的数据集合
		//从哪条记录开始
		int begin = (page - 1) * limit;
		List<Students> list = studentDao.findByPageAdmin(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	public List<BJ> ckbj(Integer tid) {
		
		return studentDao.ckbj(tid);
	}
	public List<BJ> ckbjAdmin() {
		return studentDao.ckbjAdmin();
	}
	//根据学号查询学生是否存在
	public Students findBySid(Integer sid) {
		return studentDao.finBySid(sid);
	}
	//添加学生信息实现
	public void addStudentSX(Students student, Integer bjid) {
		studentDao.addStudentSX(student,bjid);	
	}
	//修改密码实现
	public void updatePW(Integer sid, String npw) {
		studentDao.updatePW(sid,npw);
	}
	//根据学号删除学生信息
	public void deleteStudent(Integer sid) {
		studentDao.deleteStudent(sid);
	}
	
	//根据学号查询考试记录
	public List<TestNote> ckTestNote(Integer sid) {
		return studentDao.ckTestNote(sid);
	}
	//根据考试记录id查询选择题答题情况
	public List<AnswerState> ckAnswerStatexz(Integer tnid) {
		return studentDao.ckAnserStatexz(tnid);
	}
	//根据考试记录id查询判断题答题情况
	public List<AnswerState> ckAnswerStatepd(Integer tnid) {
		return studentDao.ckAnserStatepd(tnid);
	}
	//根据考试记录id查询填空题答题情况
	public List<AnswerState> ckAnswerStatetk(Integer tnid) {
		return studentDao.ckAnserStatetk(tnid);
	}

	public Students login(Students student) {
		return studentDao.login(student);
	}
	//根据学号查询学生信息
	public Students cxStudent(Integer sid) {
		return studentDao.ckStudent(sid);
	}
	
	//完善学生信息实现
	public void wsStudentSX(Students student) {
		studentDao.wsStudentSX(student);
	}
	//查询学生信息
	public BJ myBJ(Integer sid) {
		return studentDao.myBJ(sid);
	}
	//根据学号查询学生信息
	public Students ckStudentXX(Integer sid) {
		return studentDao.ckStudentXX(sid);
	}
	
}
