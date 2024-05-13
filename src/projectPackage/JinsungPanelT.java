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
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JinsungPanelT extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainFrame mainFrame;
	private TicketFrame ticketFrame;
	private Connection conn;
		
	private TicketVo ticketInfo;
	int ticket_no = 0;
	String movie_name = "";
	String time = "";
	String th_name = "";
	String mh_name = "";
	String seat_info = "";
	String local_name = "";

	/**
	 * Create the panel.
	 */

	public JinsungPanelT(MainFrame mainFrame) {

		this.mainFrame = mainFrame;
		ticketInfo  = new TicketVo(); 
		
		SQLDataconnect();
		setLayout(null);
		this.setSize(1280, 800 - 150);
		this.setPreferredSize(new Dimension(1280, 800 - 150));
		this.setBackground(Color.white);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 1280, 650);
		add(panel);
		panel.setLayout(null);
		JLabel show_image = new JLabel("");
		try {
			String sql = "" + " SELECT FILE_DIRECTORY " + " FROM MOVIE " + " WHERE MOVIE_NAME=? " ;
					PreparedStatement pstmt3 = conn.prepareStatement(sql);
			pstmt3.setString(1, "스턴트맨");

			ResultSet rs = pstmt3.executeQuery();

			while (rs.next()) {
				
			}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}

		show_image.setIcon(new ImageIcon(JinsungPanel.class.getResource("/image/ohtani/stuntman.jpg")));
		show_image.setBounds(185, 33, 161, 245);
		panel.add(show_image);

		JLabel lblNewLabelfix = new JLabel("예매 내역");
		lblNewLabelfix.setForeground(Color.WHITE);
		lblNewLabelfix.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 35));
		lblNewLabelfix.setBounds(556, 10, 168, 77);
		panel.add(lblNewLabelfix);

		// 영화명
		JLabel Title_name = new JLabel("영화명");
		Title_name.setForeground(Color.WHITE);
		Title_name.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		Title_name.setBounds(147, 273, 111, 41);
		panel.add(Title_name);

		JLabel Title = new JLabel("영화");
		Title.setForeground(Color.WHITE);
		Title.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		Title.setBounds(1029, 273, 202, 41);
		panel.add(Title);

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
		Title.setText(movie_name);

		// 예매 번호
		JLabel ticketNum = new JLabel("예매 번호");
		ticketNum.setForeground(Color.WHITE);
		ticketNum.setFont(new Font("나눔고딕", Font.BOLD, 28));
		ticketNum.setBounds(974, 130, 152, 51);
		panel.add(ticketNum);

		JLabel ticketNump = new JLabel("1234-567");
		ticketNum.setForeground(Color.WHITE);
		ticketNum.setFont(new Font("나눔고딕", Font.BOLD, 28));
		ticketNum.setBounds(1016, 130, 196, 77);
		panel.add(ticketNum);

		try {
			String sql = "" + " SELECT TICKET_NO " + " FROM TICKET " + " Where USER_NO = ? ";

			PreparedStatement pstmt1 = conn.prepareStatement(sql);
			pstmt1.setString(1, "2");

			ResultSet rs = pstmt1.executeQuery();
			while (rs.next()) {

				// 티켓번호
				ticket_no = rs.getInt("TICKET_NO");

			}
			pstmt1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ticketNum.setText(String.valueOf(ticket_no));

		// 상영시간
		JLabel Time = new JLabel("상영일시");
		Time.setForeground(Color.WHITE);
		Time.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		Time.setBounds(147, 334, 111, 41);
		panel.add(Time);

		JLabel timep = new JLabel("00:00");
		timep.setForeground(Color.WHITE);
		timep.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		timep.setBounds(902, 334, 267, 41);
		panel.add(timep);

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
		timep.setText(time);

		// 영화관 지역이름
		JLabel movielocal = new JLabel("극장명");
		movielocal.setForeground(Color.WHITE);
		movielocal.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		movielocal.setBounds(147, 385, 111, 41);
		panel.add(movielocal);

		JLabel localp = new JLabel("CGV");
		localp.setForeground(Color.WHITE);
		localp.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		localp.setBounds(1029, 385, 179, 41);
		panel.add(localp);

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
		localp.setText(local_name);

		// 상영관
		JLabel screen = new JLabel("상영관");
		screen.setForeground(Color.WHITE);
		screen.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		screen.setBounds(147, 436, 111, 41);
		panel.add(screen);
		JLabel screenp = new JLabel("0관");
		screenp.setForeground(Color.WHITE);
		screenp.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		screenp.setBounds(1029, 436, 189, 41);
		panel.add(screenp);

		try {
			String sql = "" + " SELECT MOVIEHOUSE_NAME " + " FROM MovieHouse " + " WHERE LOCAL_NO =? ";

			PreparedStatement pstmt1 = conn.prepareStatement(sql);
			pstmt1.setString(1, "4");

			ResultSet rs = pstmt1.executeQuery();

			while (rs.next()) {
				th_name = rs.getString("MOVIEHOUSE_NAME");
				screenp.setText(th_name);
			}
			pstmt1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		JLabel person = new JLabel("좌석");
		person.setForeground(Color.WHITE);
		person.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		person.setBounds(147, 487, 111, 41);
		panel.add(person);

		JLabel personp = new JLabel("A1,A2");
		personp.setForeground(Color.WHITE);
		personp.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		personp.setBounds(1029, 487, 124, 41);
		panel.add(personp);

		// 뒤로가기버튼
		JButton backButton = new JButton("");
		backButton.addActionListener(new BackAction());
		backButton.setIcon(new ImageIcon(JinsungPanelT.class.getResource("/image/button/back.png")));
		backButton.setBounds(268, 536, 110, 42);
		panel.add(backButton);

		ticketFrame = new TicketFrame();
		ticketFrame.setParentPage(this);

		// 티켓취소버튼
		JButton cancleButton = new JButton("");
		cancleButton.addActionListener(new CancleAction());
		cancleButton.setIcon(new ImageIcon(JinsungPanelT.class.getResource("/image/jinsung/ticketcancle.png")));
		cancleButton.setBounds(987, 536, 110, 42);
		panel.add(cancleButton);

		this.setVisible(false);
	}
	// 디비 연결
	private Connection SQLDataconnect() {
	
		int ticket_no = 0;
		String movie_name = "";
		String time = "";
		String th_name = "";
		String mh_name = "";
		String seat_info = "";
		String local_name = "";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@//14.42.124.35:1521/XE",
					"c##wjrls", 
					"881125" );

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
				
				this.ticketInfo.setMovie_Name(movie_name);
				this.ticketInfo.setMovieHouse_Name(mh_name);
				this.ticketInfo.setLocal_name(local_name);
				this.ticketInfo.setSchedule_time(time);
				this.ticketInfo.setTheater_Name(th_name);
				this.ticketInfo.setSeat_Info(seat_info);
				this.ticketInfo.setTicket_no(ticket_no);	

			}
			/* pstmt.close(); */ } catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} return conn;
	}
	
	// -------------------------------------------------------------//
	public MainFrame get_MainTestFrame() {
		return mainFrame;
	}
	// 티켓취소
	public void CancleProgress() {
		SQLDataconnect();
		
		try {
			String sql = "" + " DELETE FROM MOVIE " + "WHERE TICKET =? ";
			PreparedStatement pstmt1 = conn.prepareStatement(sql);
			pstmt1.setString(1, "41");
			System.out.println("Progress in----");

			int rs = pstmt1.executeUpdate();

			if (rs < 0 || rs > 1)
				System.out.println("err : movie ticket delete rs cnt : " + rs);
			
		}
		  //catch (ClassNotFoundException e) { 
		  //e.printStackTrace(); }
		  catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		// --> 전에 있던 텍스트 날려주세요.
		// TextInit();
	}

	/*
	 * 텍스트 날린거 표시 public void TextInit() { this.timep.setText("test null"); }
	 */

	class BackAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			mainFrame.PageChange(MainFrame.PANELNAME.TICKETINFO);
		}
	}

	class CancleAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ticketFrame.setVisible(true);
		}
	}
}