package com.kevinavy.easyaccount.model.vo;

import com.kevinavy.easyaccount.constant.enums.AccountType;
import com.kevinavy.easyaccount.model.po.ModelPo;

public class ModelVo {
    private String modelUuid;
    private String modelName;
    private String accountUuid;
    private String billTypeUuid;
    private Integer billMoney;
    private String userUuid;

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getModelUuid() {
        return modelUuid;
    }

    public void setModelUuid(String modelUuid) {
        this.modelUuid = modelUuid;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
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

    public ModelVo() {
    }

    public ModelVo(ModelPo modelPo) {
        this.modelUuid = modelPo.getModelUuid();
        this.modelName = modelPo.getModelName();
        this.accountUuid = modelPo.getAccountUuid();
        this.billTypeUuid = modelPo.getBillTypeUuid();
        this.billMoney = modelPo.getBillMoney();
        this.userUuid = modelPo.getUserUuid();
    }
}
