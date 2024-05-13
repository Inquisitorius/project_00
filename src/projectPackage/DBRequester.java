package projectPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBRequester {
	
	String driver;
	String url;
	String user;
	String pw;
	
	Connection conn;
	
	public DBRequester()
	{
		driver = "oracle.jdbc.driver.OracleDriver";
		url = "jdbc:oracle:thin:@//14.42.124.35:1521/XE";
		user = "c##wjrls";
		pw = "881125";
		
		try 
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pw);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public int Get_MovieNo(String movieName)
	{
		String sql = "SELECT MOVIE_NO FROM MOVIE WHERE MOVIE_NAME = '" + movieName + "'";
		int movieNo = -1;
		try 
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs =  pstmt.executeQuery();
			rs.next();
			
			movieNo = rs.getInt("MOVIE_NO");
			
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		
		
		if(movieNo < 0)
			System.out.println("Err : movieNo unKnown");
		
		return movieNo;
	}
	
	public int Get_MovieHouseNo(String movieHouseName)
	{
		String sql = "SELECT MOVIEHOUSE_NO FROM MOVIEHOUSE WHERE MOVIEHOUSE_NAME = '" + movieHouseName + "'";
		int movieNo = -1;
		try 
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs =  pstmt.executeQuery();
			rs.next();
			
			movieNo = rs.getInt("MOVIEHOUSE_NO");
			
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		
		
		if(movieNo < 0)
			System.out.println("Err : movieNo unKnown");
		
		return movieNo;
	}
	
	public int Get_LocalNo(String LocalName)
	{
		//SELECT LOCAL_NO  FROM LOCAL WHERE LOCAL_NAME  = ''
		String sql = "SELECT LOCAL_NO FROM LOCAL WHERE LOCAL_NAME = '" + LocalName + "'";
		int movieNo = -1;
		try 
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs =  pstmt.executeQuery();
			rs.next();
			
			movieNo = rs.getInt("LOCAL_NO");
			
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		
		
		if(movieNo < 0)
			System.out.println("Err : movieNo unKnown");
		
		return movieNo;
	}
	
	public int Get_TimeNo(String timeData, int MovieNo, int MovieHouse)
	{		
		String sql = "SELECT m.SCHEDULE_NO  FROM MOVIESCHEDULE m WHERE TO_CHAR(m.SCHEDULE_TIME,'yyyy-mm-dd hh24:mi:ss') ";
		sql += "LIKE '%" + timeData + "%'";
		sql += "AND m.MOVIE_NO = " + MovieNo +" ";
		sql += "AND m.MOVIEHOUSE_NO = " + MovieHouse + " ";		
		
		int movieNo = -1;
		try 
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs =  pstmt.executeQuery();
			rs.next();
			
			movieNo = rs.getInt("SCHEDULE_NO");
			
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		
		
		if(movieNo < 0)
			System.out.println("Err : movieNo unKnown");
		
		return movieNo;
	}
	
	public int Get_SeatInfo(String seatName)
	{
		String sql = "SELECT * FROM SEAT s ";
		sql += "WHERE s.THEATER_NO = 2" ;
		sql += "AND s.SEAT_INFO = '" +seatName+"'" ;		
		int result = -1;
		
		try 
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs =  pstmt.executeQuery();
			rs.next();
			
			result = rs.getInt("SEAT_NO");			
			pstmt.close();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
		
	}
	
	public Boolean Insert_Ticket(int scheduleNo, int seatNo, int userNo)
	{
		String sql = "INSERT INTO TICKET(TICKET_NO, SCHEDULE_NO, SEAT_NO, USER_NO, TICKET_STATUS) VALUES( ";
		sql += "TICKET_BNO.NEXTVAL , ";
		sql += "(SELECT SCHEDULE_NO FROM MOVIESCHEDULE m2  WHERE m2.SCHEDULE_NO  = "+ scheduleNo +"), ";
		sql += "(SELECT SEAT_NO  FROM SEAT WHERE SEAT_NO = "+ seatNo + "), ";		
		sql += "(SELECT USER_NO FROM USER_INFO ui WHERE ui.USER_NO = " + userNo + "), 'RS' )";
		
		Boolean result = false;
		try 
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int rs =  pstmt.executeUpdate();
			
			if(rs < 0)
			{
				result = true;
				System.out.println("Err : Insert_Ticket ");		
			}					
					
			pstmt.close();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	public void DisConnectDB()
	{
		try 
		{
			conn.close();
			
			System.out.println("DicConnect Function");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
