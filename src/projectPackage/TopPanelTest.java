package projectPackage;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

public class TopPanelTest extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTextField textField_1;
    private MainFrame mainFrame;
    private JTextField txtOhtani;

    public TopPanelTest(MainFrame mainFrame) {
        setLayout(null);
        this.mainFrame = mainFrame;
        JPanel panel_1 = new JPanel();
        this.setSize(1280,150);
        this.setPreferredSize(new Dimension(1280,150));
        panel_1.setBackground(Color.BLACK);
        panel_1.setBounds(0, 0, 1280, 150);
        add(panel_1);
        panel_1.setLayout(null);

        // Existing components and listeners

        JLabel imageLabel = new JLabel(new ImageIcon(TopPanelTest.class.getResource("/image/ohtani/cgving2.png")));
        imageLabel.setBounds(45, 48, 200, 51);
        panel_1.add(imageLabel);
        // imageLabel listener (if needed)

        JButton btnNewButton_1 = new JButton("");
        // btnNewButton_1 properties and listener
        panel_1.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("");
        // btnNewButton_2 properties and listener
        panel_1.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("");
        btnNewButton_3.setIcon(new ImageIcon(TopPanelTest.class.getResource("/image/button/join_s.png")));
        btnNewButton_3.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 14));
        btnNewButton_3.setBounds(1209, 20, 32, 32);
        panel_1.add(btnNewButton_3);
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.PageChange(MainFrame.PANELNAME.JOIN_AGREE);  // Assuming you have JOIN_AGREE enum in MainFrame
            }
        });

        JLabel lblNewLabel = new JLabel("C U L T U R E P L E X");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 16));
        lblNewLabel.setBounds(246, 77, 174, 15);
        panel_1.add(lblNewLabel);
        
        // Other components and setup
    }
}
