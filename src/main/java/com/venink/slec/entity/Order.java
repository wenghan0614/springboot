package com.venink.slec.entity;

import com.venink.slec.base.utils.page.BaseObject;
import java.util.Date;

public class Order extends BaseObject {
    private Integer id;

    private String orderId;

    private String userName;

    private String sex;

    private String phoneNum;

    private Date birthday;

    private String email;

    private String region;

    private String location;

    private Integer paperStatus;

    private Integer projectType;

    private Integer payStatus;

    private String smsNum;

    private Integer smsStatus;

    private Date smsTime;

    private Date createTime;

    private Integer handleStatus;

    private Date handleTime;

    private String remarksMsg;

    private String srcAddress;

    private Date startTime;
    private Date endTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Integer getPaperStatus() {
        return paperStatus;
    }

    public void setPaperStatus(Integer paperStatus) {
        this.paperStatus = paperStatus;
    }

    public Integer getProjectType() {
        return projectType;
    }

    public void setProjectType(Integer projectType) {
        this.projectType = projectType;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public String getSmsNum() {
        return smsNum;
    }

    public void setSmsNum(String smsNum) {
        this.smsNum = smsNum == null ? null : smsNum.trim();
    }

    public Integer getSmsStatus() {
        return smsStatus;
    }

    public void setSmsStatus(Integer smsStatus) {
        this.smsStatus = smsStatus;
    }

    public Date getSmsTime() {
        return smsTime;
    }

    public void setSmsTime(Date smsTime) {
        this.smsTime = smsTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(Integer handleStatus) {
        this.handleStatus = handleStatus;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public String getRemarksMsg() {
        return remarksMsg;
    }

    public void setRemarksMsg(String remarksMsg) {
        this.remarksMsg = remarksMsg == null ? null : remarksMsg.trim();
    }

    public String getSrcAddress() {
        return srcAddress;
    }

    public void setSrcAddress(String srcAddress) {
        this.srcAddress = srcAddress == null ? null : srcAddress.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", region='" + region + '\'' +
                ", location='" + location + '\'' +
                ", paperStatus=" + paperStatus +
                ", projectType=" + projectType +
                ", payStatus=" + payStatus +
                ", smsNum='" + smsNum + '\'' +
                ", smsStatus=" + smsStatus +
                ", smsTime=" + smsTime +
                ", createTime=" + createTime +
                ", handleStatus=" + handleStatus +
                ", handleTime=" + handleTime +
                ", remarksMsg='" + remarksMsg + '\'' +
                ", srcAddress='" + srcAddress + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}