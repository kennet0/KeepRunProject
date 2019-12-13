package db.connection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.kjp.keeprun.domain.DeviceDataVO;
import org.kjp.keeprun.domain.MemberVO;


public class DataCalculator {
	
public int calWorkTime(List<DeviceDataVO> listData) {
	
		Date minTime = listData.get(0).getSendTime();
		Date maxTime = listData.get(0).getSendTime();
		for(DeviceDataVO i : listData) {
			if (maxTime.compareTo(i.getSendTime())==-1) {
				maxTime=i.getSendTime();
			}
		}
		long timeDiff =  maxTime.getTime() - minTime.getTime();
		
		return (int)timeDiff/1000/60;
	}
	
	
	public int calDistance(List<DeviceDataVO> listData) {
		
		double distanceSum = 0;
		
		for(int i=0; i<listData.size()-1;i++) {
			
			double lat1,lon1,lat2,lon2;
			
			lat1 = listData.get(i).getGpsLatitude();
			lon1 = listData.get(i).getGpsLongitude();
			lat2 = listData.get(i+1).getGpsLatitude();
			lon2 = listData.get(i+1).getGpsLongitude();
			
			CalGpsToDistance calGpsToDistance = new CalGpsToDistance();
			if(calGpsToDistance.distance(lat1, lon1, lat2, lon2, "meter")<5) {
				distanceSum += calGpsToDistance.distance(lat1, lon1, lat2, lon2, "meter");
			}
			
		}
		return (int)distanceSum;		
	}

	public int calAvgHR(List<DeviceDataVO> listData) {
		int sumHR=0;
		for(DeviceDataVO i:listData) {
			sumHR += i.getUserHR();
		}
		
		return sumHR/listData.size();
	}
	
	public int calWorkIntensity(MemberVO user, List<DeviceDataVO> listData) {
		int calmHR=0;
		//남자
		if(user.getUserGender().equals("M")) {
			if(user.getUserAge()<26) {
				calmHR=72;
			}else if(user.getUserAge()>=26 && user.getUserAge()<36) {
				calmHR=73;
			}else if(user.getUserAge()>=36 && user.getUserAge()<46) {
				calmHR=74;
			}else if(user.getUserAge()>=46 && user.getUserAge()<56) {
				calmHR=75;
			}else if(user.getUserAge()>=56 && user.getUserAge()<66) {
				calmHR=76;
			}else {
				calmHR=72;
			}
		}
		//여자
		if(user.getUserGender().equals("F")) {
			if(user.getUserAge()<26) {
				calmHR=76;
			}else if(user.getUserAge()>=26 && user.getUserAge()<36) {
				calmHR=75;
			}else if(user.getUserAge()>=36 && user.getUserAge()<46) {
				calmHR=76;
			}else if(user.getUserAge()>=46 && user.getUserAge()<56) {
				calmHR=72;
			}else if(user.getUserAge()>=56 && user.getUserAge()<66) {
				calmHR=76;
			}else {
				calmHR=75;
			}
		}
				
		return 100*calAvgHR(listData)/((220-user.getUserAge())-calmHR);
	}
	
	public int calKcal(MemberVO user,List<DeviceDataVO> listData) {
		
		
		return user.getUserCurrentWeight()-calWorkTime(listData);
	}
	
	


}
