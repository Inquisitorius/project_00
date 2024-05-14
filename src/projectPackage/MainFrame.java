package projectPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;	

import javax.swing.BoxLayout;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private int index;
	private DBRequester dbRequester;
	
	private JPanel MainPane;	
	private JPanel HeadPanel;	
	
	private HashMap<MainFrame.PANELNAME, JPanel> panelMap;
	private UserInfoVo userInfo;
	private TicketVo selectedInfo;
	
	private PageChangeMessage messageObj;
	
	public enum PANELNAME {MAIN, PAGE0, PAGE1, PAGE2, LOGIN, JOIN1, JOIN2, 
		JOIN3, SELECT, TICKETING, TICKET, PAYMENT, BIRD, JOIN_AGREE, MYPAGE, SEATSELECT, TICKETINFO, TICKETCANCLE};

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void PopupVisible(String value, MainFrame.PANELNAME PAGETYPE)
	{
		this.messageObj.PopupVisible(value, PAGETYPE);
	}

	public void setMessageObj(PageChangeMessage messageObj) {
		this.messageObj = messageObj;
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {		
		
		this.setTitle("CGVING");
		this.messageObj = new PageChangeMessage(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dbRequester = new DBRequester();
		
		userInfo = null;
		index = 0;		
		panelMap = new HashMap<MainFrame.PANELNAME, JPanel>();		
		
		HeadPanel = new TopPanelTest(this);	
		//생성 판넬 관리
		//JPanel ContentPanel = new SeatSelectPage(this);
		JPanel ContentPanel = new OhtanisPanel(this);
		JPanel ContentPanel2 = new Admin_UserList(this);
		JPanel ContentPanel3 = new Admin_MovieList(this);
		JPanel ContentPanel4 = new Ticketreserve(this);
	    JPanel ContentPanel5 = new AnCont2(this);
	    JPanel ContentPanel6 = new AnCont3(this);
	    JPanel ContentPanel7 = new AnCont4(this);
	    JPanel ContentPanel8 = new Login_New(this);
	    JPanel ContentPanel9 = new CreateId_1(this);
	    JPanel ContentPanel10 = new CreateId_2(this);
	    JPanel ContentPanel11 = new CreateId_3(this);
	    JPanel ContentPanel12 = new BirdRichard(this);
	    JPanel ContentPanel13 = new JoinAgree(this);
	    JPanel ContentPanel14 = new MyPage_New(this);
	    JPanel ContentPanel15 = new SeatSelectPage(this);
	    JPanel ContentPanel16 = new JinsungInformation(this);
	    JPanel ContentPanel17 = new JinsungPanelT(this);
	    
		
		//생성된 판넬 Map 자료 구조에 넣기
		panelMap.put(MainFrame.PANELNAME.MAIN, ContentPanel);
		panelMap.put(MainFrame.PANELNAME.PAGE0, ContentPanel2);
		panelMap.put(MainFrame.PANELNAME.PAGE1, ContentPanel3);
	    panelMap.put(MainFrame.PANELNAME.TICKETING, ContentPanel4);
	    panelMap.put(MainFrame.PANELNAME.SELECT, ContentPanel5);
	    panelMap.put(MainFrame.PANELNAME.PAYMENT, ContentPanel6);
	    panelMap.put(MainFrame.PANELNAME.TICKET, ContentPanel7);
	    panelMap.put(MainFrame.PANELNAME.LOGIN, ContentPanel8);
	    panelMap.put(MainFrame.PANELNAME.JOIN1, ContentPanel9);
	    panelMap.put(MainFrame.PANELNAME.JOIN2, ContentPanel10);
	    panelMap.put(MainFrame.PANELNAME.JOIN3, ContentPanel11);
	    panelMap.put(MainFrame.PANELNAME.BIRD, ContentPanel12);
	    panelMap.put(MainFrame.PANELNAME.JOIN_AGREE, ContentPanel13);
	    panelMap.put(MainFrame.PANELNAME.MYPAGE, ContentPanel14);
	    panelMap.put(MainFrame.PANELNAME.SEATSELECT, ContentPanel15);
	    panelMap.put(MainFrame.PANELNAME.TICKETINFO, ContentPanel16);
	    panelMap.put(MainFrame.PANELNAME.TICKETCANCLE, ContentPanel17);
	    
		
		//Main판넬 설정
		setBounds(100, 100, 1280, 800);
		MainPane = new JPanel();
		MainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(MainPane);
		MainPane.setLayout(new BoxLayout(MainPane, BoxLayout.Y_AXIS));
		
		//메인 페이지 초기화 코드
		ContentPanel.setVisible(true);
		//ContentPanel3.setVisible(true);
		
		//Main 판넬에 하위 판넬 add 처리
		this.getContentPane().add(HeadPanel);
		this.getContentPane().add(ContentPanel);
		this.getContentPane().add(ContentPanel2);
		this.getContentPane().add(ContentPanel3);
		this.getContentPane().add(ContentPanel4);
	    this.getContentPane().add(ContentPanel5);
	    this.getContentPane().add(ContentPanel6);
	    this.getContentPane().add(ContentPanel7);
	    this.getContentPane().add(ContentPanel8);   //LOGIN
	    this.getContentPane().add(ContentPanel9);   //JOIN1
	    this.getContentPane().add(ContentPanel10);   //JOIN2
	    this.getContentPane().add(ContentPanel11);   //JOIN3	
	    this.getContentPane().add(ContentPanel12); 	 // bird
	    this.getContentPane().add(ContentPanel13);
	    this.getContentPane().add(ContentPanel14);
	    this.getContentPane().add(ContentPanel15);
	    this.getContentPane().add(ContentPanel16);
	    this.getContentPane().add(ContentPanel17);
	}
	
	@Override
	protected void processWindowEvent(WindowEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getID() == WindowEvent.WINDOW_CLOSING)
			this.dbRequester.DisConnectDB();
		
		super.processWindowEvent(e);
	}

	
	public DBRequester getDbRequester() {
		return dbRequester;
	}

	public void setDbRequester(DBRequester dbRequester) {
		this.dbRequester = dbRequester;
	}

	public void Pagechange_init(JPanel _panel, boolean headVisible)
	{
		this.HeadPanel.setVisible(headVisible);
		_panel.setVisible(true);
	}
	
	
	public void PageChange(PANELNAME name)
	{		
		 
		Iterator<PANELNAME> keys = panelMap.keySet().iterator();
		while (keys.hasNext()) {
			PANELNAME key = keys.next();
			panelMap.get(key).setVisible(false);
		}
		
		
		switch (name) {
		case MAIN: 						
			Pagechange_init(panelMap.get(MainFrame.PANELNAME.MAIN), true);
			break;
		case PAGE0:
			Pagechange_init(panelMap.get(MainFrame.PANELNAME.PAGE0), true);
			break;
		case PAGE1:
			Pagechange_init(panelMap.get(MainFrame.PANELNAME.PAGE1), true);			
			break;	
		case PAGE2:
			panelMap.get(MainFrame.PANELNAME.PAGE2).setVisible(true);
			break;	
	     case TICKETING:
	    	((Ticketreserve)panelMap.get(MainFrame.PANELNAME.TICKETING)).PageOpenInit();
	         panelMap.get(MainFrame.PANELNAME.TICKETING).setVisible(true);
	         break;   
	      case SELECT:
	         panelMap.get(MainFrame.PANELNAME.SELECT).setVisible(true);
	         break;   
	      case PAYMENT:
	         panelMap.get(MainFrame.PANELNAME.PAYMENT).setVisible(true);
	         break;   
	      case TICKET:
	         panelMap.get(MainFrame.PANELNAME.TICKET).setVisible(true);
	         break;
	      case LOGIN:
	    	 ((Login_New)panelMap.get(MainFrame.PANELNAME.LOGIN)).PageOpen_Init();
	         panelMap.get(MainFrame.PANELNAME.LOGIN).setVisible(true);
	         break;
	      case JOIN1:
	         panelMap.get(MainFrame.PANELNAME.JOIN1).setVisible(true);
	         break;
	      case JOIN2:
	         panelMap.get(MainFrame.PANELNAME.JOIN2).setVisible(true);
	         break;
	      case JOIN3:
	         panelMap.get(MainFrame.PANELNAME.JOIN3).setVisible(true);
	         break;
	      case BIRD:
	    	 panelMap.get(MainFrame.PANELNAME.BIRD).setVisible(true);
		     break;
	      case JOIN_AGREE:
	    	  panelMap.get(MainFrame.PANELNAME.JOIN_AGREE).setVisible(true);
	    	  break;      
	      case MYPAGE:	    	  
	    	 ((MyPage_New)panelMap.get(MainFrame.PANELNAME.MYPAGE)).MypageInit();
	    	 panelMap.get(MainFrame.PANELNAME.MYPAGE).setVisible(true);
	    	 break;
	      case SEATSELECT:
	    	  ((SeatSelectPage)panelMap.get(MainFrame.PANELNAME.SEATSELECT)).PageInit();
	    	  panelMap.get(MainFrame.PANELNAME.SEATSELECT).setVisible(true);
	    	  break;
	      case TICKETINFO:
	    	  ((JinsungInformation)panelMap.get(MainFrame.PANELNAME.TICKETINFO)).PageInit();
	    	  panelMap.get(MainFrame.PANELNAME.TICKETINFO).setVisible(true);
	    	  break;  
	      case TICKETCANCLE:
	    	  ((JinsungPanelT)panelMap.get(MainFrame.PANELNAME.TICKETCANCLE)).PageInit();
	    	  panelMap.get(MainFrame.PANELNAME.TICKETCANCLE).setVisible(true);
	    	  break;	    	
		}
	}
	
	public void Set_selectedMovieName_TicketReserve(String movieName)
	{
		((Ticketreserve)panelMap.get(MainFrame.PANELNAME.TICKETING)).Set_selectedMovieName(movieName);
	}
	
	public void Set_TicketInfo_Cancle(TicketVo ticketInfo)
	{
		((JinsungPanelT)panelMap.get(MainFrame.PANELNAME.TICKETCANCLE)).Set_TicketInfo_Cancle(ticketInfo);
	}
	
	public void Set_TicketCanclePage_TicketNo(int ticketNo)
	{
		((JinsungPanelT)panelMap.get(MainFrame.PANELNAME.TICKETCANCLE)).Set_TicketNo(ticketNo);
	}
	
	public void Set_TicketRserveData_forSeatSelect(String _moviName, String _movieHouseName, String _localName, String _timeData)
	{
		((SeatSelectPage)panelMap.get(MainFrame.PANELNAME.SEATSELECT)).Set_TicketRserveData(_moviName, _movieHouseName, _localName, _timeData);
	}
	
	public JPanel Get_Panel_Main()
	{		
		return panelMap.get(MainFrame.PANELNAME.MAIN);
	}
	
	public void Set_UserInfo_forLogout()
	{
		this.userInfo = null;
		((TopPanelTest)HeadPanel).Logout_Init();
	}
	
	public void Login_Progress()
	{
		((TopPanelTest)HeadPanel).Login_Init();
	}
	
	public UserInfoVo Get_UserInfo()
	{
		return userInfo;
	}
	
	public void Set_UserInfo(UserInfoVo userInfo)
	{
		this.userInfo = userInfo;
	}
	public void Set_selectedInfo(int movie_no, int local_no, int house_no, int schedule_no)
	{
		
	}
}
