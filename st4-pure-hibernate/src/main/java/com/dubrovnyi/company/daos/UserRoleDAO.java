package com.dubrovnyi.company.daos;

import com.dubrovnyi.company.beans.UserRole;

/**
 * Created by Bohdan on 16.06.2017.
 */
public class UserRoleDAO {
    private DAOHandler handler;

    public UserRoleDAO() {
        handler = DAOHandler.getInstanceHandler();
    }

    public void createNewUserRole(UserRole userRole) {
        handler.createObject(userRole);
    }
}
