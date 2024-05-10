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

public class CrimePopup extends JFrame {

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
    public CrimePopup() {
    	setTitle("범죄도시4");
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
        textArea.setText("신종 마약 사건 3년 뒤,\r\n괴물형사 ‘마석도’(마동석)와 서울 광수대는\r\n배달앱을 이용한 마약 판매 사건을 수사하던 중\r\n수배 중인 앱 개발자가 필리핀에서 사망한 사건이\r\n대규모 온라인 불법 도박 조직과 연관되어 있음을 알아낸다.\r\n\r\n필리핀에 거점을 두고 납치, 감금, 폭행, 살인 등으로\r\n대한민국 온라인 불법 도박 시장을 장악한\r\n특수부대 용병 출신의 빌런 ‘백창기’(김무열)와\r\n한국에서 더 큰 판을 짜고 있는 IT업계 천재 CEO ‘장동철’(이동휘).\r\n\r\n‘마석도’는 더 커진 판을 잡기 위해\r\n‘장이수’(박지환)에게 뜻밖의 협력을 제안하고\r\n광역수사대는 물론,\r\n사이버수사대까지 합류해 범죄를 소탕하기 시작하는데…\r\n\r\n나쁜 놈 잡는데 국경도 영역도 제한 없다!\r\n업그레이드 소탕 작전! 거침없이 싹 쓸어버린다!");
        textArea.setBounds(254, 35, 386, 325);
        contentPane.add(textArea);
        
        JLabel imageLabel = new JLabel(new ImageIcon(CrimePopup.class.getResource("/image/ohtani/crimetown.jpg")));
        imageLabel.setBounds(50, 72, 150, 214);
        contentPane.add(imageLabel);
        
        JButton btnNewButton = new JButton("");
        btnNewButton.setBorderPainted(false);
        btnNewButton.setIcon(new ImageIcon(CrimePopup.class.getResource("/image/button/reserve.png")));
        btnNewButton.setBounds(73, 306, 110, 42);
        contentPane.add(btnNewButton);
        
    }
}
