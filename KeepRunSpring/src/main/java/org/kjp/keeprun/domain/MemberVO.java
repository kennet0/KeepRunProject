package org.kjp.keeprun.domain;

public class MemberVO {
	private int deviceId;
	private String userId;
	private String userPw;
	private int userHeight;
	private String userGender;
	private int userAge;
	private int userWeight;
	private int userCurrentWeight;
	
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public int getUserHeight() {
		return userHeight;
	}
	public void setUserHeight(int userHeight) {
		this.userHeight = userHeight;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setAge(int userAge) {
		userAge = userAge;
	}
	public int getUserWeight() {
		return userWeight;
	}
	public void setUserWeight(int userWeight) {
		this.userWeight = userWeight;
	}
	public int getUserCurrentWeight() {
		return userCurrentWeight;
	}
	public void setUserCurrentWeight(int userCurrentWeight) {
		this.userCurrentWeight = userCurrentWeight;
	}
	@Override
	public String toString() {
		return "MemberVO [deviceId=" + deviceId + ", userId=" + userId + ", userPw=" + userPw + ", userHeight="
				+ userHeight + ", userGender=" + userGender + ", Age=" + userAge + ", userWeight=" + userWeight + ", userCurrentWeight="
				+ userCurrentWeight + "]";
	}
	

}
