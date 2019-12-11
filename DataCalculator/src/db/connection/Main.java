package db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.kjp.keeprun.domain.DeviceDataVO;
import org.kjp.keeprun.domain.MemberVO;
import org.kjp.keeprun.domain.WorkProcessVO;
import org.kjp.keeprun.service.DataService;

public class Main {

	 public static void main(String[] args) {
	        
	        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			Date now = new Date();
			String nowCompareTime = format.format(now);
//			for(;;) {
//				if(nowCompareTime.equals("23:59:59")) {
					Connection con = null;
			        PreparedStatement pstmt = null;   
			        ResultSet rs = null;
			        List<MemberVO> allUserInfo = new ArrayList<MemberVO>();
			        List<WorkProcessVO> allUserWorkProcess = new ArrayList<WorkProcessVO>();
			        try {
			            Class.forName("org.mariadb.jdbc.Driver");
			            con = DriverManager.getConnection(
			                "jdbc:mariadb://bigmit.iptime.org:54000/keeprun",
			                "kennet",
			                "1234");
			                   
			            pstmt = con.prepareStatement("select * from user");
			            rs = pstmt.executeQuery();
			            while(rs.next()) {
			            	MemberVO userInfo = new MemberVO();
			            	userInfo.setDeviceId(rs.getInt("deviceId"));
			            	userInfo.setUserId(rs.getString("userId"));
			            	userInfo.setUserPw(rs.getString("userPw"));
			            	userInfo.setUserHeight(rs.getInt("userHeight"));
			            	userInfo.setUserGender(rs.getString("userGender"));
			            	userInfo.setUserAge(rs.getInt("userAge"));
			            	userInfo.setUserWeight(rs.getInt("userWeight"));
			            	userInfo.setUserCurrentWeight(rs.getInt("userCurrentWeight"));
			            	allUserInfo.add(userInfo);
			            }
			            for(MemberVO i:allUserInfo) {
			            	DataCalculator dataCalculator = new DataCalculator();
			            	List<DeviceDataVO> allDeviceInfo = new ArrayList<DeviceDataVO>();
				            pstmt = con.prepareStatement("SELECT * FROM a_data WHERE deviceId=? and DATE(sendTime) = DATE('2019-12-05')");
				            pstmt.setInt(1,i.getDeviceId());
				            rs = pstmt.executeQuery();
				            while(rs.next()) {
				            	DeviceDataVO deviceInfo = new DeviceDataVO();
				            	deviceInfo.setDeviceId(rs.getInt("deviceId"));
				            	deviceInfo.setUserHR(rs.getInt("userHR"));
				            	deviceInfo.setGpsLatitude(rs.getDouble("gpsLatitude"));
				            	deviceInfo.setGpsLongitude(rs.getDouble("gpsLongitude"));
				            	deviceInfo.setSendTime(rs.getDate("sendTime"));
				            	allDeviceInfo.add(deviceInfo);
				            }
				            if(dataCalculator.calWorkTime(allDeviceInfo)>1) {
					            pstmt = con.prepareStatement("INSERT INTO w_data(deviceId, DISTANCE, kcal, avgHR, workIntensity, workTime) VALUES(?,?,?,?,?,?)");
					            pstmt.setInt(1, i.getDeviceId());
					            pstmt.setInt(2, dataCalculator.calDistance(allDeviceInfo));
					            pstmt.setInt(3, dataCalculator.calKcal(i, allDeviceInfo));
					            pstmt.setInt(4, dataCalculator.calAvgHR(allDeviceInfo));
					            pstmt.setInt(5, dataCalculator.calWorkIntensity(i, allDeviceInfo));
					            pstmt.setInt(6, dataCalculator.calWorkTime(allDeviceInfo));
					            pstmt.executeQuery();
					            
					            System.out.println("info");
					            System.out.println(i.getDeviceId());
					            System.out.println(dataCalculator.calDistance(allDeviceInfo));
					            System.out.println(dataCalculator.calAvgHR(allDeviceInfo));
					            System.out.println(dataCalculator.calWorkTime(allDeviceInfo));
				            }
			            }
			            System.out.println("db저장완료");
		           
		        } catch(Exception e) {
		            e.printStackTrace();
		        } finally {
		            try {
		                if(rs != null) {
		                    rs.close(); // 선택 사항
		                }
		                
		                if(pstmt != null) {
		                    pstmt.close(); // 선택사항이지만 호출 추천
		                }
		            
		                if(con != null) {
		                    con.close(); // 필수 사항
		                }
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }
			}  
//		}
//	}
}
