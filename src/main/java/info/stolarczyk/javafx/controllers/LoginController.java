package info.stolarczyk.javafx.controllers;




import java.sql.*;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import info.stolarczyk.javafx.models.Alert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


@Component
public class LoginController implements Initializable {

	@FXML
	private Label nameUserLab;

	@FXML
	private Label passwordUserLab;

	@FXML
	private PasswordField pasField;

	@FXML
	private TextField logTextField;

	@FXML
	private Button logButton;

	@FXML
	private Label statLab;

	Alert alert;

	@FXML
	public void OnAction(ActionEvent event) throws SQLException, ClassNotFoundException {

		String login = logTextField.getText();
		String password = pasField.getText();

		if (login.equals("admin") && password.equals("password")) {

			alert.info(" Your login and password is correct!");
			((Node) event.getSource()).getScene().getWindow().hide();

			try {

				Stage stg2 = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("/PanelCustomers.fxml"));
				Scene sce = new Scene(root, 600, 400);
				stg2.setScene(sce);
				stg2.setResizable(false);
				stg2.show();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			alert.info(" Your login or password is not correct!");
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
