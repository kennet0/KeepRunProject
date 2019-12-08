package org.kjp.keeprun.persistence;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kjp.keeprun.domain.DeviceDataVO;
import org.kjp.keeprun.domain.MemberVO;
import org.kjp.keeprun.domain.WorkProcessVO;
import org.springframework.stereotype.Repository;

@Repository
public class DataDAOImpl implements DataDAO {
	
	@Inject
	private SqlSession session;
	static final String nameSpace = "org.mybatis.example.dataMapper";

	@Override
	public int calWorkTime(int deviceId) {
		
		List<DeviceDataVO> listData = session.selectList(nameSpace+ ".dailyDeviceData",deviceId);
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
	
	@Override
	public int calDistance(int deviceId) {
		
		List<DeviceDataVO> listData = session.selectList(nameSpace+ ".dailyDeviceData",deviceId);
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

	@Override
	public int calAvgHR(int deviceId) {
		List<DeviceDataVO> listData = session.selectList(nameSpace+ ".dailyDeviceData",deviceId);
		int sumHR=0;
		for(DeviceDataVO i:listData) {
			sumHR += i.getUserHR();
		}
		
		return sumHR/listData.size();
	}

	@Override
	public void insertDayWorkProcess(WorkProcessVO workProcessVO) {
		
		session.insert(nameSpace + ".insertDayWorkProcess", workProcessVO);
	}
	
	@Override
	public void insertA_data(DeviceDataVO deviceDataVO) {
		session.insert(nameSpace + ".a_dataInsert", deviceDataVO);
		
	}

	@Override
	public List<MemberVO> userInfo() {
		
		return session.selectList(nameSpace + ".userInfo");
	}
	
	
		
		
}
	
	
	


