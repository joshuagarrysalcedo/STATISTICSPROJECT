package xu.stat.statestix.controllers;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class AboutController implements Initializable {
    private String userID;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void initData(String userID){
        this.userID = userID;
    }
}
