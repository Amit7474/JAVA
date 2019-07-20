import java.util.GregorianCalendar;

public class CalendarAdapter {
	private GregorianCalendar clndr;

	public CalendarAdapter(GregorianCalendar clndr) {
		this.clndr = clndr;
	}

	public int getHour() {
		return clndr.getTime().getHours();
	}

	public int getMinute() {
		return clndr.getTime().getMinutes();
	}

	public int getSecond() {
		return clndr.getTime().getSeconds();
	}
}
