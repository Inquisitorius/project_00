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

public class MonPopup extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	MonPopup frame = new MonPopup();
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
    public MonPopup() {
    	setResizable(false);
    	setForeground(new Color(255, 255, 255));
    	setTitle("몬스터 프렌즈");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(300, 300, 700, 434);
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
        textArea.setText("“전설의 몬스터가 보고 싶어요!”\r\n \r\n\r\n몬스터들은 아무도 모르는 곳에 따로 모여사는 세상.\r\n몬스터와 친구가 되고 싶어하는 ‘한나’는 \r\n우연히 몬스터 마을을 발견한다.\r\n\r\n그곳에서 ‘한나’가 마주친 건 무시무시한 몬스터들!\r\n빨간모자와 늑대의 ‘울프걸’부터 설인의 전설 속 ‘예티’까지\r\n모두 처음 본 인간인 ‘한나’를 경계하기 시작한다.\r\n\r\n설상가상으로 악마의 사신 ‘가고일’이 자신의 은밀한 계획을 위해\r\n외눈박이 거인 ‘사이클롭스’와 함께 한나를 납치하는데…\r\n\r\n과연 ‘한나’는 몬스터들과 친구가 될 수 있을까?");
        textArea.setBounds(254, 35, 386, 325);
        contentPane.add(textArea);
        
        JLabel imageLabel = new JLabel(new ImageIcon(MonPopup.class.getResource("/image/ohtani/monsterfriends.jpg")));
        imageLabel.setBounds(50, 72, 150, 214);
        contentPane.add(imageLabel);
        
        JButton btnNewButton = new JButton("");
        btnNewButton.setIcon(new ImageIcon(MonPopup.class.getResource("/image/button/reserve.png")));
        btnNewButton.setBounds(73, 306, 110, 42);
        contentPane.add(btnNewButton);
    }
}
