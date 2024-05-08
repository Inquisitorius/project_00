package projectPackage;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.DropMode;

public class DeleteId_1 extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainTestFrame mainFrame;
	private Connection conn;
	/**
	 * Create the panel.
	 */
	Color bg = new Color(0xdfeff0);
	private JTextField tf_pw;
	
//	public deleteId_1() {
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "c##green", "green1234");
//		} catch (Exception e) {
//			e.printStackTrace();
//			exit();
//		}
//	}
	
	public DeleteId_1(MainTestFrame mainFrame) {

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
		
		JLabel cgving = new JLabel(new ImageIcon(DeleteId_1.class.getResource("/image/ohtani/cgving2.png")));
		cgving.setBounds(540, 20, 200, 42);
		panel.add(cgving);
		
		JLabel lb_title_delete = new JLabel("회원탈퇴");
		lb_title_delete.setForeground(Color.WHITE);
		lb_title_delete.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title_delete.setFont(new Font("여기어때 잘난체 고딕 TTF", Font.PLAIN, 25));
		lb_title_delete.setBounds(540, 115, 200, 50);
		panel.add(lb_title_delete);
		
		JLabel lb_typePw = new JLabel("회원탈퇴를 위해 비밀번호를 입력해주세요");
		lb_typePw.setForeground(Color.WHITE);
		lb_typePw.setHorizontalAlignment(SwingConstants.CENTER);
		lb_typePw.setFont(new Font("나눔고딕", Font.BOLD, 12));
		lb_typePw.setBounds(490, 260, 300, 30);
		panel.add(lb_typePw);
		
		JLabel lb_pw = new JLabel("비밀번호");
		lb_pw.setForeground(Color.WHITE);
		lb_pw.setFont(new Font("나눔고딕", Font.BOLD, 12));
		lb_pw.setBounds(340, 310, 50, 30);
		panel.add(lb_pw);
		
		tf_pw = new JTextField();
		tf_pw.setDropMode(DropMode.INSERT);
		tf_pw.setHorizontalAlignment(SwingConstants.CENTER);
		tf_pw.setColumns(125);
		tf_pw.setBounds(390, 310, 500, 30);
		panel.add(tf_pw);
		
		JButton bt_deleteConfirm = new JButton("");
		bt_deleteConfirm.setIcon(new ImageIcon(DeleteId_1.class.getResource("/image/seungho/bt_delete_small.png")));
		bt_deleteConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		bt_deleteConfirm.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		bt_deleteConfirm.setBounds(390, 500, 245, 50);
		panel.add(bt_deleteConfirm);
		
		JButton bt_cancel = new JButton("");
		bt_cancel.setIcon(new ImageIcon(DeleteId_1.class.getResource("/image/seungho/bt_cancel.png")));
		bt_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.PageChange(MainTestFrame.PANELNAME.MAIN);
			}
		});
		bt_cancel.setFont(new Font("굴림", Font.PLAIN, 12));
		bt_cancel.setBounds(645, 500, 245, 50);
		panel.add(bt_cancel);
		
//		JPanel panel_1_1 = new JPanel();
//		panel_1_1.setOpaque(false);
//		panel_1_1.setBorder(new LineBorder(new Color(255, 0, 0)));
//		panel_1_1.setBackground(new Color(224, 255, 255));
//		panel_1_1.setBounds(346, 75, 587, 512);
//		panel.add(panel_1_1);
		

		this.setVisible(false);
	}
}
