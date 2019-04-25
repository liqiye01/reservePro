package com.reserve.bean;

public class SportsGround {
    private String id;

    private String area;

    private String name;

    private Integer space;

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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSpace() {
        return space;
    }

    public void setSpace(Integer space) {
        this.space = space;
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
}