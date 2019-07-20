import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
//Amit kremer 302863253

public class FlutePane extends GridPane {
	private Label brand = new Label("Brand:");
	private Label price = new Label("Price:");
	private Label material = new Label("Material:");
	private Label fluteType = new Label("Flute Type:");
	private TextField brandf = new TextField();
	private TextField pricef = new TextField();
	private ComboBox<String> chkMaterial = new ComboBox<String>();
	private ComboBox<String> chkType = new ComboBox<String>();
	private Button add = new Button("Add");

	public FlutePane() {
		setPadding(new Insets(10, 10, 10, 10));
		setHgap(10);
		setVgap(10);
		setAlignment(Pos.CENTER);
		setPromptTextToAllFields();
		chkMaterial.setPromptText("Material");
		chkMaterial.getItems().addAll("Wood", "Metal", "Plastic");
		chkType.setPromptText("Type");
		chkType.getItems().addAll("Flute", "Recorder", "Bass");
		GridPane.setConstraints(brand, 0, 0);
		GridPane.setConstraints(brandf, 1, 0);
		GridPane.setConstraints(price, 0, 1);
		GridPane.setConstraints(pricef, 1, 1);
		GridPane.setConstraints(material, 0, 2);
		GridPane.setConstraints(chkMaterial, 1, 2);
		GridPane.setConstraints(fluteType, 0, 3);
		GridPane.setConstraints(chkType, 1, 3);
		getChildren().addAll(brand, price, material, chkMaterial, brandf, pricef, fluteType, chkType);

	}
	public void clearFields() {
		brandf.clear();
		pricef.clear();
	}

	private void setPromptTextToAllFields() {
		brandf.setPromptText("Ex: Levit");
		pricef.setPromptText("Ex: 300");
	}

	public Button getAdd() {
		return add;
	}

	public String getBrandf() {
		return brandf.getText();
	}

	public String getPricef() {
		return pricef.getText();
	}

	public String getChkType() {
		return chkType.getValue();
	}

	public String getChkMaterial() {
		return chkMaterial.getValue();
	}

}
