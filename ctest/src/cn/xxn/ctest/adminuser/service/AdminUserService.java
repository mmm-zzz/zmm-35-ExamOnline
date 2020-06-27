package cn.xxn.ctest.adminuser.service;

import org.springframework.transaction.annotation.Transactional;

import cn.xxn.ctest.adminuser.dao.AdminUserDao;
import cn.xxn.ctest.adminuser.entity.AdminUser;
import cn.xxn.ctest.teacheruser.entity.Teacher;

@Transactional
public class AdminUserService {
	
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}
	
	//����Ա��¼��֤
	public AdminUser login(AdminUser admin) {
		return adminUserDao.login(admin);
	}

	public void updatePW(Integer uid, String npw) {
		adminUserDao.updatePW(uid,npw);
	}

}
