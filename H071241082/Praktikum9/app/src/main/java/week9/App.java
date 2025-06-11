  package week9;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/register.fxml"));
        //inisialisasi scene
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
        //inisialisasi stage
        primaryStage.setTitle("JavaFX Photo App");
        //menambhkan scene dalam stage
        primaryStage.setScene(scene);
        //menamppilkan stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}