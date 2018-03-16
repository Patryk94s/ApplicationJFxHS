package info.stolarczyk.spring.loader;
import javafx.fxml.FXMLLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class FXMLLoaderProvider {
	
	private AnnotationConfigApplicationContext context;
	
	public FXMLLoader getLoader(String path) {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setControllerFactory(param -> context.getBean(param));
		loader.setLocation(getClass().getResource(path));
		return loader;
	}

	
	
	@Autowired
	public void setContext(AnnotationConfigApplicationContext context) {
		
		this.context = context;
		
		
	}
	
	
}
