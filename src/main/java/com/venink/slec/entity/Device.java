package com.venink.slec.entity;

import com.venink.slec.base.utils.page.BaseObject;

import java.util.Date;

public class Device extends BaseObject {
    private Integer id;

    private Integer createManId;

    private Date createTime;

    private Integer updateManId;

    private Date updateTime;

    private String deviceName;

    private String deviceType;

    private String aboutUser;

    private String deviceIp;

    private String devicePort;

    private String companyName;

    private Integer distinguishMod;

    private String distinguishRange;

    private Integer distinguishScore;

    private Integer openDelay;

    private Integer outType;

    private Integer outOrder;

    private Integer outFormat;

    private String deviceSn;

    private Integer inOutType;

    private Integer inOutMark;

    private Integer deviceAddress;

    private Integer floorNumber;

    private Integer syncState;

    private Integer groupId;

    private Integer hideUserNum;

    private Integer hidePassName;

    private Integer cancelPlaySpeech;

    private Integer qrCodeTransferIcCard;

    private Integer heartbeatInterval;

    private Integer lastSyncTime;

    private Integer verifyType;

    private String verifyUrl;

    private Integer deviceSaveRecordState;

    private Integer verifyTimeout;

    private Integer unresponsiveProcessing;

    private String webSocketUri;

    private Integer strangerHandling;

    private Integer temperatureDetectionType;

    private String alarmTemperature;

    private Integer detectionMaskFlag;

    //在线状态:0:未连接过系统；1：在线；2：离线；
    private Integer onLineState;

    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Integer getOnLineState() {
        return onLineState;
    }

    public void setOnLineState(Integer onLineState) {
        this.onLineState = onLineState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreateManId() {
        return createManId;
    }

    public void setCreateManId(Integer createManId) {
        this.createManId = createManId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateManId() {
        return updateManId;
    }

    public void setUpdateManId(Integer updateManId) {
        this.updateManId = updateManId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType == null ? null : deviceType.trim();
    }

    public String getAboutUser() {
        return aboutUser;
    }

    public void setAboutUser(String aboutUser) {
        this.aboutUser = aboutUser == null ? null : aboutUser.trim();
    }

    public String getDeviceIp() {
        return deviceIp;
    }

    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp == null ? null : deviceIp.trim();
    }

    public String getDevicePort() {
        return devicePort;
    }

    public void setDevicePort(String devicePort) {
        this.devicePort = devicePort == null ? null : devicePort.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public Integer getDistinguishMod() {
        return distinguishMod;
    }

    public void setDistinguishMod(Integer distinguishMod) {
        this.distinguishMod = distinguishMod;
    }

    public String getDistinguishRange() {
        return distinguishRange;
    }

    public void setDistinguishRange(String distinguishRange) {
        this.distinguishRange = distinguishRange == null ? null : distinguishRange.trim();
    }

    public Integer getDistinguishScore() {
        return distinguishScore;
    }

    public void setDistinguishScore(Integer distinguishScore) {
        this.distinguishScore = distinguishScore;
    }

    public Integer getOpenDelay() {
        return openDelay;
    }

    public void setOpenDelay(Integer openDelay) {
        this.openDelay = openDelay;
    }

    public Integer getOutType() {
        return outType;
    }

    public void setOutType(Integer outType) {
        this.outType = outType;
    }

    public Integer getOutOrder() {
        return outOrder;
    }

    public void setOutOrder(Integer outOrder) {
        this.outOrder = outOrder;
    }

    public Integer getOutFormat() {
        return outFormat;
    }

    public void setOutFormat(Integer outFormat) {
        this.outFormat = outFormat;
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn == null ? null : deviceSn.trim();
    }

    public Integer getInOutType() {
        return inOutType;
    }

    public void setInOutType(Integer inOutType) {
        this.inOutType = inOutType;
    }

    public Integer getInOutMark() {
        return inOutMark;
    }

    public void setInOutMark(Integer inOutMark) {
        this.inOutMark = inOutMark;
    }

    public Integer getDeviceAddress() {
        return deviceAddress;
    }

    public void setDeviceAddress(Integer deviceAddress) {
        this.deviceAddress = deviceAddress;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Integer getSyncState() {
        return syncState;
    }

    public void setSyncState(Integer syncState) {
        this.syncState = syncState;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getHideUserNum() {
        return hideUserNum;
    }

    public void setHideUserNum(Integer hideUserNum) {
        this.hideUserNum = hideUserNum;
    }

    public Integer getHidePassName() {
        return hidePassName;
    }

    public void setHidePassName(Integer hidePassName) {
        this.hidePassName = hidePassName;
    }

    public Integer getCancelPlaySpeech() {
        return cancelPlaySpeech;
    }

    public void setCancelPlaySpeech(Integer cancelPlaySpeech) {
        this.cancelPlaySpeech = cancelPlaySpeech;
    }

    public Integer getQrCodeTransferIcCard() {
        return qrCodeTransferIcCard;
    }

    public void setQrCodeTransferIcCard(Integer qrCodeTransferIcCard) {
        this.qrCodeTransferIcCard = qrCodeTransferIcCard;
    }

    public Integer getHeartbeatInterval() {
        return heartbeatInterval;
    }

    public void setHeartbeatInterval(Integer heartbeatInterval) {
        this.heartbeatInterval = heartbeatInterval;
    }

    public Integer getLastSyncTime() {
        return lastSyncTime;
    }

    public void setLastSyncTime(Integer lastSyncTime) {
        this.lastSyncTime = lastSyncTime;
    }

    public Integer getVerifyType() {
        return verifyType;
    }

    public void setVerifyType(Integer verifyType) {
        this.verifyType = verifyType;
    }

    public String getVerifyUrl() {
        return verifyUrl;
    }

    public void setVerifyUrl(String verifyUrl) {
        this.verifyUrl = verifyUrl == null ? null : verifyUrl.trim();
    }

    public Integer getDeviceSaveRecordState() {
        return deviceSaveRecordState;
    }

    public void setDeviceSaveRecordState(Integer deviceSaveRecordState) {
        this.deviceSaveRecordState = deviceSaveRecordState;
    }

    public Integer getVerifyTimeout() {
        return verifyTimeout;
    }

    public void setVerifyTimeout(Integer verifyTimeout) {
        this.verifyTimeout = verifyTimeout;
    }

    public Integer getUnresponsiveProcessing() {
        return unresponsiveProcessing;
    }

    public void setUnresponsiveProcessing(Integer unresponsiveProcessing) {
        this.unresponsiveProcessing = unresponsiveProcessing;
    }

    public String getWebSocketUri() {
        return webSocketUri;
    }

    public void setWebSocketUri(String webSocketUri) {
        this.webSocketUri = webSocketUri == null ? null : webSocketUri.trim();
    }

    public Integer getStrangerHandling() {
        return strangerHandling;
    }

    public void setStrangerHandling(Integer strangerHandling) {
        this.strangerHandling = strangerHandling;
    }

    public Integer getTemperatureDetectionType() {
        return temperatureDetectionType;
    }

    public void setTemperatureDetectionType(Integer temperatureDetectionType) {
        this.temperatureDetectionType = temperatureDetectionType;
    }

    public String getAlarmTemperature() {
        return alarmTemperature;
    }

    public void setAlarmTemperature(String alarmTemperature) {
        this.alarmTemperature = alarmTemperature == null ? null : alarmTemperature.trim();
    }

    public Integer getDetectionMaskFlag() {
        return detectionMaskFlag;
    }

    public void setDetectionMaskFlag(Integer detectionMaskFlag) {
        this.detectionMaskFlag = detectionMaskFlag;
    }
}