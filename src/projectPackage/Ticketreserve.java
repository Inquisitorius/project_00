package projectPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.SwingConstants;

public class Ticketreserve extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainFrame mainTestFrame;
	private JList<String> movie_name_list, movie_location_list, movie_theater_list, movie_time_list;
	private JScrollPane thaeterP;
	private String selectedMovieName;
	
	private enum LISTYPE {MOVIE, LOCAL, MOVIEHOUSE, TIME, END };

	/**
	 * Create the panel.
	 */
	public Ticketreserve(MainFrame mainTestFrame) {
		this.mainTestFrame = mainTestFrame;

		setLayout(null);
		this.setSize(1280, 800 - 150);
		this.setPreferredSize(new Dimension(1280, 800 - 150));
		this.setBackground(new Color(0, 0, 0));
		
		this.setVisible(false);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(155, 10, 934, 591);
		add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(12, 10, 910, 569);
		panel.add(panel_1);
		panel_1.setLayout(null);
		// 고정값

		JLabel ticketreserve_1 = new JLabel("영화");
		ticketreserve_1.setHorizontalAlignment(SwingConstants.CENTER);
		ticketreserve_1.setBounds(84, 94, 60, 50);
		panel_1.add(ticketreserve_1);
		ticketreserve_1.setForeground(new Color(255, 255, 255));
		ticketreserve_1.setFont(new Font("나눔고딕", Font.BOLD, 26));

		JLabel ticketreserve_2 = new JLabel("지역");
		ticketreserve_2.setHorizontalAlignment(SwingConstants.CENTER);
		ticketreserve_2.setBounds(278, 94, 71, 50);
		panel_1.add(ticketreserve_2);
		ticketreserve_2.setForeground(new Color(255, 255, 255));
		ticketreserve_2.setFont(new Font("나눔고딕", Font.BOLD, 26));

		JLabel ticketreserve_3 = new JLabel("극장");
		ticketreserve_3.setHorizontalAlignment(SwingConstants.CENTER);
		ticketreserve_3.setBounds(461, 94, 71, 50);
		panel_1.add(ticketreserve_3);
		ticketreserve_3.setForeground(new Color(255, 255, 255));
		ticketreserve_3.setFont(new Font("나눔고딕", Font.BOLD, 26));

		JLabel ticketreserve_4 = new JLabel("시간");
		ticketreserve_4.setHorizontalAlignment(SwingConstants.CENTER);
		ticketreserve_4.setBounds(717, 94, 71, 50);
		panel_1.add(ticketreserve_4);
		ticketreserve_4.setForeground(new Color(255, 255, 255));
		ticketreserve_4.setFont(new Font("나눔고딕", Font.BOLD, 26));

		JButton BackButton = new JButton("");
		BackButton.addActionListener(new BackAction());
		BackButton.setBorderPainted(false);
		BackButton.setIcon(new ImageIcon(Ticketreserve.class.getResource("/image/button/back.png")));
		BackButton.setBounds(12, 494, 110, 42);
		panel_1.add(BackButton);

		JButton SeatButton = new JButton("");
		SeatButton.addActionListener(new SeatAction());
		SeatButton.setBorderPainted(false);
		SeatButton.setIcon(new ImageIcon(Ticketreserve.class.getResource("/image/button/select.png")));
		SeatButton.setBounds(788, 494, 110, 42);
		panel_1.add(SeatButton);

		// 영화제목 리스트
		movie_name_list = new JList<String>();
		movie_name_list.setBounds(34, 171, 176, 200);
		movie_name_list.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		JScrollPane namep = new JScrollPane(movie_name_list);
		namep.setBounds(12, 144, 205, 334);
		panel_1.add(namep);
		//loadSQLData(movie_name_list, LISTYPE.MOVIE);

		// 지역 리스트
		movie_location_list = new JList<String>();
		movie_location_list.setBounds(229, 172, 149, 243);
		movie_location_list.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
		JScrollPane locationP = new JScrollPane(movie_location_list);
		locationP.setBounds(229, 144, 163, 334);
		panel_1.add(locationP);

		// 극장 리스트
		movie_theater_list = new JList<String>();
		movie_theater_list.setBounds(390, 172, 156, 243);
		movie_theater_list.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
		thaeterP = new JScrollPane(movie_theater_list);
		thaeterP.setBounds(404, 144, 190, 334);
		movie_theater_list.setBackground(Color.white);
		panel_1.add(thaeterP);

		// 시간 리스트
		movie_time_list = new JList<String>();
		movie_time_list.setBounds(558, 171, 196, 243);
		movie_time_list.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		JScrollPane time = new JScrollPane(movie_time_list);
		time.setBounds(606, 144, 292, 334);
		panel_1.add(time);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Ticketreserve.class.getResource("/image/title/select2.png")));
		lblNewLabel.setBounds(335, 10, 270, 80);
		panel_1.add(lblNewLabel);
		
		ListInit();
	}
	
	public void PageOpenInit()
	{
		this.loadSqlData_test(movie_name_list, LISTYPE.MOVIE, "", "", "");
		
		DefaultListModel<String> nullObj = new DefaultListModel<String>();
		movie_location_list.setModel(nullObj);
		
		
		ListModel<String> temp = movie_name_list.getModel();
		for(int i = 0 ; i < temp.getSize(); ++i)
		{
			if(temp.getElementAt(i).equals(selectedMovieName))
			{
				movie_name_list.setSelectedIndex(i);				
				String selectValue = movie_name_list.getSelectedValue();
				System.out.println(selectValue);
				loadSqlData_test(movie_location_list, LISTYPE.LOCAL, selectValue, "", "");
				
				break;
			}
		}
		
		//movie_location_list.setModel(nullObj);
		movie_time_list.setModel(nullObj);
		movie_theater_list.setModel(nullObj);		
	}
	
	public void ListInit()
	{
		//_list.addMouseListener(new MouseAdapter() {
		this.loadSqlData_test(movie_name_list, LISTYPE.MOVIE, "", "", "");
		
		movie_name_list.addMouseListener(new MouseAdapter() 
		{			
			@Override
			public void mouseClicked(MouseEvent e)
			{
				String selectValue = movie_name_list.getSelectedValue();				
				loadSqlData_test(movie_location_list, LISTYPE.LOCAL, selectValue, "", "");
				
				DefaultListModel<String> nullObj = new DefaultListModel<String>();
				movie_time_list.setModel(nullObj);
				movie_theater_list.setModel(nullObj);
			}
		});
		
		movie_location_list.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				String movie_selectValue = movie_name_list.getSelectedValue();	
				String local_selectValue = movie_location_list.getSelectedValue();
				
				loadSqlData_test(movie_theater_list, LISTYPE.MOVIEHOUSE, movie_selectValue , local_selectValue, "");
				
				DefaultListModel<String> nullObj = new DefaultListModel<String>();
				movie_time_list.setModel(nullObj);
			}
		});
		
		movie_theater_list.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				String movie_selectValue = movie_name_list.getSelectedValue();	
				String local_selectValue = movie_location_list.getSelectedValue();	
				String house_selectValue = movie_theater_list.getSelectedValue();
				
				loadSqlData_test(movie_time_list, LISTYPE.TIME, movie_selectValue, local_selectValue, house_selectValue);
			}
		});
		
		movie_time_list.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
			
			}
			
		});
		
	}
	
	public void Set_selectedMovieName(String name)
	{
		this.selectedMovieName = name;
	}
	
	public void loadSqlData_test(JList<String> _list, LISTYPE _type, String movieName, String LocalName, String houseName)
	{
		//db -> data 가져오는 함수
		DefaultListModel<String> model = new DefaultListModel<>();
		
		_list.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		_list.setCellRenderer(new DefaultListCellRenderer());	
		
		
		String sql = "SELECT m.SCHEDULE_NO, m2.MOVIE_NO, m2.MOVIE_NAME, m3.MOVIEHOUSE_NO, m3.MOVIEHOUSE_NAME, m.SCHEDULE_TIME, LOCAL.LOCAL_NO ,LOCAL.LOCAL_NAME "
				+ "		FROM "
				+ "		((( "
				+ "		MOVIESCHEDULE m "
				+ "		JOIN MOVIE m2 ON m2.MOVIE_NO = m.MOVIE_NO ) "
				+ "		JOIN MOVIEHOUSE m3 ON m3.MOVIEHOUSE_NO = m.MOVIEHOUSE_NO) "
				+ "		JOIN LOCAL ON LOCAL.LOCAL_NO = m3.LOCAL_NO)";	
		
		switch (_type) 
		{
			case MOVIE: 
				sql = "SELECT MOVIE_NAME FROM MOVIE ";
				break;
			case LOCAL:
				//sql += "WHERE m2.MOVIE_NAME = '"+ movieName +"' ";
				//선택된 영화를 상영하는 유효 지역이 나와야함
				sql = "SELECT DISTINCT  LOCAL.LOCAL_NO, LOCAL.LOCAL_NAME "
						+ "		FROM "
						+ "		((( "
						+ "		MOVIESCHEDULE m "
						+ "		JOIN MOVIE m2 ON m2.MOVIE_NO = m.MOVIE_NO ) "
						+ "		JOIN MOVIEHOUSE m3 ON m3.MOVIEHOUSE_NO = m.MOVIEHOUSE_NO) "
						+ "		JOIN LOCAL ON LOCAL.LOCAL_NO = m3.LOCAL_NO)";	
				sql += "WHERE m2.MOVIE_NAME = '"+ movieName +"' ";
				break;
			case MOVIEHOUSE:
				sql = "SELECT DISTINCT  m3.MOVIEHOUSE_NO, m3.MOVIEHOUSE_NAME "
						+ "		FROM "
						+ "		((( "
						+ "		MOVIESCHEDULE m "
						+ "		JOIN MOVIE m2 ON m2.MOVIE_NO = m.MOVIE_NO ) "
						+ "		JOIN MOVIEHOUSE m3 ON m3.MOVIEHOUSE_NO = m.MOVIEHOUSE_NO) "
						+ "		JOIN LOCAL ON LOCAL.LOCAL_NO = m3.LOCAL_NO)";	
				
				sql += "WHERE m2.MOVIE_NAME = '"+ movieName +"' ";
				sql += "AND LOCAL.LOCAL_NAME = '" + LocalName + "' ";
				//상영하는 유효 영화관이 나와야함 local 정보 포함
				
				break;
			case TIME:
				sql += "WHERE m2.MOVIE_NAME = '"+ movieName +"' ";
				sql += "AND LOCAL.LOCAL_NAME = '" + LocalName + "' ";
				sql += "AND m3.MOVIEHOUSE_NAME = '" + houseName + "' ";
				sql += "ORDER BY SCHEDULE_TIME ";
				break;
		}

		try 
		{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@//14.42.124.35:1521/XE", 
					"c##wjrls", 
					"881125");
			
			PreparedStatement pstmt1 = conn.prepareStatement(sql);
			ResultSet rs = pstmt1.executeQuery();
			
			while (rs.next()) 
			{	
				switch (_type) 
				{
					case MOVIE: 
						String movie_Name = rs.getString("MOVIE_NAME");
						model.addElement(movie_Name);
						break;
					case LOCAL:
						String local_name = rs.getString("LOCAL_NAME");
						model.addElement(local_name);
						break;
					case MOVIEHOUSE:
						String house_name = rs.getString("MOVIEHOUSE_NAME");
						model.addElement(house_name);
						break;
					case TIME:					
						//나중에
						String time_name = rs.getString("SCHEDULE_TIME");
						model.addElement(time_name);
						break;
				}	
			}
			
			pstmt1.close();
			conn.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		_list.setModel(model);
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
			
			//0.검사
			int movieCheker = movie_name_list.getSelectedIndex();
			int localChecker = movie_location_list.getSelectedIndex();
			int timeChecker = movie_time_list.getSelectedIndex();
			int houseChecker = movie_theater_list.getSelectedIndex();
			
            String movieName = movie_name_list.getSelectedValue();
            String localName = movie_location_list.getSelectedValue();
            String timeName = movie_time_list.getSelectedValue();
            String houseName = movie_theater_list.getSelectedValue();
			
			if( movieCheker < 0 || localChecker < 0 || timeChecker < 0 || houseChecker < 0)
			{
				JOptionPane.showMessageDialog(null, "선택사항 확인 부탁드립니다.");
				return;
			}			
			
            mainTestFrame.Set_TicketRserveData_forSeatSelect(movieName, houseName, localName, timeName);
			mainTestFrame.PageChange(MainFrame.PANELNAME.SEATSELECT);
		}
	}
	
}
