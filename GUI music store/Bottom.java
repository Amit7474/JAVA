import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;
//Amit kremer 302863253

public class Bottom extends BorderPane {
	private Button add = new Button("Add");
	private Button delete = new Button("Delete");
	private Button clear = new Button("Clear");
	private Line line = new Line();
	private LocalDateTime localDateTime = LocalDateTime.now();
	private DateTimeFormatter timeAndDateShape = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

	public Bottom() {
		// up
		HBox up = new HBox(20);
		up.setPadding(new Insets(10, 10, 10, 10));
		up.getChildren().addAll(add, delete, clear);
		up.setAlignment(Pos.CENTER);
		BorderPane.setAlignment(up, Pos.TOP_CENTER);
		// down
		HBox down = new HBox();
		Label text = new Label(
				localDateTime.format(timeAndDateShape) + " Afeka Instrument Music store $$$ ON SALE!!! $$$");
		text.setTextFill(Color.RED);
		text.setFont(Font.font("Ariel", FontWeight.BOLD, 15));
		PathTransition movingtext = new PathTransition();
		movingtext.setDuration(Duration.millis(5000));
		movingtext.setPath(line);
		line.setStartX(130.20);
		line.setStartY(0.20);
		line.setEndX(470.20);
		line.setEndY(0.20);
		movingtext.setNode(text);
		movingtext.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		movingtext.setCycleCount(Timeline.INDEFINITE);
		movingtext.setAutoReverse(true);
		movingtext.play();
		down.setOnMouseMoved(e -> movingtext.pause());
		down.setOnMouseExited(e -> movingtext.play());
		BorderPane.setAlignment(down, Pos.BOTTOM_CENTER);
		down.getChildren().add(text);
		setPadding(new Insets(20, 20, 20, 20));
		setTop(up);
		setBottom(down);

	}

	public Button getAdd() {
		return add;
	}

	public Button getDelete() {
		return delete;
	}

	public Button getClear() {
		return clear;
	}

}
