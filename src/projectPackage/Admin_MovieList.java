package projectPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class Admin_MovieList extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainFrame mainFrame;
	
	private JTextField textField;
	private JTable table;
	private UserDetailInfoFrame userDetailFrame;
	private JScrollPane sPane;
	private Container contentPane;
	private JComboBox<String> comboBox;
	

	private enum MOIVE_FINDTYPE { MOVIE_NAME, MOVIE_NO, FILE_NAME, ACTIVATE };
	
	private Vector<String> columnName = null;   // String을 원소로 갖는 갖는 리스트
	private Vector<Vector<String>> data = null; // String 여러개를 갖는 백터들을 원소로 갖는 리스트

	/**
	 * Create the panel.
	 */
	public Admin_MovieList(MainFrame mainFrame) {
		
		this.mainFrame = mainFrame;
		this.setSize(1280,800-150);
		this.setPreferredSize(new Dimension(1280,800-150));
		
		this.setBackground(Color.darkGray);
		setLayout(null);		
		this.setVisible(false);
		
		JLabel lblAdminUserlist = new JLabel("Admin - MovieList");
		lblAdminUserlist.setForeground(new Color(255, 255, 255));
		lblAdminUserlist.setFont(new Font("나눔바른고딕", Font.PLAIN, 20));
		lblAdminUserlist.setBounds(12, 10, 1256, 55);
		add(lblAdminUserlist);
		
		textField = new JTextField();
		textField.setBounds(771, 119, 347, 30);
		add(textField);
		textField.setColumns(10);
		
		
		//button init
		JButton btnNewButton_4 = new JButton("Search");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id =  textField.getText();
				Get_MovieInfomation(data,id);
				tableUpdate();
				
			}
		});
		
		this.tableInit();
		
		btnNewButton_4.setBounds(1130, 118, 97, 30);
		add(btnNewButton_4);
		
	}
	
	public void tableInit()
	{
		//<Table>
		columnName = new Vector<String>();
		data = new Vector<Vector<String>>();		
		
		Get_MovieInfomation(data);
		
		columnName.add("MOVIE_NO");
		columnName.add("MOVIE_NAME");
		columnName.add("FILE_NAME");
		columnName.add("FILE_DIRECTORY");
		columnName.add("ACTIVATE");
		
		
		UserInfoTableModel aa = new UserInfoTableModel(data,columnName);
	
		
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
        			 
        			 
        			 //이거 고쳐
        			 UserInfoVo usinfo = new UserInfoVo();
        			 usinfo.setUser_no(Integer.parseInt( (String)m.getValueAt(row, 0) ));
        			 usinfo.setUser_id((String)m.getValueAt(row, 1));
        			 usinfo.setUser_pw((String)m.getValueAt(row, 2));
        			 usinfo.setUser_name((String)m.getValueAt(row, 3));
        			 usinfo.setUser_email((String)m.getValueAt(row, 4));
        			 usinfo.setUser_phone((String)m.getValueAt(row, 5));
        			 usinfo.setAuth_no(Integer.parseInt( (String)m.getValueAt(row, 6) ));
        			 
        			 
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
		
		comboBox.insertItemAt("MOVIE_NAME", MOIVE_FINDTYPE.MOVIE_NAME.ordinal());
		comboBox.insertItemAt("MOVIE_NO", MOIVE_FINDTYPE.MOVIE_NO.ordinal());
		comboBox.insertItemAt("FILE_NAME", MOIVE_FINDTYPE.FILE_NAME.ordinal());		
		comboBox.insertItemAt("ACTIVATE", MOIVE_FINDTYPE.ACTIVATE.ordinal());		
		//comboBox.insertItemAt("AUTH_NO", 5);
		
	
		
		comboBox.setBounds(657, 119, 105, 30);
		comboBox.setSelectedIndex(0);
		
		add(comboBox);
		
	}
	
	public String Get_FindUserQuery(int index, String input)
	{
		String sql = "";
		
		if(index == MOIVE_FINDTYPE.MOVIE_NAME.ordinal())
		{
			sql = "SELECT MOVIE_NO ,MOVIE_NAME ,MOVIE_COMMENT , FILE_NAME, FILE_DIRECTORY, ACTIVATE FROM MOVIE"
					+ " WHERE MOVIE_NAME LIKE '%"+ input + "%' ORDER BY MOVIE_NO";
		}
		else if(index == MOIVE_FINDTYPE.MOVIE_NO.ordinal())
		{
			sql = "SELECT MOVIE_NO ,MOVIE_NAME ,MOVIE_COMMENT , FILE_NAME, FILE_DIRECTORY, ACTIVATE FROM MOVIE"
					+ " WHERE MOVIE_NO LIKE '%"+ input + "%' ORDER BY MOVIE_NO";
		}
		else if(index == MOIVE_FINDTYPE.FILE_NAME.ordinal())
		{
			sql = "SELECT MOVIE_NO ,MOVIE_NAME ,MOVIE_COMMENT , FILE_NAME, FILE_DIRECTORY, ACTIVATE FROM MOVIE"
					+ " WHERE FILE_NAME LIKE '%"+ input + "%' ORDER BY MOVIE_NO";
		}	
		else if(index == MOIVE_FINDTYPE.ACTIVATE.ordinal())
		{
			sql = "SELECT MOVIE_NO ,MOVIE_NAME ,MOVIE_COMMENT , FILE_NAME, FILE_DIRECTORY, ACTIVATE FROM MOVIE"
					+ " WHERE ACTIVATE LIKE '%"+ input + "%' ORDER BY MOVIE_NO";
		}	
		
		return sql;
	}
	
	public void Get_MovieInfomation(Vector<Vector<String>> data)
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
			
			String sql = "SELECT MOVIE_NO ,MOVIE_NAME ,MOVIE_COMMENT , "
					+ "FILE_NAME, FILE_DIRECTORY, ACTIVATE FROM MOVIE";
			
			
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{				
				MovieVo movieinfo = 
						new MovieVo(	
						rs.getInt("MOVIE_NO"),
						rs.getString("MOVIE_NAME"), 					
						rs.getString("MOVIE_COMMENT"),
						rs.getString("FILE_NAME"),
						rs.getString("FILE_DIRECTORY"),
						rs.getString("ACTIVATE")				
						);
				
				Vector<String> info = new Vector<String>();
				info.add(Integer.toString(movieinfo.getMovie_no()));
				info.add(movieinfo.getMovie_name());
				info.add(movieinfo.getMovie_comment());
				info.add(movieinfo.getFile_name());				
				info.add(movieinfo.getActivate());				
				
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
	
	public void Get_MovieInfomation(Vector<Vector<String>> data,String input)
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
				MovieVo movieinfo = 
						new MovieVo(	
						rs.getInt("MOVIE_NO"),
						rs.getString("MOVIE_NAME"), 					
						rs.getString("MOVIE_COMMENT"),
						rs.getString("FILE_NAME"),
						rs.getString("FILE_DIRECTORY"),
						rs.getString("ACTIVATE")				
						);				

				Vector<String> info = new Vector<String>();
				info.add(Integer.toString(movieinfo.getMovie_no()));
				info.add(movieinfo.getMovie_name());
				info.add(movieinfo.getMovie_comment());
				info.add(movieinfo.getFile_name());				
				info.add(movieinfo.getActivate());	
				
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
	
	public void tableUpdate()
	{
		UserInfoTableModel temp = new UserInfoTableModel(data,columnName);
		table.setModel(temp);
	}
	
	public void Refresh_Table()
	{
		String input =  textField.getText();
		
		if(!input.isEmpty())
			Get_MovieInfomation(data,input);
		else
			Get_MovieInfomation(data);
		
		tableUpdate();
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

}
