import java.applet.Applet;
import java.applet.AudioClip;

public class AnnounceTimeOnSeparateThread extends Applet implements Runnable {
	int hour;
	int minute;
	protected AudioClip[] hourAudio = new AudioClip[12];
	protected AudioClip[] minuteAudio = new AudioClip[60];
	protected AudioClip amAudio = Applet.newAudioClip(this.getClass().getResource("/audio/am.au"));
	protected AudioClip pmAudio = Applet.newAudioClip(this.getClass().getResource("/audio/pm.au"));

	public AnnounceTimeOnSeparateThread(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
		for (int i = 0; i < 12; i++)
			hourAudio[i] = Applet.newAudioClip(this.getClass().getResource("/audio/hour" + i + ".au"));
		for (int i = 0; i < 60; i++)
			minuteAudio[i] = Applet.newAudioClip(this.getClass().getResource("/audio/minute" + i + ".au"));
	}

	@Override
	public void run() {
		try { // Announce hour
			hourAudio[hour % 12].play();
			// Time delay to allow hourAudio play to finish
			Thread.sleep(2200);
			// Announce minute
			minuteAudio[minute].play();
			// Time delay to allow minuteAudio play to finish
			Thread.sleep(1800);
		} catch (InterruptedException ex) {
		}
		// Announce am or pm
		if (hour < 12)
			amAudio.play();
		else
			pmAudio.play();
	}

}
