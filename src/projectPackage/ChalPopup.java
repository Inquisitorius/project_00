package projectPackage;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.Icon;


public class ChalPopup extends JFrame {
	

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private OhtanisPanel parentPanel; 
 
    public ChalPopup(OhtanisPanel parentPanel) {
    	setTitle("챌린저스");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(300, 300, 700, 434);
        setResizable(false);
        this.parentPanel = parentPanel;
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBorder(new EmptyBorder(10, 10, 0, 0));
        
        textArea.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
        textArea.setText("테니스 코트 밖, 진짜 경쟁이 시작된다!\r\n\r\n스타급의 인기를 누리던 테니스 천재 ‘타시’(젠데이아)는\r\n부상으로 인해 더 이상 선수 생활을 하지 못하고\r\n지금은 남편 ‘아트’(마이크 파이스트)의 코치를 맡고 있다.\r\n\r\n연패 슬럼프에서 빠져나오지 못하는 ‘아트’를\r\n챌린저급 대회에 참가시킨 ‘타시’는\r\n남편과 둘도 없는 친구 사이이자\r\n자신의 전 남친인 ‘패트릭’(조쉬 오코너)를 다시 만나게 된다.\r\n\r\n선 넘는 세 남녀의 아슬아슬한 관계는 \r\n테니스 코트 밖에서 더욱 격렬하게 이어지는데…\r\n\r\n결승전 D-DAY,\r\n가장 매혹적인 랠리가 시작된다!");
        textArea.setBounds(254, 35, 386, 325);
        contentPane.add(textArea);
        
        JLabel imageLabel = new JLabel(new ImageIcon(ChalPopup.class.getResource("/image/ohtani/challengers.jpg")));
        imageLabel.setBounds(50, 72, 150, 214);
        contentPane.add(imageLabel);
        
        JButton btnNewButton = new JButton("");
        btnNewButton.setBorderPainted(false);
        btnNewButton.setIcon(new ImageIcon(ChalPopup.class.getResource("/image/button/reserve.png")));
        btnNewButton.setBounds(73, 306, 110, 42);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//progress
        		parentPanel.TicketMove();
        	}
        });
        
        contentPane.add(btnNewButton);
        
    }
}
