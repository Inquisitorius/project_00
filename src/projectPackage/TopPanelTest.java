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

        JLabel imageLabel = new JLabel(new ImageIcon(TopPanelTest.class.getResource("/image/ohtani/cgving2.png")));
        imageLabel.setBounds(45, 48, 200, 51);
        panel_1.add(imageLabel);
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainFrame.PageChange(MainFrame.PANELNAME.MAIN);
            }
        });

        textField_1 = new JTextField();
        textField_1.setBorder(new EmptyBorder(0, 10, 0, 0));
        textField_1.setBounds(954, 73, 250, 30);
        panel_1.add(textField_1);
        textField_1.setColumns(40);
        
        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.setIcon(new ImageIcon(TopPanelTest.class.getResource("/image/button/search_s.png")));
        btnNewButton_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 14));
        btnNewButton_1.setBounds(1210, 73, 32, 32);
        panel_1.add(btnNewButton_1);
        
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchText = textField_1.getText().toLowerCase();
                switch (searchText) {
                    case "범죄도시4":
                        new CrimePopup().setVisible(true);
                        break;
                    case "쿵푸팬더4":
                        new KungfuPopup().setVisible(true);
                        break;
                    case "스턴트맨":
                        new StuntPopup().setVisible(true);
                        break;
                    case "챌린저스":
                        new ChalPopup().setVisible(true);
                        break;
                    case "몬스터 프렌즈":
                        new MonPopup().setVisible(true);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "검색 결과가 없습니다.");
                        break;
                }
            }
        });

        JButton btnNewButton_2 = new JButton("");
        btnNewButton_2.setIcon(new ImageIcon(TopPanelTest.class.getResource("/image/button/login_s.png")));
        btnNewButton_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 14));
        btnNewButton_2.setBounds(1172, 20, 32, 32);
        panel_1.add(btnNewButton_2);
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.PageChange(MainFrame.PANELNAME.LOGIN);
            }
        });

        JButton btnNewButton_3 = new JButton("");
        btnNewButton_3.setIcon(new ImageIcon(TopPanelTest.class.getResource("/image/button/join_s.png")));
        btnNewButton_3.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 14));
        btnNewButton_3.setBounds(1210, 20, 32, 32);
        panel_1.add(btnNewButton_3);
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.PageChange(MainFrame.PANELNAME.JOIN_AGREE);
            }
        });

        JLabel lblNewLabel = new JLabel("C U L T U R E P L E X");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 16));
        lblNewLabel.setBounds(246, 77, 174, 15);
        panel_1.add(lblNewLabel);
        
        txtOhtani = new JTextField();
        txtOhtani.setEditable(false);
        txtOhtani.setText("ohtani님 환영합니다.");
        txtOhtani.setBounds(1032, 30, 134, 21);
        panel_1.add(txtOhtani);
        txtOhtani.setColumns(10);

        this.setVisible(true);
    }
}
