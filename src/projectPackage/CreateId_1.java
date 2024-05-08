package projectPackage;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.ButtonGroup;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.Icon;
import java.awt.Rectangle;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class CreateId_1 extends JPanel implements ItemListener {

	private static final long serialVersionUID = 1L;
	private MainFrame mainFrame;

	/**
	 * Create the panel.
	 */
	Color bg = new Color(0xdfeff0);
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Object rbt_agree;
	private Object rbt_dagree;

	public CreateId_1(MainFrame mainFrame) {

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
		
		JLabel cgving = new JLabel(new ImageIcon(CreateId_1.class.getResource("/image/ohtani/cgving2.png")));
		cgving.setBounds(540, 20, 200, 42);
		panel.add(cgving);
		
		JLabel lb_join = new JLabel("회원가입");
		lb_join.setForeground(Color.WHITE);
		lb_join.setHorizontalAlignment(SwingConstants.CENTER);
		lb_join.setFont(new Font("여기어때 잘난체 고딕 TTF", Font.PLAIN, 25));
		lb_join.setBounds(530, 115, 220, 50);
		panel.add(lb_join);
		
		JLabel lb_terms = new JLabel("1. 개인정보 이용 약관");
		lb_terms.setForeground(Color.WHITE);
		lb_terms.setFont(new Font("나눔고딕", Font.BOLD, 12));
		lb_terms.setBounds(390, 180, 160, 20);
		panel.add(lb_terms);
		
		TextArea ta_terms = new TextArea();
		ta_terms.setBackground(Color.WHITE);
		ta_terms.setEditable(false);
		ta_terms.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus venenatis aliquam sapien et rhoncus. In sagittis, ante faucibus dictum condimentum, mi erat pretium nisl, eu congue odio magna in nulla. Aenean bibendum pulvinar porttitor. Cras nec purus diam. Sed tristique turpis ut ante semper gravida. Curabitur ac feugiat lectus. Morbi tempus interdum laoreet.\r\n\r\nPhasellus iaculis a felis in maximus. Mauris ut mattis dui, sed condimentum sem. Etiam facilisis nibh quis lorem mollis commodo. Phasellus imperdiet lorem vitae urna dignissim, ut ornare erat aliquam. Pellentesque sagittis ultricies est, eu lobortis augue facilisis id. Donec volutpat ipsum eget sem pretium elementum. Morbi tempus, tortor nec tempus accumsan, nunc mauris porttitor eros, ac pretium mi sapien venenatis lectus. Fusce luctus mauris id orci finibus vulputate. Mauris eros sapien, dictum vel hendrerit sit amet, tincidunt eget nibh. Nunc cursus vulputate justo. Cras ut velit nunc. Vestibulum gravida auctor ipsum eu dapibus. Maecenas vitae rutrum nulla. In at urna lobortis, bibendum sapien at, imperdiet tortor. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.\r\n\r\nNullam ut quam justo. Ut condimentum sapien et sem ornare, ac eleifend diam lobortis. Sed commodo sapien et neque sagittis, sit amet volutpat massa fermentum. Ut luctus, odio ut condimentum venenatis, quam nisi laoreet ipsum, id aliquet est velit id felis. Etiam mollis consequat ullamcorper. Aliquam rhoncus ligula et dui sagittis, malesuada suscipit nunc volutpat. Morbi dignissim ipsum eget sapien tincidunt, sit amet faucibus nunc congue. Fusce vitae suscipit enim. Nulla auctor dolor vitae libero sagittis maximus. Aliquam erat volutpat. Integer lacinia sagittis tristique. Nulla at ante a velit pretium iaculis.\r\n\r\nNulla luctus pharetra odio vehicula accumsan. Ut ultricies est in orci hendrerit, at sodales sem ullamcorper. Mauris viverra iaculis dolor, sed scelerisque eros commodo vel. Morbi nunc nisl, pulvinar tincidunt imperdiet et, commodo eget elit. Aenean velit libero, ornare eu faucibus sit amet, bibendum nec nisi. Fusce egestas accumsan tellus, at sagittis mi finibus ut. Curabitur mauris mauris, consequat vel elementum at, faucibus et orci. Curabitur nunc ligula, feugiat vitae venenatis eu, laoreet vitae dolor. Etiam lectus dui, faucibus ac commodo et, hendrerit in est. Etiam blandit eros eu neque elementum, vitae porta justo sagittis. Integer sapien augue, vulputate eget sapien sed, tempus ornare ipsum. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nulla porta sollicitudin enim, sed pharetra velit viverra ut. Quisque molestie ante in elit vestibulum maximus. Nulla libero leo, dictum in dolor eu, molestie porttitor arcu. Ut maximus erat vitae malesuada ultrices.\r\n\r\nUt a velit ut mauris eleifend blandit. Ut et elementum ex, at molestie dui. Duis hendrerit tristique neque porta tristique. Vestibulum suscipit, nunc commodo viverra ullamcorper, risus magna venenatis quam, in pulvinar nibh justo dictum orci. Aenean sagittis nisl ut imperdiet fermentum. Nam erat diam, lacinia at lacus sed, sodales suscipit ligula. Sed vestibulum mollis odio non egestas. Pellentesque vitae nulla tincidunt, condimentum enim vel, gravida mi. Proin sed scelerisque metus. Pellentesque a nibh placerat magna mollis rutrum in nec ligula. Donec eleifend ac odio vitae vestibulum. Maecenas vestibulum lacus non odio interdum, eu accumsan lorem pretium. Integer eget blandit est.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus venenatis aliquam sapien et rhoncus. In sagittis, ante faucibus dictum condimentum, mi erat pretium nisl, eu congue odio magna in nulla. Aenean bibendum pulvinar porttitor. Cras nec purus diam. Sed tristique turpis ut ante semper gravida. Curabitur ac feugiat lectus. Morbi tempus interdum laoreet.\r\n\r\nPhasellus iaculis a felis in maximus. Mauris ut mattis dui, sed condimentum sem. Etiam facilisis nibh quis lorem mollis commodo. Phasellus imperdiet lorem vitae urna dignissim, ut ornare erat aliquam. Pellentesque sagittis ultricies est, eu lobortis augue facilisis id. Donec volutpat ipsum eget sem pretium elementum. Morbi tempus, tortor nec tempus accumsan, nunc mauris porttitor eros, ac pretium mi sapien venenatis lectus. Fusce luctus mauris id orci finibus vulputate. Mauris eros sapien, dictum vel hendrerit sit amet, tincidunt eget nibh. Nunc cursus vulputate justo. Cras ut velit nunc. Vestibulum gravida auctor ipsum eu dapibus. Maecenas vitae rutrum nulla. In at urna lobortis, bibendum sapien at, imperdiet tortor. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.\r\n\r\nNullam ut quam justo. Ut condimentum sapien et sem ornare, ac eleifend diam lobortis. Sed commodo sapien et neque sagittis, sit amet volutpat massa fermentum. Ut luctus, odio ut condimentum venenatis, quam nisi laoreet ipsum, id aliquet est velit id felis. Etiam mollis consequat ullamcorper. Aliquam rhoncus ligula et dui sagittis, malesuada suscipit nunc volutpat. Morbi dignissim ipsum eget sapien tincidunt, sit amet faucibus nunc congue. Fusce vitae suscipit enim. Nulla auctor dolor vitae libero sagittis maximus. Aliquam erat volutpat. Integer lacinia sagittis tristique. Nulla at ante a velit pretium iaculis.\r\n\r\nNulla luctus pharetra odio vehicula accumsan. Ut ultricies est in orci hendrerit, at sodales sem ullamcorper. Mauris viverra iaculis dolor, sed scelerisque eros commodo vel. Morbi nunc nisl, pulvinar tincidunt imperdiet et, commodo eget elit. Aenean velit libero, ornare eu faucibus sit amet, bibendum nec nisi. Fusce egestas accumsan tellus, at sagittis mi finibus ut. Curabitur mauris mauris, consequat vel elementum at, faucibus et orci. Curabitur nunc ligula, feugiat vitae venenatis eu, laoreet vitae dolor. Etiam lectus dui, faucibus ac commodo et, hendrerit in est. Etiam blandit eros eu neque elementum, vitae porta justo sagittis. Integer sapien augue, vulputate eget sapien sed, tempus ornare ipsum. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nulla porta sollicitudin enim, sed pharetra velit viverra ut. Quisque molestie ante in elit vestibulum maximus. Nulla libero leo, dictum in dolor eu, molestie porttitor arcu. Ut maximus erat vitae malesuada ultrices.\r\n\r\nUt a velit ut mauris eleifend blandit. Ut et elementum ex, at molestie dui. Duis hendrerit tristique neque porta tristique. Vestibulum suscipit, nunc commodo viverra ullamcorper, risus magna venenatis quam, in pulvinar nibh justo dictum orci. Aenean sagittis nisl ut imperdiet fermentum. Nam erat diam, lacinia at lacus sed, sodales suscipit ligula. Sed vestibulum mollis odio non egestas. Pellentesque vitae nulla tincidunt, condimentum enim vel, gravida mi. Proin sed scelerisque metus. Pellentesque a nibh placerat magna mollis rutrum in nec ligula. Donec eleifend ac odio vitae vestibulum. Maecenas vestibulum lacus non odio interdum, eu accumsan lorem pretium. Integer eget blandit est.");
		ta_terms.setBounds(390, 200, 500, 200);
		panel.add(ta_terms);
		
		JRadioButton rbt_agree = new JRadioButton("약관에 동의함");
		rbt_agree.setBackground(Color.BLACK);
		rbt_agree.setForeground(Color.WHITE);
		rbt_agree.setFont(new Font("나눔고딕", Font.BOLD, 12));
		rbt_agree.setBounds(770, 435, 120, 25);
		panel.add(rbt_agree);
		buttonGroup.add(rbt_agree);
		
		JRadioButton rbt_dagree = new JRadioButton("약관에 동의안함");
		rbt_dagree.setBackground(Color.BLACK);
		rbt_dagree.setForeground(Color.WHITE);
		rbt_dagree.setSelected(true);
		rbt_dagree.setFont(new Font("나눔고딕", Font.BOLD, 12));
		rbt_dagree.setBounds(770, 410, 120, 25);
		panel.add(rbt_dagree);
		buttonGroup.add(rbt_dagree);
		
		
			
		JButton bt_next = new JButton("");
		bt_next.setIcon(new ImageIcon(CreateId_1.class.getResource("/image/seungho/bt_next.png")));
		bt_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("go to Class[create_2(JOIN2)]");
				setVisible(false);
				mainFrame.PageChange(MainFrame.PANELNAME.JOIN2);
				setVisible(true);
			}
		});
		bt_next.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		bt_next.setBounds(390, 500, 500, 50);
		panel.add(bt_next);
		
//		JPanel border = new JPanel();
//		border.setOpaque(false);
//		border.setFocusTraversalKeysEnabled(false);
//		border.setEnabled(false);
//		border.setDoubleBuffered(false);
//		border.setBorder(new LineBorder(new Color(255, 51, 51)));
//		border.setBounds(356, 75, 587, 512);
//		panel.add(border);
		
//		JLabel lblNewLabel_2 = new JLabel("New label");
//		lblNewLabel_2.setIcon(new ImageIcon("E:\\KDTFullStackClass\\TeamProject1\\img\\screen\\agreement.png"));
//		lblNewLabel_2.setBounds(0, 0, 1280, 650);
//		panel.add(lblNewLabel_2);

		this.setVisible(false);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object btg = e.getItem();
		if(btg == rbt_agree)
			new CreateId_2(mainFrame);
		else if (btg == rbt_dagree)
			System.out.println("동의함을 눌러주세요");
			
	}
}