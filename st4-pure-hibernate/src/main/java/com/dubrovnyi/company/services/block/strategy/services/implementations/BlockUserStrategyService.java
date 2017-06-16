package com.dubrovnyi.company.services.block.strategy.services.implementations;

import com.dubrovnyi.company.beans.User;
import com.dubrovnyi.company.daos.UserDAO;
import com.dubrovnyi.company.services.block.strategy.services.BlockerStrategyService;

import static com.dubrovnyi.company.constants.ConstantClass.ACCOUNT_BLOCK_VALUE;

/**
 * Blocks User by login
 */
public class BlockUserStrategyService implements BlockerStrategyService {
    private UserDAO userDAO;

    public BlockUserStrategyService() {
        userDAO = new UserDAO();
    }

    @Override
    public void changeBlock(String blockerId) {
        User currentUser = userDAO.getUserByUserLogin(blockerId);
        currentUser.setUserBlockValue(ACCOUNT_BLOCK_VALUE);

        userDAO.updateUser(currentUser);
    }
}
