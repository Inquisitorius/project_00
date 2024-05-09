package projectPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import projectPackage.Admin_UserList.UserInfoTableModel;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class MyPage_New extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainFrame mainFrame;
	private JTextField textField_id;
	private JTextField textField_pw;
	private JTextField textField_name;
	private JTextField textField_mail;
	private JTextField textField_phone;

	private UserDetailInfoFrame userDetailFrame;
	private JTable table;
	private JScrollPane sPane;

	private Vector<String> columnName = null;
	private Vector<Vector<String>> data = null;

	/**
	 * Create the panel.
	 */
	public void MypageInit() {
		UserInfoVo userInfo = this.mainFrame.Get_UserInfo();
		textField_id.setText(userInfo.getUser_id());
		textField_pw.setText(userInfo.getUser_pw());
		textField_mail.setText(userInfo.getUser_email());
		textField_phone.setText(userInfo.getUser_phone());
		textField_name.setText(userInfo.getUser_name());
		
		this.TableInit();
	}

	public MyPage_New(MainFrame mainFrame) {

		this.mainFrame = mainFrame;
		this.setSize(1280, 800 - 150);
		this.setPreferredSize(new Dimension(1280, 800 - 150));

		this.setBackground(new Color(0, 0, 0));
		setLayout(null);

		JLabel mypageLabel = new JLabel("MyPage");
		mypageLabel.setBackground(new Color(255, 255, 255));
		mypageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mypageLabel.setForeground(new Color(238, 46, 36));
		mypageLabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 48));
		mypageLabel.setBounds(502, 36, 240, 56);
		add(mypageLabel);

		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 14));
		lblId.setBounds(121, 135, 100, 56);
		add(lblId);

		textField_id = new JTextField();
		textField_id.setBounds(232, 135, 316, 56);
		textField_id.setEditable(false);
		add(textField_id);
		textField_id.setColumns(10);

		JLabel lblPw = new JLabel("PW");
		lblPw.setHorizontalAlignment(SwingConstants.CENTER);
		lblPw.setForeground(Color.WHITE);
		lblPw.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 14));
		lblPw.setBounds(121, 201, 100, 56);
		add(lblPw);

		textField_pw = new JTextField();
		textField_pw.setColumns(10);
		textField_pw.setBounds(232, 201, 316, 56);
		add(textField_pw);

		JLabel lblName = new JLabel("NAME");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 14));
		lblName.setBounds(121, 267, 100, 56);
		add(lblName);

		textField_name = new JTextField();
		textField_name.setColumns(10);
		textField_name.setBounds(232, 267, 316, 56);
		add(textField_name);

		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 14));
		lblEmail.setBounds(121, 333, 100, 56);
		add(lblEmail);

		textField_mail = new JTextField();
		textField_mail.setColumns(10);
		textField_mail.setBounds(232, 333, 316, 56);
		add(textField_mail);

		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 14));
		lblPhone.setBounds(121, 399, 100, 56);
		add(lblPhone);

		textField_phone = new JTextField();
		textField_phone.setColumns(10);
		textField_phone.setBounds(232, 399, 316, 56);
		add(textField_phone);

		JButton UpdateBtn = new JButton("");
		UpdateBtn.setIcon(new ImageIcon(MyPage_New.class.getResource("/image/button/ok.png")));
		UpdateBtn.setBounds(438, 471, 110, 42);

		UpdateBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UpdateUserInfo();
			}
		});
		add(UpdateBtn);
		this.setVisible(false);

		//TableInit();
	}

	public void TableInit() {
		columnName = new Vector<String>();
		data = new Vector<Vector<String>>();

		//columnName.add("TICKET_NO");
		columnName.add("MOVIE_NAME");
		columnName.add("MOVIEHOUSE_NAME");
		columnName.add("SEAT_INFO");
		columnName.add("SCHEDULE_TIME");
		columnName.add("TICKET_STATUS");

		Get_TicketInfo();
		
		UserInfoTableModel InfoModel = new UserInfoTableModel(data, columnName);

		table = new JTable(InfoModel);
		table.getTableHeader().setReorderingAllowed(false); // 컬럼들 이동 불가
		table.getTableHeader().setResizingAllowed(false); // 컬럼 크기 조절 불가

		table.addMouseListener(new MouseAdapter() {
		});

		sPane = new JScrollPane(table);
		sPane.setBounds(603, 135, 597, 378);
		table.setBounds(41, 154, 1196, 453);

		this.add(sPane, BorderLayout.CENTER);

		// 데이터 받아오기
		// 테이블 업데이트
		// 더블클릭 이벤트
	}

	public void Get_TicketInfo() {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@//14.42.124.35:1521/XE";
		String user = "c##wjrls";
		String pw = "881125";
		
		try 
		
		{
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, pw);
			
			String sql= "SELECT A.TICKET_NO, A.SEAT_INFO, A.SEAT_NO, A.TICKET_STATUS, A.USER_NO, ui.USER_NAME  ,m.SCHEDULE_NO,t2.THEATER_NAME , m3.MOVIEHOUSE_NAME ,m.SCHEDULE_TIME, m.SCHEDULE_ENDTIME, m2.MOVIE_NAME "
					+ "from "
					+ "("
					+ "(((((SELECT t.TICKET_NO, t.TICKET_STATUS ,t.SEAT_NO, s.SEAT_INFO, T.SCHEDULE_NO, T.USER_NO  FROM TICKET t JOIN SEAT s ON t.SEAT_NO = s.SEAT_NO) A "
					+ "JOIN MOVIESCHEDULE m ON A.SCHEDULE_NO = m.SCHEDULE_NO ) "
					+ "JOIN MOVIE m2 ON m.MOVIE_NO = m2.MOVIE_NO) "
					+ "JOIN MOVIEHOUSE m3 ON m3.MOVIEHOUSE_NO = m.MOVIEHOUSE_NO) "
					+ "JOIN THEATER t2 ON t2.MOVIEHOUSE_NO = m3.MOVIEHOUSE_NO) "
					+ "JOIN USER_INFO ui ON ui.USER_NO = A.USER_NO) "
					+ "JOIN LOCAL ON LOCAL.LOCAL_NO  = m3.LOCAL_NO "
					+ "WHERE a.user_no = " + this.mainFrame.Get_UserInfo().getUser_no();
			
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				TicketVo ticket = new TicketVo(
						rs.getInt("TICKET_NO"), 
						rs.getInt("SCHEDULE_NO"),
						rs.getInt("SEAT_NO"),
						rs.getInt("USER_NO"),
						rs.getString("TICKET_STATUS")
						);
				
				ticket.Set_NameInfo(rs.getString("MOVIE_NAME"), 
						rs.getString("MOVIEHOUSE_NAME"), 
						rs.getString("THEATER_NAME"), 
						rs.getString("SEAT_INFO"), 
						rs.getString("SCHEDULE_TIME"));
				
				Vector<String> info = new Vector<String>();
				
				info.add(ticket.getMovie_Name()); 
				info.add(ticket.getMovieHouse_Name());
				info.add(ticket.getSeat_Info()); 
				info.add(ticket.Get_SimpleSchedule_time());
				info.add(ticket.getTicket_status());
				
				data.add(info);
			}
			
			pstmt.close();
			conn.close();	
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

	public void UpdateUserInfo() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@//14.42.124.35:1521/XE";
		String user = "c##wjrls";
		String pw = "881125";

		try {

			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, pw);

			UserInfoVo userInfo = this.mainFrame.Get_UserInfo();
			String sql = "UPDATE USER_INFO  SET USER_NAME = '" + textField_name.getText() + "', USER_PW = '"
					+ textField_pw.getText() + "', USER_EMAIL = '" + textField_mail.getText() + "', USER_PHONE = '"
					+ textField_phone.getText() + "' " + "WHERE USER_NO = " + userInfo.getUser_no();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			int rs = pstmt.executeUpdate();

			if (rs == 1) {
				JOptionPane.showMessageDialog(null, "변경되었습니다.");
			} else {
				JOptionPane.showMessageDialog(null, "Err : Update UserInfo.");
			}
			pstmt.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String ChangeDateFormat(String dateStr) 
	{
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

	class UserInfoTableModel extends DefaultTableModel {
		public UserInfoTableModel(Vector<? extends Vector> data, Vector<?> columnNames) {
			setDataVector(data, columnNames);
		}

		public boolean isCellEditable(int rowIndex, int mColIndex) {
			return false;
		}
	}
}
