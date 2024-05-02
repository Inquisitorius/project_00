package projectPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class JinsungInformation extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel JinsungPanelT;
	private MainTestFrame mainTestFrame;	
	/**
	 * Create the panel.
	 */
	public JinsungInformation(MainTestFrame mainTestFrame) {
		this.mainTestFrame = mainTestFrame;
		
		setLayout(null);
		this.setSize(1280, 800 - 150);
		this.setPreferredSize(new Dimension(1280, 800 - 150));
		this.setBackground(Color.white);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 1280, 650);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabelfix = new JLabel("상세 정보");
		lblNewLabelfix.setForeground(Color.WHITE);
		lblNewLabelfix.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 30));
		lblNewLabelfix.setBounds(429, 54, 143, 51);
		panel.add(lblNewLabelfix);
		
		JLabel lblNewLabelfix2 = new JLabel("영화명");
		lblNewLabelfix2.setForeground(Color.WHITE);
		lblNewLabelfix2.setFont(new Font("나눔고딕", Font.BOLD, 26));
		lblNewLabelfix2.setBounds(100, 235, 111, 41);
		panel.add(lblNewLabelfix2);
		
		JLabel lblNewLabelfix3 = new JLabel("예매 번호");
		lblNewLabelfix3.setForeground(Color.WHITE);
		lblNewLabelfix3.setFont(new Font("나눔고딕", Font.BOLD, 26));
		lblNewLabelfix3.setBounds(100, 159, 152, 51);
		panel.add(lblNewLabelfix3);
		
		JLabel lblNewLabel_loc= new JLabel("극장명");
		lblNewLabel_loc.setForeground(Color.WHITE);
		lblNewLabel_loc.setFont(new Font("나눔고딕", Font.BOLD, 26));
		lblNewLabel_loc.setBounds(100, 297, 111, 41);
		panel.add(lblNewLabel_loc);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("상영일시");
		lblNewLabel_2_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1_1.setFont(new Font("나눔고딕", Font.BOLD, 26));
		lblNewLabel_2_1_1_1_1.setBounds(100, 378, 111, 41);
		panel.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("0000-001");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("나눔고딕", Font.BOLD, 26));
		lblNewLabel_4.setBounds(840, 146, 143, 77);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("범죄도시 4");
		lblNewLabel_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_1_2.setFont(new Font("나눔고딕", Font.BOLD, 26));
		lblNewLabel_2_1_2.setBounds(840, 235, 202, 41);
		panel.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabelloc = new JLabel("CGV의정부");
		lblNewLabelloc.setForeground(Color.WHITE);
		lblNewLabelloc.setFont(new Font("나눔고딕", Font.BOLD, 26));
		lblNewLabelloc.setBounds(840, 297, 179, 41);
		panel.add( lblNewLabelloc);
		
		JLabel lblNewLabel_title_1 = new JLabel("null");
		lblNewLabel_title_1.setForeground(Color.WHITE);
		lblNewLabel_title_1.setFont(new Font("나눔고딕", Font.BOLD, 26));
		lblNewLabel_title_1.setBounds(840, 378, 205, 41);
		panel.add(lblNewLabel_title_1);
		
		JButton	BackButton= new JButton("뒤로가기");
		BackButton.addActionListener(new BackAction());
		BackButton.setForeground(new Color(0, 0, 0));
		BackButton.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		BackButton.setBounds(675, 534, 135, 44);
		panel.add(BackButton);
		
		JButton InfoButton = new JButton("상세정보");
		InfoButton.addActionListener(new InfoAction());
		InfoButton.setForeground(new Color(0, 0, 0));
		InfoButton.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		InfoButton.setBounds(836, 534, 135, 44);
		panel.add(InfoButton);
	
		this.setVisible(false);
	}
	
	class InfoAction implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

      
		mainTestFrame.PageChange(MainFrame.PANELNAME.PAGE1);
	}
}
	class BackAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		mainTestFrame.PageChange(MainFrame.PANELNAME.MAIN);
}
	}
}