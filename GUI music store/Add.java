import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//Amit kremer 302863253

public class Add {
	private GuitarPane guitarpane = new GuitarPane();
	private BassPane basspane = new BassPane();
	private SaxophonePane saxophonepane = new SaxophonePane();
	private FlutePane flutepane = new FlutePane();
	private ComboBox<String> combobox = new ComboBox<String>();
	private Stage primaryStage;

	public Add() {
		primaryStage = new Stage();
		setPrimaryStage(primaryStage);
		setCombobox();
		setComboBoxHandler(combobox);
		VBox pane = new VBox(20);
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().add(combobox);
		Scene scene = new Scene(pane, 301, 310);
		primaryStage.setScene(scene);

	}

	public void setComboBoxHandler(ComboBox<String> comboBox) {
		combobox.setOnAction(e -> {
			switch (combobox.getSelectionModel().getSelectedItem()) {
			case "Guitar":
				setSceneAfterChoise(guitarpane, guitarpane.getAdd());
				break;
			case "Bass":
				setSceneAfterChoise(basspane, basspane.getAdd());
				break;
			case "Flute":
				setSceneAfterChoise(flutepane, flutepane.getAdd());
				break;
			case "Saxophone":
				setSceneAfterChoise(saxophonepane, saxophonepane.getAdd());
				break;

			}
		});
	}

	public void setSceneAfterChoise(GridPane pane, Button addBtn) {
		VBox mainpane = new VBox(20);
		mainpane.setAlignment(Pos.CENTER);
		mainpane.getChildren().addAll(combobox, pane, addBtn);
		Scene scene = new Scene(mainpane, 310, 310);
		primaryStage.setScene(scene);
	}

	public void setCombobox() {
		combobox.setPromptText("Choose Instrument Type Here");
		combobox.getItems().addAll("Guitar", "Bass", "Saxophone", "Flute");
		combobox.setPrefWidth(200);
	}

	public void show() {
		primaryStage.show();
	}

	public void close() {
		primaryStage.close();
	}

	public void setPrimaryStage(Stage primaryStage) {
		primaryStage.setTitle("Afeka Instruments - Add new Instrument");
	}

	public GuitarPane getGuitarpane() {
		return guitarpane;
	}

	public BassPane getBasspane() {
		return basspane;
	}

	public SaxophonePane getSaxophonepane() {
		return saxophonepane;
	}

	public FlutePane getFlutepane() {
		return flutepane;
	}

	public ComboBox<String> getCombobox() {
		return combobox;
	}
}
