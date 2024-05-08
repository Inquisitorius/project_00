package projectPackage;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.JCheckBox;
import javax.swing.Icon;
import java.awt.Rectangle;
import javax.swing.border.EmptyBorder;
import javax.swing.DropMode;
import javax.swing.JPasswordField;

public class CreateId_2 extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainFrame mainFrame;

	/**
	 * Create the panel.
	 */
	Color bg = new Color(0xdfeff0);
	private JTextField tf_user_name;
	private JTextField tf_user_id;
	private JTextField tf_user_email;
	private JTextField tf_user_phone;
	private JPasswordField tf_user_pw;
	
	public CreateId_2(MainFrame mainFrame2) {

		this.mainFrame = mainFrame2;
		this.setSize(1280, 800 - 150);
		this.setPreferredSize(new Dimension(1280, 800 - 150));
		this.setBackground(bg);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1280, 650);
		add(panel);
		panel.setLayout(null);
		
		JLabel cgving = new JLabel(new ImageIcon(CreateId_2.class.getResource("/image/ohtani/cgving2.png")));
		cgving.setBounds(540, 20, 200, 42);
		panel.add(cgving);
		
		JLabel lb_MainTitle = new JLabel("회원가입");
		lb_MainTitle.setForeground(Color.WHITE);
		lb_MainTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lb_MainTitle.setFont(new Font("여기어때 잘난체 고딕 TTF", Font.PLAIN, 25));
		lb_MainTitle.setBounds(530, 115, 220, 50);
		panel.add(lb_MainTitle);
		
		JLabel lb_subTitle = new JLabel("2. 회원정보 입력");
		lb_subTitle.setForeground(Color.WHITE);
		lb_subTitle.setFont(new Font("나눔고딕", Font.BOLD, 12));
		lb_subTitle.setBounds(390, 180, 130, 20);
		panel.add(lb_subTitle);
		
		JLabel lb_user_name = new JLabel("이  름");
		lb_user_name.setForeground(Color.WHITE);
		lb_user_name.setFont(new Font("나눔고딕", Font.BOLD, 12));
		lb_user_name.setBounds(340, 210, 50, 30);
		panel.add(lb_user_name);
		
		tf_user_name = new JTextField();
		tf_user_name.setDropMode(DropMode.INSERT);
		tf_user_name.setBorder(new EmptyBorder(0, 10, 0, 0));
		tf_user_name.setHorizontalAlignment(SwingConstants.LEFT);
		tf_user_name.setColumns(125);
		tf_user_name.setBounds(390, 210, 500, 30);
		panel.add(tf_user_name);
		
		JLabel lb_user_id = new JLabel("아이디");
		lb_user_id.setForeground(Color.WHITE);
		lb_user_id.setFont(new Font("나눔고딕", Font.BOLD, 12));
		lb_user_id.setBounds(340, 260, 50, 30);
		panel.add(lb_user_id);
		
		tf_user_id = new JTextField();
		tf_user_id.setDropMode(DropMode.INSERT);
		tf_user_id.setBorder(new EmptyBorder(0, 10, 0, 0));
		tf_user_id.setHorizontalAlignment(SwingConstants.LEFT);
		tf_user_id.setColumns(125);
		tf_user_id.setBounds(390, 260, 500, 30);
		panel.add(tf_user_id);

		JLabel lb_user_pw = new JLabel("비밀번호");
		lb_user_pw.setForeground(Color.WHITE);
		lb_user_pw.setLabelFor(tf_user_pw);
		lb_user_pw.setFont(new Font("나눔고딕", Font.BOLD, 12));
		lb_user_pw.setBounds(340, 310, 50, 30);
		panel.add(lb_user_pw);
		
		tf_user_pw = new JPasswordField();
		tf_user_pw.setBorder(new EmptyBorder(0, 10, 0, 0));
		tf_user_pw.setEchoChar('*');
		tf_user_pw.setBounds(390, 310, 500, 30);
		panel.add(tf_user_pw);
		

		JLabel lb_user_email = new JLabel("이메일");
		lb_user_email.setForeground(Color.WHITE);
		lb_user_email.setFont(new Font("나눔고딕", Font.BOLD, 12));
		lb_user_email.setBounds(340, 360, 50, 30);
		panel.add(lb_user_email);
		
		tf_user_email = new JTextField();
		tf_user_email.setDropMode(DropMode.INSERT);
		tf_user_email.setBorder(new EmptyBorder(0, 10, 0, 0));
		tf_user_email.setBounds(390, 360, 500, 30);
		panel.add(tf_user_email);
		tf_user_email.setColumns(125);
		
		JLabel lb_user_phone = new JLabel("휴대전화");
		lb_user_phone.setForeground(Color.WHITE);
		lb_user_phone.setFont(new Font("나눔고딕", Font.BOLD, 12));
		lb_user_phone.setBounds(340, 410, 50, 30);
		panel.add(lb_user_phone);
		
		tf_user_phone = new JTextField();
		tf_user_phone.setDropMode(DropMode.INSERT);
		tf_user_phone.setBorder(new EmptyBorder(0, 10, 0, 0));
		tf_user_phone.setBounds(390, 410, 500, 30);
		panel.add(tf_user_phone);
		tf_user_phone.setColumns(125);
		
		JButton bt_join = new JButton("");
		bt_join.setIcon(new ImageIcon(CreateId_2.class.getResource("/image/seungho/bt_join2.png")));
		bt_join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame2.PageChange(MainFrame.PANELNAME.JOIN3);
			}
		});
		bt_join.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		bt_join.setBounds(390, 500, 500, 50);
		panel.add(bt_join);
		
//		JLabel lblNewLabel_2 = new JLabel("");
//		lblNewLabel_2.setOpaque(true);
//		lblNewLabel_2.setVisible(false);
//		lblNewLabel_2.setIcon(new ImageIcon("E:\\KDTFullStackClass\\TeamProject1\\img\\screen\\로그인2.png"));
//		lblNewLabel_2.setBounds(0, 0, 1280, 650);
//		panel.add(lblNewLabel_2);
		
//		JPanel border = new JPanel();
//		border.setEnabled(false);
//		border.setOpaque(false);
//		border.setBorder(new LineBorder(new Color(255, 0, 0)));
//		border.setBackground(new Color(224, 255, 255));
//		border.setBounds(346, 75, 587, 512);
//		panel.add(border);

		this.setVisible(false);
	}
}
