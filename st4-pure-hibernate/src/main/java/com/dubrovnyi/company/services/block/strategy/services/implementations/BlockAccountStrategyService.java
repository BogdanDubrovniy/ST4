package com.dubrovnyi.company.services.block.strategy.services.implementations;

import com.dubrovnyi.company.beans.Account;
import com.dubrovnyi.company.daos.AccountDAO;
import com.dubrovnyi.company.services.block.strategy.services.BlockerStrategyService;

import static com.dubrovnyi.company.constants.ConstantClass.ACCOUNT_BLOCK_VALUE;

/**
 * Blocks account by accountName
 */
public class BlockAccountStrategyService implements BlockerStrategyService {

    private AccountDAO accountDAO;

    public BlockAccountStrategyService() {
        accountDAO = new AccountDAO();
    }

    @Override
    public void changeBlock(String blockerId) {
        Account currentAccount = accountDAO.getAccountByAccountName(blockerId);
        currentAccount.setAccountBlockValue(ACCOUNT_BLOCK_VALUE);

        accountDAO.updateAccount(currentAccount);
    }
}
