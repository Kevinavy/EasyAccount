package com.kevinavy.easyaccount.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kevinavy.easyaccount.constant.enums.CreditType;
import com.kevinavy.easyaccount.model.vo.CreditVo;

@TableName("credit")
public class CreditPo {
    @TableId(type = IdType.ASSIGN_UUID)
    private String creditUuid;
    private String creditName;
    private CreditType creditType;
    private Integer creditMoney;
    private Integer creditMoneyTotal;
    private Integer creditFinish;
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

    public String getCreditUuid() {
        return creditUuid;
    }

    public void setCreditUuid(String creditUuid) {
        this.creditUuid = creditUuid;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public CreditType getCreditType() {
        return creditType;
    }

    public void setCreditType(CreditType creditType) {
        this.creditType = creditType;
    }

    public Integer getCreditMoney() {
        return creditMoney;
    }

    public void setCreditMoney(Integer creditMoney) {
        this.creditMoney = creditMoney;
    }

    public Integer getCreditMoneyTotal() {
        return creditMoneyTotal;
    }

    public void setCreditMoneyTotal(Integer creditMoneyTotal) {
        this.creditMoneyTotal = creditMoneyTotal;
    }

    public Integer getCreditFinish() {
        return creditFinish;
    }

    public void setCreditFinish(Integer creditFinish) {
        this.creditFinish = creditFinish;
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

    public CreditPo() {
    }

    public CreditPo(CreditVo creditVo) {
        this.creditName = creditVo.getCreditName();
        this.creditType = creditVo.getCreditType();
        this.creditMoney = creditVo.getCreditMoney();
        this.creditMoneyTotal = creditVo.getCreditMoneyTotal();
        this.creditFinish = creditVo.getCreditFinish();
        this.userUuid = creditVo.getUserUuid();
    }
}
