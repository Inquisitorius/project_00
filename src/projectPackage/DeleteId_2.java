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
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class DeleteId_2 extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainTestFrame mainFrame;

	/**
	 * Create the panel.
	 */
	Color bg = new Color(0xdfeff0);
	Color btcolor = new Color(0x276bf0);
	
	public DeleteId_2(MainTestFrame mainFrame) {

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
		
		JLabel cgving = new JLabel(new ImageIcon(DeleteId_2.class.getResource("/image/ohtani/cgving2.png")));
		cgving.setBounds(540, 20, 200, 42);
		panel.add(cgving);
		
		JLabel lb_bye = new JLabel("그동안 CGVING을 이용해주셔서 감사합니다!");
		lb_bye.setForeground(Color.WHITE);
		lb_bye.setHorizontalAlignment(SwingConstants.CENTER);
		lb_bye.setFont(new Font("여기어때 잘난체 고딕 TTF", Font.PLAIN, 25));
		lb_bye.setBounds(365, 230, 550, 50);
		panel.add(lb_bye);
		
		JButton bt_home = new JButton("");
		bt_home.setIcon(new ImageIcon(DeleteId_2.class.getResource("/image/seungho/bt_home.png")));
		bt_home.setBackground(UIManager.getColor("Button.background"));
		bt_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
