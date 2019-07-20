import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
//Amit kremer 302863253

public class CenterPane extends GridPane {
	private Label type = new Label("Type:");
	private Label brand = new Label("Brand:");
	private Label price = new Label("Price:");
	private TextField typef = new TextField();
	private TextField brandf = new TextField();
	private TextField pricef = new TextField();
	private final String PROMPT_TEXT = "No Items";

	public CenterPane() {
		typef.setPrefColumnCount(15);
		typef.setPromptText(PROMPT_TEXT);
		brandf.setPrefColumnCount(15);
		brandf.setPromptText(PROMPT_TEXT);
		pricef.setPrefColumnCount(15);
		pricef.setPromptText(PROMPT_TEXT);
		setPadding(new Insets(20, 20, 20, 20));
		setHgap(20);
		setVgap(20);
		setAlignment(Pos.CENTER);
		GridPane.setConstraints(type, 0, 0);
		GridPane.setConstraints(typef, 1, 0);
		GridPane.setConstraints(brand, 0, 1);
		GridPane.setConstraints(brandf, 1, 1);
		GridPane.setConstraints(price, 0, 2);
		GridPane.setConstraints(pricef, 1, 2);
		getChildren().addAll(type, brand, price, typef, brandf, pricef);

	}

	public void setTextFields(String brand, String price, String type) {
		brandf.setText(brand);
		pricef.setText(price);
		typef.setText(type);
	}

	public void clearTextFields() {
		brandf.clear();
		pricef.clear();
		typef.clear();
	}

	public TextField getTypef() {
		return typef;
	}

	public void setTypef(String typef) {
		this.typef.setText(typef);
	}

	public TextField getBrandf() {
		return brandf;
	}

	public void setBrandf(String brandf) {
		this.brandf.setText(brandf);
	}

	public TextField getPricef() {
		return pricef;
	}

	public void setPricef(Double pricef) {
		this.pricef.setText("" + pricef);
	}

}
