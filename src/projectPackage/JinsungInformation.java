package projectPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class JinsungInformation extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel JinsungPanelT;
	private MainFrame mainFrame;
	
	private JLabel Movi_namep;
	private JLabel ticket_Nump;
	private JLabel Local_namep;
	private JLabel Movie_timep;
	
	private TicketVo ticketObj;
	
	private int TicketNo = -1;

	/**
	 * Create the panel.
	 */
	public JinsungInformation(MainFrame mainFrame) {
		this.mainFrame = mainFrame;

		ticketObj = new TicketVo();
		
		Connection conn = null;

		int ticket_no = 0;
		String movie_name = "";
		String time = "";
		String th_name = "";
		String mh_name = "";
		String seat_info = "";
		String local_name = "";

		// 디비 연결
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@//14.42.124.35:1521/XE",
					"c##wjrls", 
					"881125");

			String sql = "SELECT LOCAL.LOCAL_NAME, A.TICKET_NO, A.SEAT_INFO, A.SEAT_INFO, A.USER_NO, ui.USER_NAME ,m.SCHEDULE_NO,t2.THEATER_NAME , m3.MOVIEHOUSE_NAME ,m.SCHEDULE_TIME, m.SCHEDULE_ENDTIME, m2.MOVIE_NAME "
					+ "from " + "( "
					+ "(((((SELECT t.TICKET_NO ,t.SEAT_NO, s.SEAT_INFO, T.SCHEDULE_NO, T.USER_NO  FROM TICKET t JOIN SEAT s ON t.SEAT_NO = s.SEAT_NO) A "
					+ "JOIN MOVIESCHEDULE m ON A.SCHEDULE_NO = m.SCHEDULE_NO ) "
					+ "JOIN MOVIE m2 ON m.MOVIE_NO = m2.MOVIE_NO) "
					+ "JOIN MOVIEHOUSE m3 ON m3.MOVIEHOUSE_NO = m.MOVIEHOUSE_NO) "
					+ "JOIN THEATER t2 ON t2.MOVIEHOUSE_NO = m3.MOVIEHOUSE_NO) "
					+ "JOIN USER_INFO ui ON ui.USER_NO = A.USER_NO) " + "JOIN LOCAL ON LOCAL.LOCAL_NO = m3.LOCAL_NO "
					+ "WHERE a.TICKET_NO = " + "41";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				// 예매 번호, 영화명, 상영시간, 상영관이름, 극장 이름, 좌석번호
				ticket_no = rs.getInt("TICKET_NO");
				movie_name = rs.getString("MOVIE_NAME");
				time = rs.getString("SCHEDULE_TIME");
				th_name = rs.getString("THEATER_NAME");
				mh_name = rs.getString("MOVIEHOUSE_NAME");
				seat_info = rs.getString("SEAT_INFO");
				local_name = rs.getString("LOCAL_NAME");
			}
			/* pstmt.close(); */ } catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		setLayout(null);
		this.setSize(1280, 800 - 150);
		this.setPreferredSize(new Dimension(1280, 800 - 150));
		this.setBackground(Color.white);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 1280, 650);
		add(panel);
		panel.setLayout(null);

		JLabel movie_Info = new JLabel("Information");
		movie_Info.setForeground(new Color(238, 46, 36));
		movie_Info.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 40));
		movie_Info.setBounds(530, 26, 224, 74);
		panel.add(movie_Info);

		// 영화제목
		JLabel Movie_name = new JLabel("영화명");
		Movie_name.setForeground(Color.WHITE);
		Movie_name.setFont(new Font("나눔고딕", Font.BOLD, 26));
		Movie_name.setBounds(340, 220, 111, 40);
		panel.add(Movie_name);

		Movi_namep = new JLabel("영화제목불러오기");
		Movi_namep.setForeground(Color.WHITE);
		Movi_namep.setFont(new Font("나눔고딕", Font.BOLD, 26));
		Movi_namep.setBounds(770, 220, 245, 40);
		panel.add(Movi_namep);

		try {
			String sql = "" + " SELECT MOVIE_NAME " + " FROM MOVIE " + " WHERE MOVIE_COMMENT = ? ";

			PreparedStatement pstmt2 = conn.prepareStatement(sql);
			pstmt2.setString(1, "TEST_COMMENT");

			ResultSet rs = pstmt2.executeQuery();

			while (rs.next()) {

				movie_name = rs.getString("MOVIE_NAME");

			}

			pstmt2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Movi_namep.setText("00");

		// 예매번호
		JLabel ticketNum = new JLabel("예매 번호");
		ticketNum.setForeground(Color.WHITE);
		ticketNum.setFont(new Font("나눔고딕", Font.BOLD, 26));
		ticketNum.setBounds(340, 160, 152, 40);
		panel.add(ticketNum);

		ticket_Nump = new JLabel("0000-001");
		ticket_Nump.setForeground(Color.WHITE);
		ticket_Nump.setFont(new Font("나눔고딕", Font.BOLD, 26));
		ticket_Nump.setBounds(770, 160, 245, 40);
		panel.add(ticket_Nump);

		try {
			String sql = "" + " SELECT TICKET_NO " + " FROM TICKET " + " Where USER_NO = ? ";

			PreparedStatement pstmt1 = conn.prepareStatement(sql);
			pstmt1.setString(1, "2");

			ResultSet rs = pstmt1.executeQuery();
			while (rs.next()) {
				ticket_no = rs.getInt("TICKET_NO");

			}
			pstmt1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ticket_Nump.setText("00");

		// 극장명
		JLabel Local_name = new JLabel("극장명");
		Local_name.setForeground(Color.WHITE);
		Local_name.setFont(new Font("나눔고딕", Font.BOLD, 26));
		Local_name.setBounds(340, 280, 111, 40);
		panel.add(Local_name);

		Local_namep = new JLabel("CGV의정부");
		Local_namep.setForeground(Color.WHITE);
		Local_namep.setFont(new Font("나눔고딕", Font.BOLD, 26));
		Local_namep.setBounds(770, 280, 258, 40);
		panel.add(Local_namep);

		try {
			String sql = "" + " SELECT LOCAL_NAME " + " FROM LOCAL " + " WHERE LOCAL_POSITION =? ";
			PreparedStatement pstmt1 = conn.prepareStatement(sql);
			pstmt1.setString(1, "경기도 의정부시");

			ResultSet rs = pstmt1.executeQuery();

			while (rs.next()) {
				mh_name = rs.getString("LOCAL_NAME");
			}
			pstmt1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Local_namep.setText("00");

		// 상영시간
		JLabel Movie_time = new JLabel("상영일시");
		Movie_time.setForeground(Color.WHITE);
		Movie_time.setFont(new Font("나눔고딕", Font.BOLD, 26));
		Movie_time.setBounds(340, 340, 111, 40);
		panel.add(Movie_time);

		Movie_timep = new JLabel("null");
		Movie_timep.setForeground(Color.WHITE);
		Movie_timep.setFont(new Font("나눔고딕", Font.BOLD, 26));
		Movie_timep.setBounds(770, 340, 302, 40);
		panel.add(Movie_timep);
		
		try {
			String sql = "" + " SELECT SCHEDULE_TIME " + " FROM MOVIESCHEDULE " + " WHERE SCHEDULE_NO = ? ";

			PreparedStatement pstmt3 = conn.prepareStatement(sql);
			pstmt3.setString(1, "2");

			ResultSet rs = pstmt3.executeQuery();

			while (rs.next()) {

				time = rs.getString("SCHEDULE_TIME");
			}
			pstmt3.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Movie_timep.setText("00");

		JButton BackButton = new JButton("");
		BackButton.setBorderPainted(false);
		BackButton.addActionListener(new BackAction());
		BackButton.setIcon(new ImageIcon(JinsungInformation.class.getResource("/image/button/back.png")));
		BackButton.setBounds(520, 480, 110, 42);
		panel.add(BackButton);

		JButton InfoButton = new JButton("");
		InfoButton.setBorderPainted(false);
		InfoButton.addActionListener(new InfoAction());
		InfoButton.setIcon(new ImageIcon(JinsungInformation.class.getResource("/image/jinsung/ticketinfoma.png")));
		InfoButton.setBounds(660, 480, 110, 42);
		panel.add(InfoButton);

		this.setVisible(false);
	}
	
	public void PageInit()
	{
		if(TicketNo <= 0)
		{
			System.out.println("비정상적인 접근");
			return;
		}
		
		ticketObj = new TicketVo();
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@//14.42.124.35:1521/XE",
					"c##wjrls", 
					"881125");

			String sql = "SELECT LOCAL.LOCAL_NAME, A.TICKET_NO, A.SEAT_INFO, A.SEAT_INFO, A.USER_NO, ui.USER_NAME ,m.SCHEDULE_NO,t2.THEATER_NAME , m3.MOVIEHOUSE_NAME ,m.SCHEDULE_TIME, m.SCHEDULE_ENDTIME, m2.MOVIE_NAME "
					+ "from " + "( "
					+ "(((((SELECT t.TICKET_NO ,t.SEAT_NO, s.SEAT_INFO, T.SCHEDULE_NO, T.USER_NO  FROM TICKET t JOIN SEAT s ON t.SEAT_NO = s.SEAT_NO) A "
					+ "JOIN MOVIESCHEDULE m ON A.SCHEDULE_NO = m.SCHEDULE_NO ) "
					+ "JOIN MOVIE m2 ON m.MOVIE_NO = m2.MOVIE_NO) "
					+ "JOIN MOVIEHOUSE m3 ON m3.MOVIEHOUSE_NO = m.MOVIEHOUSE_NO) "
					+ "JOIN THEATER t2 ON t2.MOVIEHOUSE_NO = m3.MOVIEHOUSE_NO) "
					+ "JOIN USER_INFO ui ON ui.USER_NO = A.USER_NO) " + "JOIN LOCAL ON LOCAL.LOCAL_NO = m3.LOCAL_NO "
					+ "WHERE a.TICKET_NO = " + this.TicketNo;

			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			rs.next();			
			
			ticketObj.setTicket_no(rs.getInt("TICKET_NO"));
			ticketObj.setMovie_Name(rs.getString("MOVIE_NAME"));
			ticketObj.setSchedule_time(rs.getString("SCHEDULE_TIME"));
			ticketObj.setTheater_Name(rs.getString("THEATER_NAME"));
			ticketObj.setMovieHouse_Name(rs.getString("MOVIEHOUSE_NAME"));
			ticketObj.setSeat_Info(rs.getString("SEAT_INFO"));
			ticketObj.setLocal_name(rs.getString("LOCAL_NAME"));
			
			pstmt.close();
			conn.close();			
		
			} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	
		Movi_namep.setText(ticketObj.getMovie_Name());
		ticket_Nump.setText(Integer.toString(ticketObj.getTicket_no()));
		Local_namep.setText(ticketObj.getLocal_name());
		Movie_timep.setText(ticketObj.getSchedule_time());
	}
	
	public void Set_TicketNo(int ticketNo)
	{
		System.out.println(ticketNo);
		this.TicketNo = ticketNo;
	}	
	

	ImageIcon imageSetSize(ImageIcon icon, int i, int j) { // image Size Setting
		Image ximg = icon.getImage(); // ImageIcon을 Image로 변환.
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}

	class InfoAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {			
			
			System.out.println(ticketObj.getMovie_Name());
			mainFrame.Set_TicketInfo_Cancle(ticketObj);
			mainFrame.PageChange(MainFrame.PANELNAME.TICKETCANCLE);
		}
	}
	
	class BackAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			mainFrame.PageChange(MainFrame.PANELNAME.MYPAGE);

		}
	}
}
