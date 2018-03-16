package info.stolarczyk.javafx.controllers;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;


import info.stolarczyk.javafx.models.Alert;
import info.stolarczyk.javafx.models.Customers;
import info.stolarczyk.javafx.models.ErrorConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

@Component
public class TabController implements Initializable {

	public static EntityManagerFactory entityManagerFactory;
	public static EntityManager entityManager;

	@FXML
	private TextField IdTextField;

	@FXML
	private TextField firstNameTextField;

	@FXML
	private TextField lastNameTextField;

	@FXML
	private TextField streetTextField;

	@FXML
	private TextField zipCodeTextField;

	@FXML
	private TextField homeTextField;

	@FXML
	private TextField mobilePhoneTextField;

	@FXML
	private Button add_button;

	@FXML
	private Button back_button;

	@FXML
	private Label lab_error;

	@FXML
	private Button ok_zm_button;

	// public DataBaseConnection db;
	// public KlienciController kc;

	private ContactController controller = new ContactController();

	private Alert alert;

	// public Connection conn = null;
	// public PreparedStatement ps = null;
	// public ResultSet rs = null;

	@FXML
	void BackOnAction(ActionEvent event) {

		try {

			Stage stg2 = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/PanelCustomers.fxml"));
			Scene sce = new Scene(root, 600, 400);
			stg2.setScene(sce);
			stg2.setResizable(false);
			stg2.show();

			((Node) event.getSource()).getScene().getWindow().hide();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void ShowEditOnAction(ActionEvent event) throws ClassNotFoundException {

		String result = IdTextField.getText();
		Integer id = Integer.parseInt(result);

		// Klienci kl = DataBaseConnection.getKlienciId(id);

		Customers customer = controller.findEmployee(id);

		firstNameTextField.setText(customer.getFirstName());
		lastNameTextField.setText(customer.getLastName());
		streetTextField.setText(customer.getStreet());
		zipCodeTextField.setText(customer.getZipCode());
		homeTextField.setText(customer.getPlaceOfResidence());
		mobilePhoneTextField.setText(customer.getMobilePhone());

	}

	@FXML
	void OkOnAction(ActionEvent event) throws ClassNotFoundException {

		String result = IdTextField.getText();
		int id = Integer.parseInt(result);

		Customers customer = controller.findEmployee(id);

		// Klienci kl = DataBaseConnection.getKlienciId(id);
		// Klienci kl = new Klienci();

		// String idd = (String) kl.setId(id);

		// IdTextField.setText(kl.setId(id));

		firstNameTextField.setText(customer.getFirstName());
		lastNameTextField.setText(customer.getLastName());
		streetTextField.setText(customer.getStreet());
		zipCodeTextField.setText(customer.getZipCode());
		homeTextField.setText(customer.getPlaceOfResidence());
		mobilePhoneTextField.setText(customer.getMobilePhone());

	}

	@FXML
	void AddOnAction(ActionEvent event) throws SQLException {

		// SprawdzPolaTekst();

		if (checkField1()) {

			String firstName_k = firstNameTextField.getText();
			String lastName_k = lastNameTextField.getText();
			String street_k = streetTextField.getText();
			String zipCode_k = zipCodeTextField.getText();
			String placeOfResidence_k = homeTextField.getText();
			String mobilePhone_k = mobilePhoneTextField.getText();

			Customers k = new Customers();

			k.setFirstName(firstName_k);
			k.setLastName(lastName_k);
			k.setStreet(street_k);
			k.setZipCode(zipCode_k);
			k.setPlaceOfResidence(placeOfResidence_k);
			k.setMobilePhone(mobilePhone_k);

			boolean status = controller.addEmployee(k);

			if (status == true) {

				alert.info("The customer has been added successfully!");
				clearTextField();

			}

			else {

				alert.info("The customer has not been added correctly!");

			}

		}

	}

	@FXML
	void DeleteTabOnAction(ActionEvent event) throws SQLException{
	
		 if(checkField1()){
		 
			 String result = IdTextField.getText(); 
			 Integer id=Integer.parseInt(result); 
			 
			//Customers customer =  new Customers();
			boolean status = controller.removeEmployee(id);
		  
		  
		  
		 
		  
		  if(status == true ){
		  
		  alert.info("The customer has been deleted successfully!");
		  clearTextField();
		  }
		  
		  else{
		  
		  
		  alert.info("The customer has not been removed!");
		 
		  }
		  
		  }
		 
		 
	}

	@FXML
	void EditTabOnAction(ActionEvent event) {

		
		if(checkField2()){

		String result = IdTextField.getText();
		Integer id = Integer.parseInt(result);

		String firstName_k = firstNameTextField.getText();
		String lastName_k = lastNameTextField.getText();
		String street_k = streetTextField.getText();
		String zipCode_k = zipCodeTextField.getText();
		String placeOfResidence_k = homeTextField.getText();
		String mobilePhone_k = mobilePhoneTextField.getText();

		Customers customer = new Customers();

		customer.setFirstName(firstName_k);
		customer.setLastName(lastName_k);
		customer.setStreet(street_k);
		customer.setZipCode(zipCode_k);
		customer.setPlaceOfResidence(placeOfResidence_k);
		customer.setMobilePhone(mobilePhone_k);
		customer.setId(id);

		boolean status = controller.updateEmployee(customer);
		
		
		 if(status == true ){
			  
			  alert.info("The client has been edited correctly!");
			  clearTextField();
			  }
			  
			  else{
			  
			  
			  alert.info("The client has not been edited correctly!");
			 
			  }
			  
			  

		// int status=DataBaseConnection.zmianaDanychKl(kc);

		// if(status>0){

		// al.info("Dane zosta³y zmodyfikowane!");
		// ClearTextField();

		// System.out.println(" Record saved successfully! ");
		// }else{

		// al.info("Dane nie zosta³y zmodyfikowane!");

		 }

	}

	

	public void clearTextField() {
		firstNameTextField.clear();
		lastNameTextField.clear();
		streetTextField.clear();
		zipCodeTextField.clear();
		homeTextField.clear();
		mobilePhoneTextField.clear();

	}

	public boolean checkField1() {

		boolean fieldFirstNameEmpty = ErrorConnection.fieldIsEmpty(firstNameTextField, lab_error,"Complete all fields!");
		boolean fieldLastNameEmpty = ErrorConnection.fieldIsEmpty(lastNameTextField, lab_error, "Complete all fields!");
		boolean fieldStreetEmpty = ErrorConnection.fieldIsEmpty(streetTextField, lab_error, "Complete all fields!");
		boolean fieldZipCodeEmpty = ErrorConnection.fieldIsEmpty(zipCodeTextField, lab_error, "Complete all fields!");
		boolean fieldHomeEmpty = ErrorConnection.fieldIsEmpty(homeTextField, lab_error, "Complete all fields!");
		boolean fieldMobilePhoneEmpty = ErrorConnection.fieldIsEmpty(mobilePhoneTextField, lab_error,
				"Complete all fields!");

		return (fieldFirstNameEmpty && fieldLastNameEmpty && fieldStreetEmpty && fieldZipCodeEmpty && fieldHomeEmpty && fieldMobilePhoneEmpty);

	}

	
	  public boolean checkField2(){
	  
	  
	  boolean fieldIdTextField = ErrorConnection.fieldIsEmpty(IdTextField, lab_error,"Complete all fields!"); 
	  boolean fieldFirstNameEmpty = ErrorConnection.fieldIsEmpty(firstNameTextField, lab_error, "Complete all fields!");
	  boolean fieldLastNameEmpty = ErrorConnection.fieldIsEmpty(lastNameTextField, lab_error, "Complete all fields!"); 
	  boolean fieldStreetEmpty = ErrorConnection.fieldIsEmpty(streetTextField, lab_error, "Complete all fields!"); 
	  boolean fieldZipCodeEmpty = ErrorConnection.fieldIsEmpty(zipCodeTextField, lab_error, "Complete all fields!"); 
	  boolean fieldHomeEmpty = ErrorConnection.fieldIsEmpty(homeTextField, lab_error, "Complete all fields!");
	  boolean fieldMobilePhoneEmpty = ErrorConnection.fieldIsEmpty(mobilePhoneTextField, lab_error, "Complete all fields!");
	  
	  return (fieldIdTextField && fieldFirstNameEmpty && fieldLastNameEmpty && fieldStreetEmpty &&
			  fieldZipCodeEmpty && fieldHomeEmpty && fieldMobilePhoneEmpty);
	  
	  
	  }
	  
	 

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
