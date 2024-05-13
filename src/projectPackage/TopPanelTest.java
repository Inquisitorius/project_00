package projectPackage;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

public class TopPanelTest extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTextField textField_1;
    private MainFrame mainFrame;
    private JLabel lblNewLabel_1;
    private JButton btnNewButton_2; 
    private JButton logoutBtn;
    
    private JButton joinPageBtn;
    private JButton myPageBtn;
    
    private ActionListener loginBtnAction;
    private ActionListener logoutBtnAction;
    

    public TopPanelTest(MainFrame mainFrame) {
        setLayout(null);
        this.mainFrame = mainFrame;
        JPanel panel_1 = new JPanel();
        this.setSize(1280,150);
        this.setPreferredSize(new Dimension(1280,150));
        panel_1.setBackground(Color.BLACK);
        panel_1.setBounds(0, 0, 1280, 150);
        add(panel_1);
        panel_1.setLayout(null);
        
        
        //---------Action ------------//
        loginBtnAction =  new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {            	
                mainFrame.PageChange(MainFrame.PANELNAME.LOGIN);
                System.out.println("action login");
            }
        };
        
        logoutBtnAction =  new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {
            	
            	mainFrame.Set_UserInfo_forLogout();
                mainFrame.PageChange(MainFrame.PANELNAME.LOGIN);
                System.out.println("action logout");
            }
        };
        //-------------------------------//

        JLabel imageLabel = new JLabel(new ImageIcon(TopPanelTest.class.getResource("/image/ohtani/cgving2.png")));
        imageLabel.setBounds(45, 48, 200, 51);
        panel_1.add(imageLabel);
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainFrame.PageChange(MainFrame.PANELNAME.MAIN);
            }
        });

        textField_1 = new JTextField();
        textField_1.setBorder(new EmptyBorder(0, 10, 0, 0));
        textField_1.setBounds(941, 73, 250, 30);
        panel_1.add(textField_1);
        textField_1.setColumns(40);
        
        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.setBorderPainted(false);
        btnNewButton_1.setIcon(new ImageIcon(TopPanelTest.class.getResource("/image/button/search_s.png")));
        btnNewButton_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 14));
        btnNewButton_1.setBounds(1197, 73, 32, 32);
        panel_1.add(btnNewButton_1);
        
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchText = textField_1.getText().toLowerCase();
                switch (searchText) {
                    case "범죄도시4":
                    	((OhtanisPanel)mainFrame.Get_Panel_Main()).Set_PopupInit();
                    	((OhtanisPanel)mainFrame.Get_Panel_Main()).getCrimePopup().setVisible(true);
                        break;
                    case "쿵푸팬더4":
                    	//OhtanisPanel parentPanel = (OhtanisPanel)mainFrame.Get_Panel_Main();
                    	((OhtanisPanel)mainFrame.Get_Panel_Main()).Set_PopupInit();
                    	((OhtanisPanel)mainFrame.Get_Panel_Main()).getKungfuPopup().setVisible(true);
                        break;
                    case "스턴트맨":                    	
                    	((OhtanisPanel)mainFrame.Get_Panel_Main()).Set_PopupInit();
                    	((OhtanisPanel)mainFrame.Get_Panel_Main()).getStuntPopup().setVisible(true);
                        break;
                    case "챌린저스":                    	
                    	((OhtanisPanel)mainFrame.Get_Panel_Main()).Set_PopupInit();
                    	((OhtanisPanel)mainFrame.Get_Panel_Main()).getChalPopup().setVisible(true);
                        break;
                    case "몬스터 프렌즈":
                    	((OhtanisPanel)mainFrame.Get_Panel_Main()).Set_PopupInit();
                    	((OhtanisPanel)mainFrame.Get_Panel_Main()).getMonPopup().setVisible(true);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "검색 결과가 없습니다.");
                        break;
                }
            }
        });

        btnNewButton_2 = new JButton("");
        btnNewButton_2.setBorderPainted(false);
        btnNewButton_2.setIcon(new ImageIcon(TopPanelTest.class.getResource("/image/button/login_s.png")));
        btnNewButton_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 14));
        btnNewButton_2.setBounds(1159, 34, 32, 32);
        panel_1.add(btnNewButton_2);
        btnNewButton_2.addActionListener(loginBtnAction);

        joinPageBtn = new JButton("");
        joinPageBtn.setBorderPainted(false);
        joinPageBtn.setIcon(new ImageIcon(TopPanelTest.class.getResource("/image/button/join_s.png")));
        joinPageBtn.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 14));
        joinPageBtn.setBounds(1197, 34, 32, 32);
        panel_1.add(joinPageBtn);
        joinPageBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.PageChange(MainFrame.PANELNAME.JOIN_AGREE);
            }
        });
        
        myPageBtn = new JButton("");
        myPageBtn.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 14));
        myPageBtn.setIcon(new ImageIcon(TopPanelTest.class.getResource("/image/button/mypage_s.png")));
        myPageBtn.setBorderPainted(false);
        myPageBtn.setBounds(1197, 34, 32, 32);
        myPageBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.PageChange(MainFrame.PANELNAME.MYPAGE);
				
			}
		});
        panel_1.add(myPageBtn);
        

        JLabel lblNewLabel = new JLabel("C U L T U R E P L E X");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 16));
        lblNewLabel.setBounds(246, 77, 174, 15);
        panel_1.add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("ohtani님, 환영합니다.");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 12));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(941, 50, 211, 15);
        panel_1.add(lblNewLabel_1);
        
        logoutBtn = new JButton("");
        logoutBtn.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 14));
        logoutBtn.setBorderPainted(false);
        logoutBtn.setBounds(1159, 34, 32, 32);
        panel_1.add(logoutBtn);
        
        logoutBtn.addActionListener(logoutBtnAction);        
        logoutBtn.setVisible(false);
        
        logoutBtn.setIcon(new ImageIcon(TopPanelTest.class.getResource("/image/button/logout_s.png")));
        
       

        this.setVisible(true);     

        Logout_Init();
        
    }
    
    public void Login_Init()
    {
    	if(this.mainFrame.Get_UserInfo() == null)
    		return;
    	
    	String text = this.mainFrame.Get_UserInfo().getUser_id() + " 님, 환영합니다.";
    	
    	btnNewButton_2.setVisible(false);    	
    	logoutBtn.setVisible(true);    	
    	
    	joinPageBtn.setVisible(false);
    	myPageBtn.setVisible(true);
    	
    	lblNewLabel_1.setText(text);
    	lblNewLabel_1.setVisible(true);
    }
    
    public void Logout_Init()
    {
    	btnNewButton_2.setVisible(true);    	
    	logoutBtn.setVisible(false);
    	
    	joinPageBtn.setVisible(true);
    	myPageBtn.setVisible(false);
    	
    	lblNewLabel_1.setVisible(false);
    }
}
