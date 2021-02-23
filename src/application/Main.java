package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			 primaryStage.setTitle("Key Event");

			
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/GameView.fxml"));
			Scene scene = new Scene(root,800,800);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
			scene.getRoot().requestFocus();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
