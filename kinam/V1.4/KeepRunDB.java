package keeprun;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.JDBCUtill;

@WebServlet("/keeprun")
public class KeepRunDB extends HttpServlet {
   private static final long serialVersionUID = 1L;
   

   
    public KeepRunDB() {
        super();
    }
    
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	   int deviceID = Integer.parseInt(request.getParameter("deviceID"));
	   int userHR = Integer.parseInt(request.getParameter("userHR"));
	   String gpslatitude = request.getParameter("gpslatitude");
	   String gpslongitude =request.getParameter("gpslongitude");
	   
	   System.out.println(deviceID);
	   System.out.println(userHR);
	   
	   response.setContentType("text/html;charset=utf-8");
	   
	   Connection conn = null;
	   PreparedStatement pstmt = null; 
     
      if(gpslatitude!=null && gpslongitude!=null ) {
      try {
    	  conn = JDBCUtill.getConnection();
          String sql = "INSERT INTO a_data (deviceID,userHR,gpslatitude,gpslongitude) VALUES(?,?,?,?)";
          pstmt = conn.prepareStatement(sql);
          pstmt.setInt(1, deviceID);
          pstmt.setInt(2, userHR);
          pstmt.setString(3, gpslatitude);
          pstmt.setString(4, gpslongitude);
          pstmt.executeUpdate();
         
          if( conn != null ) {
              System.out.println("케이스1 DB 접속 성공");
              JDBCUtill.commit(conn);
              System.out.println(deviceID + " 심박수->" + userHR + "위도->"+ gpslatitude + "경도->"+ gpslongitude);
              JDBCUtill.close(conn);
          }else{
        	  JDBCUtill.rollback(conn);
          }
      }catch (Exception e) {
         e.printStackTrace();         
      }      
      
      }else {
    	  try {
    		  conn = JDBCUtill.getConnection();
    		  String sql = "INSERT INTO a_data (deviceID,userHR) VALUES(?,?)";
    		  pstmt = conn.prepareStatement(sql);
    		  pstmt.setInt(1, deviceID);
    		  pstmt.setInt(2, userHR);
    		  pstmt.executeUpdate();
    		  
    		  if( conn != null ) {
                  System.out.println("케이스2 DB 접속 성공");
                  JDBCUtill.commit(conn);
                  System.out.println(deviceID + " 심박수->" + userHR );
                  JDBCUtill.close(conn);
              }else{
            	  JDBCUtill.rollback(conn);
              }
          }catch (Exception e) {
             e.printStackTrace();         
          }      
    }
   }
   
   

}
