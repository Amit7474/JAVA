import java.util.InputMismatchException;
import java.util.Scanner;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
//Amit kremer 302863253

public class MusicalInstrument {
	private double price;
	private String brand;

	public MusicalInstrument(String brand, double price) {
		setBrand(brand);
		setPrice(price);
	}

	public MusicalInstrument(Scanner scanner) {
		double price = 0;
		String brand;

		try {
			price = scanner.nextDouble();
		} catch (InputMismatchException ex) {
			throw new InputMismatchException("Price not found!");
		}
		setPrice(price);
		scanner.nextLine();
		brand = scanner.nextLine();
		setBrand(brand);
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price > 0)
			this.price = price;
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error");
			alert.setContentText("Price must be positive number!");
			alert.showAndWait();

		}
	}

	protected boolean isValidType(String[] typeArr, String material) {
		for (int i = 0; i < typeArr.length; i++) {
			if (material.equals(typeArr[i])) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || !(o instanceof MusicalInstrument))
			return false;

		MusicalInstrument otherInstrument = (MusicalInstrument) o;

		return getPrice() == otherInstrument.getPrice() && getBrand().equals(otherInstrument.getBrand());
	}

	@Override
	public String toString() {
		return String.format("%-8s %-9s| Price: %7.2f,", getBrand(), getClass().getCanonicalName(), getPrice());
	}
}
