import java.util.GregorianCalendar;
import javafx.application.Platform;

public class Tick implements Runnable {
	private ClockPane clock;
	private int hour;
	private int minute;
	private int second;
	private int sleepTime = 1000;
	private boolean pause = false;
	private Thread thread = new Thread(this);

	public Tick(ClockPane clock) {
		this.clock = clock;
		thread.start();
	}

	private void getCurrentTime() {
		CalendarAdapter calendar = new CalendarAdapter(new GregorianCalendar());
		this.hour = calendar.getHour();
		this.minute = calendar.getMinute();
		this.second = calendar.getSecond();
		if (this.second == 0)
			announceTime(this.hour, this.minute);
		setClockTime();
	}

	private void setClockTime() {
		clock.setSecond(second);
		clock.setMinute(minute);
		clock.setHour(hour);
	}

	public ClockPane getClock() {
		return clock;

	}

	public void announceTime(int h, int m) {
		new Thread(new AnnounceTimeOnSeparateThread(h, m)).start();
	}

	synchronized void pause() {
		this.pause = true;
	}

	synchronized void play() {
		this.pause = false;
		notify();
	}

	@Override
	public void run() {
		try {
			while (true) {
				Platform.runLater(() -> getCurrentTime());
				Thread.sleep(sleepTime);
				synchronized (this) {
					while (pause) {
						wait();
					}
				}
			}
		} catch (InterruptedException ex) {
		}
	}

}
