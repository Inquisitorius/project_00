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
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class ShCreatIDA extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainFrame mainFrame;

	/**
	 * Create the panel.
	 */
	Color bg = new Color(0xdfeff0);
	
	public ShCreatIDA(MainFrame mainFrame) {

		this.mainFrame = mainFrame;
		this.setSize(1280, 800 - 150);
		this.setPreferredSize(new Dimension(1280, 800 - 150));
		this.setBackground(bg);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1280, 650);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 50));
		lblNewLabel.setBounds(530, 39, 220, 50);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("다   음");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNewButton_1.setBounds(393, 477, 500, 50);
		panel.add(btnNewButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("약관에 동의함");
		rdbtnNewRadioButton.setBounds(772, 400, 121, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("약관에 동의안함");
		rdbtnNewRadioButton_1.setBounds(772, 360, 121, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("1. 개인정보 이용 약관");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(393, 115, 160, 20);
		panel.add(lblNewLabel_1);
		
		TextArea textArea = new TextArea();
		textArea.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus venenatis aliquam sapien et rhoncus. In sagittis, ante faucibus dictum condimentum, mi erat pretium nisl, eu congue odio magna in nulla. Aenean bibendum pulvinar porttitor. Cras nec purus diam. Sed tristique turpis ut ante semper gravida. Curabitur ac feugiat lectus. Morbi tempus interdum laoreet.\r\n\r\nPhasellus iaculis a felis in maximus. Mauris ut mattis dui, sed condimentum sem. Etiam facilisis nibh quis lorem mollis commodo. Phasellus imperdiet lorem vitae urna dignissim, ut ornare erat aliquam. Pellentesque sagittis ultricies est, eu lobortis augue facilisis id. Donec volutpat ipsum eget sem pretium elementum. Morbi tempus, tortor nec tempus accumsan, nunc mauris porttitor eros, ac pretium mi sapien venenatis lectus. Fusce luctus mauris id orci finibus vulputate. Mauris eros sapien, dictum vel hendrerit sit amet, tincidunt eget nibh. Nunc cursus vulputate justo. Cras ut velit nunc. Vestibulum gravida auctor ipsum eu dapibus. Maecenas vitae rutrum nulla. In at urna lobortis, bibendum sapien at, imperdiet tortor. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.\r\n\r\nNullam ut quam justo. Ut condimentum sapien et sem ornare, ac eleifend diam lobortis. Sed commodo sapien et neque sagittis, sit amet volutpat massa fermentum. Ut luctus, odio ut condimentum venenatis, quam nisi laoreet ipsum, id aliquet est velit id felis. Etiam mollis consequat ullamcorper. Aliquam rhoncus ligula et dui sagittis, malesuada suscipit nunc volutpat. Morbi dignissim ipsum eget sapien tincidunt, sit amet faucibus nunc congue. Fusce vitae suscipit enim. Nulla auctor dolor vitae libero sagittis maximus. Aliquam erat volutpat. Integer lacinia sagittis tristique. Nulla at ante a velit pretium iaculis.\r\n\r\nNulla luctus pharetra odio vehicula accumsan. Ut ultricies est in orci hendrerit, at sodales sem ullamcorper. Mauris viverra iaculis dolor, sed scelerisque eros commodo vel. Morbi nunc nisl, pulvinar tincidunt imperdiet et, commodo eget elit. Aenean velit libero, ornare eu faucibus sit amet, bibendum nec nisi. Fusce egestas accumsan tellus, at sagittis mi finibus ut. Curabitur mauris mauris, consequat vel elementum at, faucibus et orci. Curabitur nunc ligula, feugiat vitae venenatis eu, laoreet vitae dolor. Etiam lectus dui, faucibus ac commodo et, hendrerit in est. Etiam blandit eros eu neque elementum, vitae porta justo sagittis. Integer sapien augue, vulputate eget sapien sed, tempus ornare ipsum. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nulla porta sollicitudin enim, sed pharetra velit viverra ut. Quisque molestie ante in elit vestibulum maximus. Nulla libero leo, dictum in dolor eu, molestie porttitor arcu. Ut maximus erat vitae malesuada ultrices.\r\n\r\nUt a velit ut mauris eleifend blandit. Ut et elementum ex, at molestie dui. Duis hendrerit tristique neque porta tristique. Vestibulum suscipit, nunc commodo viverra ullamcorper, risus magna venenatis quam, in pulvinar nibh justo dictum orci. Aenean sagittis nisl ut imperdiet fermentum. Nam erat diam, lacinia at lacus sed, sodales suscipit ligula. Sed vestibulum mollis odio non egestas. Pellentesque vitae nulla tincidunt, condimentum enim vel, gravida mi. Proin sed scelerisque metus. Pellentesque a nibh placerat magna mollis rutrum in nec ligula. Donec eleifend ac odio vitae vestibulum. Maecenas vestibulum lacus non odio interdum, eu accumsan lorem pretium. Integer eget blandit est.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus venenatis aliquam sapien et rhoncus. In sagittis, ante faucibus dictum condimentum, mi erat pretium nisl, eu congue odio magna in nulla. Aenean bibendum pulvinar porttitor. Cras nec purus diam. Sed tristique turpis ut ante semper gravida. Curabitur ac feugiat lectus. Morbi tempus interdum laoreet.\r\n\r\nPhasellus iaculis a felis in maximus. Mauris ut mattis dui, sed condimentum sem. Etiam facilisis nibh quis lorem mollis commodo. Phasellus imperdiet lorem vitae urna dignissim, ut ornare erat aliquam. Pellentesque sagittis ultricies est, eu lobortis augue facilisis id. Donec volutpat ipsum eget sem pretium elementum. Morbi tempus, tortor nec tempus accumsan, nunc mauris porttitor eros, ac pretium mi sapien venenatis lectus. Fusce luctus mauris id orci finibus vulputate. Mauris eros sapien, dictum vel hendrerit sit amet, tincidunt eget nibh. Nunc cursus vulputate justo. Cras ut velit nunc. Vestibulum gravida auctor ipsum eu dapibus. Maecenas vitae rutrum nulla. In at urna lobortis, bibendum sapien at, imperdiet tortor. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.\r\n\r\nNullam ut quam justo. Ut condimentum sapien et sem ornare, ac eleifend diam lobortis. Sed commodo sapien et neque sagittis, sit amet volutpat massa fermentum. Ut luctus, odio ut condimentum venenatis, quam nisi laoreet ipsum, id aliquet est velit id felis. Etiam mollis consequat ullamcorper. Aliquam rhoncus ligula et dui sagittis, malesuada suscipit nunc volutpat. Morbi dignissim ipsum eget sapien tincidunt, sit amet faucibus nunc congue. Fusce vitae suscipit enim. Nulla auctor dolor vitae libero sagittis maximus. Aliquam erat volutpat. Integer lacinia sagittis tristique. Nulla at ante a velit pretium iaculis.\r\n\r\nNulla luctus pharetra odio vehicula accumsan. Ut ultricies est in orci hendrerit, at sodales sem ullamcorper. Mauris viverra iaculis dolor, sed scelerisque eros commodo vel. Morbi nunc nisl, pulvinar tincidunt imperdiet et, commodo eget elit. Aenean velit libero, ornare eu faucibus sit amet, bibendum nec nisi. Fusce egestas accumsan tellus, at sagittis mi finibus ut. Curabitur mauris mauris, consequat vel elementum at, faucibus et orci. Curabitur nunc ligula, feugiat vitae venenatis eu, laoreet vitae dolor. Etiam lectus dui, faucibus ac commodo et, hendrerit in est. Etiam blandit eros eu neque elementum, vitae porta justo sagittis. Integer sapien augue, vulputate eget sapien sed, tempus ornare ipsum. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nulla porta sollicitudin enim, sed pharetra velit viverra ut. Quisque molestie ante in elit vestibulum maximus. Nulla libero leo, dictum in dolor eu, molestie porttitor arcu. Ut maximus erat vitae malesuada ultrices.\r\n\r\nUt a velit ut mauris eleifend blandit. Ut et elementum ex, at molestie dui. Duis hendrerit tristique neque porta tristique. Vestibulum suscipit, nunc commodo viverra ullamcorper, risus magna venenatis quam, in pulvinar nibh justo dictum orci. Aenean sagittis nisl ut imperdiet fermentum. Nam erat diam, lacinia at lacus sed, sodales suscipit ligula. Sed vestibulum mollis odio non egestas. Pellentesque vitae nulla tincidunt, condimentum enim vel, gravida mi. Proin sed scelerisque metus. Pellentesque a nibh placerat magna mollis rutrum in nec ligula. Donec eleifend ac odio vitae vestibulum. Maecenas vestibulum lacus non odio interdum, eu accumsan lorem pretium. Integer eget blandit est.");
		textArea.setBounds(393, 152, 500, 182);
		panel.add(textArea);

		this.setVisible(false);
	}
}
