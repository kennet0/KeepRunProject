package org.kjp.keeprun.domain;

import java.sql.Date;

public class TempVO {
	int deviceId;
	Date lastWorkDate;
	
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public Date getLastWorkDate() {
		return lastWorkDate;
	}
	public void setLastWorkDate(Date lastWorkDate) {
		this.lastWorkDate = lastWorkDate;
	}

}
