package info.stolarczyk.javafx.controllers;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

	

@Component
public class PanelController {

	@FXML
	private Button add_customer;

	@FXML
	private Button delete_customer;

	@FXML
	private Button edit_customer;

	@FXML
	private Button show_table;

	@FXML
	void ShowTabOnAction(ActionEvent event) {

		try {

			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/TableCustomers.fxml"));
			Scene sce = new Scene(root, 700, 400);
			primaryStage.setScene(sce);
			primaryStage.show();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@FXML
	public void AddOnAction(ActionEvent event) {

		((Node) event.getSource()).getScene().getWindow().hide();

		try {

			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/AddCustomer.fxml"));
			Scene sce = new Scene(root, 400, 500);
			primaryStage.setScene(sce);
			primaryStage.show();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@FXML
	void DeleteOnAction(ActionEvent event) {

		((Node) event.getSource()).getScene().getWindow().hide();

		try {

			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/RemoveCustomer.fxml"));
			Scene sce = new Scene(root, 400, 500);
			primaryStage.setScene(sce);
			primaryStage.show();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@FXML
	void EditOnAction(ActionEvent event) {

		((Node) event.getSource()).getScene().getWindow().hide();

		try {

			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/EditCustomer.fxml"));
			Scene sce = new Scene(root, 400, 500);
			primaryStage.setScene(sce);
			primaryStage.show();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
