package projectPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Ticketreserve extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainTestFrame mainTestFrame;
	private JList<String> movie_name_list, movie_location_list, movie_theater_list, movie_time_list;

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
		panel.setBounds(134, 10, 934, 591);
		add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(12, 10, 910, 569);
		panel.add(panel_1);
		panel_1.setLayout(null);
		// 고정값

		JLabel ticketreserve_1 = new JLabel("영화");
		ticketreserve_1.setBounds(77, 93, 60, 41);
		panel_1.add(ticketreserve_1);
		ticketreserve_1.setForeground(new Color(255, 255, 255));
		ticketreserve_1.setFont(new Font("맑은 고딕", Font.PLAIN, 28));

		JLabel ticketreserve_2 = new JLabel("지역");
		ticketreserve_2.setBounds(279, 86, 71, 55);
		panel_1.add(ticketreserve_2);
		ticketreserve_2.setForeground(new Color(255, 255, 255));
		ticketreserve_2.setFont(new Font("맑은 고딕", Font.PLAIN, 28));

		JLabel ticketreserve_3 = new JLabel("극장");
		ticketreserve_3.setBounds(457, 86, 71, 55);
		panel_1.add(ticketreserve_3);
		ticketreserve_3.setForeground(new Color(255, 255, 255));
		ticketreserve_3.setFont(new Font("맑은 고딕", Font.PLAIN, 28));

		JLabel ticketreserve_4 = new JLabel("시간");
		ticketreserve_4.setBounds(723, 86, 71, 55);
		panel_1.add(ticketreserve_4);
		ticketreserve_4.setForeground(new Color(255, 255, 255));
		ticketreserve_4.setFont(new Font("맑은 고딕", Font.PLAIN, 28));

		JLabel ticketreserve = new JLabel("영화예매하기");
		ticketreserve.setBounds(350, 10, 223, 55);
		panel_1.add(ticketreserve);
		ticketreserve.setForeground(new Color(255, 255, 255));
		ticketreserve.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 35));

		JButton BackButton = new JButton("");
		BackButton.addActionListener(new BackAction());
		BackButton.setIcon(new ImageIcon(Ticketreserve.class.getResource("/image/button/back.png")));
		BackButton.setBounds(12, 504, 110, 42);
		panel_1.add(BackButton);

		JButton SeatButton = new JButton("");
		SeatButton.addActionListener(new SeatAction());
		SeatButton.setIcon(new ImageIcon(Ticketreserve.class.getResource("/image/button/select.png")));
		SeatButton.setBounds(788, 504, 110, 42);
		panel_1.add(SeatButton);

		// 영화제목 리스트
		movie_name_list = new JList<String>();
		movie_name_list.setBounds(34, 171, 176, 200);
		movie_name_list.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		JScrollPane namep = new JScrollPane(movie_name_list);
		namep.setBounds(12, 144, 205, 334);
		panel_1.add(namep);
		loadSQLData(movie_name_list);

		// 지역 리스트
		movie_location_list = new JList<String>();
		movie_location_list.setBounds(229, 172, 149, 243);
		movie_location_list.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel_1.add(movie_location_list);

		JScrollPane locationP = new JScrollPane(movie_location_list);
		locationP.setBounds(229, 144, 167, 333);
		panel_1.add(locationP);
		// localSQLData(movie_location_list);

		// 극장 리스트
		movie_theater_list = new JList<String>();
		movie_theater_list.setBounds(390, 172, 156, 243);
		movie_theater_list.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel_1.add(movie_theater_list);

		JScrollPane thaeterP = new JScrollPane(movie_theater_list);
		thaeterP.setBounds(404, 144, 190, 334);
		panel_1.add(thaeterP);
		// loadSQLData(movie_location_list);

		// 시간 리스트
		movie_time_list = new JList<String>();
		movie_time_list.setBounds(558, 171, 196, 243);
		movie_time_list.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel_1.add(movie_time_list);

		JScrollPane time = new JScrollPane(movie_time_list);
		time.setBounds(606, 144, 292, 334);
		panel_1.add(time);

		// loadSQLData(movie_time_list);

	}

	private void loadSQLData(JList<String> _list) {

		DefaultListModel<String> model = new DefaultListModel<>();

		// movie_name_list = new JList<>(model);
		_list.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		_list.setCellRenderer(new DefaultListCellRenderer());

		// 디비연결
		Connection conn = getDBConnection();

		try {
			String sql = "" + " SELECT MOVIE_NAME " + " FROM MOVIE ";

			PreparedStatement pstmt1 = conn.prepareStatement(sql);

			ResultSet rs = pstmt1.executeQuery();

			while (rs.next()) {

				String movieName = rs.getString("MOVIE_NAME");
				model.addElement(movieName);

			}
			pstmt1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		_list.setModel(model);
		// ListSelectionLis tener
		_list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				localSQLData(movie_location_list);
				removeActionPerformed(e);

			}

			private void removeActionPerformed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	// 지역명 불러오기
	private void localSQLData(JList<String> local_list) {

		DefaultListModel<String> local = new DefaultListModel<>();

		local_list.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		local_list.setCellRenderer(new DefaultListCellRenderer());

		// 디비연결
		Connection conn = getDBConnection();
		try {
			String sql = "" + " SELECT LOCAL_NAME " + " FROM LOCAL";

			PreparedStatement pstmt1 = conn.prepareStatement(sql);

			ResultSet rs = pstmt1.executeQuery();

			while (rs.next()) {

				String localName = rs.getString("LOCAL_NAME");
				local.addElement(localName);
			}
			pstmt1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		local_list.setModel(local);
		local_list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				TheaterSQLData(movie_theater_list);

			}
		});
	}

//극장명 불러오기
	private void TheaterSQLData(JList<String> theater_list) {

		DefaultListModel<String> theater = new DefaultListModel<>();

		theater_list.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		theater_list.setCellRenderer(new DefaultListCellRenderer());

		// 디비연결
		Connection conn = getDBConnection();
		try {
			String sql = " " + " SELECT THEATER_NAME  " + " FROM THEATER";

			PreparedStatement pstmt1 = conn.prepareStatement(sql);

			ResultSet rs = pstmt1.executeQuery();

			while (rs.next()) {

				String theaterName = rs.getString("THEATER_NAME");
				theater.addElement(theaterName);
			}
			pstmt1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		theater_list.setModel(theater);
		theater_list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				TimeSQLData(movie_time_list);

			}
		});
	}

//상영시간 불러오기
	private void TimeSQLData(JList<String> Time_list) {

		DefaultListModel<String> time = new DefaultListModel<>();

		Time_list.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		Time_list.setCellRenderer(new DefaultListCellRenderer());

		// 디비연결
		Connection conn = getDBConnection();
		try {
			String sql = " " + " SELECT SCHEDULE_TIME  " + " FROM MOVIESCHEDULE";

			PreparedStatement pstmt1 = conn.prepareStatement(sql);

			ResultSet rs = pstmt1.executeQuery();

			while (rs.next()) {

				String timeName = rs.getString("SCHEDULE_TIME");
				time.addElement(ChangeDateFormat(timeName));

			}
			pstmt1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		Time_list.setModel(time);
		Time_list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				// TheaterSQLData(movie_theater_list);

			}
		});
	}

//시간변환출력
	public String ChangeDateFormat(String dateStr) {
		String result = "";

// FORMAT 2개 선언
// 받아줄 FORMAT
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
// 변환할 FORMAT
		SimpleDateFormat format2 = new SimpleDateFormat("MM/dd hh:mm");
		try {
			// 받은 날짜를 DATE 형태로 변환
			Date temp = format.parse(dateStr);

			// DATE를 목적에 맞는 형식으로 변환
			result = format2.format(temp);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

//버튼 액션
	class BackAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			mainTestFrame.PageChange(MainFrame.PANELNAME.MAIN);
		}
	}

	class SeatAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			mainTestFrame.PageChange(MainFrame.PANELNAME.PAGE1);
		}
	}

	// 디비 연결과 티켓정보
	private Connection getDBConnection() {
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

			conn = DriverManager.getConnection("jdbc:oracle:thin:@//14.42.124.35:1521/XE", "c##wjrls", "881125");

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
			/* pstmt.close(); */ } catch (ClassNotFoundException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
