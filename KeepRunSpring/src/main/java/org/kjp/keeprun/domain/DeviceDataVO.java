package org.kjp.keeprun.domain;

import java.sql.Date;

public class DeviceDataVO {

	private int deviceId;
	private int userHR;
	private double gpsAltitude;
	private double gpsLongitude;
	private Date nowTime;
	private int dno;
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
	public double getGpsAltitude() {
		return gpsAltitude;
	}
	public void setGpsAltitude(double gpsAltitude) {
		this.gpsAltitude = gpsAltitude;
	}
	public double getGpsLongitude() {
		return gpsLongitude;
	}
	public void setGpsLongitude(double gpsLongitude) {
		this.gpsLongitude = gpsLongitude;
	}
	public Date getNowTime() {
		return nowTime;
	}
	public void setNowTime(Date nowTime) {
		this.nowTime = nowTime;
	}
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	
	
}

