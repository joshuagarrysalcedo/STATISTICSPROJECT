package xu.stat.statestix.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    private String ID;
    @FXML
    private HBox aboutHbox;

    @FXML
    private  BorderPane borderPane;

    @FXML
    private HBox homeHB;

    @FXML
    private HBox homeHbox;

    @FXML
    private HBox learnHB;

    @FXML
    private HBox playHB;

    @FXML
    private HBox statsHB;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadPage("/home.fxml");
    }

    public void initData(String ID) {
        this.ID = ID;
    }

    @FXML
    void onAboutClicked(MouseEvent event) {
        loadPage("/about.fxml");
    }

    @FXML
    void onHomeClick(MouseEvent event) {
        loadPage("/home.fxml");
    }

    @FXML
    void onLearnClicked(MouseEvent event) {
        loadPage("/learn.fxml");
    }



    @FXML
    void onPlayClicked(MouseEvent event) {
        loadPage("/play.fxml");
    }

    @FXML
    void onRankingsClicked(MouseEvent event) {
        loadPage("/rankings.fxml");
    }

    @FXML
    void onStatsClicked(MouseEvent event) {
        loadPage("/stats.fxml");
    }

    public void loadPage(String file) {
        Node root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(file));
            borderPane.setCenter(root);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public BorderPane getBorderPane() {
        return borderPane;
    }

    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }

    @FXML
    void onMouseIn(MouseEvent event) {

    }

    @FXML
    void onMouseOut(MouseEvent event) {

    }
}

