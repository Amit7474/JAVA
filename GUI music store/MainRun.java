import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;


public class MainRun extends Application {
	private ArrayList<MusicalInstrument> allInstruments = new ArrayList<MusicalInstrument>();
	private ArrayList<MusicalInstrument> secondaryInstruments = new ArrayList<MusicalInstrument>();
	private int index = 0;
	private Add add = new Add();

	public void start(Stage primaryStage) throws Exception {
		try {
			File file;
			file = AfekaInstruments.getInstrumentsFileFromUser();
			AfekaInstruments.loadInstrumentsFromFile(file, allInstruments);
			MainWindow mainPane = new MainWindow();
			showAllInstruments(mainPane);
			setEventHandlers(mainPane);
			Scene scene = new Scene(mainPane, 650, 310);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Afeka Instruments Music Store");
			primaryStage.show();
		} catch (InputMismatchException | IllegalArgumentException ex) {
			System.err.println("\n" + ex.getMessage());
			System.exit(1);
		}
	}

	public void setEventHandlers(MainWindow mainpane) {
		handleSearchOption(mainpane);
		handleLeftButton(mainpane);
		handleRightButton(mainpane);
		handleClearButton(mainpane);
		handleDeleteItem(mainpane);
		handleAddItem(mainpane);
	}

	public void handleAddItem(MainWindow mainpane) {
		mainpane.getAddBtn().setOnAction(e -> add.show());
		add.getGuitarpane().getAdd().setOnAction(e -> addGuitar());
		add.getBasspane().getAdd().setOnAction(e -> addBass());
		add.getFlutepane().getAdd().setOnAction(e -> addFlute());
		add.getSaxophonepane().getAdd().setOnAction(e -> addSaxophone());
	}

	public void addGuitar() {
		try {
			String brand = add.getGuitarpane().getBrandf();
			Double price = Double.parseDouble(add.getGuitarpane().getPricef());
			int numOfStrings = Integer.parseInt(add.getGuitarpane().getNumberOfStringsf());
			String type = add.getGuitarpane().getTypec();
			Guitar g = new Guitar(brand, price, numOfStrings, type);
			if (price > 0 && numOfStrings > 5 && numOfStrings < 9) {
				allInstruments.add(g);
				add.getGuitarpane().clearFields();
				add.close();
			}
		} catch (IllegalArgumentException ex) {
			argumentException();
		}
	}

	public void addBass() {
		try {
			String brand = add.getBasspane().getBrandf();
			Double price = Double.parseDouble(add.getBasspane().getPricef());
			int numOfStrings = Integer.parseInt(add.getBasspane().getNumberOfStringsf());
			boolean isFretless = add.getBasspane().getChkBox();
			Bass b = new Bass(brand, price, numOfStrings, isFretless);
			if (price > 0 && numOfStrings > 3 && numOfStrings < 7) {
				allInstruments.add(b);
				add.getBasspane().clearFields();
				add.close();
			}
		} catch (IllegalArgumentException ex) {
			argumentException();
		}
	}

	public void addFlute() {
		try {
			String brand = add.getFlutepane().getBrandf();
			Double price = Double.parseDouble(add.getFlutepane().getPricef());
			String meterial = add.getFlutepane().getChkMaterial();
			String type = add.getFlutepane().getChkType();
			if (price > 0) {
				allInstruments.add(new Flute(brand, price, meterial, type));
				add.getFlutepane().clearFields();
				add.close();
			}
		} catch (IllegalArgumentException ex) {
			argumentException();
		}
		add.close();
	}

	public void addSaxophone() {
		try {
			String brand = add.getSaxophonepane().getBrandf();
			Double price = Double.parseDouble(add.getSaxophonepane().getPricef());
			Saxophone s = new Saxophone(brand, price);
			if (price > 0) {
				allInstruments.add(s);
				add.getSaxophonepane().clearFields();
				add.close();
			}
		} catch (IllegalArgumentException ex) {
			argumentException();
		}
	}

	public void handleLeftButton(MainWindow mainpane) {
		mainpane.getLeftBtn().setOnAction(e -> {
			if (secondaryInstruments.size() != 0) {
				index = (index + secondaryInstruments.size() - 1) % secondaryInstruments.size();
				showFilteredItems(mainpane);
			}
			if (allInstruments.size() != 0) {
				index = (index + allInstruments.size() - 1) % allInstruments.size();
				showAllInstruments(mainpane);
			}
		});
	}

	public void handleRightButton(MainWindow mainpane) {
		mainpane.getRightBtn().setOnAction(e -> {
			if (secondaryInstruments.size() != 0) {
				index = (index + 1) % secondaryInstruments.size();
				showFilteredItems(mainpane);
			}
			if (allInstruments.size() != 0) {
				index = (index + 1) % allInstruments.size();
				showAllInstruments(mainpane);
			}
		});
	}

	public void handleClearButton(MainWindow mainpane) {
		mainpane.getClearBtn().setOnAction(e -> {
			secondaryInstruments.removeAll(secondaryInstruments);
			mainpane.clearTextFields();
		});
	}

	public void handleDeleteItem(MainWindow mainpane) {
		mainpane.getDeleteBtn().setOnAction(e -> deleteInstrument(mainpane));
		mainpane.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.DELETE)
				deleteInstrument(mainpane);
		});
	}

	public void deleteInstrument(MainWindow mainpane) {
		if (!secondaryInstruments.isEmpty()) {
			secondaryInstruments.remove(index);
			showFilteredItems(mainpane);
		} else {
			if ((!allInstruments.isEmpty())) {
				if (allInstruments.size() == 1) {
					allInstruments.clear();
					mainpane.clearTextFields();
				} else {
					allInstruments.remove(index);
					showAllInstruments(mainpane);
				}
			}
		}
	}

	public void handleSearchOption(MainWindow mainpane) {
		mainpane.getGoBtn().setOnAction(e -> {
			searchInstrument(mainpane.getSearchField().getText(), allInstruments);
			showFilteredItems(mainpane);
		});

		mainpane.getSearchField().setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				searchInstrument(mainpane.getSearchField().getText(), allInstruments);
				showFilteredItems(mainpane);
			}
		});
		index = 0;
	}

	public void searchInstrument(String text, ArrayList<MusicalInstrument> allInstruments) {
		int secondaryInstrumentsindex = 0;
		for (int i = 0; i < allInstruments.size(); i++) {
			if (allInstruments.get(i).toString().toLowerCase().contains(text.toLowerCase())) {
				secondaryInstruments.add(secondaryInstrumentsindex, allInstruments.get(i));
				secondaryInstrumentsindex++;
			}
		}
	}

	public void showFilteredItems(MainWindow mainpane) {
		if (secondaryInstruments.isEmpty())
			mainpane.clearTextFields();
		else {
			String brand = secondaryInstruments.get(index).getBrand();
			String price = secondaryInstruments.get(index).getPrice() + "";
			String type = secondaryInstruments.get(index).getClass().getCanonicalName();
			mainpane.setTextFields(brand, price, type);
		}
	}

	public void showAllInstruments(MainWindow mainpane) {
		try {
			if (index == allInstruments.size() && index != 0)
				index--;
			String brand = allInstruments.get(index).getBrand();
			String price = allInstruments.get(index).getPrice() + "";
			String type = allInstruments.get(index).getClass().getCanonicalName();
			mainpane.setTextFields(brand, price, type);
		} catch (IndexOutOfBoundsException ex) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error");
			alert.setContentText("There are no instruments in the store!");
			alert.showAndWait();
			System.exit(1);
		}
	}

	public void argumentException() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("Error");
		alert.setContentText("Price or Number of strings can be only numbers!");
		alert.showAndWait();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
