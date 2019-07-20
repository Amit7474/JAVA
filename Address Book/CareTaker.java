import java.util.ArrayList;

public class CareTaker {
	private ArrayList<Memento> mementoList = new ArrayList<Memento>();
	private int index;

	public CareTaker() {

	}

	public int getIndex() {
		return index;
	}

	public int getMementoListSize() {
		return mementoList.size();
	}

	public void incrementIndex() {
		this.index++;
	}

	public void decrementIndex() {
		this.index--;
	}

	public void add(Memento state) {
		if (state != null) {
			mementoList.add(state);
			index = mementoList.size() - 1;
		}
	}

	public Memento getPrev() {
		if (mementoList.isEmpty() || index <= 0) {
			return null;
		}
		return mementoList.get(--index);
	}

	public Memento getNext() {
		if (mementoList.isEmpty() || index >= mementoList.size() - 1) {
			return null;
		}
		return mementoList.get(++index);
	}

}
