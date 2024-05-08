package projectPackage;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
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

	/**
	 * Create the panel.
	 */
	public void MypageInit()
	{
		UserInfoVo userInfo =  this.mainFrame.Get_UserInfo();
		textField_id.setText(userInfo.getUser_id());
		textField_pw.setText(userInfo.getUser_pw());
		textField_mail.setText(userInfo.getUser_email());
		textField_phone.setText(userInfo.getUser_phone());
		textField_name.setText(userInfo.getUser_name());
		
	}
	
	public MyPage_New(MainFrame mainFrame) {
		
		this.mainFrame = mainFrame;
		this.setSize(1280,800-150);
		this.setPreferredSize(new Dimension(1280,800-150));
		
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
				System.out.println("123213");				
			}
		} );
		add(UpdateBtn);
		this.setVisible(false);		
	}
	
	public void UpdateUserInfo()
	{
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@//14.42.124.35:1521/XE";
		String user = "c##wjrls";
		String pw = "881125";

		try {
			
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,user,pw);
			
			UserInfoVo userInfo =  this.mainFrame.Get_UserInfo();
			String sql = 
			"UPDATE USER_INFO  SET USER_NAME = '" + textField_name.getText() +
			"', USER_PW = '" + textField_pw.getText() +
			"', USER_EMAIL = '" + textField_mail.getText() +
			"', USER_PHONE = '" + textField_phone.getText() +
			"' " + "WHERE USER_NO = " + userInfo.getUser_no();
			
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
		
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
