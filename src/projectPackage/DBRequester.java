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
	
	public int Get_TimeNo(String timeData)
	{
		//SELECT m.SCHEDULE_NO  FROM MOVIESCHEDULE m WHERE TO_CHAR(m.SCHEDULE_TIME,'yyyy-mm-dd hh24:mi:ss')  
		//LIKE '%2024-04-01 19:00:00%'
		
		String sql = "SELECT m.SCHEDULE_NO  FROM MOVIESCHEDULE m WHERE TO_CHAR(m.SCHEDULE_TIME,'yyyy-mm-dd hh24:mi:ss') ";
		sql += "LIKE '%" + timeData + "%'";
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
