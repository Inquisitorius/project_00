package projectPackage;

public class TicketVo 
{
	private int ticket_no;
	private int schedule_no;
	private int seat_no;
	private int user_no;
	private String ticket_status;
	
	public TicketVo() {}
	
	
	public TicketVo(int ticket_no, int schedule_no, int seat_no, int user_no, String ticket_status) {
		super();
		this.ticket_no = ticket_no;
		this.schedule_no = schedule_no;
		this.seat_no = seat_no;
		this.user_no = user_no;
		this.ticket_status = ticket_status;
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