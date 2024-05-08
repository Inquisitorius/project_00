package projectPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
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

public class JinsungPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainFrame mainFrame;
	private JFrame ticketFrame;
	/**
	 * Create the panel.
	 */

	public JinsungPanel(MainFrame mainFrame) {
		
		this.mainFrame = mainFrame;
		System.out.println("1232131");
		
		  Connection conn = null; 
		  try {
			  Class.forName("oracle.jdbc.OracleDriver");
		  
		  conn= DriverManager.getConnection(
				  "jdbc:oracle:thin:@//14.42.124.35:1521/XE",
				  "c##wjrls",
				  "881125" ); 
		  
		  String sql = "" + " SELECT * FROM MOVIE ";
		  //" SELECT movie_id, title, location, screen " + " FROM movie " +
		  //" WHERE title =? ";
		  
		  PreparedStatement pstmt = conn.prepareStatement(sql);
		  //pstmt.setString(1,"범죄도시4");
		  
		  ResultSet rs = pstmt.executeQuery();
		  while(rs.next())  {
		  Movi movi = new Movi();
		  movi.setMovie_id(rs.getString("movie_id"));
		  movi.setTitle(rs.getString("title"));
		  movi.setLocation(rs.getString("location"));
		  movi.setScreen(rs.getInt("screen"));
		  movi.setTicket(rs.getInt("ticket"));
		  
		  System.out.println("init " + movi);
		  } /*pstmt.close();*/
		  } catch(ClassNotFoundException e) 
		  { 
			  // TODO Auto-generated catch block
		  e.printStackTrace();
		  } catch (SQLException e) { 
			  e.printStackTrace();
		  }
			/*
			 * finally { if(conn !=null) { try { conn.close(); } catch (SQLException e) { }
			 * } }
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
		lblNewLabel.setBounds(500, 0, 212, 84);
		panel.add(lblNewLabel);
		
		// 고정
		JLabel lblNewLabelfix = new JLabel("상세 내역");
		lblNewLabelfix.setForeground(Color.WHITE);
		lblNewLabelfix.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 30));
		lblNewLabelfix.setBounds(533, 60, 143, 51);
		panel.add(lblNewLabelfix);
		
		JLabel lblNewLabelfix2 = new JLabel("영화명");
		lblNewLabelfix2.setForeground(Color.WHITE);
		lblNewLabelfix2.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		lblNewLabelfix2.setBounds(54, 289, 111, 41);
		panel.add(lblNewLabelfix2);
		
		JLabel lblNewLabelfix3 = new JLabel("예매 번호");
		lblNewLabelfix3.setForeground(Color.WHITE);
		lblNewLabelfix3.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		lblNewLabelfix3.setBounds(777, 146, 152, 51);
		panel.add(lblNewLabelfix3);
		
		//db 불러와서 출력
		JLabel ticketnum= new JLabel("1234-567");
		ticketnum.setForeground(Color.WHITE);
		ticketnum.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		ticketnum.setBounds(1010, 130, 196, 77);
		panel.add(ticketnum);
		Movi movi1 = new Movi(); 
		//ticketnum.setText("12345");
		 try { String sql ="" + " select * from MOVIE " + " where Ticket =? ";
		  
		  PreparedStatement pstmt1 = conn.prepareStatement(sql);
		  pstmt1.setString(1,"1001");
		  
		  ResultSet rs = pstmt1.executeQuery(); 
		  
		  while(rs.next())   { 
		  //movi1 = new Movi(); 
		  movi1.setMovie_id(rs.getString("movie_id"));
		  movi1.setLocation(rs.getString("location"));
		  movi1.setScreen(rs.getInt("screen")); 
		  movi1.setTicket(rs.getInt("ticket"));
		  movi1.setTitle(rs.getString("title"));
		  
		  System.out.println(movi1); 
		  } pstmt1.close(); 
		  } 
		 catch (SQLException
		  e) { e.printStackTrace();
		  } 
		 finally { if(conn !=null) 
		  { try { conn.close();
		  
		  }
		  catch (SQLException e) {} } }
		 
		ticketnum.setText(Integer.toString(movi1.getTicket()));
		JLabel Title = new JLabel("영화");
		Title.setForeground(Color.WHITE);
		Title.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		Title.setBounds(902, 289, 202, 41);
		panel.add(Title);
		Title .setText("범죄도시 4");
		
		JLabel Time = new JLabel("상영일시");
		Time.setForeground(Color.WHITE);
		Time.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		Time.setBounds(54, 340, 111, 41);
		panel.add(Time);
		
		JLabel movielocal= new JLabel("극장명");
		movielocal.setForeground(Color.WHITE);
		movielocal.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		movielocal.setBounds(54, 391, 111, 41);
		panel.add(movielocal);
		
		JLabel screen = new JLabel("상영관");
		screen.setForeground(Color.WHITE);
		screen.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		screen.setBounds(54, 442, 111, 41);
		panel.add(screen);
		
		JLabel person = new JLabel("관람수");
		person.setForeground(Color.WHITE);
		person.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		person.setBounds(54, 493, 111, 41);
		panel.add(person);
		
//      --------------------------------- db 입력받기  ------------------- // 
		
		JLabel timep = new JLabel("00:00");
		timep.setForeground(Color.WHITE);
		timep.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		timep.setBounds(1059, 340, 205, 41);
		panel.add(timep);
		
		JLabel localp = new JLabel("CGV의정부");
		localp.setForeground(Color.WHITE);
		localp.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		localp.setBounds(1059, 391, 179, 41);
		panel.add(localp);
		JLabel screenp = new JLabel("1관");
		screenp.setForeground(Color.WHITE);
		screenp.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		screenp.setBounds(1059, 442, 189, 41);
		panel.add(screenp);
		
		JLabel personp = new JLabel("2명");
		personp.setForeground(Color.WHITE);
		personp.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		personp.setBounds(1059, 493, 124, 41);
		panel.add(personp);
		
		JButton backButton = new JButton("뒤로가기");
		backButton.setFont(new Font("나눔고딕", Font.BOLD, 26));
		backButton.setForeground(Color.WHITE);
		backButton.setBounds(834, 544, 143, 41);
		panel.add(backButton);
		
		ticketFrame = new TicketFrame();
		JButton cancleButton = new JButton("티켓 취소하기");
		cancleButton.setFont(new Font("나눔고딕", Font.BOLD, 26));
		cancleButton.setForeground(Color.WHITE);
		cancleButton.setBounds(1010, 544, 196, 41);
		panel.add(cancleButton);
		
		this.setVisible(false);
	}
	
}