import java.util.InputMismatchException;
import java.util.Scanner;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
//Amit kremer 302863253

public class StringInstrument extends MusicalInstrument {
	private int numOfStrings;

	public StringInstrument(String brand, double price, int numOfStrings) {
		super(brand, price);
		setNumOfStrings(numOfStrings);
	}

	public StringInstrument(Scanner scanner) {
		super(scanner);
		int numOfStrings;
		try {
			numOfStrings = scanner.nextInt();
		} catch (InputMismatchException e) {
			throw new InputMismatchException("Number of strings must be a positive integer");
		}
		setNumOfStrings(numOfStrings);
	}

	public void setNumOfStrings(int numOfStrings) {
		if (numOfStrings < 1) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error");
			alert.setContentText("Number of strings cannot be negative!");
			alert.showAndWait();
		} else
			this.numOfStrings = numOfStrings;
	}

	public int getNumOfStrings() {
		return numOfStrings;
	}

	@Override
	public boolean equals(Object o) {
		if (!super.equals(o))
			return false;

		if (!(o instanceof StringInstrument))
			return false;

		return getNumOfStrings() == ((StringInstrument) o).getNumOfStrings();
	}

	@Override
	public String toString() {
		return super.toString() + String.format(" Number of strings: %2d| ", getNumOfStrings());
	}
}
