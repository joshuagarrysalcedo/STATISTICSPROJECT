package xu.stat.statestix;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StatestixApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StatestixApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 700);
        scene.getStylesheets().add("style.css");
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}