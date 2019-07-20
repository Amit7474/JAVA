import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
//Amit kremer 302863253

public class SaxophonePane extends GridPane {
	private Label brand = new Label("Brand:");
	private Label price = new Label("Price:");
	private TextField brandf = new TextField();
	private TextField pricef = new TextField();
	private Button add = new Button("Add");

	public SaxophonePane() {
		setPadding(new Insets(10, 10, 10, 10));
		setHgap(10);
		setVgap(10);
		setAlignment(Pos.CENTER);
		GridPane.setConstraints(brand, 0, 0);
		GridPane.setConstraints(brandf, 1, 0);
		GridPane.setConstraints(price, 0, 1);
		GridPane.setConstraints(pricef, 1, 1);

		getChildren().addAll(brand, price, brandf, pricef);

	}
	public void clearFields() {
		brandf.clear();
		pricef.clear();
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

}
