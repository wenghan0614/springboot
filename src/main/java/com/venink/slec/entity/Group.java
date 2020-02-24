package com.venink.slec.entity;

import com.venink.slec.base.utils.page.BaseObject;
import java.util.Date;

public class Group extends BaseObject {
    private Integer id;

    private Integer createManId;

    private Date createTime;

    private Integer updateManId;

    private Date updateTime;

    private String groupName;

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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", createManId=" + createManId +
                ", createTime=" + createTime +
                ", updateManId=" + updateManId +
                ", updateTime=" + updateTime +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}