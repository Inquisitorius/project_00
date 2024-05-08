package projectPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Ticketreserve extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainTestFrame mainTestFrame;
	private JList<String> movie_name_list,movie_location_list,movie_theater_list, movie_time_list;

	/**
	 * Create the panel.
	 */
	public Ticketreserve(MainTestFrame mainTestFrame) {
		this.mainTestFrame = mainTestFrame;
		
		setLayout(null);
		this.setSize(1280, 800 - 150);
		this.setPreferredSize(new Dimension(1280, 800 - 150));
		this.setBackground(new Color(0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(214, 90, 790, 521);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(12, 10, 766, 499);
		panel.add(panel_1);
		panel_1.setLayout(null);
		//고정값
			 
		JLabel ticketreserve_1 = new JLabel("영화");
		ticketreserve_1.setBounds(72, 120, 60, 41);
		panel_1.add(ticketreserve_1);
		ticketreserve_1.setForeground(new Color(255, 255, 255));
		ticketreserve_1.setFont(new Font("맑은 고딕", Font.PLAIN, 28));
		
		JLabel ticketreserve_2 = new JLabel("지역");
		ticketreserve_2.setBounds(236, 113, 120, 55);
		panel_1.add(ticketreserve_2);
		ticketreserve_2.setForeground(new Color(255, 255, 255));
		ticketreserve_2.setFont(new Font("맑은 고딕", Font.PLAIN, 28));
		
		JLabel ticketreserve_3 = new JLabel("극장");
		ticketreserve_3.setBounds(410, 113, 149, 55);
		panel_1.add(ticketreserve_3);
		ticketreserve_3.setForeground(new Color(255, 255, 255));
		ticketreserve_3.setFont(new Font("맑은 고딕", Font.PLAIN, 28));
		
		JLabel ticketreserve_4 = new JLabel("시간");
		ticketreserve_4.setBounds(595, 113, 71, 55);
		panel_1.add(ticketreserve_4);
		ticketreserve_4.setForeground(new Color(255, 255, 255));
		ticketreserve_4.setFont(new Font("맑은 고딕", Font.PLAIN, 28));
		
		JLabel ticketreserve = new JLabel("영화예매하기");
		ticketreserve.setBounds(278, 24, 223, 55);
		panel_1.add(ticketreserve);
		ticketreserve.setForeground(new Color(255, 255, 255));
		ticketreserve.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 35));
		 
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Ticketreserve.class.getResource("/image/button/back.png")));
		lblNewLabel.setBounds(22, 424, 110, 55);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Ticketreserve.class.getResource("/image/button/select.png")));
		lblNewLabel_1.setBounds(644, 424, 110, 55);
		panel_1.add(lblNewLabel_1);
		
		// 영화제목 리스트
		movie_name_list = new JList<String>();
		movie_name_list.setBounds(34, 171, 176, 200);
		movie_name_list.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		  
		JScrollPane namep=new JScrollPane(movie_name_list);
		namep.setBounds(12, 171, 205, 243);
		panel_1.add(namep); 
		loadSQLData(movie_name_list);
		
		// 지역 리스트
		movie_location_list = new JList<String>();
		movie_location_list.setBounds(229, 172, 149, 243);
		movie_location_list.setFont(new Font("맑은 고딕", Font.BOLD,20));
		panel_1.add(movie_location_list);
		
		
		JScrollPane locationP=new JScrollPane(movie_location_list);
		locationP.setBounds(229, 172, 149, 243); panel_1.add(locationP);
		//loadSQLData(movie_location_list);
		 
		// 극장 리스트
		movie_theater_list = new JList<String>();
		movie_theater_list.setBounds(390, 172, 156, 243);
		movie_theater_list.setFont(new Font("맑은 고딕", Font.BOLD,20));
		panel_1.add(movie_theater_list);
		
		  JScrollPane thaeterP=new JScrollPane(movie_theater_list);
		  thaeterP.setBounds(390, 172, 156, 243); panel_1.add(thaeterP);
		 // loadSQLData(movie_location_list);
		 
		// 시간 리스트
		movie_time_list = new JList<String>();
		movie_time_list.setBounds(558, 171, 196, 243);
		movie_time_list.setFont(new Font("맑은 고딕", Font.BOLD,20));
		panel_1.add(movie_time_list);
		
		JScrollPane time=new JScrollPane(movie_time_list); 
		time.setBounds(558, 171, 196, 243); 
	    panel_1.add(time); 
	   // loadSQLData(movie_time_list);
		 
	}
	
private void loadSQLData(JList<String> _list) {

	DefaultListModel<String> model = new DefaultListModel<>();
	
	//movie_name_list = new JList<>(model);
	_list.setFont(new Font("맑은 고딕", Font.BOLD, 20));
	_list.setCellRenderer(new DefaultListCellRenderer());
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
	  
	try { String sql ="" + " SELECT MOVIE_NAME " + " FROM MOVIE ";
		  
		  PreparedStatement pstmt1 = conn.prepareStatement(sql);
		  
		  ResultSet rs = pstmt1.executeQuery();
		  
		  while(rs.next()) {
		  
		 String movieName = rs.getString("MOVIE_NAME");
         model.addElement(movieName);
		  }		
		  pstmt1.close();
		  } catch (SQLException e) { 
			  e.printStackTrace(); }
		finally { 
		if(conn !=null) { 
		try { conn.close(); } 
		catch (SQLException e) {} }}

		_list.setModel(model);
		//ListSelectionLis tener
		_list.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				
			}
		});
		}
		/*
		 * private void localsqldata(JList<String> local_list) {
		 * 
		 * DefaultListModel<String> local = new DefaultListModel<>(); }
		 */
}

