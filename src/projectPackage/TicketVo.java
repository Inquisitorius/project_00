package projectPackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TicketVo 
{
	private int ticket_no;
	private int schedule_no;
	private int seat_no;
	private int user_no;
	private String ticket_status;
	
	private String movie_Name;
	private String movieHouse_Name;
	private String theater_Name;
	private String seat_Info;
	private String schedule_time;
	
	public TicketVo() {}
	
	
	public TicketVo(int ticket_no, int schedule_no, int seat_no, int user_no, String ticket_status) {
		super();
		this.ticket_no = ticket_no;
		this.schedule_no = schedule_no;
		this.seat_no = seat_no;
		this.user_no = user_no;
		this.ticket_status = ticket_status;
	}
	
	public void Set_NameInfo(String  movie_Name, String movieHouse_Name, String theater_Name, String seat_Info, String schedule_time)
	{
		this.movie_Name = movie_Name;
		this.movieHouse_Name = movieHouse_Name;
		this.theater_Name = theater_Name;
		this.seat_Info = seat_Info;
		this.schedule_time =schedule_time;
	}
	
	public String Get_SimpleSchedule_time() 
	{
		String result = "";
		
		// FORMAT 2개 선언
		// 받아줄 FORMAT
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		// 변환할 FORMAT
		SimpleDateFormat format2 = new SimpleDateFormat("MM/dd hh:mm");
		try {
			// 받은 날짜를 DATE 형태로 변환
			Date temp = format.parse(schedule_time);

			// DATE를 목적에 맞는 형식으로 변환
			result = format2.format(temp);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public String getMovie_Name() {
		return movie_Name;
	}


	public void setMovie_Name(String movie_Name) {
		this.movie_Name = movie_Name;
	}


	public String getMovieHouse_Name() {
		return movieHouse_Name;
	}


	public void setMovieHouse_Name(String movieHouse_Name) {
		this.movieHouse_Name = movieHouse_Name;
	}


	public String getTheater_Name() {
		return theater_Name;
	}


	public void setTheater_Name(String theater_Name) {
		this.theater_Name = theater_Name;
	}


	public String getSeat_Info() {
		return seat_Info;
	}


	public void setSeat_Info(String seat_Info) {
		this.seat_Info = seat_Info;
	}


	public String getSchedule_time() {
		return schedule_time;
	}


	public void setSchedule_time(String schedule_time) {
		this.schedule_time = schedule_time;
	}


	public int getTicket_no() {
		return ticket_no;
	}
	public void setTicket_no(int ticket_no) {
		this.ticket_no = ticket_no;
	}
	public int getSchedule_no() {
		return schedule_no;
	}
	public void setSchedule_no(int schedule_no) {
		this.schedule_no = schedule_no;
	}
	public int getSeat_no() {
		return seat_no;
	}
	public void setSeat_no(int seat_no) {
		this.seat_no = seat_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getTicket_status() {
		return ticket_status;
	}
	public void setTicket_status(String ticket_status) {
		this.ticket_status = ticket_status;
	}
	
	
}


/*
CREATE TABLE TICKET
(
	TICKET_NO NUMBER(10) NOT NULL PRIMARY KEY,
	SCHEDULE_NO NUMBER(3) NOT null,
	SEAT_NO NUMBER(3) NOT null,
	CONSTRAINT FK_SCHEDULE 
	FOREIGN KEY(SCHEDULE_NO) 
	REFERENCES MOVIESCHEDULE(SCHEDULE_NO),
	CONSTRAINT FK_SEAT
	FOREIGN KEY(SEAT_NO) 
	REFERENCES SEAT(SEAT_NO)
);

*/