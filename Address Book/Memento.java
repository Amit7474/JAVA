
public class Memento {
	private String jtfName;
	private String jtfStreet;
	private String jtfCity;
	private String jtfState;
	private String jtfZip;
	private long rafPosition;

	public Memento(String name, String street, String city, String state, String zip, long position) {
		this.jtfName = name;
		this.jtfStreet = street;
		this.jtfState = state;
		this.jtfCity = city;
		this.jtfZip = zip;
		this.rafPosition = position;
	}

	public String getJtfName() {
		return jtfName;
	}

	public String getJtfStreet() {
		return jtfStreet;
	}

	public String getJtfCity() {
		return jtfCity;
	}

	public String getJtfState() {
		return jtfState;
	}

	public String getJtfZip() {
		return jtfZip;
	}

	public long getRafPosition() {
		return rafPosition;
	}

}
