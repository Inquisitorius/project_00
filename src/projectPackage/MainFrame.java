package projectPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowEvent;
import java.util.HashMap;


import java.awt.Component;	

import javax.swing.BoxLayout;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private int index;
	private DBRequester dbRequester;
	private SceneChanger sceneChanger;
	
	private JPanel MainPane;	
	private JPanel HeadPanel;	
	
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
		this.setResizable(false);
		this.messageObj = new PageChangeMessage(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dbRequester = new DBRequester();
		
		userInfo = null;
		index = 0;		
		
		//HeadPanel = new TopPanelTest(this);	
		
		//Main판넬 설정
		setBounds(100, 100, 1280, 800);
		MainPane = new JPanel();
		MainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(MainPane);
		MainPane.setLayout(new BoxLayout(MainPane, BoxLayout.Y_AXIS));
		
		sceneChanger = new SceneChanger(this);
	}
	
	public void PanelAdd(Component comp)
	{
		 this.getContentPane().add(comp);
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
		this.sceneChanger.PageChange(name);
	}
	
	public void Set_selectedMovieName_TicketReserve(String movieName)
	{
		this.sceneChanger.Set_selectedMovieName_TicketReserve(movieName);
		//((Ticketreserve)panelMap.get(MainFrame.PANELNAME.TICKETING)).Set_selectedMovieName(movieName);
	}
	
	public void Set_TicketInfo_Cancle(TicketVo ticketInfo)
	{
		this.sceneChanger.Set_TicketInfo_Cancle(ticketInfo);
		//((JinsungPanelT)panelMap.get(MainFrame.PANELNAME.TICKETCANCLE)).Set_TicketInfo_Cancle(ticketInfo);
	}
	
	public void Set_TicketCanclePage_TicketNo(int ticketNo)
	{
		this.sceneChanger.Set_TicketCanclePage_TicketNo(ticketNo);
		//((JinsungPanelT)panelMap.get(MainFrame.PANELNAME.TICKETCANCLE)).Set_TicketNo(ticketNo);
	}
	
	public void Set_TicketRserveData_forSeatSelect(String _moviName, String _movieHouseName, String _localName, String _timeData)
	{
		this.sceneChanger.Set_TicketRserveData_forSeatSelect(_moviName, _movieHouseName, _localName, _timeData);
		//((SeatSelectPage)panelMap.get(MainFrame.PANELNAME.SEATSELECT)).Set_TicketRserveData(_moviName, _movieHouseName, _localName, _timeData);
	}
	
	public JPanel Get_Panel_Main()
	{		
		return this.sceneChanger.Get_Panel_Main();
		//return panelMap.get(MainFrame.PANELNAME.MAIN);
	}
	
	public void Set_UserInfo_forLogout()
	{
		this.userInfo = null;
		this.sceneChanger.Set_UserInfo_forLogout();
		//((TopPanelTest)HeadPanel).Logout_Init();
	}
	
	public void Login_Progress()
	{
		this.sceneChanger.Login_Progress();
		//((TopPanelTest)HeadPanel).Login_Init();
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
