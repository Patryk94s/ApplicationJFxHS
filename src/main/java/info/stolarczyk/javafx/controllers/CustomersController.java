package info.stolarczyk.javafx.controllers;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import info.stolarczyk.dao.HibernateDaoImpl;
import info.stolarczyk.javafx.models.Alert;
import info.stolarczyk.javafx.models.Customers;
import info.stolarczyk.javafx.models.CustomersTable;
import info.stolarczyk.service.HibernateServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

@Component
public class CustomersController implements Initializable {

	
	
	
		@FXML
	    private TableView<CustomersTable> customers_table;

	    @FXML
	    private TableColumn<CustomersTable, Integer> Id_column;

	    @FXML
	    private TableColumn<CustomersTable, String> firstName_column;

	    @FXML
	    private TableColumn<CustomersTable, String> lastName_column;

	    @FXML
	    private TableColumn<CustomersTable, String> street_column;

	    @FXML
	    private TableColumn<CustomersTable, String> zipCode_column;

	    @FXML
	    private TableColumn<CustomersTable, String> town_column;

	    @FXML
	    private TableColumn<CustomersTable, String> mobilePhone_column;
    
	    private ContactController controller = new ContactController();
	    private HibernateServiceImpl  hibernateServiceImpl = new HibernateServiceImpl() ;
	    private HibernateDaoImpl hibernateDaoImpl = new HibernateDaoImpl();
	  //  private CustomersTable customersTbale;
	    //private ObservableList<Customers> customersList = FXCollections.observableArrayList();
    
	   

	    private List<Customers> listCustomers =  hibernateServiceImpl.listEmployee();
	    
	    private ObservableList<CustomersTable> listCustomersTable= FXCollections.observableArrayList();
	    //private Alert alert;
   
  //  private HibernateDaoImpl hibernateDaoImpl;
   
    
   
	   
    
    
    
    

  
    
    
    
    public void setTable(){
   // 	customers_table.getItems().clear();
    	    
    //	customers_table.setItems(controller.getCustomersList());
      	
      	Id_column.setCellValueFactory(new PropertyValueFactory<CustomersTable,Integer>("id"));
      	firstName_column.setCellValueFactory(new PropertyValueFactory<CustomersTable,String>("firstName"));
      	lastName_column.setCellValueFactory(new PropertyValueFactory<CustomersTable,String>("Last Name"));
      	street_column.setCellValueFactory(new PropertyValueFactory<CustomersTable,String>("Street"));
      	zipCode_column.setCellValueFactory(new PropertyValueFactory<CustomersTable,String>("Zip Code"));
      	town_column.setCellValueFactory(new PropertyValueFactory<CustomersTable,String>("Town"));
      	mobilePhone_column.setCellValueFactory(new PropertyValueFactory<CustomersTable,String>("Mobile Phone"));
      //	customers_table.getColumns().setAll(Id_column, firstName_column,lastName_column,street_column, zipCode_column,town_column, mobilePhone_column);
      		
      	customers_table.setItems(listCustomersTable);
      }

  
  public void loadData() {
  	
	  //customersList.clear();
  	
	
			
		//	 customersList= FXCollections.observableArrayList();
		//	ps = conn.prepareStatement("SELECT * FROM Klienci");
			//rs=ps.executeQuery();
			
			//  while (rs.next()){
	          //  	data.add(new Customers(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
	           // }
	            
  	
	  

		//setTable();
		//customers_table.setItems(null);
	//	customers_table.setItems(customersList);
	  
	 // if (controller.getCustomersList().isEmpty())
       //   return;
	  
	  if (!listCustomersTable.isEmpty()) {
		  listCustomersTable.clear();
		//contactList = FXCollections.observableList((List<Customers>) contactService.listEmployee());
		//return contactList;
	  }
	  for(Customers customer: listCustomers) {
		  
		  
		  CustomersTable ct = new CustomersTable(customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getStreet(),customer.getZipCode(), customer.getPlaceOfResidence(), customer.getMobilePhone());
		  listCustomersTable.add(ct);
		  
	  }
	//  Id_column.setCellValueFactory(new PropertyValueFactory<CustomersTable,Integer>("Id"));
	  
	  	Id_column.setCellValueFactory(new PropertyValueFactory<CustomersTable,Integer>("propertyid"));
    	firstName_column.setCellValueFactory(new PropertyValueFactory<CustomersTable,String>("firstName"));
    	lastName_column.setCellValueFactory(new PropertyValueFactory<CustomersTable,String>("lastName"));
    	street_column.setCellValueFactory(new PropertyValueFactory<CustomersTable,String>("street"));
    	zipCode_column.setCellValueFactory(new PropertyValueFactory<CustomersTable,String>("zipCode"));
    	town_column.setCellValueFactory(new PropertyValueFactory<CustomersTable,String>("placeOfResidence"));
    	mobilePhone_column.setCellValueFactory(new PropertyValueFactory<CustomersTable,String>("mobilePhone"));
    //	customers_table.getColumns().setAll(Id_column, firstName_column,lastName_column,street_column, zipCode_column,town_column, mobilePhone_column);
    		
    	customers_table.setItems(listCustomersTable);
	  
		/*
     Customers c = (Customers) controller.getCustomersList();
     Id_column.setText(c.getId().toString());
     firstName_column.setText(c.getFirstName());
     lastName_column.setText(c.getLastName());
     street_column.setText(c.getStreet());
     town_column.setText(c.getPlaceOfResidence());
     zipCode_column.setText(c.getZipCode());
     mobilePhone_column.setText(c.getMobilePhone());
		
  */
  	
  	
}


@Override
public void initialize(URL location, ResourceBundle resources) {
	loadData();
	
}
    
}


