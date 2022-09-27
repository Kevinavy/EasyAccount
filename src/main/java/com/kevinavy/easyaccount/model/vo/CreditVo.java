package com.kevinavy.easyaccount.model.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kevinavy.easyaccount.constant.enums.CreditType;
import com.kevinavy.easyaccount.model.po.CreditPo;

public class CreditVo {
    private String creditUuid;
    private String creditName;
    private CreditType creditType;
    private Integer creditMoney;
    private Integer creditMoneyTotal;
    private Integer creditFinish;
    private String userUuid;

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

    public CreditVo() {
    }

    public CreditVo(CreditPo creditPo) {
        this.creditUuid = creditPo.getCreditUuid();
        this.creditName = creditPo.getCreditName();
        this.creditType = creditPo.getCreditType();
        this.creditMoney = creditPo.getCreditMoney();
        this.creditMoneyTotal = creditPo.getCreditMoneyTotal();
        this.creditFinish = creditPo.getCreditFinish();
        this.userUuid = creditPo.getUserUuid();
    }
}
