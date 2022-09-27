package com.kevinavy.easyaccount.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("bill")
public class BillPo {
    @TableId(type = IdType.ASSIGN_UUID)
    private String billUuid;
    private String accountUuid;
    private String billTypeUuid;
    private Integer billMoney;
    private String billDate;
    private String billTime;
    private String billDesc;
    private Integer relatedCreditFlag;
    private String relatedCreditUuid;
    private Integer relatedTransactionFlag;
    private Integer relatedCreditMoney;
    private String relatedTransactionUuid;
    private String userUuid;
    private String createTime;
    private String updateTime;
    private Integer deleteFlag;

    public Integer getRelatedCreditMoney() {
        return relatedCreditMoney;
    }

    public void setRelatedCreditMoney(Integer relatedCreditMoney) {
        this.relatedCreditMoney = relatedCreditMoney;
    }

    public String getBillUuid() {
        return billUuid;
    }

    public void setBillUuid(String billUuid) {
        this.billUuid = billUuid;
    }

    public String getAccountUuid() {
        return accountUuid;
    }

    public void setAccountUuid(String accountUuid) {
        this.accountUuid = accountUuid;
    }

    public String getBillTypeUuid() {
        return billTypeUuid;
    }

    public void setBillTypeUuid(String billTypeUuid) {
        this.billTypeUuid = billTypeUuid;
    }

    public Integer getBillMoney() {
        return billMoney;
    }

    public void setBillMoney(Integer billMoney) {
        this.billMoney = billMoney;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getBillTime() {
        return billTime;
    }

    public void setBillTime(String billTime) {
        this.billTime = billTime;
    }

    public String getBillDesc() {
        return billDesc;
    }

    public void setBillDesc(String billDesc) {
        this.billDesc = billDesc;
    }

    public Integer getRelatedCreditFlag() {
        return relatedCreditFlag;
    }

    public void setRelatedCreditFlag(Integer relatedCreditFlag) {
        this.relatedCreditFlag = relatedCreditFlag;
    }

    public String getRelatedCreditUuid() {
        return relatedCreditUuid;
    }

    public void setRelatedCreditUuid(String relatedCreditUuid) {
        this.relatedCreditUuid = relatedCreditUuid;
    }

    public Integer getRelatedTransactionFlag() {
        return relatedTransactionFlag;
    }

    public void setRelatedTransactionFlag(Integer relatedTransactionFlag) {
        this.relatedTransactionFlag = relatedTransactionFlag;
    }

    public String getRelatedTransactionUuid() {
        return relatedTransactionUuid;
    }

    public void setRelatedTransactionUuid(String relatedTransactionUuid) {
        this.relatedTransactionUuid = relatedTransactionUuid;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
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
}
