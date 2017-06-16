package com.dubrovnyi.company.services.role.services.implementations;

import com.dubrovnyi.company.beans.PermissionBean;
import com.dubrovnyi.company.beans.User;
import com.dubrovnyi.company.daos.UserDAO;
import com.dubrovnyi.company.services.role.services.PermissionService;

import static com.dubrovnyi.company.constants.ConstantClass.ACCOUNT_BLOCK_VALUE;
import static com.dubrovnyi.company.constants.ConstantClass.ADMIN_ROLE_VALUE;

public class PermissionServiceImpl implements PermissionService {
    UserDAO userDAO;

    public PermissionServiceImpl() {
        userDAO = new UserDAO();
    }

    @Override
    public PermissionBean getUserPermissionByUserLoginAndPassword(
            String userLogin, String userPassword) {

        PermissionBean permission = new PermissionBean();
        User currentUserByLoginAndPassword = userDAO
                .getUserByUserLoginAndPassword(userLogin, userPassword);

        if (currentUserByLoginAndPassword != null) {
            String currentUserRole = currentUserByLoginAndPassword.getUserRole()
                    .getUserRole();
            permission.setUserRole(currentUserRole);

            boolean isUserBlocked = ADMIN_ROLE_VALUE.equals(currentUserRole)
                    || ACCOUNT_BLOCK_VALUE
                    .equals(currentUserByLoginAndPassword.getUserBlockValue());
            permission.setBlocked(isUserBlocked);
        }
        return permission;
    }
}
