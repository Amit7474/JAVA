

public class Originator {

	private String jtfName;
	private String jtfStreet;
	private String jtfCity;
	private String jtfState;
	private String jtfZip;
	private long rafPosition;

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

	public void setState(String name, String street, String city, String state, String zip, long position) {
		this.jtfName = name;
		this.jtfStreet = street;
		this.jtfState = state;
		this.jtfCity = city;
		this.jtfZip = zip;
		this.rafPosition = position;
	}

	public Memento saveStateToMemento() {
		return new Memento(jtfName, jtfStreet, jtfCity, jtfState, jtfZip, rafPosition);
	}

	public void getStateFromMemento(Memento memento) {
		if (memento != null) {
			this.jtfName = memento.getJtfName();
			this.jtfStreet = memento.getJtfStreet();
			this.jtfState = memento.getJtfState();
			this.jtfCity = memento.getJtfCity();
			this.jtfZip = memento.getJtfZip();
			this.rafPosition = memento.getRafPosition();
		}
	}

}
