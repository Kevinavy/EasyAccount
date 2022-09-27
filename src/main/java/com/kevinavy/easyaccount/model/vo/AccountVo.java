package com.kevinavy.easyaccount.model.vo;

import com.kevinavy.easyaccount.constant.enums.AccountType;

public class AccountVo {
    private String accountUuid;
    private String accountName;
    private AccountType accountType;
    private Float accountMoney;
    private Integer creditMoney;
    private String userUuid;

    public Integer getCreditMoney() {
        return creditMoney;
    }

    public void setCreditMoney(Integer creditMoney) {
        this.creditMoney = creditMoney;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getAccountUuid() {
        return accountUuid;
    }

    public void setAccountUuid(String accountUuid) {
        this.accountUuid = accountUuid;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Float getAccountMoney() {
        return accountMoney;
    }

    public void setAccountMoney(Float accountMoney) {
        this.accountMoney = accountMoney;
    }

    public AccountVo() {
    }
}
