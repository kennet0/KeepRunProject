package org.kjp.keeprun.domain;

import java.sql.Date;

public class DeviceDataVO {

	private int deviceId;
	private int userHR;
	private double gpsLatitude;
	private double gpsLongitude;
	private Date sendTime;
	private int dno;
	
	
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public int getUserHR() {
		return userHR;
	}
	public void setUserHR(int userHR) {
		this.userHR = userHR;
	}
	public double getGpsLatitude() {
		return gpsLatitude;
	}
	public void setGpsLatitude(double gpsLatitude) {
		this.gpsLatitude = gpsLatitude;
	}
	public double getGpsLongitude() {
		return gpsLongitude;
	}
	public void setGpsLongitude(double gpsLongitude) {
		this.gpsLongitude = gpsLongitude;
	}
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	
	
}

