package xu.stat.statestix.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import xu.stat.statestix.util.ControlUtil;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class QuizController implements Initializable {
    private String studentID;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void initData(String studentID) {
        this.studentID = studentID;
    }

    @FXML
    private Button CompleteButton;
    @FXML
    private AnchorPane quizPane;
    @FXML
    void onButtonClick(MouseEvent event) throws IOException {
        System.out.println("Button clicked!");
        System.out.println("Button clicked!");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/dashboard.fxml"));
        Parent menuParent = loader.load();
        Scene scene = new Scene(menuParent);
        DashboardController controller = loader.getController();
        controller.initData("1234");

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.centerOnScreen();
        window.show();
    }

}
