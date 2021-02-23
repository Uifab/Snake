module client {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	exports application;
	
	opens controller to javafx.fxml;
}