package projectPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import projectPackage.MainFrame.PANELNAME;

public class SeatSelectPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainFrame mainFrame;
	private SeatSelectPage contentPanel;
	private HashMap<String, SeatObj> seatMap;
	
	private JLabel SelectedCntLabel;
	private JLabel totalPrice;
	
	private String movieName, movieHouseName, localName, timeData;
	private int movieNo, movieHouseNo, localNo, timeNo;
	
	int startX;
	
	int index = 0;
	

	/**
	 * Create the panel.
	 */
	public SeatSelectPage(MainFrame mainFrame) 
	{		
		this.mainFrame = mainFrame;
		contentPanel = this;
		this.setSize(1280,800-150);
		this.setPreferredSize(new Dimension(1280,800-150));
		
		this.setBackground(Color.black);
		setLayout(null);	
		this.setVisible(false);
		
		seatMap = new HashMap<String, SeatSelectPage.SeatObj>();
		
		startX = 213 -40;
		
		Init_SeatInfomation(263, 0);
		
		Init_SeatInfomation(463, 1);
		Init_SeatInfomation(633, 2);
		
		Init_SeatInfomation(833, 3);
		
		JLabel title = new JLabel("");
		title.setBounds(502, 0, 271, 85);
		ImageIcon tempIcon2 = new ImageIcon(SeatSelectPage.class.getResource("/image/button/select_seat.png"));
		tempIcon2 = imageSetSize(tempIcon2, 271, 85);		
		title.setIcon(tempIcon2);
		
		this.setComponentZOrder(title, index++);
		add(title);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(SeatSelectPage.class.getResource("/image/screen/sale.png")));
		lblNewLabel.setBounds(1093, 248, 35, 35);
		add(lblNewLabel);
		this.setComponentZOrder(lblNewLabel, index++);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(SeatSelectPage.class.getResource("/image/screen/select_sheet.png")));
		lblNewLabel_1.setBounds(1093, 293, 35, 35);
		add(lblNewLabel_1);
		this.setComponentZOrder(lblNewLabel_1, index++);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(SeatSelectPage.class.getResource("/image/screen/soldout.png")));
		lblNewLabel_2.setBounds(1093, 338, 35, 35);
		add(lblNewLabel_2);
		this.setComponentZOrder(lblNewLabel_2, index++);
		
		JLabel lblNewLabel_3 = new JLabel("Available");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(1140, 248, 70, 35);
		add(lblNewLabel_3);
		this.setComponentZOrder(lblNewLabel_3, index++);
		
		JLabel lblNewLabel_3_1 = new JLabel("Selected");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setBounds(1140, 293, 70, 35);
		add(lblNewLabel_3_1);
		this.setComponentZOrder(lblNewLabel_3_1, index++);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Reserved");
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setBounds(1140, 338, 70, 35);
		add(lblNewLabel_3_1_1);
		this.setComponentZOrder(lblNewLabel_3_1_1, index++);
		
		
		ImageIcon tempIcon = new ImageIcon(SeatSelectPage.class.getResource("/image/screen/screen.jpg"));		
		tempIcon = imageSetSize(tempIcon, 1000, 150);
		JLabel screenLabelIcon = new JLabel("");	
		screenLabelIcon.setIcon(tempIcon);	
		screenLabelIcon.setBounds(131, 107, 1000 , 150);
		add(screenLabelIcon);
		
		this.setComponentZOrder(screenLabelIcon, index++);
		
		SelectedCntLabel = new JLabel("");
		SelectedCntLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		SelectedCntLabel.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 12));
		SelectedCntLabel.setForeground(new Color(252, 196, 52));
		SelectedCntLabel.setBounds(199, 423, 213, 60);
		add(SelectedCntLabel);
		
		totalPrice = new JLabel("");
		totalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		totalPrice.setFont(new Font("나눔고딕", Font.BOLD, 30));
		totalPrice.setForeground(Color.WHITE);
		totalPrice.setBounds(177, 453, 235, 60);
		add(totalPrice);
		
		JLabel reserveBtn = new JLabel("");
		
		ImageIcon tempIcon3 = new ImageIcon(SeatSelectPage.class.getResource("/image/button/buy2.png"));		
		tempIcon3 = imageSetSize(tempIcon3, 135, 52);
		reserveBtn.setIcon(tempIcon3);
		
		reserveBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(mainFrame.Get_UserInfo() == null)
				{
					mainFrame.PageChange(PANELNAME.LOGIN);
				}
				else if(contentPanel.Count_SelectedSeat() <= 0)
				{
					JOptionPane.showMessageDialog(null, "좌석을 선택해주세요.");
				}			
				else
				{
					//어떤 좌석이 있는지 확인
					Iterator<String> keys = seatMap.keySet().iterator();
					
					while (keys.hasNext()) 
					{
					    String key = keys.next();
					    if(seatMap.get(key).adapter.value == SeatMouseAdapter.STATUS.CHECK)
					    {
					    	//이름 변환 작업하고 SEAT NO 찾기
					    	String seatName = seatMap.get(key).adapter.TextObj.getText();
					    	String alpa = seatName.substring(0,1);
					    	String number = seatName.substring(1,3);
					    	
					    	seatName = alpa + "_" + number;					    	
					    	
					    	int seatNo = mainFrame.getDbRequester().Get_SeatInfo(seatName);
					    	
					    	Boolean result =  mainFrame.getDbRequester().Insert_Ticket(timeNo, seatNo, mainFrame.Get_UserInfo().getUser_no());
					    	
					    	if(result == true)
					    		System.out.println("Err: Seat Ticket Reserve");
					    }
					}
					
					mainFrame.PopupVisible("예매가 완료되었습니다.", PANELNAME.MAIN);
				}
			}
		});
		
		reserveBtn.setBounds(849, 443, 180, 70);
		add(reserveBtn);
		
	}
	
	public void PageInit()
	{
		//SQL 붙어서 현재 예약된 좌석 정보에 대해 대응
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@//14.42.124.35:1521/XE";
		String user = "c##wjrls";
		String pw = "881125";
		
		//전페이지에서 준 정보를 바탕으로 현재 상영관에 포함된 티켓 가져옴
		Get_DbData_forSeat();
				
		//전체 좌석 Render 초기화
		SeatInit();
		
		try 
		{			
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,user,pw);
			
			String sql = "SELECT t.TICKET_NO , SEAT.SEAT_NO , SEAT.SEAT_INFO , t.SCHEDULE_NO, t.TICKET_STATUS, m.THEATER_NO, LOCAL.LOCAL_NO "; 
			sql += "FROM (((TICKET t JOIN MOVIESCHEDULE m ON t.SCHEDULE_NO = m.SCHEDULE_NO ) ";
			sql += "JOIN SEAT ON SEAT.SEAT_NO  = t.SEAT_NO) ";
			sql += "JOIN MOVIEHOUSE m2 ON m2.MOVIEHOUSE_NO = m.MOVIEHOUSE_NO) ";
			sql += "JOIN LOCAL ON LOCAL.LOCAL_NO = m2.LOCAL_NO "; 			
			
			sql += "WHERE m.MOVIE_NO = " + this.movieNo + " ";
			sql += "AND m.MOVIEHOUSE_NO = " + this.movieHouseNo +" ";
			sql += "AND LOCAL.LOCAL_NO  = " + this.localNo + " ";
			sql += "AND TO_CHAR(m.SCHEDULE_TIME,'yyyy-mm-dd hh24:mi:ss') LIKE '%" + this.timeData + "%'";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				String seatName =  rs.getString("SEAT_INFO");
				String status = rs.getString("TICKET_STATUS");
				
				SeatObj temp =  this.Get_SeatObj(seatName);
				
				if(temp == null)
					System.out.println("not found seat Err!!");
				else if(status.equals("RS"))
				{
					temp.adapter.SellSeat_Init();
				}
			}
			
			pstmt.close();
			conn.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void Get_DbData_forSeat()
	{
		this.movieNo = this.mainFrame.getDbRequester().Get_MovieNo(this.movieName);
		this.movieHouseNo = this.mainFrame.getDbRequester().Get_MovieHouseNo(this.movieHouseName);
		this.localNo = this.mainFrame.getDbRequester().Get_LocalNo(this.localName);
		this.timeNo = this.mainFrame.getDbRequester().Get_TimeNo(this.timeData, this.movieNo, this.movieHouseNo);
	}
	
	public Boolean TicketingProgress(int seatNo)
	{		
		return mainFrame.getDbRequester().Insert_Ticket(this.timeNo, 0, mainFrame.Get_UserInfo().getUser_no());
	}
	
	public void SeatInit()
	{
		Iterator<String> keys = this.seatMap.keySet().iterator();
		int result = 0;
		
		while (keys.hasNext()) 
		{
		    String key = keys.next();
		    this.seatMap.get(key).adapter.SeatDefault();
		}
		
		UpdateSelectedSeat();
	}
	
	public SeatObj Get_SeatObj(String seatInfo)
	{
		if(this.seatMap.containsKey(seatInfo))			
			return this.seatMap.get(seatInfo);
		
		return null;
	}
	
	public void UpdateSelectedSeat()
	{
		int selectedSeat = Count_SelectedSeat();
		int price = selectedSeat * 10000;
		
		if(selectedSeat <= 0)
		{
			SelectedCntLabel.setText("");
			totalPrice.setText("");
			return;
		}
		
		SelectedCntLabel.setText(selectedSeat + " 개 좌석이 선택되었습니다.");
		DecimalFormat df = new DecimalFormat("#,###");
		
		totalPrice.setText("Total :  " +  df.format(price));		
	}
	
	public int Count_SelectedSeat()
	{
		Iterator<String> keys = this.seatMap.keySet().iterator();
		int result = 0;
		
		while (keys.hasNext()) 
		{
		    String key = keys.next();
		    if(this.seatMap.get(key).adapter.value == SeatMouseAdapter.STATUS.CHECK)
		    {
		    	++result;
		    }
		}
		
		return result;
	}
	
	public void Init_SeatInfomation(int startX, int section)
	{
		String imgDir = "/image/screen/sale.png";
		int X = startX - 40; //213 - 40;
		int Y = 252 - 40;
		
		int yName = (int)'A';
		
		
		for(int i = 0; i < 4; ++i)
		{
			for(int j = 0; j < 4; j++)
			{
				JLabel seat_00 = new JLabel("");
				JLabel text_00 = new JLabel("");
				text_00.setForeground(new Color(255, 255, 255));
				seat_00.setIcon(new ImageIcon(SeatSelectPage.class.getResource(imgDir)));
				seat_00.setBounds(X + (j +1) * 40 , Y + (i+1) * 40, 35, 35);
				text_00.setBounds(X + 3 + (j +1) * 40 , Y + (i+1) * 40, 35, 35);
				SeatMouseAdapter adapter = new SeatMouseAdapter(seat_00, text_00, this);
				seat_00.addMouseListener(adapter);
				
				String textValue = Character.toString((char)yName);
				int index_section = 4 * (section);
				String seatNum = "";
				
				if(index_section + j + 1 < 10)
					seatNum = "0" + Integer.toString(index_section + j + 1);
				else
					seatNum = Integer.toString(index_section + j + 1);
				
				text_00.setText(textValue + seatNum + " ");				
				
				add(seat_00);
				add(text_00);
				
				seatMap.put(textValue+"_"+seatNum, new SeatObj(seat_00, text_00, adapter));
				
				this.setComponentZOrder(text_00, index++);
				this.setComponentZOrder(seat_00, index++);
			}			
			
			yName++;
		}		
	}
	
	public int Get_Xposition()
	{
		this.startX += 40;
		return startX;
	}
	
	public ImageIcon imageSetSize(ImageIcon icon, int i, int j) { // image Size Setting
		Image ximg = icon.getImage();  //ImageIcon을 Image로 변환.
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg); 
		return xyimg;
	}
	
	class SeatObj 
	{
		public JLabel seatObj;
		public JLabel textObj;
		public SeatMouseAdapter adapter;
		
		public SeatObj(JLabel seatObj, JLabel textObj, SeatMouseAdapter adapter)
		{
			this.seatObj = seatObj;
			this.textObj = textObj;
			this.adapter = adapter;
		}		
	}
	
	public void Set_TicketRserveData(String _movieName, String _movieHouseName, String _localName, String _timeData)
	{
		this.movieName = _movieName;
		this.movieHouseName = _movieHouseName;
		this.localName = _localName;
		this.timeData = _timeData;
	}
	
	class SeatMouseAdapter extends MouseAdapter
	{
		public JLabel SeatObj;
		public JLabel TextObj;
		public SeatSelectPage prentPage;
		
		private String iconPath_clicked = "/image/screen/sale.png";
		private String iconPath_nonClicked = "/image/screen/select_sheet.png";
		private String iconPath_sale = "/image/screen/soldout.png";
		
		
		private enum STATUS {NONE, SALE, CHECK};
		private STATUS value;
		
		public SeatMouseAdapter(JLabel seatObj, JLabel textObj, SeatSelectPage prentPage)
		{
			this.SeatObj = seatObj;
			this.TextObj = textObj;
			this.prentPage = prentPage;
			
			this.TextObj.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 12));	
			this.TextObj.setHorizontalAlignment(JLabel.CENTER);
			value = STATUS.NONE;
		}
		
		public void SeatDefault()
		{
			this.value = STATUS.NONE;
			this.TextObj.setForeground(new Color(255, 255, 255));
			this.SeatObj.setIcon(new ImageIcon(SeatSelectPage.class.getResource(iconPath_clicked)));
		}
		
		public void SellSeat_Init()
		{
			this.value = STATUS.SALE;
			this.TextObj.setForeground(new Color(255, 255, 255));
			this.SeatObj.setIcon(new ImageIcon(SeatSelectPage.class.getResource(iconPath_sale)));
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			if(this.value == STATUS.CHECK)
			{
				this.value = STATUS.NONE;
				this.TextObj.setForeground(new Color(255, 255, 255));				
				this.SeatObj.setIcon(new ImageIcon(SeatSelectPage.class.getResource(iconPath_clicked)));
				
				this.prentPage.UpdateSelectedSeat();
			}				
			else if(this.value == STATUS.NONE)
			{
				this.value = STATUS.CHECK;
				this.TextObj.setForeground(new Color(0, 0, 0));
				this.SeatObj.setIcon(new ImageIcon(SeatSelectPage.class.getResource(iconPath_nonClicked)));
				
				this.prentPage.UpdateSelectedSeat();
			}				
		}
	}
}
