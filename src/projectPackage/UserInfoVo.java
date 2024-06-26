package projectPackage;

public class UserInfoVo {
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	private int user_no;
	private String user_name;
	private String user_id;
	private String user_pw;
	private String user_email;
	private String user_phone;
	private int auth_no;
	
	public UserInfoVo() {}
	
	public UserInfoVo(int user_no, String user_id, String user_pw, String user_name, String user_email, String user_phone,
			int auth_no) {
		super();
		this.user_no = user_no;
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pw = user_pw;
		this.user_email = user_email;
		this.user_phone = user_phone;
		this.auth_no = auth_no;
	}
	
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public int getAuth_no() {
		return auth_no;
	}
	public void setAuth_no(int auth_no) {
		this.auth_no = auth_no;
	}
	
	public void RenderInfo()
	{
		System.out.println("ID : " + this.user_id);
		System.out.println("NAME : "  + this.user_name);
		System.out.println("NO : "  + this.user_no);
	}
	
}
