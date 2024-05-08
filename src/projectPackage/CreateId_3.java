package projectPackage;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.Icon;

public class CreateId_3 extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainFrame mainFrame;

	/**
	 * Create the panel.
	 */
	Color bg = new Color(0xdfeff0);
	
	public CreateId_3(MainFrame mainFrame) {

		this.mainFrame = mainFrame;
		this.setSize(1280, 800 - 150);
		this.setPreferredSize(new Dimension(1280, 800 - 150));
		this.setBackground(bg);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1280, 650);
		add(panel);
		panel.setLayout(null);
		
		JLabel cgving = new JLabel(new ImageIcon(CreateId_3.class.getResource("/image/ohtani/cgving2.png")));
		cgving.setBounds(540, 20, 200, 42);
		panel.add(cgving);
		
		JLabel lb_thankyou = new JLabel("감사합니다!");
		lb_thankyou.setFont(new Font("여기어때 잘난체 고딕 TTF", Font.BOLD, 25));
		lb_thankyou.setHorizontalAlignment(SwingConstants.CENTER);
		lb_thankyou.setBackground(Color.BLACK);
		lb_thankyou.setForeground(Color.WHITE);
		lb_thankyou.setBounds(490, 180, 300, 50);
		panel.add(lb_thankyou);
		
		JLabel lb_joincomp = new JLabel("회원가입이 완료되었습니다!");
		lb_joincomp.setForeground(Color.WHITE);
		lb_joincomp.setMinimumSize(new Dimension(81, 23));
		lb_joincomp.setMaximumSize(new Dimension(81, 23));
		lb_joincomp.setHorizontalAlignment(SwingConstants.CENTER);
		lb_joincomp.setFont(new Font("여기어때 잘난체 고딕 TTF", Font.PLAIN, 25));
		lb_joincomp.setBounds(390, 300, 500, 50);
		panel.add(lb_joincomp);
		
		JButton bt_home = new JButton("");
		bt_home.setIcon(new ImageIcon(CreateId_3.class.getResource("/image/seungho/bt_home.png")));
		bt_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.PageChange(MainFrame.PANELNAME.MAIN);
			}
		});
		bt_home.setPreferredSize(new Dimension(81, 23));
		bt_home.setMinimumSize(new Dimension(81, 23));
		bt_home.setMaximumSize(new Dimension(81, 23));
		bt_home.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		bt_home.setBounds(390, 500, 500, 50);
		panel.add(bt_home);
		
//		JPanel panel_1 = new JPanel();
//		panel_1.setOpaque(false);
//		panel_1.setBorder(new LineBorder(new Color(255, 0, 0)));
//		panel_1.setBackground(new Color(224, 255, 255));
//		panel_1.setBounds(346, 75, 587, 512);
//		panel.add(panel_1);

		this.setVisible(false);
	}
}
