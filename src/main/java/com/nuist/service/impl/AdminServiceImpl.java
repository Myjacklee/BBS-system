package com.nuist.service.impl;

import com.nuist.dao.AdminDao;
import com.nuist.domain.Admin;
import com.nuist.domain.PostAdmin;
import com.nuist.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiZonggen
 * @date 2021-03-29 11:17
 * @description:管理员账号服务层
 * @version:
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public Integer login(Admin admin) {
        return adminDao.login(admin);
    }

    @Override
    public Integer addAdmin(Admin admin) {
        adminDao.addAdmin(admin);

        return 1;
    }

    @Override
    public Integer setPostAdmin(PostAdmin postAdmin) {
        if(adminDao.findPosAdmin(postAdmin)!=0){
            return 2;
        }
        return adminDao.setPostAdmin(postAdmin);
    }


}
