package projectPackage;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import projectPackage.HeadPanel.popupDefine;
import projectPackage.MainFrame.PANELNAME;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.Icon;

public class OhtanisPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainFrame mainFrame;
	private JFrame crimePopup;
	private JFrame stuntPopup;
	private JFrame kungfuPopup;
	private JFrame chalPopup;
	private JFrame monPopup;


	/**
	 * Create the panel.
	 */
	public OhtanisPanel(MainFrame mainFrame) {

		this.mainFrame = mainFrame;

		setLayout(null);
		this.setSize(1280, 800 - 150);
		this.setPreferredSize(new Dimension(1280, 800 - 150));
		this.setBackground(new Color(0, 0, 0));

		try {

			// JFrame Initialize
			// 팝업 jframe 정의
			// 클릭시 이벤트 정의
			// --------------------------------------------------//
			crimePopup = new CrimePopup();
			JButton btnNewButton_1 = new JButton("");		
			btnNewButton_1.addActionListener(new crimePopupAction());
			btnNewButton_1.setIcon(new ImageIcon(OhtanisPanel.class.getResource("/image/ohtani/crimetown.jpg")));
			btnNewButton_1.setBounds(88, 326, 150, 214);
			add(btnNewButton_1);

			stuntPopup = new StuntPopup();
			JButton btnNewButton_2 = new JButton("");
			btnNewButton_2.addActionListener(new stuntPopupAction());
			btnNewButton_2.setIcon(new ImageIcon(OhtanisPanel.class.getResource("/image/ohtani/stuntman.jpg")));
			btnNewButton_2.setBounds(326, 326, 150, 214);
			add(btnNewButton_2);

			kungfuPopup = new KungfuPopup();
			JButton btnNewButton_3 = new JButton("");
			btnNewButton_3.addActionListener(new kungfuPopupAction());
			btnNewButton_3.setIcon(new ImageIcon(OhtanisPanel.class.getResource("/image/ohtani/kungfupanda.jpg")));
			btnNewButton_3.setBounds(560, 326, 150, 214);
			add(btnNewButton_3);

			chalPopup = new ChalPopup();
			JButton btnNewButton_4 = new JButton("");
			btnNewButton_4.addActionListener(new chalPopupAction());
			btnNewButton_4.setIcon(new ImageIcon(OhtanisPanel.class.getResource("/image/ohtani/challengers.jpg")));
			btnNewButton_4.setBounds(802, 326, 150, 214);
			add(btnNewButton_4);
			
			monPopup = new MonPopup();
			JButton btnNewButton_5 = new JButton("");
			btnNewButton_5.addActionListener(new monPopupAction());
			btnNewButton_5.setIcon(new ImageIcon(OhtanisPanel.class.getResource("/image/ohtani/monsterfriends.jpg")));
			btnNewButton_5.setBounds(1040, 326, 150, 214);
			add(btnNewButton_5);

			JLabel label_1 = new JLabel("1. 범죄도시4");
			label_1.setForeground(new Color(255, 255, 255));
			label_1.setFont(new Font("나눔고딕", Font.BOLD, 18));
			label_1.setBounds(111, 550, 100, 22);
			add(label_1);

			JLabel label_2 = new JLabel("2. 스턴트맨");
			label_2.setForeground(new Color(255, 255, 255));
			label_2.setFont(new Font("나눔고딕", Font.BOLD, 18));
			label_2.setBounds(351, 550, 100, 22);
			add(label_2);

			JLabel label_3 = new JLabel("3. 쿵푸팬더4");
			label_3.setForeground(new Color(255, 255, 255));
			label_3.setFont(new Font("나눔고딕", Font.BOLD, 18));
			label_3.setBounds(585, 550, 100, 22);
			add(label_3);

			JLabel label_4 = new JLabel("5. 몬스터 프렌즈");
			label_4.setForeground(new Color(255, 255, 255));
			label_4.setFont(new Font("나눔고딕", Font.BOLD, 18));
			label_4.setBounds(1046, 550, 139, 22);
			add(label_4);

			JLabel label_5 = new JLabel("4. 챌린저스");
			label_5.setForeground(new Color(255, 255, 255));
			label_5.setFont(new Font("나눔고딕", Font.BOLD, 18));
			label_5.setBounds(827, 550, 100, 22);
			add(label_5);

			JLabel label_6 = new JLabel("예매율 91.2%");
			label_6.setForeground(new Color(255, 255, 255));
			label_6.setFont(new Font("나눔고딕", Font.BOLD, 12));
			label_6.setBounds(130, 573, 85, 22);
			add(label_6);

			JLabel label_7 = new JLabel("예매율 1.4%");
			label_7.setForeground(new Color(255, 255, 255));
			label_7.setFont(new Font("나눔고딕", Font.BOLD, 12));
			label_7.setBounds(370, 573, 85, 22);
			add(label_7);

			JLabel label_8 = new JLabel("예매율 1.3%");
			label_8.setForeground(new Color(255, 255, 255));
			label_8.setFont(new Font("나눔고딕", Font.BOLD, 12));
			label_8.setBounds(609, 573, 85, 22);
			add(label_8);

			JLabel label_9 = new JLabel("예매율 1.2%");
			label_9.setForeground(new Color(255, 255, 255));
			label_9.setFont(new Font("나눔고딕", Font.BOLD, 12));
			label_9.setBounds(847, 573, 85, 22);
			add(label_9);

			JLabel label_10 = new JLabel("예매율 1.2%");
			label_10.setForeground(new Color(255, 255, 255));
			label_10.setFont(new Font("나눔고딕", Font.BOLD, 12));
			label_10.setBounds(1084, 573, 85, 22);
			add(label_10);
			
			JLabel imageLabel = new JLabel(new ImageIcon(OhtanisPanel.class.getResource("/image/ohtani/birds.jpg")));
			imageLabel.setBounds(0, 0, 1277, 237);
			
			imageLabel.addMouseListener(new MyMouseListener());
			add(imageLabel);

		} catch (Exception e) {
			e.printStackTrace();
		}

		this.setVisible(false);
	}
	
	class MyMouseListener extends MouseAdapter{            // 이벤트 리스너 구현
		@Override
        public void mouseClicked(MouseEvent e) 
		{
			mainFrame.PageChange(PANELNAME.BIRD);
		}
	}


	// popup 이벤트 구현
	class crimePopupAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			crimePopup.setVisible(true);
			stuntPopup.setVisible(false);
			kungfuPopup.setVisible(false);
			chalPopup.setVisible(false);
			monPopup.setVisible(false);

		}
	}

	class stuntPopupAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			crimePopup.setVisible(false);
			stuntPopup.setVisible(true);
			kungfuPopup.setVisible(false);
			chalPopup.setVisible(false);
			monPopup.setVisible(false);
		}
	}

	class kungfuPopupAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			crimePopup.setVisible(false);
			stuntPopup.setVisible(false);
			kungfuPopup.setVisible(true);
			chalPopup.setVisible(false);
			monPopup.setVisible(false);
		}
	}

	class chalPopupAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			crimePopup.setVisible(false);
			stuntPopup.setVisible(false);
			kungfuPopup.setVisible(false);
			chalPopup.setVisible(true);
			monPopup.setVisible(false);
		}
	}
	
	class monPopupAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			crimePopup.setVisible(false);
			stuntPopup.setVisible(false);
			kungfuPopup.setVisible(false);
			chalPopup.setVisible(false);
			monPopup.setVisible(true);
		}
	}

}
