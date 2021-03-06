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

@WebServlet("/keeprun")
public class KeepRunDB extends HttpServlet {
   private static final long serialVersionUID = 1L;
   

   
    public KeepRunDB() {
        super();
    }
    
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	   int deviceID = Integer.parseInt(request.getParameter("deviceID"));
	   int userHR = Integer.parseInt(request.getParameter("userHR"));
	   
	   System.out.println(deviceID);
	   System.out.println(userHR);
	   
	   response.setContentType("text/html;charset=utf-8");
	   
	   Connection conn = null;
	   PreparedStatement pstmt = null; 
     
      
      try {
    	  
    	  Class.forName("org.mariadb.jdbc.Driver");
          conn = DriverManager.getConnection(
                  "jdbc:mariadb://bigmit.iptime.org:54000/keeprun",
                  "kinam",
                  "1020");
          String sql = "INSERT INTO a_data (deviceID,userHR) VALUES(?,?)";
          pstmt = conn.prepareStatement(sql);
          pstmt.setInt(1, deviceID);
          pstmt.setInt(2, userHR);
          pstmt.executeUpdate();
          
          if( conn != null ) {
              System.out.println("DB 접속 성공");
          }
    	   Class.forName("org.mariadb.jdbc.Driver");  
            conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1/db", "****", "****");
            
           
           
         
            System.out.println(deviceID + " 심박수->" + userHR);         
         
      }catch (Exception e) {
         e.printStackTrace();         
      }      
      
      try {
         pstmt.close();
         conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }      
   }
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}
