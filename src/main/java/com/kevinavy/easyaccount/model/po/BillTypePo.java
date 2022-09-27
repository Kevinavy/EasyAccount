package com.kevinavy.easyaccount.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kevinavy.easyaccount.constant.enums.BillTypeClass;

@TableName("bill_type")
public class BillTypePo {
    @TableId(type = IdType.ASSIGN_UUID)
    private String billTypeUuid;
    private String billTypeName;
    private String userUuid;
    private String parentUuid;
    private String grandParentUuid;
    private BillTypeClass billTypeClass;
    private String createTime;
    private String updateTime;
    private Integer deleteFlag;

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
