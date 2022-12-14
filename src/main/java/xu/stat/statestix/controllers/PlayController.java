package xu.stat.statestix.controllers;

import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.EventListener;

public class PlayController {

    @FXML
    private AnchorPane dashboardPane;

    @FXML
    private CheckBox meanChk;

    @FXML
    private CheckBox medfianCk;

    @FXML
    private CheckBox modeCh;

    @FXML
    private CheckBox probChk;

    @FXML
    private CheckBox rangeChk;

    @FXML
    private CheckBox sdChk;

    @FXML
    private Button startBtn;

    @FXML
    private CheckBox varianceChk;
    @FXML
    private ComboBox<Integer> quantityCB;
    @FXML
    private ComboBox<Integer> timeCB;

    @FXML
    private ComboBox<String> modeCB;

    @FXML
    void onMouseEnter(MouseEvent event) {

    }

    @FXML
    void onMouseExit(MouseEvent event) {

    }

    @FXML
    void onStartButtonClicked(MouseEvent event) throws IOException {
        System.out.println("startButton Clicked");

        System.out.println("Button clicked!");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/quiz.fxml"));
        Parent menuParent = loader.load();
        Scene scene = new Scene(menuParent);
        QuizController controller = loader.getController();
        controller.initData("1234");
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void initialize() {
        ObservableList<String> modes =
                FXCollections.observableArrayList(
                        "Timed",
                        "Classic",
                        "Unlimited"
                );

        ObservableList<Integer> time =
                FXCollections.observableArrayList(
                        2,
                            5,
                           10
                );
        ObservableList<Integer> quantity =
                FXCollections.observableArrayList(
                        10,
                        20,
                        30
                );
        modeCB.setItems(modes);
        timeCB.setItems(time);
        quantityCB.setItems(quantity);

        modeCB.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if(modeCB.getValue() == "Timed") {
                    timeCB.setDisable(false);
                    quantityCB.setDisable(true);
                }
                if(modeCB.getValue() == "Unlimited") {
                    timeCB.setDisable(true);
                    quantityCB.setDisable(true);
                }
                if(modeCB.getValue() == "Classic") {
                    timeCB.setDisable(true);
                    quantityCB.setDisable(false);
                }
            }
        });
        ObservableList<CheckBox> checkBoxes = FXCollections.observableArrayList();
        checkBoxes.addAll(meanChk, medfianCk, modeCh, probChk, sdChk, rangeChk, varianceChk);

        startBtn.disableProperty().bind(Bindings.not(meanChk.selectedProperty().or(modeCh.selectedProperty()).or(medfianCk.selectedProperty()
                .or(probChk.selectedProperty().or(sdChk.selectedProperty().or(rangeChk.selectedProperty().or(varianceChk.selectedProperty())))))));

        }



}
