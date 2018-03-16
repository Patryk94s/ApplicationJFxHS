package info.stolarczyk.javafx.models;
	
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import info.stolarczyk.spring.config.SpringConfig;
import info.stolarczyk.spring.loader.FXMLLoaderProvider;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {

	@Override
	public void start(Stage pS) {
		try {

			 AnnotationConfigApplicationContext context = new
			AnnotationConfigApplicationContext(SpringConfig.class);
			//Parent root = FXMLLoader.load(getClass().getResource("/Login.fxml"));
			FXMLLoader loader = context.getBean(FXMLLoaderProvider.class).getLoader("/Login.fxml");
			Parent root = loader.load();
			Scene scene = new Scene(root, 500, 300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			pS.setScene(scene);
			pS.setTitle("Login Panel");
			pS.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		
		public static void main(String[] args) {
			launch(args);
		}
	}


