package projectPackage;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.Icon;

public class KungfuPopup extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CrimePopup frame = new CrimePopup();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public KungfuPopup() {
    	setTitle("쿵푸팬더4");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(300, 300, 700, 434);
        setResizable(false);
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
        textArea.setText("오랜만이지! 드림웍스 레전드 시리즈 마침내 컴백!\r\n\r\n마침내 내면의 평화… 냉면의 평화…가 찾아왔다고 믿는 용의 전사 ‘포’\r\n이젠 평화의 계곡의 영적 지도자가 되고, \r\n자신을 대신할 후계자를 찾아야만 한다.\r\n“이제 용의 전사는 그만둬야 해요?”\r\n\r\n용의 전사로의 모습이 익숙해지고 새로운 성장을 하기보다 \r\n지금 이대로가 좋은 ‘포’\r\n하지만 모든 쿵푸 마스터들의 능력을 그대로 복제하는 강력한 빌런 \r\n‘카멜레온’이 나타나고\r\n그녀를 막기 위해 정체를 알 수 없는 쿵푸 고수 ‘젠’과 함께 \r\n모험을 떠나게 되는데…\r\n포는 가장 강력한 빌런과 자기 자신마저 뛰어넘고 \r\n진정한 변화를 할 수 있을까?");
        textArea.setBounds(254, 35, 386, 325);
        contentPane.add(textArea);
        
        JLabel imageLabel = new JLabel(new ImageIcon(KungfuPopup.class.getResource("/image/ohtani/kungfupanda.jpg")));
        imageLabel.setBounds(50, 72, 150, 214);
        contentPane.add(imageLabel);
        
        JButton btnNewButton = new JButton("");
        btnNewButton.setIcon(new ImageIcon(KungfuPopup.class.getResource("/image/button/reserve.png")));
        btnNewButton.setBounds(73, 306, 110, 42);
        contentPane.add(btnNewButton);
    }
}
