package projectPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JinsungPanelT extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainFrame mainFrame;
	private TicketFrame ticketFrame;
	private Connection conn;
		
	private TicketVo ticketInfo;
	private TicketVo ticketInfo2;
	int ticket_no = 0;
	String movie_name = "";
	String time = "";
	String th_name = "";
	String mh_name = "";
	String seat_info = "";
	String local_name = "";
	
	private JLabel Title;
	private JLabel show_image;
	private JLabel ticketNum;
	private JLabel timep;
	private JLabel localp;
	private JLabel screenp;
	private JLabel personp;

	private int TicketNo = -1;
	/**
	 * Create the panel.
	 */
	
	public void PageInit()	
	{
		if(TicketNo <= 0)
		{
			System.out.println("비정상적인 접근");
			return;
		}
		
		ticketInfo2 = new TicketVo();
		
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
			
			ticketInfo2.setTicket_no(rs.getInt("TICKET_NO"));
			ticketInfo2.setMovie_Name(rs.getString("MOVIE_NAME"));
			ticketInfo2.setSchedule_time(rs.getString("SCHEDULE_TIME"));
			ticketInfo2.setTheater_Name(rs.getString("THEATER_NAME"));
			ticketInfo2.setMovieHouse_Name(rs.getString("MOVIEHOUSE_NAME"));
			ticketInfo2.setSeat_Info(rs.getString("SEAT_INFO"));
			ticketInfo2.setLocal_name(rs.getString("LOCAL_NAME"));
			
			pstmt.close();
			conn.close();			
		
			} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	
		/*
		 * Movi_namep.setText(ticketInfo2.getMovie_Name());
		 * ticket_Nump.setText(Integer.toString(ticketInfo2.getTicket_no()));
		 * Local_namep.setText(ticketInfo2.getLocal_name());
		 * Movie_timep.setText(ticketInfo2.getSchedule_time());
		 */
		Title.setText(ticketInfo2.getMovie_Name());
		
		//TicketNumberCreator(ticketInfo2);
		//ticketNum.setText(Integer.toString(ticketInfo2.getTicket_no()));
		ticketNum.setText(TicketNumberCreator(ticketInfo2));
		
		timep.setText(ticketInfo2.getSchedule_time());
		localp.setText(ticketInfo2.getMovieHouse_Name());
		screenp.setText(ticketInfo2.getTheater_Name());
		personp.setText(ticketInfo2.getSeat_Info());
		
		MoviePosterUpdate();
	}
	
	public String TicketNumberCreator(TicketVo ticketInfo)
	{
		String result = Integer.toString(ticketInfo.getUser_no());
		result += Integer.toString(ticketInfo.getTicket_no());
		
		
		String[] seat = ticketInfo.getSeat_Info().split("_");
		result += seat[0] + seat[1];
		
		
		return result;
	}
	
	public void MoviePosterUpdate()
	{
		String Dir = "";
		try 
		{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@//14.42.124.35:1521/XE",
					"c##wjrls", 
					"881125");
			
			String rawString = ticketInfo2.getMovie_Name();	
			
			String sql = "SELECT FILE_DIRECTORY FROM MOVIE WHERE MOVIE_NAME = '" + rawString +"' " ;
			PreparedStatement pstmt3 = conn.prepareStatement(sql);			

			ResultSet rs = pstmt3.executeQuery();
			rs.next();
			
			Dir = rs.getString("FILE_DIRECTORY");		
			System.out.println(Dir);
		} 
		catch (SQLException | ClassNotFoundException e) 
		{		
			e.printStackTrace(); 
		}
		
		ImageIcon tempIcon = new ImageIcon(JinsungPanelT.class.getResource(Dir));
		tempIcon = imageSetSize(tempIcon, 150, 214);
		show_image.setIcon(tempIcon);
	}
			
	public JinsungPanelT(MainFrame mainFrame) {

		this.mainFrame = mainFrame;
		ticketInfo2  = new TicketVo(); 
		
		setLayout(null);
		this.setSize(1280, 800 - 150);
		this.setPreferredSize(new Dimension(1280, 800 - 150));
		this.setBackground(Color.white);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 1280, 650);
		add(panel);
		panel.setLayout(null);
		
		//SQLDataconnect();
		
		show_image = new JLabel("");
		show_image.setBounds(206, 162, 150, 214);	
		panel.add(show_image);

		// 영화명
		JLabel Title_name = new JLabel("영화명");
		Title_name.setBounds(436, 197, 111, 40);
		Title_name.setForeground(Color.WHITE);
		Title_name.setFont(new Font("나눔고딕", Font.BOLD, 26));
		panel.add(Title_name);

		Title = new JLabel("");
		Title.setBounds(732, 197, 202, 40);
		Title.setForeground(Color.WHITE);
		Title.setFont(new Font("나눔고딕", Font.BOLD, 22));
		panel.add(Title);

		// 예매 번호
		ticketNum = new JLabel("");
		ticketNum.setBackground(new Color(0, 0, 0));
		ticketNum.setHorizontalAlignment(SwingConstants.CENTER);
		ticketNum.setBounds(530, 110, 196, 77);
		ticketNum.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 30));
		ticketNum.setForeground(new Color(252, 196, 52));
		panel.add(ticketNum);
	
		/*
		 * ticketNump = new JLabel("1234-567"); ticketNum.setForeground(Color.WHITE);
		 * ticketNum.setFont(new Font("나눔고딕", Font.BOLD, 28)); panel.add(ticketNum);
		 */
		
		// 상영시간
		JLabel Time = new JLabel("상영일시");
		Time.setBounds(436, 247, 111, 40);
		Time.setForeground(Color.WHITE);
		Time.setFont(new Font("나눔고딕", Font.BOLD, 26));
		panel.add(Time);

		timep = new JLabel("");
		timep.setBounds(732, 247, 370, 40);
		timep.setForeground(Color.WHITE);
		timep.setFont(new Font("나눔고딕", Font.BOLD, 22));
		panel.add(timep);

		// 영화관 지역이름
		JLabel movielocal = new JLabel("극장명");
		movielocal.setBounds(436, 297, 111, 40);
		movielocal.setForeground(Color.WHITE);
		movielocal.setFont(new Font("나눔고딕", Font.BOLD, 26));
		panel.add(movielocal);

		localp = new JLabel("");
		localp.setBounds(732, 297, 179, 40);
		localp.setForeground(Color.WHITE);
		localp.setFont(new Font("나눔고딕", Font.BOLD , 22));
		panel.add(localp);

		// 상영관
		JLabel screen = new JLabel("상영관");
		screen.setBounds(436, 347, 111, 40);
		screen.setForeground(Color.WHITE);
		screen.setFont(new Font("나눔고딕", Font.BOLD, 26));
		panel.add(screen);
		
		screenp = new JLabel("");
		screenp.setBounds(732, 347, 357, 40);
		screenp.setForeground(Color.WHITE);
		screenp.setFont(new Font("나눔고딕", Font.BOLD, 22));
		panel.add(screenp);

	
		JLabel person = new JLabel("좌석");
		person.setBounds(436, 397, 120, 40);
		person.setForeground(new Color(255, 255, 255));
		person.setFont(new Font("나눔고딕", Font.BOLD, 26));
		panel.add(person);

		personp = new JLabel("");
		personp.setBounds(732, 397, 337, 40);
		personp.setForeground(Color.WHITE);
		personp.setFont(new Font("나눔고딕", Font.BOLD, 22));
		panel.add(personp);

		// 뒤로가기버튼
		JButton backButton = new JButton("");
		backButton.setBorderPainted(false);
		backButton.setBounds(508, 500, 110, 42);
		backButton.addActionListener(new BackAction());
		backButton.setIcon(new ImageIcon(JinsungPanelT.class.getResource("/image/button/back.png")));
		panel.add(backButton);

		ticketFrame = new TicketFrame();
		ticketFrame.setParentPage(this);

		// 티켓취소버튼
		JButton cancleButton = new JButton("");
		cancleButton.setBorderPainted(false);
		cancleButton.setBounds(643, 500, 110, 42);
		cancleButton.addActionListener(new CancleAction());
		cancleButton.setIcon(new ImageIcon(JinsungPanelT.class.getResource("/image/jinsung/ticketcancle.png")));
		panel.add(cancleButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(JinsungPanelT.class.getResource("/image/title/reserve2.png")));
		lblNewLabel.setBounds(510, 24, 270, 80);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(JinsungPanelT.class.getResource("/image/button/cgving_th.png")));
		lblNewLabel_1.setBounds(700, 120, 64, 16);
		panel.add(lblNewLabel_1);

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
	//이미지아이콘 변경
	public ImageIcon imageSetSize(ImageIcon icon, int i, int j) { // image Size Setting
		Image ximg = icon.getImage();  //ImageIcon을 Image로 변환.
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg); 
		return xyimg;
	}
	
	public void Set_TicketNo(int ticketNo)
	{
		System.out.println(ticketNo);
		this.TicketNo = ticketNo;
	}	
	
	// 티켓취소
	public void CancleProgress() {
		//SQLDataconnect();
		
		try 
		{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn_temp = DriverManager.getConnection(
					"jdbc:oracle:thin:@//14.42.124.35:1521/XE",
					"c##wjrls", 
					"881125");
			
			String sql = " UPDATE TICKET  SET TICKET_STATUS = 'CC' "
					+ "WHERE TICKET_NO = ? ";
			PreparedStatement pstmt1 = conn_temp.prepareStatement(sql);
			pstmt1.setInt(1, this.ticketInfo2.getTicket_no());			

			int rs = pstmt1.executeUpdate();
			
			pstmt1.close();
			conn_temp.close();

			if (rs < 0 || rs > 1)
				System.out.println("err : movie ticket delete rs cnt : " + rs);
			
		}		
		  catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
	}
	/*
	 * 텍스트 날린거 표시 public void TextInit() { this.timep.setText("test null"); }
	 */

	class BackAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			mainFrame.PageChange(MainFrame.PANELNAME.MYPAGE);
		}
	}

	class CancleAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ticketFrame.setVisible(true);
		}
	}

	public void Set_TicketInfo_Cancle(TicketVo ticketInfo) {
		// TODO Auto-generated method stub
		this.ticketInfo2 = ticketInfo;
	}
}