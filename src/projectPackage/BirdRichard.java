package projectPackage;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import java.awt.TextArea;
import javax.swing.border.EmptyBorder;


public class BirdRichard extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainFrame mainFrame;


	/**
	 * Create the panel.
	 */
	public BirdRichard(MainFrame mainFrame) {
		setBorder(new EmptyBorder(10, 10, 0, 0));

		this.mainFrame = mainFrame;

		setLayout(null);
		this.setSize(1280, 800 - 150);
		this.setPreferredSize(new Dimension(1280, 760));
		this.setBackground(new Color(0, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(BirdRichard.class.getResource("/image/ohtani/birdrichard2.jpg")));
		lblNewLabel_1.setBounds(280, 46, 150, 214);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("꼬마참새 리차드-신비한 보석 탐험대 ");
		lblNewLabel_2.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 28));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(464, 26, 492, 62);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Richard the Stork and the Mystery of the Great Jewel");
		lblNewLabel_3.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 12));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(464, 76, 648, 15);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("예매율 3.2%");
		lblNewLabel_4.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 14));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(464, 96, 78, 25);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("감독 : 메테 탕에 ,  벤자민 쿠아벡 / 배우 : \r\n정의진 ,  박시윤 ,  김용 ,  김아롱 ,  서정익 ,  정해은");
		lblNewLabel_5.setFont(new Font("나눔고딕", Font.BOLD, 12));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(464, 131, 590, 15);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("장르 : 애니메이션 / 기본 정보 : \r\n전체관람가, 85분, 노르웨이, 독일, 벨기에");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("나눔고딕", Font.BOLD, 12));
		lblNewLabel_6.setBounds(464, 156, 590, 15);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("개봉 : \r\n2024.05.01");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 12));
		lblNewLabel_7.setBounds(464, 181, 590, 15);
		add(lblNewLabel_7);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(BirdRichard.class.getResource("/image/button/reserve.png")));
		btnNewButton_1.setBounds(464, 213, 110, 42);
		add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(BirdRichard.class.getResource("/image/ohtani/egg2.png")));
		lblNewLabel.setBounds(554, 94, 32, 32);
		add(lblNewLabel);
		
		JLabel lblNewLabel_4_1 = new JLabel("99%");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(586, 96, 39, 25);
		add(lblNewLabel_4_1);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setForeground(new Color(255, 255, 255));
		textArea_1.setBackground(new Color(0, 0, 0));
		textArea_1.setText("황새가 키운 최강 꼬마참새 ‘리차드’가 돌아왔다!\r\n\r\n \r\n아프리카의 해변에서 황새 가족의 따듯한 보살핌 속에\r\n\r\n\r\n뛰어난 비행 실력을 지닌 용감한 참새로 자란 ‘리차드’.\r\n \r\n\r\n어느 날 ‘리차드’는 친구인 앵무새 ‘키키’, 올빼미 ‘올가’와 함께\r\n\r\n\r\n우연히 위험천만한 사막을 지나 신비로운 도시에 도착하게 된다.\r\n\r\n \r\n하지만 그들은 곧 공작새 ‘자마노’의 부하인\r\n\r\n\r\n대머리황새들에게 공격을 당하고\r\n\r\n\r\n도시 참새의 리더 ‘사미아’의 도움을 받아\r\n\r\n\r\n가까스로 위기에서 벗어난다.\r\n\r\n\r\n자신을 구해준 도시 참새들이 탐욕스러운\r\n\r\n\r\n‘자마노’에게 잡혀 있다는 사실을 알게 된\r\n\r\n\r\n‘리차드’와 친구들은 이제 그들을\r\n\r\n\r\n구하기 위해 전설 속 보석을 찾기로 결심하는데…\r\n\r\n\r\n더 빠르게! 더 신나게! 더 높게!\r\n\r\n\r\n신비한 보석을 찾아 아프리카 속으로 훨훨 날아볼까?");
		textArea_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 12));
		textArea_1.setEditable(false);
		textArea_1.setBounds(464, 275, 460, 375);
		add(textArea_1);

		try {

			

		} catch (Exception e) {
			e.printStackTrace();
		}

		this.setVisible(false);
	}
}
