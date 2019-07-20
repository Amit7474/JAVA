import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
//Amit kremer 302863253

public class SearchField extends HBox {
	private TextField searchField = new TextField();
	private Button go = new Button("Go!");

	public SearchField() {
		setSpacing(10);
		setPadding(new Insets(20, 20, 20, 20));
		searchField.setPromptText("Search");
		searchField.setPrefColumnCount(45);
		setAlignment(Pos.CENTER);
		getChildren().addAll(searchField, go);
	}

	public Button getGoBtn() {
		return go;
	}

	public TextField getSearchField() {
		return searchField;
	}

}
