package com.venink.slec.entity;

import com.venink.slec.base.utils.page.BaseObject;

public class ErrRecord extends BaseObject {
    private Integer id;

    private Integer personId;

    private String personName;

    private String errMsg;

    private String errType;

    private String deviceSN;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName == null ? null : personName.trim();
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg == null ? null : errMsg.trim();
    }

    public String getErrType() {
        return errType;
    }

    public void setErrType(String errType) {
        this.errType = errType == null ? null : errType.trim();
    }

    public String getDeviceSN() {
        return deviceSN;
    }

    public void setDeviceSN(String deviceSN) {
        this.deviceSN = deviceSN == null ? null : deviceSN.trim();
    }

    @Override
    public String toString() {
        return "ErrRecord{" +
                "id=" + id +
                ", personId=" + personId +
                ", personName='" + personName + '\'' +
                ", errMsg='" + errMsg + '\'' +
                ", errType='" + errType + '\'' +
                ", deviceSN='" + deviceSN + '\'' +
                '}';
    }
}