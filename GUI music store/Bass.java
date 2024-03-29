import java.util.InputMismatchException;
import java.util.Scanner;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
//Amit kremer 302863253

public class Bass extends StringInstrument {
	public static final int MIN_NUM_OF_STRINGS = 4, MAX_NUM_OF_STRINGS = 6;

	private boolean fretless;

	public Bass(String brand, double price, int numOfStrings, boolean isFretless) {
		super(brand, price, numOfStrings);
		setNumOfStrings(numOfStrings);
		setFretless(isFretless);
	}

	public Bass(Scanner scanner) {
		super(scanner);

		try {
			setFretless(scanner.nextBoolean());
		} catch (InputMismatchException ex) {
			throw new InputMismatchException(
					"Whether a bass is fretless or not is boolean, any other string than \"True\" or \"False\" is not acceptable");
		}
	}

	public boolean isFretless() {
		return fretless;
	}

	public void setFretless(boolean fretless) {
		this.fretless = fretless;
	}

	@Override
	public void setNumOfStrings(int numOfStrings) {
		if (numOfStrings < MIN_NUM_OF_STRINGS || numOfStrings > MAX_NUM_OF_STRINGS) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error");
			alert.setContentText(
					"Bass number of strings is a number between " + MIN_NUM_OF_STRINGS + " and " + MAX_NUM_OF_STRINGS);
			alert.showAndWait();
		} else {
			super.setNumOfStrings(numOfStrings);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (!super.equals(o))
			return false;

		if (!(o instanceof Bass))
			return false;

		return isFretless() == ((Bass) o).isFretless();
	}

	@Override
	public String toString() {
		return super.toString() + String.format(" Fretless: %3s", isFretless() ? "Yes" : "No");
	}
}
