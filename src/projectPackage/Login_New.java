package projectPackage;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;

import projectPackage.MainFrame.PANELNAME;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

public class Login_New extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainFrame mainFrame;
	private JTextField textField_Id;
	private JPasswordField textField_Pw;
	private JLabel lblId;
	private JLabel lblpw;
	private JLabel lblNewLabel;
	private JButton joinBtn;
	private JLabel label_alert;
	private JButton LoginBtn;

	/**
	 * Create the panel.
	 */
	public Login_New(MainFrame mainFrame) {
		
		this.mainFrame = mainFrame;
		
		setLayout(null);
		this.setSize(1280, 800 - 150);
		this.setPreferredSize(new Dimension(1280, 800 - 150));
		this.setBackground(new Color(0, 0, 0));		
		
		Init_Elements();
		
		this.setVisible(false);
		
	}
	
	public void PageOpen_Init()
	{
		textField_Id.setText("");
		textField_Pw.setText("");
		
	}
	
	public void Init_Elements()
	{
		textField_Id = new JTextField();
		textField_Id.setBorder(new EmptyBorder(0, 10, 0, 0));
		textField_Id.setBounds(418, 195, 497, 40);
		add(textField_Id);
		textField_Id.setColumns(10);
		
		textField_Pw = new JPasswordField();
		textField_Pw.setBorder(new EmptyBorder(0, 10, 0, 0));
		textField_Pw.setColumns(10);
		textField_Pw.setBounds(418, 245, 497, 40);
		add(textField_Pw);		
		
		
		LoginBtn = new JButton("");
		LoginBtn.setBorderPainted(false);
		LoginBtn.setIcon(new ImageIcon(Login_New.class.getResource("/image/button/login.png")));
		LoginBtn.setBounds(805, 305, 110, 42);
		LoginBtn.addMouseListener(new MouseAdapter() {
			@Override public void mouseClicked(MouseEvent e)
			{
				if(Try_Login())
				{
					//mainFrame.PageChange(PANELNAME.MAIN);
					mainFrame.Login_Progress();
					mainFrame.PageChange(PANELNAME.MAIN);
				}
			}
		});
		
		textField_Pw.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER)						
				{
					if(Try_Login())
					{
						//mainFrame.PageChange(PANELNAME.MAIN);
						mainFrame.Login_Progress();
						mainFrame.PageChange(PANELNAME.MAIN);
					}
				}
			}
		} );
		add(LoginBtn);
		
		lblId = new JLabel("아이디");
		lblId.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 14));
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setBounds(351, 195, 55, 40);
		add(lblId);
		
		lblpw = new JLabel("비밀번호");
		lblpw.setForeground(Color.WHITE);
		lblpw.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 14));
		lblpw.setBounds(351, 245, 61, 40);
		add(lblpw);
		
		lblNewLabel = new JLabel("아직 아이디가 없으신가요?");
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 12));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(419, 322, 148, 35);
		add(lblNewLabel);
		
		joinBtn = new JButton("");
		joinBtn.setBorderPainted(false);
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		joinBtn.setIcon(new ImageIcon(Login_New.class.getResource("/image/button/join_s.png")));
		joinBtn.setBounds(559, 315, 32, 32);
		add(joinBtn);
		joinBtn.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                mainFrame.PageChange(MainFrame.PANELNAME.JOIN_AGREE);
	            }
	        });
		
		label_alert = new JLabel("");
		label_alert.setForeground(Color.WHITE);
		label_alert.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 12));
		label_alert.setBounds(418, 163, 497, 35);
		add(label_alert);
		
	}
	
	public UserInfoVo Get_UserInfo_fromDB(Connection conn)
	{		
		return null;
	}
	
	public Boolean Try_Login()
	{
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@//14.42.124.35:1521/XE";
		String user = "c##wjrls";
		String pw = "881125";
		
		String pageId = textField_Id.getText();
		String pagePw = new String(textField_Pw.getPassword());		
		
		boolean result = false;
		
		try {
			
			Class.forName(driver);
			System.out.println("jdbc driver lading success.");
			Connection conn = DriverManager.getConnection(url,user,pw);
			System.out.println("oralce connection success.");
			
			String sql = "SELECT count(*) AS count  FROM USER_INFO ui "
					+ "WHERE USER_ID = '" + pageId + "' AND USER_PW = '"+ pagePw +"'";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			ResultSet rs =  pstmt.executeQuery();
			
			rs.next();			
			
			if(rs.getInt("count") == 1)
			{
				result =  true;
				
				String sql_forUserInfo = "SELECT USER_NO, USER_ID ,USER_PW ,USER_NAME ,USER_EMAIL ,USER_PHONE, AUTH_NO  FROM USER_INFO ui "
						+ "WHERE USER_ID = '" + pageId + "' AND USER_PW = '"+ pagePw +"'";
				
				PreparedStatement pstmt_userInfo = conn.prepareStatement(sql_forUserInfo);	
				ResultSet rs_userInfo =  pstmt_userInfo.executeQuery();
				
				rs_userInfo.next();
				
				//int user_no, String user_id, String user_pw, String user_name, String user_email, String user_phone,
				//int auth_no) {
				UserInfoVo userInfo = new UserInfoVo(rs_userInfo.getInt("USER_NO"), 
						rs_userInfo.getString("USER_ID"), rs_userInfo.getString("USER_PW"), rs_userInfo.getString("USER_NAME"), 
						rs_userInfo.getString("USER_EMAIL"), rs_userInfo.getString("USER_PHONE"), rs_userInfo.getInt("AUTH_NO"));
				
				this.mainFrame.Set_UserInfo(userInfo);
				
				pstmt.close();
				conn.close();
			}				
			else
			{
				label_alert.setText("아이디/비밀번호가 일치하지 않습니다.");
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
