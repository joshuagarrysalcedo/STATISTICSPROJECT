package xu.stat.statestix.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import xu.stat.statestix.data.User;
import xu.stat.statestix.database.UserDB;

import java.io.IOException;

public class LoginController {

    @FXML
    private SplitPane dashboardPane;

    @FXML
    private TextField emailLog;

    @FXML
    private TextField emailReg;

    @FXML
    private TextField fnameReg;

    @FXML
    private TextField lastNameReg;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passLog;

    @FXML
    private PasswordField passwordReg;

    @FXML
    private Button regButton;

    @FXML
    void clickRegister(MouseEvent event) {
        if(emailReg != null && fnameReg != null && lastNameReg != null && passwordReg != null) {

            User user = new User(emailReg.getText(), fnameReg.getText(), lastNameReg.getText(), passwordReg.getText());
            UserDB.addUser(user);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Registration Complete!");
            alert.showAndWait();
            emailReg.setText(null);
            fnameReg.setText(null);
            lastNameReg.setText(null);
            passwordReg.setText(null);
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "Input properly");
            alert.showAndWait();
        }
    }

    @FXML
    void loginButton(MouseEvent event) throws IOException {
        if(emailLog != null && passLog != null) {

            System.out.println("Button clicked!");
            if(UserDB.authenticateLogIn(emailLog.getText(), passLog.getText())) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/dashboard.fxml"));
                Parent menuParent = loader.load();
                Scene scene = new Scene(menuParent);
                DashboardController controller = loader.getController();
                controller.initData(UserDB.retrieveData(emailLog.getText(), "id"));
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR, "Incorrect Login!");
                alert.showAndWait();
                emailLog.setText(null);
                passLog.setText(null);
            }

        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Input properly");
            alert.showAndWait();
        }

    }

}