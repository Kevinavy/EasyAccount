package com.kevinavy.easyaccount.model.vo;

public class BillVo {
    private String billUuid;
    private String accountUuid;
    private String billTypeUuid;
    private Integer billMoney;
    private String billDate;
    private String billTime;
    private String billDesc;
    private Integer relatedCreditFlag;
    private String relatedCreditUuid;
    private Integer relatedCreditMoney;
    private Integer relatedTransactionFlag;
    private String relatedTransactionUuid;
    private String userUuid;

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
}
