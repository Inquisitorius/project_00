package projectPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JinsungPanelT extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainTestFrame mainTestFrame;	
	private TicketFrame ticketFrame;
	
	/**
	 * Create the panel.
	 */

	public JinsungPanelT(MainTestFrame mainTestFrame) {

		this.mainTestFrame = mainTestFrame;
		  Connection conn = null; 
		  
		  int ticket_no = 0;
		  String movie_name = "";
		  String time = "";
		  String th_name = "";
		  String mh_name = "";
		  String seat_info = "";
		  String local_name = "";
		  
		  try {
			  Class.forName("oracle.jdbc.OracleDriver");
		  
		  conn= DriverManager.getConnection(	
				  "jdbc:oracle:thin:@//14.42.124.35:1521/XE",
				  "c##wjrls",
				  "881125" );   
		  
		  String sql = 
				  "SELECT LOCAL.LOCAL_NAME, A.TICKET_NO, A.SEAT_INFO, A.SEAT_INFO, A.USER_NO, ui.USER_NAME ,m.SCHEDULE_NO,t2.THEATER_NAME , m3.MOVIEHOUSE_NAME ,m.SCHEDULE_TIME, m.SCHEDULE_ENDTIME, m2.MOVIE_NAME "
				  + "from "
				  + "( "
				  + "(((((SELECT t.TICKET_NO ,t.SEAT_NO, s.SEAT_INFO, T.SCHEDULE_NO, T.USER_NO  FROM TICKET t JOIN SEAT s ON t.SEAT_NO = s.SEAT_NO) A "
				  + "JOIN MOVIESCHEDULE m ON A.SCHEDULE_NO = m.SCHEDULE_NO ) "
				  + "JOIN MOVIE m2 ON m.MOVIE_NO = m2.MOVIE_NO) "
				  + "JOIN MOVIEHOUSE m3 ON m3.MOVIEHOUSE_NO = m.MOVIEHOUSE_NO) "
				  + "JOIN THEATER t2 ON t2.MOVIEHOUSE_NO = m3.MOVIEHOUSE_NO) "
				  + "JOIN USER_INFO ui ON ui.USER_NO = A.USER_NO) "
				  + "JOIN LOCAL ON LOCAL.LOCAL_NO = m3.LOCAL_NO " 
				  + "WHERE a.TICKET_NO = " + "41";
		  
		  PreparedStatement pstmt = conn.prepareStatement(sql);
		  
		  ResultSet rs = pstmt.executeQuery();
		  while(rs.next()) { 
			  
			  //예매 번호, 영화명, 상영시간, 상영관이름, 극장 이름, 좌석번호
			  ticket_no = rs.getInt("TICKET_NO");
			  movie_name = rs.getString("MOVIE_NAME");
			  time = rs.getString("SCHEDULE_TIME");
			  th_name = rs.getString("THEATER_NAME");
			  mh_name = rs.getString("MOVIEHOUSE_NAME");
			  seat_info = rs.getString("SEAT_INFO");
			  local_name = rs.getString("LOCAL_NAME");
			  
		  } /*pstmt.close();*/ } 
		  catch (ClassNotFoundException e) 
		  {   // TODO Auto-generated catch block
			  e.printStackTrace();
		  } catch (SQLException e) { 
			  e.printStackTrace();
		  }
			/*
			 * finally { if(conn !=null) { try { conn.close(); } catch (SQLException e) {} }
			 * }
			 */
		setLayout(null);
		this.setSize(1280, 800 - 150);
		this.setPreferredSize(new Dimension(1280, 800 - 150));
		this.setBackground(Color.white);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 1280, 650);
		add(panel);
		panel.setLayout(null);
		  JLabel show_image = new JLabel(""); show_image.setIcon(new ImageIcon(JinsungPanel.class.getResource("/image/jinsung/poster3.jpg")));
		  show_image.setBounds(151, 71, 152, 234); panel.add(show_image);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Manic-063\\Downloads\\사진모음\\cgving2.png"));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 38));
		lblNewLabel.setBounds(485, 0, 212, 84);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabelfix = new JLabel("예매 내역");
		lblNewLabelfix.setForeground(Color.WHITE);
		lblNewLabelfix.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 30));
		lblNewLabelfix.setBounds(518, 71, 143, 51);
		panel.add(lblNewLabelfix);
		
		//영화명
		JLabel Title_name = new JLabel("영화명");
		Title_name.setForeground(Color.WHITE);
		Title_name.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		Title_name.setBounds(54, 300, 111, 41);
		panel.add(Title_name);
		
		JLabel Title = new JLabel("영화");
		Title.setForeground(Color.WHITE);
		Title.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		Title.setBounds(1059, 300, 202, 41);
		panel.add(Title);
	
		 try { 
			 String sql ="" + " SELECT MOVIE_NAME " + " FROM MOVIE " + " WHERE MOVIE_COMMENT = ? ";
		  
		  PreparedStatement pstmt2 = conn.prepareStatement(sql);
		  pstmt2.setString(1,"마동석");
		  
		  ResultSet rs = pstmt2.executeQuery(); 
		  
		  while(rs.next())   { 
		  
		  movie_name = rs.getString("MOVIE_NAME");
		  } 

		  pstmt2.close(); 
		  } 
		  catch (SQLException e) { 
			 e.printStackTrace(); 
			 } Title.setText(movie_name);
			 
		// 예매 번호
		JLabel ticketNum = new JLabel("예매 번호");
		ticketNum.setForeground(Color.WHITE);
		ticketNum.setFont(new Font("나눔고딕", Font.BOLD, 28));
		ticketNum.setBounds(798, 143, 152, 51);
		panel.add(ticketNum);
		
		JLabel ticketNump= new JLabel("1234-567");
		ticketNum.setForeground(Color.WHITE);
		ticketNum.setFont(new Font("나눔고딕", Font.BOLD, 28));
		ticketNum.setBounds(1016, 130, 196, 77);
		panel.add(ticketNum);

		 try { String sql ="" + " SELECT TICKET_NO " + " FROM TICKET " + " Where USER_NO = ? " ;
 
		  PreparedStatement pstmt1 = conn.prepareStatement(sql);
		  pstmt1.setString(1, "2");
		  
		  ResultSet rs = pstmt1.executeQuery(); 
		  while(rs.next())   { 
			  
		 // 티켓번호 
		  ticket_no = rs.getInt("TICKET_NO");
		 
		  } pstmt1.close(); 
		  } 
		 catch (SQLException
		  e) { e.printStackTrace();
		  } ticketNum.setText(String.valueOf(ticket_no));
		 
		//상영시간
		JLabel Time = new JLabel("상영일시");
		Time.setForeground(Color.WHITE);
		Time.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		Time.setBounds(54, 361, 111, 41);
		panel.add(Time);
		
		JLabel timep = new JLabel("00:00");
		timep.setForeground(Color.WHITE);
		timep.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		timep.setBounds(932, 361, 267, 41);
		panel.add(timep);
		
		 try { 
			 String sql ="" + " SELECT SCHEDULE_TIME " + " FROM MOVIESCHEDULE " + " WHERE SCHEDULE_NO = ? ";
		  
		  PreparedStatement pstmt3 = conn.prepareStatement(sql);
		  pstmt3.setString(1,"2");
		  
		  ResultSet rs = pstmt3.executeQuery(); 
		  
		  while(rs.next())   {	
	     time = rs.getString("SCHEDULE_TIME"); 
		 
		  } pstmt3.close(); 
		  } 
		 catch (SQLException
		  e) { e.printStackTrace();
		  } timep.setText(time);
		
		//영화관 지역이름
		JLabel movielocal= new JLabel("극장명");
		movielocal.setForeground(Color.WHITE);
		movielocal.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		movielocal.setBounds(54, 412, 111, 41);
		panel.add(movielocal);
		
		JLabel localp = new JLabel("CGV");
		localp.setForeground(Color.WHITE);
		localp.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		localp.setBounds(1059, 412, 179, 41);
		panel.add(localp);
		
		 try { String sql ="" + " SELECT LOCAL_NAME " + " FROM LOCAL " + " WHERE LOCAL_POSITION =? ";
		  PreparedStatement pstmt1 = conn.prepareStatement(sql);
		  pstmt1.setString(1,"경기도 의정부시");
		  
		  ResultSet rs = pstmt1.executeQuery(); 
		  
		  while(rs.next())   { 
		  mh_name = rs.getString("LOCAL_NAME");
		  } pstmt1.close(); 
		  } 
		 catch (SQLException
		  e) { e.printStackTrace();
		  } localp.setText(local_name);
		
		// 상영관
		JLabel screen = new JLabel("상영관");
		screen.setForeground(Color.WHITE);
		screen.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		screen.setBounds(54, 463, 111, 41);
		panel.add(screen);
		JLabel screenp = new JLabel("0관");
		screenp.setForeground(Color.WHITE);
		screenp.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		screenp.setBounds(1059, 463, 189, 41);
		panel.add(screenp);
		
		 try { String sql ="" + " SELECT MOVIEHOUSE_NAME " + " FROM MovieHouse " + " WHERE LOCAL_NO =? ";
		  
		  PreparedStatement pstmt1 = conn.prepareStatement(sql);
		  pstmt1.setString(1,"4");
		  
		  ResultSet rs = pstmt1.executeQuery(); 
		  
		  while(rs.next())   { 
		  th_name = rs.getString("MOVIEHOUSE_NAME");
			 screenp.setText(th_name);
		  } pstmt1.close(); 
		  } 
		 catch (SQLException
		  e) { e.printStackTrace();
		  }
		
		 finally { if(conn !=null) {
		 try { conn.close(); } 
		 catch (SQLException e) {
		 }
		 } 
		 }	 
		JLabel person = new JLabel("관람수");
		person.setForeground(Color.WHITE);
		person.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		person.setBounds(54, 514, 111, 41);
		panel.add(person);	
		   
		JLabel personp = new JLabel("2명");
		personp.setForeground(Color.WHITE);
		personp.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		personp.setBounds(1059, 514, 124, 41);
		panel.add(personp);
		
		//뒤로가기버튼
		JButton backButton = new JButton("");
		backButton.addActionListener(new BackAction());
		backButton.setIcon(new ImageIcon(JinsungPanelT.class.getResource("/image/button/back.png")));
		backButton.setBounds(614, 544, 110, 42);
		panel.add(backButton);
		
		ticketFrame = new TicketFrame();
		ticketFrame.setParentPage(this);
		
		//티켓취소버튼
		JButton cancleButton = new JButton("");
		cancleButton.addActionListener(new CancleAction());
		cancleButton.setIcon(new ImageIcon(JinsungPanelT.class.getResource("/image/jinsung/ticketcancle.png")));
		cancleButton.setBounds(776, 544, 110, 42);
		panel.add(cancleButton);

		this.setVisible(false);
	}
	//-------------------------------------------------------------//
	public MainTestFrame get_MainTestFrame() {return mainTestFrame;}

	public void progress()
	{//code
		Connection conn = null;
		try {
			 Class.forName("oracle.jdbc.OracleDriver");
			 conn= DriverManager.getConnection(
					  "jdbc:oracle:thin:@localhost:1521/xe",
					  "c##green",
					  "green1234" );
		
		String sql = "" + " DELETE FROM MOVIE " + "WHERE TICKET =? " ;
		PreparedStatement pstmt1 = conn.prepareStatement(sql);
		  pstmt1.setString(1,"");
		System.out.println("Progress in----");
		
		int rs = pstmt1.executeUpdate();
		
		if(rs < 0 || rs > 1)
			System.out.println("err : movie ticket delete rs cnt : " + rs);
		//
		  } 
	  catch (ClassNotFoundException e) { 
		  // TODO Auto-generated catch block
		  e.printStackTrace();
	  } catch (SQLException e) { 
		  e.printStackTrace();
	  }finally { if(conn !=null) { try { conn.close(); } catch (SQLException e) {} }
		  }
	
		//--> 전에 있던 텍스트 날려주세요.
		//TextInit();	
	} 
	
	/* 텍스트 날린거 표시
	 * public void TextInit() {
	 * this.timep.setText("test null"); }
	 */
	
	class BackAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		mainTestFrame.PageChange(MainFrame.PANELNAME.PAGE1);
}
	}
	class CancleAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ticketFrame.setVisible(true);
		}
}
}