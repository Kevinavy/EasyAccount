package com.kevinavy.easyaccount.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kevinavy.easyaccount.model.vo.ModelVo;

@TableName("model")
public class ModelPo {
    @TableId(type = IdType.ASSIGN_UUID)
    private String modelUuid;
    private String modelName;
    private String accountUuid;
    private String billTypeUuid;
    private Integer billMoney;
    private String userUuid;
    private String createTime;
    private String updateTime;
    private Integer deleteFlag;

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

    public ModelPo() {
    }

    public ModelPo(ModelVo modelVo) {
        this.modelUuid = modelVo.getModelUuid();
        this.modelName = modelVo.getModelName();
        this.accountUuid = modelVo.getAccountUuid();
        this.billTypeUuid = modelVo.getBillTypeUuid();
        this.billMoney = modelVo.getBillMoney();
        this.userUuid = modelVo.getUserUuid();
    }
}
