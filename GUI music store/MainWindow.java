import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
//Amit kremer 302863253

public class MainWindow extends BorderPane {
	private SearchField searchfield = new SearchField();
	private Bottom bottom = new Bottom();
	private CenterPane centerpane = new CenterPane();
	private Button rightbtn = new Button(">");
	private Button leftbtn = new Button("<");

	public MainWindow() {
		setPadding(new Insets(10, 10, 10, 10));
		BorderPane.setAlignment(leftbtn, Pos.CENTER);
		BorderPane.setAlignment(rightbtn, Pos.CENTER);
		setTop(searchfield);
		setCenter(centerpane);
		setBottom(bottom);
		setRight(rightbtn);
		setLeft(leftbtn);
	}

	public void setTextFields(String brand, String price, String type) {
		centerpane.setTextFields(brand, price, type);
	}

	public void clearTextFields() {
		centerpane.clearTextFields();
	}

	public Button getGoBtn() {
		return searchfield.getGoBtn();
	}

	public TextField getSearchField() {
		return searchfield.getSearchField();
	}

	public Button getLeftBtn() {
		return leftbtn;
	}

	public Button getRightBtn() {
		return rightbtn;
	}

	public Button getClearBtn() {
		return bottom.getClear();
	}

	public Button getDeleteBtn() {
		return bottom.getDelete();
	}

	public Button getAddBtn() {
		return bottom.getAdd();
	}
}
