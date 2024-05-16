package projectPackage;

import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JPanel;

import projectPackage.MainFrame.PANELNAME;

public class SceneChanger {

	private MainFrame mainFrame;
	private HashMap<MainFrame.PANELNAME, JPanel> panelMap;
	
	private JPanel HeadPanel;
	private PageChangeMessage messageObj;
	
	public SceneChanger(MainFrame mainFrame) {
		// TODO Auto-generated constructor stub
		this.mainFrame = mainFrame;
		this.messageObj = new PageChangeMessage(mainFrame);
		
		HeadPanel = new TopPanelTest(this.mainFrame);	
		HeadPanel.setVisible(true);
		
		panelMap = new HashMap<MainFrame.PANELNAME, JPanel>();
		
		JPanel ContentPanel = new OhtanisPanel(this.mainFrame);
		JPanel ContentPanel2 = new Admin_UserList(this.mainFrame);
		JPanel ContentPanel3 = new Admin_MovieList(this.mainFrame);
		JPanel ContentPanel4 = new Ticketreserve(this.mainFrame);	
	    JPanel ContentPanel8 = new Login_New(this.mainFrame);
	    JPanel ContentPanel12 = new BirdRichard(this.mainFrame);
	    JPanel ContentPanel13 = new JoinAgree(this.mainFrame);
	    JPanel ContentPanel14 = new MyPage_New(this.mainFrame);
	    JPanel ContentPanel15 = new SeatSelectPage(this.mainFrame);
	    //JPanel ContentPanel16 = new JinsungInformation(this.mainFrame);
	    JPanel ContentPanel17 = new JinsungPanelT(this.mainFrame);
	    
	    panelMap.put(MainFrame.PANELNAME.MAIN, ContentPanel);
		panelMap.put(MainFrame.PANELNAME.PAGE0, ContentPanel2);
		panelMap.put(MainFrame.PANELNAME.PAGE1, ContentPanel3);
	    panelMap.put(MainFrame.PANELNAME.TICKETING, ContentPanel4);
	    panelMap.put(MainFrame.PANELNAME.LOGIN, ContentPanel8);
	    panelMap.put(MainFrame.PANELNAME.BIRD, ContentPanel12);
	    panelMap.put(MainFrame.PANELNAME.JOIN_AGREE, ContentPanel13);
	    panelMap.put(MainFrame.PANELNAME.MYPAGE, ContentPanel14);
	    panelMap.put(MainFrame.PANELNAME.SEATSELECT, ContentPanel15);
	    //panelMap.put(MainFrame.PANELNAME.TICKETINFO, ContentPanel16);
	    panelMap.put(MainFrame.PANELNAME.TICKETCANCLE, ContentPanel17);
	    
	    //Main Page Visible
	    ContentPanel.setVisible(true);
	    
	    this.mainFrame.PanelAdd(HeadPanel);
	    this.mainFrame.PanelAdd(ContentPanel);
	    this.mainFrame.PanelAdd(ContentPanel2);
	    this.mainFrame.PanelAdd(ContentPanel3);
	    this.mainFrame.PanelAdd(ContentPanel4);
	    this.mainFrame.PanelAdd(ContentPanel8);
	    this.mainFrame.PanelAdd(ContentPanel12);
	    this.mainFrame.PanelAdd(ContentPanel13);
	    this.mainFrame.PanelAdd(ContentPanel14);
	    this.mainFrame.PanelAdd(ContentPanel15);
	    //this.mainFrame.PanelAdd(ContentPanel16);
	    this.mainFrame.PanelAdd(ContentPanel17);
	    
	}
	
	public void PopupVisible(String value, MainFrame.PANELNAME PAGETYPE)
	{
		this.messageObj.PopupVisible(value, PAGETYPE);
	}

	public void setMessageObj(PageChangeMessage messageObj) {
		this.messageObj = messageObj;
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
		((TopPanelTest)HeadPanel).Logout_Init();
	}
	
	public void Login_Progress()
	{
		((TopPanelTest)HeadPanel).Login_Init();
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
			panelMap.get(MainFrame.PANELNAME.MAIN).setVisible(true);
			break;
		case PAGE0:
			panelMap.get(MainFrame.PANELNAME.PAGE0).setVisible(true);
			break;
		case PAGE1:
			panelMap.get(MainFrame.PANELNAME.PAGE1).setVisible(true);
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
}
