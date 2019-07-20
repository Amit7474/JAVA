import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
//Amit kremer 302863253

public class BassPane extends GridPane {
	private Label brand = new Label("Brand:");
	private Label price = new Label("Price:");
	private Label numberOfStrings = new Label("Number Of Strings:");
	private Label fretless = new Label("Fretless:");
	private TextField brandf = new TextField();
	private TextField pricef = new TextField();
	private TextField numberOfStringsf = new TextField();
	private CheckBox chkBox = new CheckBox();
	private Button add = new Button("Add");

	public BassPane() {
		setPadding(new Insets(10, 10, 10, 10));
		setHgap(10);
		setVgap(10);
		setAlignment(Pos.CENTER);
		setPromptTextToAllFields();
		GridPane.setConstraints(brand, 0, 0);
		GridPane.setConstraints(brandf, 1, 0);
		GridPane.setConstraints(price, 0, 1);
		GridPane.setConstraints(pricef, 1, 1);
		GridPane.setConstraints(numberOfStrings, 0, 2);
		GridPane.setConstraints(numberOfStringsf, 1, 2);
		GridPane.setConstraints(fretless, 0, 3);
		GridPane.setConstraints(chkBox, 1, 3);
		getChildren().addAll(brand, price, numberOfStrings, chkBox, brandf, pricef, numberOfStringsf, fretless);
	}
	public void clearFields() {
		brandf.clear();
		pricef.clear();
		numberOfStringsf.clear();
		chkBox.disarm();
	}
	
	private void setPromptTextToAllFields() {
		brandf.setPromptText("Ex: Fender Jazz");
		pricef.setPromptText("Ex: 7500");
		numberOfStringsf.setPromptText("Ex: 4");
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

	public String getNumberOfStringsf() {
		return numberOfStringsf.getText();
	}

	public boolean getChkBox() {
		return chkBox.isPressed();
	}

}
