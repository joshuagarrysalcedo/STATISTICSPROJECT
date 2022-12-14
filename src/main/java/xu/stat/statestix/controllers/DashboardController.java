package xu.stat.statestix.controllers;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    private String ID;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void initData(String ID) {
        this.ID = ID;
    }
}

