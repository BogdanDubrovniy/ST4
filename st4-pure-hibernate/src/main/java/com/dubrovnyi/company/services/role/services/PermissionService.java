package com.dubrovnyi.company.services.role.services;

import com.dubrovnyi.company.beans.PermissionBean;

/**
 * Created by Bohdan on 16.06.2017.
 */
public interface PermissionService {
    public PermissionBean getUserPermissionByUserLoginAndPassword(
            String userLogin, String userPassword);
}