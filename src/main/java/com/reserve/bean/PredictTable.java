package com.reserve.bean;

import java.util.Date;

public class PredictTable {
    private String id;

    private String resourceId;

    private String resourceType;

    private String resourceName;

    private String predictPerson;

    private String predictReason;

    private String predictTime;

    private Date beginTime;

    private Date endTime;

    private String predictState;

    private String isRead;

    private String delFlag;
    
    private User user;   //关联子表

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId == null ? null : resourceId.trim();
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType == null ? null : resourceType.trim();
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public String getPredictPerson() {
        return predictPerson;
    }

    public void setPredictPerson(String predictPerson) {
        this.predictPerson = predictPerson == null ? null : predictPerson.trim();
    }

    public String getPredictReason() {
        return predictReason;
    }

    public void setPredictReason(String predictReason) {
        this.predictReason = predictReason == null ? null : predictReason.trim();
    }

    public String getPredictTime() {
        return predictTime;
    }

    public void setPredictTime(String predictTime) {
        this.predictTime = predictTime == null ? null : predictTime.trim();
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPredictState() {
        return predictState;
    }

    public void setPredictState(String predictState) {
        this.predictState = predictState == null ? null : predictState.trim();
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead == null ? null : isRead.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}