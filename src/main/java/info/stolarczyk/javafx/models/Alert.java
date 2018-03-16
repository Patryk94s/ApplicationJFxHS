package info.stolarczyk.javafx.models;



import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class Alert {

	public static void info(String message) {

		Stage okno = new Stage();
		okno.setTitle("Information");
		okno.setMinWidth(250);
		okno.setMaxHeight(150);

		Label label = new Label();
		label.setText(message);
		Button button = new Button("CONFIRM");
		button.setStyle("-fx-background-color: #000000;-fx-text-fill: white");
		button.setOnAction(e -> okno.close());

		VBox grup = new VBox(2);

		grup.getChildren().addAll(label, button);
		grup.setAlignment(Pos.CENTER);

		Scene scene = new Scene(grup);
		okno.setScene(scene);
		okno.showAndWait();

	}

}
