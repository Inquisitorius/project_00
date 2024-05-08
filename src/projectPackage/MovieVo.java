package projectPackage;

public class MovieVo {
	private int movie_no;
	private String movie_name;
	private String movie_comment;
	private String file_name; 
	private String file_directory;
	private String activate;

	public MovieVo() {};

	public MovieVo(int movie_no, String movie_name, String movie_comment, String file_name, String file_directory,
			String activate) {
		super();
		this.movie_no = movie_no;
		this.movie_name = movie_name;
		this.movie_comment = movie_comment;
		this.file_name = file_name;
		this.file_directory = file_directory;
		this.activate = activate;
	}


	public String getActivate() {
		return activate;
	}


	public void setActivate(String activate) {
		this.activate = activate;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_directory() {
		return file_directory;
	}

	public void setFile_directory(String file_directory) {
		this.file_directory = file_directory;
	}

	public int getMovie_no() {
		return movie_no;
	}
	public void setMovie_no(int movie_no) {
		this.movie_no = movie_no;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getMovie_comment() {
		return movie_comment;
	}
	public void setMovie_comment(String movie_comment) {
		this.movie_comment = movie_comment;
	}
	
	public void RenderInfo()
	{
		System.out.println(this.movie_no);
		System.out.println(this.movie_name);
		System.out.println(this.movie_comment);
	}
	
	
}
