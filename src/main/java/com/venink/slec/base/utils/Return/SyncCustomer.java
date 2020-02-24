package com.venink.slec.base.utils.Return;

import cn.hutool.core.convert.Convert;
import com.alibaba.fastjson.annotation.JSONField;
import com.venink.slec.entity.Person;

public class SyncCustomer {

    //用户姓名
    @JSONField(name ="CustomerName")
    private String CustomerName;
    //人员id保证唯一，从1开始到2147483647
    @JSONField(name ="personId")
    private String personId;
    //人员类型
    @JSONField(name ="personType")
    private Integer personType;
    //IC卡号
    @JSONField(name ="CardNO")
    private String CardNO;
    //用户身份证号
    @JSONField(name ="CustomerIDNO")
    private String CustomerIDNO;
    //最后操作该人员的时间（毫秒时间戳）
    @JSONField(name ="ModifyDate")
    private Long ModifyDate;
    //人脸图片的下载地址
    @JSONField(name ="Photo")
    private String Photo;
    //操作标识：1：新增 2：修改 3：删除
    @JSONField(name ="OPType")
    private Integer OPType;
    //有效期的开始时间（毫秒时间戳），如果不传起始永久有效
    @JSONField(name ="timeIntervalIds")
    private String timeIntervalIds;
    //有效期的结束时间（毫秒时间戳），如果不传结束永久有效
    @JSONField(name ="validDateStart")
    private String validDateStart;
    //允许通行的时间段id，如果不传，那么就是永久有效。多个时间段id用“,”分开
    @JSONField(name ="validDateEnd")
    private String validDateEnd;

    public SyncCustomer() {
    }

    public SyncCustomer(Person person) {
        CustomerName = person.getPersonName();
        personId = person.getPersonId()+"";
        personType = 0;
        CardNO = person.getCardNo();
        CustomerIDNO = person.getCustomerIdNo();
        ModifyDate = System.currentTimeMillis();
        Photo = person.getPersonPhoto();
        OPType = Convert.toInt(person.getState());
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Integer getPersonType() {
        return personType;
    }

    public void setPersonType(Integer personType) {
        this.personType = personType;
    }

    public String getCardNO() {
        return CardNO;
    }

    public void setCardNO(String cardNO) {
        CardNO = cardNO;
    }

    public String getCustomerIDNO() {
        return CustomerIDNO;
    }

    public void setCustomerIDNO(String customerIDNO) {
        CustomerIDNO = customerIDNO;
    }

    public Long getModifyDate() {
        return ModifyDate;
    }

    public void setModifyDate(Long modifyDate) {
        ModifyDate = modifyDate;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public Integer getOPType() {
        return OPType;
    }

    public void setOPType(Integer OPType) {
        this.OPType = OPType;
    }

    public String getTimeIntervalIds() {
        return timeIntervalIds;
    }

    public void setTimeIntervalIds(String timeIntervalIds) {
        this.timeIntervalIds = timeIntervalIds;
    }

    public String getValidDateStart() {
        return validDateStart;
    }

    public void setValidDateStart(String validDateStart) {
        this.validDateStart = validDateStart;
    }

    public String getValidDateEnd() {
        return validDateEnd;
    }

    public void setValidDateEnd(String validDateEnd) {
        this.validDateEnd = validDateEnd;
    }
}
