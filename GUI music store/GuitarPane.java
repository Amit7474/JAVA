import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
//Amit kremer 302863253

public class GuitarPane extends GridPane {
	private Label brand = new Label("Brand:");
	private Label price = new Label("Price:");
	private Label numberOfStrings = new Label("Number Of Strings:");
	private Label type = new Label("Type:");
	private TextField brandf = new TextField();
	private TextField pricef = new TextField();
	private TextField numberOfStringsf = new TextField();
	private ComboBox<String> typec = new ComboBox<>();
	private Button add = new Button("Add");

	public GuitarPane() {
		setPadding(new Insets(10, 10, 10, 10));
		setHgap(10);
		setVgap(10);
		setAlignment(Pos.CENTER);
		setPromptTextToAllFields();
		typec.getItems().addAll("Classic", "Acoustic", "Electric");
		GridPane.setConstraints(brand, 0, 0);
		GridPane.setConstraints(brandf, 1, 0);
		GridPane.setConstraints(price, 0, 1);
		GridPane.setConstraints(pricef, 1, 1);
		GridPane.setConstraints(numberOfStrings, 0, 2);
		GridPane.setConstraints(numberOfStringsf, 1, 2);
		GridPane.setConstraints(type, 0, 3);
		GridPane.setConstraints(typec, 1, 3);
		getChildren().addAll(brand, price, numberOfStrings, type, brandf, pricef, numberOfStringsf, typec);
	}

	private void setPromptTextToAllFields() {
		brandf.setPromptText("Ex: Gibson");
		pricef.setPromptText("Ex: 7500");
		numberOfStringsf.setPromptText("Ex: 6");
	}

	public Label getBrand() {
		return brand;
	}

	public Label getPrice() {
		return price;
	}

	public Label getNumberOfStrings() {
		return numberOfStrings;
	}

	public Label getType() {
		return type;
	}
	public void clearFields() {
		brandf.clear();
		pricef.clear();
		numberOfStringsf.clear();
		typec.disarm();
	}

	public String getBrandf() {
		return brandf.getText();
	}

	public String getPricef() {
		return pricef.getText();
	}

	public String getNumberOfStringsf() {
		return numberOfStringsf.getText();
	}

	public String getTypec() {
		return typec.getValue();
	}

	public Button getAdd() {
		return add;
	}

}
