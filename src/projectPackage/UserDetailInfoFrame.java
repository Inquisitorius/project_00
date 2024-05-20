package projectPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JTable;

public class UserDetailInfoFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private UserDetailInfoFrame myFrame;
	private Admin_UserList parentPage;
	
	private UserInfoVo userinfo;
	
	
	public Admin_UserList getParentPage() {
		return parentPage;
	}

	public void setParentPage(Admin_UserList parentPage) {
		this.parentPage = parentPage;
	}

	private JPanel contentPane;
	JLabel lblID;
	private JTextField idText;
	private JLabel lblPw;
	private JTextField pwText;
	private JLabel lblName;
	private JTextField nameText;
	private JLabel lblEmail;
	private JTextField emailText;
	private JLabel lblPhone;
	private JTextField phoneText;
	
	private JScrollPane sPane;	
	
	private Vector<String> columnName = null;   // String을 원소로 갖는 갖는 리스트
	private Vector<Vector<String>> data = null; // String 여러개를 갖는 백터들을 원소로 갖는 리스트
	private JTable table;
	
	private Connection connection;

	/**
	 * Create the frame.
	 */
	public UserDetailInfoFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrame = this;
		setBounds(1300, 100, 450, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		columnName = new Vector<String>();
		data = new Vector<Vector<String>>();

		setContentPane(contentPane);
		
		this.FrameSetting();		
		
		JButton updateBtn = new JButton("Update");
		updateBtn.setBounds(105, 513, 97, 23);
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myFrame.Update_UserInfo();
			}
		});
		contentPane.add(updateBtn);
		
		JButton DeleteUserBtn = new JButton("DeleteUser");
		DeleteUserBtn.setBounds(216, 513, 97, 23);
		DeleteUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myFrame.Delete_UserInfo();
				myFrame.dispose();
			}
		});
		contentPane.add(DeleteUserBtn);
		
		JButton CancelBtn = new JButton("Cancel");
		CancelBtn.setBounds(325, 513, 97, 23);
		CancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myFrame.dispose();
			}
		});
		contentPane.add(CancelBtn);
		
		TableInit();
		
		JLabel lblAuth = new JLabel("Auth");
		lblAuth.setBounds(12, 230, 130, 34);
		lblAuth.setHorizontalAlignment(SwingConstants.LEFT);
		lblAuth.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		contentPane.add(lblAuth);
		
		
		this.setVisible(false);
	}
	
	public void Popup()
	{
		this.setVisible(true);
		
		//현재 내가 위치한 권한으로 선택 되어야한다.
		
		//System.out.println("AUTH_NO : " + userinfo.getAuth_no());
		table.setRowSelectionInterval(userinfo.getAuth_no()-1, userinfo.getAuth_no()-1);
		
		//System.out.println("getSelectedRow : " + table.getSelectedRow());
		//System.out.println( table.getValueAt(table.getSelectedRow(), 0));
	}
	
	public void TableInit()
	{
		columnName.add("AUTH_NO");
		columnName.add("AUTH_INFO");
		
		Get_DBauthcolumnInfo();
		
		table = new JTable(data,columnName);
		table.setBounds(12, 264, 410, 185);
		
		sPane = new JScrollPane(table);
		sPane.setBounds(12, 264, 410, 185);
		
		contentPane.setVisible(true);
		contentPane.add(sPane, BorderLayout.CENTER);
	}
	
	public void FrameSetting()
	{
		contentPane.setLayout(null);
		lblID = new JLabel("ID");
		lblID.setBounds(12, 10, 130, 34);
		lblID.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblID.setHorizontalAlignment(JLabel.LEFT);
		contentPane.add(lblID);
		
		idText = new JTextField();
		idText.setBounds(154, 10, 268, 34);
		contentPane.add(idText);
		
		idText.setEditable(false);
		
		idText.setColumns(10);
		
		lblPw = new JLabel("PW");
		lblPw.setBounds(12, 54, 130, 34);
		lblPw.setHorizontalAlignment(SwingConstants.LEFT);
		lblPw.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		contentPane.add(lblPw);
		
		pwText = new JTextField();
		pwText.setBounds(154, 54, 268, 34);
		pwText.setColumns(10);
		contentPane.add(pwText);
		
		lblName = new JLabel("NAME");
		lblName.setBounds(12, 98, 130, 34);
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		contentPane.add(lblName);
		
		nameText = new JTextField();
		nameText.setBounds(154, 98, 268, 34);
		nameText.setColumns(10);
		contentPane.add(nameText);
		
		lblEmail = new JLabel("EMAIL");
		lblEmail.setBounds(12, 142, 130, 34);
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		contentPane.add(lblEmail);
		
		emailText = new JTextField();
		emailText.setBounds(154, 142, 268, 34);
		emailText.setColumns(10);
		contentPane.add(emailText);
		
		lblPhone = new JLabel("PHONE");
		lblPhone.setBounds(12, 186, 130, 34);
		lblPhone.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhone.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		contentPane.add(lblPhone);
		
		phoneText = new JTextField();
		phoneText.setBounds(154, 186, 268, 34);
		phoneText.setColumns(10);
		contentPane.add(phoneText);
	}
	
	public void Get_DBauthcolumnInfo()
	{
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@//14.42.124.35:1521/XE";
		String user = "c##wjrls";
		String pw = "881125";
		
		try 
		{
			Class.forName(driver);		
			//System.out.println("jdbc driver lading success.");
			
			connection = DriverManager.getConnection(url,user,pw);
			//System.out.println("oralce connection success.");
			
			String sql = "SELECT AUTH_NO, AUTH_INFO  FROM AUTHORITY";
			
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();					
			while(rs.next())
			{					
				Vector<String> vec = new Vector<String>();	
				AuthVo info = new AuthVo();
				info.setAUTH_NO(rs.getInt("AUTH_NO"));
				
				info.setAUTH_INFO(rs.getString("AUTH_INFO"));		
				vec.add(Integer.toString(rs.getInt("AUTH_NO")));
				vec.add(rs.getString("AUTH_INFO"));
				
				data.add(vec);
			}
			
			pstmt.close();
			connection.close();			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Update_UserInfo()
	{
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@//14.42.124.35:1521/XE";
		String user = "c##wjrls";
		String pw = "881125";
		
		
		String auth_no = (String)table.getValueAt(table.getSelectedRow(),0);
		
		try 
		{
			Class.forName(driver);
			
			System.out.println("jdbc driver lading success.");
			
			Connection conn = DriverManager.getConnection(url,user,pw);
			System.out.println("oralce connection success.");
			
			String id = idText.getText();
			String pwstring = pwText.getText();
			String name = nameText.getText();
			String ph = phoneText.getText();
			String mail = emailText.getText();
			
			
			
			String sql = "UPDATE USER_INFO SET "
					+"USER_ID = '" + id +"', "
					+"USER_PW = '" + pwstring +"', "
					+"USER_NAME = '" + name +"', "
					+"USER_EMAIL = '" + mail +"', "
					+"USER_PHONE = '"+ ph +"', "
					+"AUTH_NO = '" + auth_no +"' "
					+"WHERE USER_NO = "+userinfo.getUser_no();			
			
			PreparedStatement pstmt = conn.prepareStatement(sql);			
			int rs = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//업데이트 이후 모체 페이지 테이블 갱신
		parentPage.Refresh_Table();
	}
	
	public void Delete_UserInfo()
	{
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@//14.42.124.35:1521/XE";
		String user = "c##wjrls";
		String pw = "881125";
		
		try 
		{
			Class.forName(driver);
			
			System.out.println("jdbc driver lading success.");
			
			Connection conn = DriverManager.getConnection(url,user,pw);
			System.out.println("oralce connection success.");
			
			
			String sql = "DELETE FROM USER_INFO "
					+ "WHERE USER_NO = " + userinfo.getUser_no();
			
			//System.out.println(sql);
			PreparedStatement pstmt = conn.prepareStatement(sql);			
			int rs = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//업데이트 이후 모체 페이지 테이블 갱신
		parentPage.Refresh_Table();
	}
	
	public void FrameInit(UserInfoVo userInfo)
	{
		userinfo = userInfo;
		idText.setText(userInfo.getUser_id());
		pwText.setText(userInfo.getUser_pw());
		nameText.setText(userInfo.getUser_name());
		emailText.setText(userInfo.getUser_email());
		phoneText.setText(userInfo.getUser_phone());
	}
}
