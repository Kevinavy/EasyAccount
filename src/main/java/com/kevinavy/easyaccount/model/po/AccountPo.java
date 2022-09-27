package com.kevinavy.easyaccount.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kevinavy.easyaccount.constant.enums.AccountType;

@TableName("account")
public class AccountPo {
    @TableId(type = IdType.ASSIGN_UUID)
    private String accountUuid;
    private String accountName;
    private AccountType accountType;
    private Float accountMoney;
    private Float creditMoney;
    private String userUuid;
    private String createTime;
    private String updateTime;
    private Integer deleteFlag;

    public Float getCreditMoney() {
        return creditMoney;
    }

    public void setCreditMoney(Float creditMoney) {
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public AccountPo() {
    }
}
