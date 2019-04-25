package com.reserve.bean;

public class MeetingRoom {
    private String id;

    private String area;

    private Integer buildingNum;

    private Integer floor;

    private Integer roomNum;

    private Integer maxPopulation;

    private String timeArrangeId;

    private String predictPersonId;

    private String delFlag;
    
    private TimeArrange timeArrange;  //关联子表
    
    private PredictPerson predictPerson;  //关联子表

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public TimeArrange getTimeArrange() {
		return timeArrange;
	}

	public void setTimeArrange(TimeArrange timeArrange) {
		this.timeArrange = timeArrange;
	}

	public PredictPerson getPredictPerson() {
		return predictPerson;
	}

	public void setPredictPerson(PredictPerson predictPerson) {
		this.predictPerson = predictPerson;
	}

	public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public Integer getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(Integer buildingNum) {
        this.buildingNum = buildingNum;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    public Integer getMaxPopulation() {
        return maxPopulation;
    }

    public void setMaxPopulation(Integer maxPopulation) {
        this.maxPopulation = maxPopulation;
    }

    public String getTimeArrangeId() {
        return timeArrangeId;
    }

    public void setTimeArrangeId(String timeArrangeId) {
        this.timeArrangeId = timeArrangeId == null ? null : timeArrangeId.trim();
    }

    public String getPredictPersonId() {
        return predictPersonId;
    }

    public void setPredictPersonId(String predictPersonId) {
        this.predictPersonId = predictPersonId == null ? null : predictPersonId.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}