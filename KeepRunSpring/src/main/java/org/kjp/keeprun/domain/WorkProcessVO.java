package org.kjp.keeprun.domain;

import java.sql.Date;

public class WorkProcessVO {
	
	private int deviceId;
	private int distance;
	private int kcal;
	private int avgHR;
	private int maxHR;
	private int workTime;
	private Date workDate;
	private int bno;
	
	
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public int getKcal() {
		return kcal;
	}
	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	public int getAvgHR() {
		return avgHR;
	}
	public void setAvgHR(int avgHR) {
		this.avgHR = avgHR;
	}
	public int getMaxHR() {
		return maxHR;
	}
	public void setMaxHR(int maxHR) {
		this.maxHR = maxHR;
	}
	public int getWorkTime() {
		return workTime;
	}
	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}
	public Date getWorkDate() {
		return workDate;
	}
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}

}
