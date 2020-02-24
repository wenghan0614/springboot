package com.venink.slec.base.utils.Return;

import com.alibaba.fastjson.annotation.JSONField;
import com.venink.slec.entity.Device;

public class DevicParam {

    //界面上显示的公司名
    @JSONField(name ="CompanyName")
    private String CompanyName;
    //ic卡识别模式:1人卡合一;2:人卡任一
    @JSONField(name ="DistinguishMod")
    private Integer DistinguishMod;
    //识别距离
    @JSONField(name ="DistinguishRange")
    private String DistinguishRange;
    //比对阈值
    @JSONField(name ="DistinguishScore")
    private Integer DistinguishScore;
    //继电器开关间隔（单位是毫秒）
    @JSONField(name ="OpenDelay")
    private Integer OpenDelay;
    //韦根输出类型：0：用户ID 1（或其他）：用户卡号
    @JSONField(name ="OutType")
    private Integer OutType;
    //韦根输出格式：0：韦根26 1（或其他）：韦根34
    @JSONField(name ="OutOrder")
    private Integer OutOrder;
    //韦根输出顺序：0：顺序 1（或其他）：倒序
    @JSONField(name ="OutFormat")
    private Integer OutFormat;
    //是否隐藏人数：0：不隐藏 1（或其他）：隐藏
    @JSONField(name ="hideUserNum")
    private Integer hideUserNum;
    //验证通过是否隐藏姓名：0：不隐藏 1（或其他）：隐藏
    @JSONField(name ="hidePassName")
    private Integer hidePassName;
    //是否取消播放语音：0：不取消 1（或其他）：取消播放
    @JSONField(name ="cancelPlaySpeech")
    private Integer cancelPlaySpeech;
    //二维码数据是否做卡号处理：0：做卡号处理，处理流程当读卡流程处理  1：不当卡号处理，请求接口7验证二维码有效性
    @JSONField(name ="qrCodeTransferIcCard")
    private Integer qrCodeTransferIcCard;
    //心跳请求的间隔时间，默认是10秒，设置的参数单位是秒
    @JSONField(name ="heartbeatInterval")
    private Integer heartbeatInterval;
    //服务器同步设备时间（毫秒时间戳）
    @JSONField(name ="lastSyncTime")
    private String lastSyncTime;
    //需要验证的类型：
    @JSONField(name ="verifyType")
    private Integer verifyType;
    //验证的接口地址：传空字符串""不验证，否则必须传完整的url地址。
    @JSONField(name ="verifyUrl")
    private String verifyUrl;
    //设备是否保存记录：0:设备保存记录 1(或者其他):设备不保存记录
    @JSONField(name ="deviceSaveRecordState")
    private Integer deviceSaveRecordState;
    //请求验证接口的超时时间，单位是毫秒
    @JSONField(name ="verifyTimeout")
    private Integer verifyTimeout;
    //超时，没有网络或者url错误等请求无法响应处理： 0：不再验证直接放行 1(或者其他)：不放行
    @JSONField(name ="unresponsiveProcessing")
    private Integer unresponsiveProcessing;
    //webSocket服务器地址：传空字符串""不通讯，否则必须传完整的地址。
    @JSONField(name ="webSocketUri")
    private String webSocketUri;
    //陌生人处理方式：0：不需要处理 1：界面提示 2：记录上传 3：界面提示和记录上传
    @JSONField(name ="strangerHandling")
    private Integer strangerHandling;
    //体温检测设置：0：不检测温度，识别人脸 1：不识别，只检测温度（_T版本默认该模式） 2：识别人脸，并检测温度
    @JSONField(name ="temperatureDetectionType")
    private Integer temperatureDetectionType;
    //设置需要报警的体温，单位是℃（默认37.3）
    @JSONField(name ="alarmTemperature")
    private String  alarmTemperature;
    //0:不检测口罩 1: 检测口罩(默认检测)
    @JSONField(name ="detectionMaskFlag")
    private Integer detectionMaskFlag;

    public DevicParam() {
    }

    public DevicParam(Device device){
        //公司名称
        CompanyName = device.getCompanyName();
        //识别模式
        DistinguishMod = device.getDistinguishMod();
        //识别距离
        DistinguishRange = device.getDistinguishRange();
        //比对阈值
        DistinguishScore = device.getDistinguishScore();
        //继电器开关间隔
        OpenDelay = device.getOpenDelay();
        OutType = device.getOutType();
        OutFormat = device.getOutFormat();
        OutOrder = device.getOutOrder();
        //是否隐藏人数
        hideUserNum = device.getHideUserNum();
        //验证通过是否隐藏姓名
        hidePassName = device.getHidePassName();
        //是否取消播放语音
        cancelPlaySpeech = device.getCancelPlaySpeech();
        //陌生人处理方式
        strangerHandling = device.getStrangerHandling();
        //体温检测设置
        temperatureDetectionType = device.getTemperatureDetectionType();
        //设置需要报警的体温
        alarmTemperature = device.getAlarmTemperature();
        //口罩检测
        detectionMaskFlag = device.getDetectionMaskFlag();
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public Integer getDistinguishMod() {
        return DistinguishMod;
    }

    public void setDistinguishMod(Integer distinguishMod) {
        DistinguishMod = distinguishMod;
    }

    public String getDistinguishRange() {
        return DistinguishRange;
    }

    public void setDistinguishRange(String distinguishRange) {
        DistinguishRange = distinguishRange;
    }

    public Integer getDistinguishScore() {
        return DistinguishScore;
    }

    public void setDistinguishScore(Integer distinguishScore) {
        DistinguishScore = distinguishScore;
    }

    public Integer getOpenDelay() {
        return OpenDelay;
    }

    public void setOpenDelay(Integer openDelay) {
        OpenDelay = openDelay;
    }

    public Integer getOutType() {
        return OutType;
    }

    public void setOutType(Integer outType) {
        OutType = outType;
    }

    public Integer getOutOrder() {
        return OutOrder;
    }

    public void setOutOrder(Integer outOrder) {
        OutOrder = outOrder;
    }

    public Integer getOutFormat() {
        return OutFormat;
    }

    public void setOutFormat(Integer outFormat) {
        OutFormat = outFormat;
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

    public String getLastSyncTime() {
        return lastSyncTime;
    }

    public void setLastSyncTime(String lastSyncTime) {
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
        this.verifyUrl = verifyUrl;
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
        this.webSocketUri = webSocketUri;
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
        this.alarmTemperature = alarmTemperature;
    }

    public Integer getDetectionMaskFlag() {
        return detectionMaskFlag;
    }

    public void setDetectionMaskFlag(Integer detectionMaskFlag) {
        this.detectionMaskFlag = detectionMaskFlag;
    }
}
