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


public class StuntPopup extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	StuntPopup frame = new StuntPopup();
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
    public StuntPopup() {
    	setTitle("스턴트맨");
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
        textArea.setText("사람도 구하고, 영화도 구하고, X도 구하려다 X됐다…!\r\n \r\n잠수 이별을 택하고 후회뿐인 날을 보내던\r\n스턴트맨 ‘콜트’(라이언 고슬링)\r\n영화감독이 된 전 여친 ‘조디’(에밀리 블런트)의\r\n촬영장에 복귀하며 아련한 재회를 기대했\r\n지만… 갑자기 주연배우가 사라지고\r\n콜트는 우선 그부터 찾아야만 한다!\r\n \r\n<데드풀 2> 감독이 말아주는 코미디, 액션, 로맨스 장르 풀코스\r\n액션도 터지고, 사랑도 터지고, 웃음도 터진다!");
        textArea.setBounds(254, 35, 386, 325);
        contentPane.add(textArea);
        
        JLabel imageLabel = new JLabel(new ImageIcon(StuntPopup.class.getResource("/image/ohtani/stuntman.jpg")));
        imageLabel.setBounds(50, 72, 150, 214);
        contentPane.add(imageLabel);
        
        JButton btnNewButton = new JButton("");
        btnNewButton.setIcon(new ImageIcon(StuntPopup.class.getResource("/image/button/reserve.png")));
        btnNewButton.setBounds(73, 306, 110, 42);
        contentPane.add(btnNewButton);
    }
}
