import java.util.Scanner;
//Amit kremer 302863253

public class Saxophone extends WindInstrument {
	public static final int METAL = 1;

	public Saxophone(String brand, double price) {
		super(brand, price, WIND_INSTRUMENT_MATERIAL[METAL]);
	}

	public Saxophone(Scanner scanner) {
		super(scanner);

		if (!getMaterial().equals(WIND_INSTRUMENT_MATERIAL[METAL]))
			throw new IllegalArgumentException("Illegal Saxophone material: " + getMaterial());
	}

	@Override
	public boolean equals(Object o) {
		if (!super.equals(o))
			return false;

		return o instanceof Saxophone;
	}
}
