package xu.stat.statestix.controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import xu.stat.statestix.data.RatingList;
import xu.stat.statestix.data.User;
import xu.stat.statestix.database.UserDB;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

public class RankingsController implements Initializable {
    @FXML
    private AnchorPane dashboardPane;

    @FXML
    private TextArea rankingList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}


