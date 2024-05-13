package projectPackage;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import projectPackage.JinsungInformation.InfoAction;
import projectPackage.MainFrame.PANELNAME;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TicketFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JinsungPanelT parentPage;

	public JinsungPanelT getParentPage() {
		return parentPage;
	}

	public void setParentPage(JinsungPanelT parentPage) {
		this.parentPage = parentPage;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketFrame frame = new TicketFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public TicketFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("티켓을 취소하시겠습니까?");
		lblNewLabel.setFont(new Font("나눔바른고딕", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(34, 90, 616, 145);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lblNewLabel);
		
		JButton BackButton = new JButton("");
		
		BackAction action = new BackAction();
		action.oriFrame = this;
		
		BackButton.addActionListener(action);
	
		BackButton.setIcon(new ImageIcon(JinsungInformation.class.getResource("/image/jinsung/No.png")));
		BackButton.setBounds(375, 303, 135, 44);
		contentPane.add(BackButton);	
		
		JButton CancleButton = new JButton("");
		
		CancleAction action2 = new CancleAction();
		action2.oriFrame2 = this;
		
		CancleButton.addActionListener(action2);
		CancleButton.setIcon(new ImageIcon(JinsungInformation.class.getResource("/image/jinsung/yes.png")));
		CancleButton.setBounds(182, 303, 135, 44);
		contentPane.add(CancleButton);
		
		
	}
	class BackAction implements ActionListener {
		//
		public TicketFrame oriFrame;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			oriFrame.dispose();
}
	}
	class CancleAction implements ActionListener {
		public TicketFrame oriFrame2;
		@Override
		public void actionPerformed(ActionEvent e) {
			parentPage.CancleProgress();
			oriFrame2.dispose();
			parentPage.get_MainTestFrame().PageChange(PANELNAME.MAIN);
			
}
	}
}

