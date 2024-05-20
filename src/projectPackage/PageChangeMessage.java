package projectPackage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class PageChangeMessage extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private MainFrame mainFrame;
	private PageChangeMessage thisObj;
	private MainFrame.PANELNAME pageSave;
	
	
	private JLabel lblNewLabel;
	
	public PageChangeMessage(MainFrame mainFrame) {		
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.mainFrame = mainFrame;
		
		thisObj = this;
		
		setBounds(760, 400, 453, 141);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 413, 55);
		contentPanel.add(lblNewLabel);
		
		this.setTitle("CGVING");
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(PageChangeMessage.class.getResource("/image/button/ok.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				mainFrame.PageChange(pageSave);
				thisObj.setVisible(false);
			}
		});
		btnNewButton.setBounds(315, 50, 110, 42);
		contentPanel.add(btnNewButton);
		
		this.setVisible(false);
	}
	
	public void PopupVisible(String value, MainFrame.PANELNAME PAGETYPE)
	{
		this.lblNewLabel.setText(value);
		this.pageSave = PAGETYPE;
		
		this.setVisible(true);
	}
	
}
