package info.stolarczyk.javafx.models;

import org.springframework.stereotype.Component;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

//@Component
public class ErrorConnection {

	public static boolean fieldIsNotEmpty(TextField tf) {

		boolean bool = false;

		if (tf.getText().length() != 0) {

			bool = true;

		}

		return bool;

	}

	public static boolean fieldIsEmpty(TextField tf, Label lb, String bmessage) {

		boolean bool = true;
		String message = null;

		if (!fieldIsNotEmpty(tf)) {

			bool = false;
			message = bmessage;

		}

		lb.setText(message);
		return bool;

	}

}
