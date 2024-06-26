package projectPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.border.EmptyBorder;

import projectPackage.MainFrame.PANELNAME;

public class JoinAgree extends JPanel {

    private static final long serialVersionUID = 1L;
    private MainFrame mainFrame;
    private JTextField textField_1;  // 아이디 필드
    private JPasswordField passwordField_1;  // 비밀번호 필드
    private JPasswordField passwordField_2;  // 비밀번호 확인 필드
    private JTextField textField_2;  // 이름 필드
    private JTextField textField_3;  // 이메일 필드
    private JTextField textField_4;  // 휴대전화 필드
    private Checkbox checkbox_1, checkbox_2, checkbox_3;

    public JoinAgree(MainFrame mainFrame) {
        
        this.mainFrame = mainFrame;
        setBackground(Color.BLACK);
        this.setSize(1280, 800 - 150);
        this.setPreferredSize(new Dimension(1280, 800 - 150));
        this.setVisible(false);
        setLayout(null);

        TextArea textArea_1 = new TextArea();
        textArea_1.setEditable(false);
        textArea_1.setFont(new Font("나눔고딕", Font.PLAIN, 11));
        textArea_1.setText("제1조 목적\r\n\r\n본 이용약관은 “CGVING”(이하 \"사이트\")의 서비스의 이용조건과 운영에 관한 제반 사항 규정을 목적으로 합니다.\r\n\r\n제2조 용어의 정의\r\n\r\n본 약관에서 사용되는 주요한 용어의 정의는 다음과 같습니다.\r\n\r\n① 회원 : 사이트의 약관에 동의하고 개인정보를 제공하여 회원등록을 한 자로서, 사이트와의 이용계약을 체결하고 사이트를 이용하는 이용자를 말합니다.\r\n② 이용계약 : 사이트 이용과 관련하여 사이트와 회원간에 체결 하는 계약을 말합니다.\r\n③ 회원 아이디(이하 \"ID\") : 회원의 식별과 회원의 서비스 이용을 위하여 회원별로 부여하는 고유한 문자와 숫자의 조합을 말합니다.\r\n④ 비밀번호 : 회원이 부여받은 ID와 일치된 회원임을 확인하고 회원의 권익 보호를 위하여 회원이 선정한 문자와 숫자의 조합을 말합니다.\r\n⑤ 운영자 : 서비스에 홈페이지를 개설하여 운영하는 운영자를 말합니다.\r\n⑥ 해지 : 회원이 이용계약을 해약하는 것을 말합니다.\r\n\r\n제3조 약관 외 준칙\r\n\r\n운영자는 필요한 경우 별도로 운영정책을 공지 안내할 수 있으며, 본 약관과 운영정책이 중첩될 경우 운영정책이 우선 적용됩니다.\r\n\r\n제4조 이용계약 체결\r\n\r\n① 이용계약은 회원으로 등록하여 사이트를 이용하려는 자의 본 약관 내용에 대한 동의와 가입신청에 대하여 운영자의 이용승낙으로 성립합니다.\r\n② 회원으로 등록하여 서비스를 이용하려는 자는 사이트 가입신청 시 본 약관을 읽고 아래에 있는 \"동의합니다\"를 선택하는 것으로 본 약관에 대한 동의 의사 표시를 합니다.\r\n\r\n제5조 서비스 이용 신청\r\n\r\n① 회원으로 등록하여 사이트를 이용하려는 이용자는 사이트에서 요청하는 제반정보(이용자ID,비밀번호, 닉네임 등)를 제공해야 합니다.\r\n② 타인의 정보를 도용하거나 허위의 정보를 등록하는 등 본인의 진정한 정보를 등록하지 않은 회원은 사이트 이용과 관련하여 아무런 권리를 주장할 수 없으며, 관계 법령에 따라 처벌받을 수 있습니다.\r\n\r\n제6조 개인정보처리방침\r\n\r\n사이트 및 운영자는 회원가입 시 제공한 개인정보 중 비밀번호를 가지고 있지 않으며 이와 관련된 부분은 사이트의 개인정보처리방침을 따릅니다.\r\n운영자는 관계 법령이 정하는 바에 따라 회원등록정보를 포함한 회원의 개인정보를 보호하기 위하여 노력합니다.\r\n\r\n회원의 개인정보보호에 관하여 관계법령 및 사이트가 정하는 개인정보처리방침에 정한 바에 따릅니다.\r\n\r\n단, 회원의 귀책 사유로 인해 노출된 정보에 대해 운영자는 일체의 책임을 지지 않습니다.\r\n운영자는 회원이 미풍양속에 저해되거나 국가안보에 위배되는 게시물 등 위법한 게시물을 등록 · 배포할 경우 관련 기관의 요청이 있을 시 회원의 자료를 열람 및 해당 자료를 관련 기관에 제출할 수 있습니다.\r\n\r\n제7조 운영자의 의무\r\n\r\n① 운영자는 이용회원으로부터 제기되는 의견이나 불만이 정당하다고 인정할 경우에는 가급적 빨리 처리하여야 합니다. 다만, 개인적인 사정으로 신속한 처리가 곤란한 경우에는 사후에 공지 또는 이용회원에게 쪽지, 전자우편 등을 보내는 등 최선을 다합니다.\r\n② 운영자는 계속적이고 안정적인 사이트 제공을 위하여 설비에 장애가 생기거나 유실된 때에는 이를 지체 없이 수리 또는 복구할 수 있도록 사이트에 요구할 수 있습니다. 다만, 천재지변 또는 사이트나 운영자에 부득이한 사유가 있는 경우, 사이트 운영을 일시 정지할 수 있습니다.\r\n\r\n제8조 회원의 의무\r\n\r\n① 회원은 본 약관에서 규정하는 사항과 운영자가 정한 제반 규정, 공지사항 및 운영정책 등 사이트가 공지하는 사항 및 관계 법령을 준수하여야 하며, 기타 사이트의 업무에 방해가 되는 행위, 사이트의 명예를 손상하는 행위를 해서는 안 됩니다.\r\n② 회원은 사이트의 명시적 동의가 없는 한 서비스의 이용 권한, 기타 이용계약상 지위를 타인에게 양도, 증여할 수 없으며, 이를 담보로 제공할 수 없습니다.\r\n③ 이용고객은 아이디 및 비밀번호 관리에 상당한 주의를 기울여야 하며, 운영자나 사이트의 동의 없이 제3자에게 아이디를 제공하여 이용하게 할 수 없습니다.\r\n④ 회원은 운영자와 사이트 및 제3자의 지적 재산권을 침해해서는 안 됩니다.\r\n\r\n제9조 서비스 이용 시간\r\n\r\n① 서비스 이용 시간은 업무상 또는 기술상 특별한 지장이 없는 한 연중무휴 1일 24시간을 원칙으로 합니다. 단, 사이트는 시스템 정기점검, 증설 및 교체를 위해 사이트가 정한 날이나 시간에 서비스를 일시중단 할 수 있으며 예정된 작업으로 인한 서비스 일시 중단은 사이트의 홈페이지에 사전에 공지하오니 수시로 참고하시길 바랍니다.\r\n② 단, 사이트는 다음 경우에 대하여 사전 공지나 예고 없이 서비스를 일시적 혹은 영구적으로 중단할 수 있습니다.\r\n- 긴급한 시스템 점검, 증설, 교체, 고장 혹은 오동작을 일으키는 경우\r\n- 국가비상사태, 정전, 천재지변 등의 불가항력적인 사유가 있는 경우\r\n- 전기통신사업법에 규정된 기간통신사업자가 전기통신 서비스를 중지한 경우\r\n- 서비스 이용의 폭주 등으로 정상적인 서비스 이용에 지장이 있는 경우\r\n③ 전항에 의한 서비스 중단의 경우 사이트는 사전에 공지사항 등을 통하여 회원에게 통지합니다. 단, 사이트가 통제할 수 없는 사유로 발생한 서비스의 중단에 대하여 사전공지가 불가능한 경우에는 사후공지로 대신합니다.\r\n\r\n제10조 서비스 이용 해지\r\n\r\n① 회원이 사이트와의 이용계약을 해지하고자 하는 경우에는 회원 본인이 온라인을 통하여 등록해지 신청을 하여야 합니다. 한편, 사이트 이용 해지와 별개로 사이트에 대한 이용계약 해지는 별도로 하셔야 합니다.\r\n② 해지 신청과 동시에 사이트가 제공하는 사이트 관련 프로그램이 회원 관리 화면에서 자동적으로 삭제됨으로 운영자는 더 이상 해지신청자의 정보를 볼 수 없습니다.\r\n\r\n제11조 서비스 이용 제한\r\n\r\n회원은 다음 각호에 해당하는 행위를 하여서는 아니 되며 해당 행위를 한 경우에 사이트는 회원의 서비스 이용 제한 및 적법한 조치를 할 수 있으며 이용계약을 해지하거나 기간을 정하여 서비스를 중지할 수 있습니다.\r\n① 회원 가입시 혹은 가입 후 정보 변경 시 허위 내용을 등록하는 행위\r\n② 타인의 사이트 이용을 방해하거나 정보를 도용하는 행위\r\n③ 사이트의 운영진, 직원 또는 관계자를 사칭하는 행위\r\n④ 사이트, 기타 제3자의 인격권 또는 지적재산권을 침해하거나 업무를 방해하는 행위\r\n⑤ 다른 회원의 ID를 부정하게 사용하는 행위\r\n⑥ 다른 회원에 대한 개인정보를 그 동의 없이 수집, 저장, 공개하는 행위\r\n⑦ 범죄와 결부된다고 객관적으로 판단되는 행위\r\n⑧ 기타 관련 법령에 위배되는 행위\r\n\r\n제12조 게시물의 관리\r\n\r\n① 사이트의 게시물과 자료의 관리 및 운영의 책임은 운영자에게 있습니다. 운영자는 항상 불량 게시물 및 자료에 대하여 모니터링을 하여야 하며, 불량 게시물 및 자료를 발견하거나 신고를 받으면 해당 게시물 및 자료를 삭제하고 이를 등록한 회원에게 주의를 주어야 합니다.\r\n한편, 이용회원이 올린 게시물에 대해서는 게시자 본인에게 책임이 있으니 회원 스스로 본 이용약관에서 위배되는 게시물은 게재해서는 안 됩니다.\r\n② 정보통신윤리위원회 등 공공기관의 시정요구가 있는 경우 운영자는 회원의 사전동의 없이 게시물을 삭제하거나 이동 할 수 있습니다.\r\n③ 불량게시물의 판단기준은 다음과 같습니다.\r\n- 다른 회원 또는 제3자에게 심한 모욕을 주거나 명예를 손상하는 내용인 경우\r\n- 공공질서 및 미풍양속에 위반되는 내용을 유포하거나 링크 시키는 경우\r\n- 불법 복제 또는 해킹을 조장하는 내용인 경우\r\n- 영리를 목적으로 하는 광고일 경우\r\n- 범죄와 결부된다고 객관적으로 인정되는 내용일 경우\r\n- 다른 이용자 또는 제3자와 저작권 등 기타 권리를 침해하는 경우\r\n- 기타 관계 법령에 위배된다고 판단되는 경우\r\n④ 사이트 및 운영자는 게시물 등에 대하여 제3자로부터 명예훼손, 지적재산권 등의 권리 침해를 이유로 게시중단 요청을 받은 경우 이를 임시로 게시 중단(전송중단)할 수 있으며, 게시중단 요청자와 게시물 등록자 간에 소송, 합의 기타 이에 준하는 관련 기관의 결정 등이 이루어져 사이트에 접수된 경우 이에 따릅니다.\r\n\r\n제13조 게시물의 보관\r\n\r\n사이트 운영자가 불가피한 사정으로 본 사이트를 중단하게 될 경우, 회원에게 사전 공지를 하고 게시물의 이전이 쉽도록 모든 조치를 하기 위해 노력합니다.\r\n\r\n제14조 게시물에 대한 저작권\r\n\r\n① 회원이 사이트 내에 게시한 게시물의 저작권은 게시한 회원에게 귀속됩니다. 또한 사이트는 게시자의 동의 없이 게시물을 상업적으로 이용할 수 없습니다. 다만 비영리 목적인 경우는 그러하지 아니하며, 또한 서비스 내의 게재권을 갖습니다.\r\n② 회원은 서비스를 이용하여 취득한 정보를 임의 가공, 판매하는 행위 등 서비스에 게재된 자료를 상업적으로 사용할 수 없습니다.\r\n③ 운영자는 회원이 게시하거나 등록하는 사이트 내의 내용물, 게시 내용에 대해 제12조 각호에 해당한다고 판단되는 경우 사전통지 없이 삭제하거나 이동 또는 등록 거부할 수 있습니다.\r\n\r\n제15조 손해배상\r\n\r\n① 본 사이트의 발생한 모든 민, 형법상 책임은 회원 본인에게 1차적으로 있습니다.\r\n② 본 사이트로부터 회원이 받은 손해가 천재지변 등 불가항력적이거나 회원의 고의 또는 과실로 인하여 발생한 때에는 손해배상을 하지 않습니다.\r\n\r\n제16조 면책\r\n\r\n① 운영자는 회원이 사이트의 서비스 제공으로부터 기대되는 이익을 얻지 못하였거나 서비스 자료에 대한 취사선택 또는 이용으로 발생하는 손해 등에 대해서는 책임이 면제됩니다.\r\n② 운영자는 본 사이트의 서비스 기반 및 타 통신업자가 제공하는 전기통신 서비스의 장애로 인한 경우에는 책임이 면제되며 본 사이트의 서비스 기반과 관련되어 발생한 손해에 대해서는 사이트의 이용약관에 준합니다\r\n③ 운영자는 회원이 저장, 게시 또는 전송한 자료와 관련하여 일체의 책임을 지지 않습니다.\r\n④ 운영자는 회원의 귀책 사유로 인하여 서비스 이용의 장애가 발생한 경우에는 책임지지 아니합니다.\r\n⑤ 운영자는 회원 상호 간 또는 회원과 제3자 상호 간, 기타 회원의 본 서비스 내외를 불문한 일체의 활동(데이터 전송, 기타 커뮤니티 활동 포함)에 대하여 책임을 지지 않습니다.\r\n⑥ 운영자는 회원이 게시 또는 전송한 자료 및 본 사이트로 회원이 제공받을 수 있는 모든 자료들의 진위, 신뢰도, 정확성 등 그 내용에 대해서는 책임지지 아니합니다.\r\n⑦ 운영자는 회원 상호 간 또는 회원과 제3자 상호 간에 서비스를 매개로 하여 물품거래 등을 한 경우에 그로부터 발생하는 일체의 손해에 대하여 책임지지 아니합니다.\r\n⑧ 운영자는 운영자의 귀책 사유 없이 회원간 또는 회원과 제3자간에 발생한 일체의 분쟁에 대하여 책임지지 아니합니다.\r\n⑨ 운영자는 서버 등 설비의 관리, 점검, 보수, 교체 과정 또는 소프트웨어의 운용 과정에서 고의 또는 고의에 준하는 중대한 과실 없이 발생할 수 있는 시스템의 장애, 제3자의 공격으로 인한 시스템의 장애, 국내외의 저명한 연구기관이나 보안 관련 업체에 의해 대응 방법이 개발되지 아니한 컴퓨터 바이러스 등의 유포나 기타 운영자가 통제할 수 없는 불가항력적 사유로 인한 회원의 손해에 대하여 책임지지 않습니다.\r\n\r\n부칙\r\n\r\n이 약관은 <사이트 개설일>부터 시행합니다.");
        textArea_1.setBounds(44, 146, 558, 181);
        add(textArea_1);

        checkbox_1 = new Checkbox("이용약관 동의 (필수)");
        checkbox_1.setForeground(Color.WHITE);
        checkbox_1.setBounds(44, 117, 160, 23);
        add(checkbox_1);
        

        TextArea textArea_2 = new TextArea("1. 개인정보 수집목적 및 이용목적\r\n\r\n(1) 홈페이지 회원 가입 및 관리\r\n회원 가입 의사 확인, 회원제 서비스 제공에 따른 본인 식별․인증, 회원자격 유지․관리, 제한적 본인확인제 시행에 따른 본인확인, 서비스 부정 이용 방지, 만 14세 미만 아동의 개인정보 처리시 법정대리인의 동의 여부 확인, 각종 고지․통지, 고충 처리 등의 목적\r\n\r\n(2) 재화 또는 서비스 제공\r\n물품 배송, 서비스 제공, 계약서․청구서 발송, 콘텐츠 제공, 맞춤 서비스 제공, 본인인증, 연령인증, 요금 결제 및 정산, 채권추심 등의 목적\r\n\r\n(3) 고충 처리\r\n민원인의 신원 확인, 민원사항 확인, 사실조사를 위한 연락․통지, 처리 결과 통보 등\r\n\r\n2. 수집하는 개인정보 항목\r\nID, 성명, 비밀번호, 주소, 휴대폰 번호, 이메일, 14세 미만 가입자의 경우 법정대리인 정보\r\n\r\n3. 개인정보 보유 및 이용기간\r\n회원탈퇴 시까지 (단, 관계 법령에 보존 근거가 있는 경우 해당 기간 시까지 보유, 개인정보처리방침에서 확인 가능)");
        textArea_2.setEditable(false);
        textArea_2.setFont(new Font("나눔고딕", Font.PLAIN, 11));
        textArea_2.setBounds(44, 379, 558, 155);
        add(textArea_2);

        checkbox_2 = new Checkbox("개인정보 수집 및 이용 동의 (필수)");
        checkbox_2.setForeground(Color.WHITE);
        checkbox_2.setBounds(44, 350, 260, 23);
        add(checkbox_2);

        checkbox_3 = new Checkbox("이용약관, 개인정보 수집 및 이용에 모두 동의합니다.");
        checkbox_3.setForeground(Color.WHITE);
        checkbox_3.setBounds(44, 554, 350, 23);
        add(checkbox_3);
        
        checkbox_3.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                boolean selected = checkbox_3.getState();
                checkbox_1.setState(selected);
                checkbox_2.setState(selected);
            }
        });

        checkbox_1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkbox_3.setState(checkbox_1.getState() && checkbox_2.getState());
            }
        });

        checkbox_2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkbox_3.setState(checkbox_1.getState() && checkbox_2.getState());
            }
        });

        // 사용자 입력 필드
        textField_1 = new JTextField();
        textField_1.setBorder(new EmptyBorder(0, 10, 0, 0));
        textField_1.setColumns(16);
        textField_1.setBounds(804, 183, 341, 32);
        add(textField_1);

        passwordField_1 = new JPasswordField();
        passwordField_1.setToolTipText("");
        passwordField_1.setBorder(new EmptyBorder(0, 10, 0, 0));
        passwordField_1.setBounds(804, 221, 341, 32);
        add(passwordField_1);

        passwordField_2 = new JPasswordField();
        passwordField_2.setBorder(new EmptyBorder(0, 10, 0, 0));
        passwordField_2.setBounds(804, 259, 341, 32);
        add(passwordField_2);

        textField_2 = new JTextField();
        textField_2.setBorder(new EmptyBorder(0, 10, 0, 0));
        textField_2.setColumns(12);
        textField_2.setBounds(804, 333, 341, 32);
        add(textField_2);

        textField_3 = new JTextField();
        textField_3.setBorder(new EmptyBorder(0, 10, 0, 0));
        textField_3.setColumns(16);
        textField_3.setBounds(804, 371, 341, 32);
        add(textField_3);

        textField_4 = new JTextField();
        textField_4.setBorder(new EmptyBorder(0, 10, 0, 0));
        textField_4.setColumns(14);
        textField_4.setBounds(804, 409, 341, 32);
        
        textField_4.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER)						
				{
	                if (validateEmail(textField_3.getText()) && validatePasswords(new String(passwordField_1.getPassword()), new String(passwordField_2.getPassword()))) 
	                {                                    	
	                	if(!checkbox_1.getState())
	                	{
	                		JOptionPane.showMessageDialog(null, "이용약관에 동의하여 주십시오.");
	                		return;
	                	}
	                	else if(!checkbox_2.getState())
	                	{
	                		JOptionPane.showMessageDialog(null, "개인정보 수집에 동의하여 주십시오.");
	                		return;
	                	}
	                	
	                     Boolean result =  InsertUser();          
	                     
	                     if(result)
	                     {
	                    	 JOptionPane.showMessageDialog(null, "아이디가 중복되었습니다.");
	                    	 return;
	                     }
	                     
	                     mainFrame.PopupVisible("CGVING 회원가입을 환영합니다.", PANELNAME.LOGIN);
	                    
	                } else {
	                    // Handle error
	                	 JOptionPane.showMessageDialog(null, "입력한 정보를 확인해주십시오.");
	                }
				}
			}
		} );
        
        add(textField_4);

        setupButtons();
        
        JLabel lblNewLabel_2 = new JLabel("아이디");
        lblNewLabel_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 14));
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setBounds(690, 190, 57, 15);
        add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("비밀번호");
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(690, 229, 71, 15);
        add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("비밀번호확인");
        lblNewLabel_4.setForeground(Color.WHITE);
        lblNewLabel_4.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 14));
        lblNewLabel_4.setBounds(690, 269, 102, 15);
        add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("이 름");
        lblNewLabel_5.setForeground(Color.WHITE);
        lblNewLabel_5.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 14));
        lblNewLabel_5.setBounds(690, 341, 71, 15);
        add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("이메일");
        lblNewLabel_6.setForeground(Color.WHITE);
        lblNewLabel_6.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 14));
        lblNewLabel_6.setBounds(690, 379, 71, 15);
        add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("휴대전화");
        lblNewLabel_7.setForeground(Color.WHITE);
        lblNewLabel_7.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 14));
        lblNewLabel_7.setBounds(690, 417, 71, 15);
        add(lblNewLabel_7);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(JoinAgree.class.getResource("/image/title/terms2.png")));
        lblNewLabel.setBounds(182, 32, 270, 80);
        add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon(JoinAgree.class.getResource("/image/title/sign2.png")));
        lblNewLabel_1.setBounds(804, 32, 270, 80);
        add(lblNewLabel_1);
    }

    private void initializeUserInputFields() {
        textField_1 = new JTextField();
        textField_1.setBorder(new EmptyBorder(0, 10, 0, 0));
        textField_1.setColumns(16);
        textField_1.setBounds(804, 183, 341, 32);
        add(textField_1);

        passwordField_1 = new JPasswordField();
        passwordField_1.setToolTipText("");
        passwordField_1.setBorder(new EmptyBorder(0, 10, 0, 0));
        passwordField_1.setBounds(804, 221, 341, 32);
        add(passwordField_1);

        passwordField_2 = new JPasswordField();
        passwordField_2.setBorder(new EmptyBorder(0, 10, 0, 0));
        passwordField_2.setBounds(804, 259, 341, 32);
        add(passwordField_2);

        textField_2 = new JTextField();
        textField_2.setBorder(new EmptyBorder(0, 10, 0, 0));
        textField_2.setColumns(12);
        textField_2.setBounds(804, 333, 341, 32);
        add(textField_2);

        textField_3 = new JTextField();
        textField_3.setBorder(new EmptyBorder(0, 10, 0, 0));
        textField_3.setColumns(16);
        textField_3.setBounds(804, 371, 341, 32);
        add(textField_3);

        textField_4 = new JTextField();
        textField_4.setBorder(new EmptyBorder(0, 10, 0, 0));
        textField_4.setColumns(14);
        textField_4.setBounds(804, 409, 341, 32);
        add(textField_4);
    }

    private void setupButtons() {
        JButton BackBtn = new JButton("");
        BackBtn.setBorderPainted(false);
        BackBtn.setIcon(new ImageIcon(JoinAgree.class.getResource("/image/button/back.png")));
        BackBtn.setBounds(855, 499, 110, 42);
        add(BackBtn);
        BackBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.PageChange(MainFrame.PANELNAME.MAIN);
            }
        });

        JButton btnNewButton_2 = new JButton("");
        btnNewButton_2.setBorderPainted(false);
        btnNewButton_2.setIcon(new ImageIcon(JoinAgree.class.getResource("/image/button/join2.png")));
        btnNewButton_2.setBounds(998, 499, 110, 42);
        add(btnNewButton_2);
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validateEmail(textField_3.getText()) && validatePasswords(new String(passwordField_1.getPassword()), new String(passwordField_2.getPassword()))) 
                {                                    	
                	if(!checkbox_1.getState())
                	{
                		JOptionPane.showMessageDialog(null, "이용약관에 동의하여 주십시오.");
                		return;
                	}
                	else if(!checkbox_2.getState())
                	{
                		JOptionPane.showMessageDialog(null, "개인정보 수집에 동의하여 주십시오.");
                		return;
                	}
                	
                     Boolean result =  InsertUser();          
                     
                     if(result)
                     {
                    	 JOptionPane.showMessageDialog(null, "아이디가 중복되었습니다.");
                    	 return;
                     }
                     
                     //JOptionPane.showMessageDialog(null, "CGVING 회원가입을 환영합니다.");   
                     mainFrame.PopupVisible("CGVING 회원가입을 환영합니다.", PANELNAME.LOGIN);
                    
                } else {
                    // Handle error
                	 JOptionPane.showMessageDialog(null, "입력한 정보를 확인해주십시오.");
                }
            }
        });
    }
    public Boolean InsertUser()
    {
    	try 
    	{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@14.42.124.35:1521/xe", "C##wjrls", "881125");
			
			String sql_test = "select count(*) as COUNT FROM USER_INFO WHERE USER_ID = '" + textField_1.getText() +"'";
			PreparedStatement pstmt_test = conn.prepareStatement(sql_test);
			
			ResultSet rs = pstmt_test.executeQuery();
			rs.next();
			int result_test = rs.getInt("COUNT");
			
			
			if(result_test >= 1)
			{
			pstmt_test.close();
			    conn.close();
			    
			    return true;
			}
				
						
			
			String sql = "INSERT INTO USER_INFO(USER_NO, USER_NAME, USER_ID, USER_PW, USER_EMAIL, USER_PHONE, AUTH_NO) "
					+ " VALUES(USER_BNO.NEXTVAL, ? , ? , ?, ?, ?, 1)";
			
			
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        
	        pstmt.setString(1, textField_2.getText());
	        pstmt.setString(2, textField_1.getText()); 
	        pstmt.setString(3, new String(passwordField_1.getPassword()));
	        pstmt.setString(4, textField_3.getText());
	        pstmt.setString(5, textField_4.getText());
	        
	        int result = pstmt.executeUpdate();
	        if(result < 0)
	        {
	        	System.out.println("Insert User Err--");
	        }

	        pstmt.close();
	        pstmt_test.close();
	        conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return false;
        
    }

    private void setupLabels() {
        addLabel("Terms & Policy", 180, 44, 301, 42, "나눔고딕 ExtraBold", 40, new Color(238, 46, 36));
        addLabel("아이디", 690, 190, 57, 15, "나눔고딕 ExtraBold", 14, Color.WHITE);
        addLabel("비밀번호", 690, 229, 71, 15, "나눔고딕 ExtraBold", 14, Color.WHITE);
        addLabel("비밀번호확인", 690, 269, 102, 15, "나눔고딕 ExtraBold", 14, Color.WHITE);
        addLabel("이 름", 690, 333, 71, 15, "나눔고딕 ExtraBold", 14, Color.WHITE);
        addLabel("이메일", 690, 371, 71, 15, "나눔고딕 ExtraBold", 14, Color.WHITE);
        addLabel("휴대전화", 690, 409, 71, 15, "나눔고딕 ExtraBold", 14, Color.WHITE);
        addLabel("Sign in", 787, 44, 301, 42, "나눔고딕 ExtraBold", 40, new Color(238, 46, 36));
    }

    private void addLabel(String text, int x, int y, int width, int height, String fontName, int fontSize, Color color) {
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font(fontName, Font.PLAIN, fontSize));
        label.setForeground(color);
        label.setBounds(x, y, width, height);
        add(label);
    }

    private boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(null, "유효하지 않은 이메일 형식입니다.");
            return false;
        }
        return true;
    }

    private boolean validatePasswords(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
            return false;
        }
        return true;
    }
}
