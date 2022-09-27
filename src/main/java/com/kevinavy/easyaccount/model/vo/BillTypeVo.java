package com.kevinavy.easyaccount.model.vo;

import com.kevinavy.easyaccount.constant.enums.BillTypeClass;

public class BillTypeVo {
    private String billTypeUuid;
    private String billTypeName;
    private String userUuid;
    private String parentUuid;
    private String grandParentUuid;
    private BillTypeClass billTypeClass;

    public BillTypeClass getBillTypeClass() {
        return billTypeClass;
    }

    public void setBillTypeClass(BillTypeClass billTypeClass) {
        this.billTypeClass = billTypeClass;
    }

    public String getBillTypeUuid() {
        return billTypeUuid;
    }

    public void setBillTypeUuid(String billTypeUuid) {
        this.billTypeUuid = billTypeUuid;
    }

    public String getBillTypeName() {
        return billTypeName;
    }

    public void setBillTypeName(String billTypeName) {
        this.billTypeName = billTypeName;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getParentUuid() {
        return parentUuid;
    }

    public void setParentUuid(String parentUuid) {
        this.parentUuid = parentUuid;
    }

    public String getGrandParentUuid() {
        return grandParentUuid;
    }

    public void setGrandParentUuid(String grandParentUuid) {
        this.grandParentUuid = grandParentUuid;
    }
}
