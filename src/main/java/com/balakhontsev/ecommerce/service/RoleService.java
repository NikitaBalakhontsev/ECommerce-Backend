package com.balakhontsev.ecommerce.service;

import com.balakhontsev.ecommerce.dao.RoleDao;
import com.balakhontsev.ecommerce.entity.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleDao roleDao;

    public RoleService(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public Role createNewRole(Role role){
        return roleDao.save(role);
    }
}
