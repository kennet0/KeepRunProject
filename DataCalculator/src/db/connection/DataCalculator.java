package db.connection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.kjp.keeprun.domain.DeviceDataVO;


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
			distanceSum += calGpsToDistance.distance(lat1, lon1, lat2, lon2, "meter");
			
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


}
