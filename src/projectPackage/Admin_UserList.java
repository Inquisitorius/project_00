package projectPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class Admin_UserList extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainFrame mainFrame;
	private JTextField textField;
	private JTable table;
	private UserDetailInfoFrame userDetailFrame;
	private JScrollPane sPane;
	private Container contentPane;
	private JComboBox<String> comboBox;
	
	private enum FINDTYPE {USER_ID, USER_NAME, AUTH_NO, USER_NO};
	
	
	Vector<String> columnName = null;   // String을 원소로 갖는 갖는 리스트
	Vector<Vector<String>> data = null; // String 여러개를 갖는 백터들을 원소로 갖는 리스트

	/**
	 * Create the panel.
	 */
	public Admin_UserList(MainFrame mainFrame) {
		
		this.mainFrame = mainFrame;
		this.userDetailFrame = new UserDetailInfoFrame();
		this.userDetailFrame.setParentPage(this);
		
		this.setSize(1280,800-150);
		this.setPreferredSize(new Dimension(1280,800-150));
		this.setBackground(Color.darkGray);
		setLayout(null);
		
		this.setVisible(false);
		
		JLabel lblAdminUserlist = new JLabel("Admin - UserList");
		lblAdminUserlist.setForeground(new Color(255, 255, 255));
		lblAdminUserlist.setFont(new Font("나눔바른고딕", Font.PLAIN, 20));
		lblAdminUserlist.setBounds(12, 10, 1256, 55);
		add(lblAdminUserlist);
		/*---------------------------------------------------------*/
		
		textField = new JTextField();
		textField.setBounds(771, 119, 347, 30);
		
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Search");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id =  textField.getText();
				Get_UserInfomation(data,id);
				tableUpdate();
				
			}
		});
		btnNewButton_4.setBounds(1130, 118, 97, 30);
		add(btnNewButton_4);
		
		tableInit();		
	}
	
	class UserInfoTableModel extends DefaultTableModel
	{
		public UserInfoTableModel(Vector<? extends Vector> data, Vector<?> columnNames) {
			setDataVector(data, columnNames);
		}
		
		 public boolean isCellEditable(int rowIndex, int mColIndex) {
             return false;
         }		
	}	
	
	public void tableUpdate()
	{
		UserInfoTableModel temp = new UserInfoTableModel(data,columnName);
		table.setModel(temp);		
	}
	
	public void tableInit()
	{
		//<Table>
		columnName = new Vector<String>();
		data = new Vector<Vector<String>>();		
		
		Get_UserInfomation(data);
		
		/*columnName.add("USER_NO");
		columnName.add("USER_ID");
		columnName.add("USER_PW");
		columnName.add("USER_NAME");
		columnName.add("USER_EMAIL");
		columnName.add("USER_PHONE");
		columnName.add("AUTH_NO");*/
		
		columnName.add("유저번호");
		columnName.add("ID");
		columnName.add("PW");
		columnName.add("이름");
		columnName.add("이메일");
		columnName.add("전화번호");
		columnName.add("권한정보");
		
		UserInfoTableModel aa = new UserInfoTableModel(data,columnName);
		
		/*DefaultTableModel mod = new DefaultTableModel(data, columnName) 
		{		
	        public boolean isCellEditable(int rowIndex, int mColIndex) {
	                return false;
	            }
	    };*/
		
		table = new JTable(aa);
		table.getTableHeader().setReorderingAllowed(false); // 컬럼들 이동 불가
        table.getTableHeader().setResizingAllowed(false); // 컬럼 크기 조절 불가
        
        
        table.addMouseListener(new MouseAdapter() 
        {
        	 @Override public void mouseClicked(MouseEvent e) {
        		 JTable t = (JTable)e.getSource();
        		 
        		 if(e.getClickCount()==2)
        		 {
        			 TableModel m = t.getModel();
        			 Point pt = e.getPoint();
        			 int i = t.rowAtPoint(pt);
        			 
        			 if(i < 0)
        				 return;
        			 
        			 int row = t.convertRowIndexToModel(i);
        			 String s = String.format("%s (%s)", m.getValueAt(row, 0), m.getValueAt(row, 1));
        			 System.out.println(s);
        			 
        			 UserInfoVo usinfo = new UserInfoVo();
        			 usinfo.setUser_no(Integer.parseInt( (String)m.getValueAt(row, 0) ));
        			 usinfo.setUser_id((String)m.getValueAt(row, 1));
        			 usinfo.setUser_pw((String)m.getValueAt(row, 2));
        			 usinfo.setUser_name((String)m.getValueAt(row, 3));
        			 usinfo.setUser_email((String)m.getValueAt(row, 4));
        			 usinfo.setUser_phone((String)m.getValueAt(row, 5));
        			 
        			 int auth = ConvertAuthNo_forDB((String)m.getValueAt(row, 6));
        			 usinfo.setAuth_no(auth);
        			 
        			 //usinfo.setAuth_no(Integer.parseInt( (String)m.getValueAt(row, 6) ));
        			 
        			 
        			 userDetailFrame.FrameInit(usinfo);  
        			 userDetailFrame.Popup();
        			 //userDetailFrame.setVisible(true);
        			 //JOptionPane.showMessageDialog(t, s, "title", JOptionPane.INFORMATION_MESSAGE);
        		 }
        	 }        	
		});     
		
		
		sPane = new JScrollPane(table);
		sPane.setBounds(28, 159, 1199, 440);
		
		//sPane.revalidate();
		
		table.setBounds(41, 154, 1196, 453);
		
		contentPane = this;
		contentPane.add(sPane, BorderLayout.CENTER);
		
		comboBox = new JComboBox<String>();
		
		comboBox.insertItemAt("ID", FINDTYPE.USER_ID.ordinal());
		comboBox.insertItemAt("이름", FINDTYPE.USER_NAME.ordinal());
		comboBox.insertItemAt("유저권한", FINDTYPE.AUTH_NO.ordinal());		
		comboBox.insertItemAt("유저번호", FINDTYPE.USER_NO.ordinal());		
		//comboBox.insertItemAt("AUTH_NO", 5);
		
		comboBox.setBounds(657, 119, 105, 30);
		comboBox.setSelectedIndex(0);
		
		add(comboBox);
		
	}
	
	public void Get_UserInfomation(Vector<Vector<String>> data,String input)
	{
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@//14.42.124.35:1521/XE";
		String user = "c##wjrls";
		String pw = "881125";
		
		data.clear();
		
		try {
			
			Class.forName(driver);
			System.out.println("jdbc driver lading success.");
			
			Connection conn = DriverManager.getConnection(url,user,pw);
			System.out.println("oralce connection success.");
			
			String sql = "";
			
			int selectedIndex = comboBox.getSelectedIndex();
			sql = Get_FindUserQuery(selectedIndex, input);
			
			
			
			PreparedStatement pstmt = conn.prepareStatement(sql);			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{				
				UserInfoVo usinfo = 
						new UserInfoVo(	
						rs.getInt("USER_NO"),
						rs.getString("USER_ID"), 
						rs.getString("USER_PW"),
						rs.getString("USER_NAME"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_PHONE"),
						rs.getInt("AUTH_NO")				
						);
				
				Vector<String> info = new Vector<String>();
				info.add(Integer.toString(usinfo.getUser_no()));
				info.add(usinfo.getUser_id());
				info.add(usinfo.getUser_pw());
				info.add(usinfo.getUser_name());
				info.add(usinfo.getUser_email());
				info.add(usinfo.getUser_phone());
				
				info.add(this.ConvertAuthNo_forClient(usinfo.getAuth_no()));
				
				//info.add(Integer.toString(usinfo.getAuth_no()));
				
				data.add(info);
			}
			
			pstmt.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String Get_FindUserQuery(int index, String input)
	{
		String sql = "";
		
		if(index == FINDTYPE.USER_ID.ordinal())
		{
			sql = "select USER_NO, USER_ID, USER_PW, USER_NAME, USER_EMAIL, USER_PHONE, AUTH_NO from USER_INFO"
					+ " WHERE USER_ID LIKE '%"+ input + "%' ORDER BY USER_NO";
		}
		else if(index == FINDTYPE.USER_NAME.ordinal())
		{
			sql = "select USER_NO, USER_ID, USER_PW, USER_NAME, USER_EMAIL, USER_PHONE, AUTH_NO from USER_INFO"
					+ " WHERE USER_NAME LIKE '%"+ input + "%' ORDER BY USER_NO";
		}
		else if(index == FINDTYPE.AUTH_NO.ordinal())
		{
			int inputConvert = this.ConvertAuthNo_forDB(input);
			
			sql = "select USER_NO, USER_ID, USER_PW, USER_NAME, USER_EMAIL, USER_PHONE, AUTH_NO from USER_INFO"
					+ " WHERE AUTH_NO LIKE '%"+ inputConvert + "%' ORDER BY USER_NO";
		}
		else if(index == FINDTYPE.USER_NO.ordinal())
		{
			sql = "select USER_NO, USER_ID, USER_PW, USER_NAME, USER_EMAIL, USER_PHONE, AUTH_NO from USER_INFO"
					+ " WHERE USER_NO = "+ input + " ORDER BY USER_NO";
		}		
		
		return sql;
	}
	
	public String ConvertAuthNo_forClient(int status)
	{
		String result = "";
		
		System.out.println(status);
		
		switch (status) {
		case 1:
			result = "USER AUTH";
			break;
		case 2:
			result = "MASTER AUTH";
			break;
		case 3:
			result = "ADMIN VIEWER";
			break;
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + status);
		}
		
			
		return result;
	}
	
	public int ConvertAuthNo_forDB(String status)
	{
		int result = -1;
		
		String auth_01 = "USER AUTH";
		String auth_02 = "MASTER AUTH";
		String auth_03 = "ADMIN VIEWER";

		if (auth_01.contains(status)) 
		{
			result = 1;
		}
		else if(auth_02.contains(status)) 
		{
			result = 2;
		}
		else if(auth_03.contains(status)) 
		{
			result = 3;
		}		
			
		return result;
	}
	
	public void Refresh_Table()
	{
		String input =  textField.getText();
		
		if(!input.isEmpty())		
			Get_UserInfomation(data,input);
		else
			Get_UserInfomation(data);
		
		tableUpdate();
	}
	
	public void Get_UserInfomation(Vector<Vector<String>> data)
	{
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@//14.42.124.35:1521/XE";
		String user = "c##wjrls";
		String pw = "881125";
		
		data.clear();
		
		try {
			
			Class.forName(driver);
			System.out.println("jdbc driver lading success.");
			
			Connection conn = DriverManager.getConnection(url,user,pw);
			System.out.println("oralce connection success.");
			
			String sql = "select USER_NO, USER_ID, USER_PW, USER_NAME, USER_EMAIL, USER_PHONE, AUTH_NO from USER_INFO ORDER BY USER_NO";			
			
			
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{				
				UserInfoVo usinfo = 
						new UserInfoVo(	
						rs.getInt("USER_NO"),
						rs.getString("USER_ID"), 
						rs.getString("USER_PW"),
						rs.getString("USER_NAME"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_PHONE"),
						rs.getInt("AUTH_NO")				
						);
				
				Vector<String> info = new Vector<String>();
				info.add(Integer.toString(usinfo.getUser_no()));
				info.add(usinfo.getUser_id());
				info.add(usinfo.getUser_pw());
				info.add(usinfo.getUser_name());
				info.add(usinfo.getUser_email());
				info.add(usinfo.getUser_phone());
				
				info.add(this.ConvertAuthNo_forClient(usinfo.getAuth_no()));
				//info.add(Integer.toString(usinfo.getAuth_no()));
				
				data.add(info);
			}
			
			pstmt.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
