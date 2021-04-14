package com.nuist.service;

import com.nuist.domain.Admin;
import com.nuist.domain.Post;
import com.nuist.domain.PostAdmin;

public interface AdminService {
    public Integer login(Admin admin);
    public Integer addAdmin(Admin admin);
    public Integer setPostAdmin(PostAdmin postAdmin);
}
