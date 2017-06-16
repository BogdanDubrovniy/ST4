package com.dubrovnyi.company.services.block.strategy.services.implementations;

import com.dubrovnyi.company.beans.User;
import com.dubrovnyi.company.daos.UserDAO;
import com.dubrovnyi.company.services.block.strategy.services.BlockerStrategyService;

import static com.dubrovnyi.company.constants.ConstantClass.ACCOUNT_UNBLOCK_VALUE;

/**
 * Unblock user by user login
 */
public class UnblockUserStrategyService implements BlockerStrategyService {
    private UserDAO userDAO;

    public UnblockUserStrategyService() {
        userDAO = new UserDAO();
    }

    @Override
    public void changeBlock(String blockerId) {
        User currentUser = userDAO.getUserByUserLogin(blockerId);
        currentUser.setUserBlockValue(ACCOUNT_UNBLOCK_VALUE);

        userDAO.updateUser(currentUser);
    }
}
