package xu.stat.statestix.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import xu.stat.statestix.data.Question;
import xu.stat.statestix.data.StatTracker;
import xu.stat.statestix.data.Statistics.QuestionGenerator;
import xu.stat.statestix.data.Statistics.Statistics;
import xu.stat.statestix.data.Statistics.probability.Type;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class QuizController implements Initializable {
    private String studentID;
    public static Statistics[] stat;
    public static Question question;
    public static int score = 0;

    private String gameMode;
    private int quantity;
    private int time;
    private static HashMap<Type, StatTracker> map;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


      map = new HashMap<>();





    }

    public void initData(String studentID, Statistics[] stat, String gameMode, int quantity, int time) {
        this.studentID = studentID;
        this.stat = stat;
        this.gameMode = gameMode;
        this.quantity = quantity;
        this.time = time;
        reloadQuestions();
        for(int i = 0; i < stat.length; i++) {
            map.put(stat[i].getType(), new StatTracker(0,0));
        }
        scoreBoard.setText("0");

    }
    @FXML
    private Button buttonA;

    @FXML
    private Button buttonB;

    @FXML
    private Button buttonC;

    @FXML
    private Button buttonD;

    @FXML
    private Label labelA;

    @FXML
    private Label labelB;

    @FXML
    private Label labelC;

    @FXML
    private Label labelD;

    @FXML
    private Button CompleteButton;
    @FXML
    private AnchorPane quizPane;
    @FXML
    private BorderPane boardPaneQuiz;

    @FXML
    private TextField scoreBoard;

    @FXML
    private ImageView nextButton;


    @FXML
    private Spinner<Integer> timer;

    @FXML
    void answerOnClicked(MouseEvent event) {

    }

    @FXML
    void onButtonClicked(MouseEvent event) {
        reloadQuestions();

    }

    @FXML
    void onMouseEntered(MouseEvent event) {

    }

    @FXML
    void onMouseExit(MouseEvent event) {

    }

    @FXML
    void onMouseReleased(MouseEvent event) {

    }

    @FXML
    private TextArea textArea;
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


    public void reloadQuestions() {
        question = QuestionGenerator.generateQuestion(stat);
        buttonA.setText(question.getList().get(0));
        buttonB.setText(question.getList().get(1));
        buttonC.setText(question.getList().get(2));
        buttonD.setText(question.getList().get(3));
        textArea.setText(question.getQuestion());

    }

    @FXML
    void clickOnB(MouseEvent event) {
        boolean check = false;
        String B = buttonB.getText();
        if(B.equalsIgnoreCase(question.getAnswer())) {
            score++;
            scoreBoard.setText(Integer.toString(score));
            reloadQuestions();
            check = true;
        }
        updateStats(question, check);
        reloadQuestions();

    }

    @FXML
    void clickOnC(MouseEvent event) {
        boolean check = false;
        String B = buttonA.getText();
        if(B.equalsIgnoreCase(question.getAnswer())) {
            score++;
            scoreBoard.setText(Integer.toString(score));
            reloadQuestions();
            check = true;
        }
        updateStats(question, check);
        reloadQuestions();
    }

    @FXML
    void clickOnD(MouseEvent event) {
        boolean check = false;
        String B = buttonD.getText();
        if(B.equalsIgnoreCase(question.getAnswer())) {
            score++;
            scoreBoard.setText(Integer.toString(score));
            reloadQuestions();
            check = true;
        }
        updateStats(question, check);
        reloadQuestions();
    }

    @FXML
    void clickonA(MouseEvent event) {
        boolean check = false;
        String B = buttonA.getText();
        if(B.equalsIgnoreCase(question.getAnswer())) {
            score++;
            scoreBoard.setText(Integer.toString(score));

            check = true;
        }
        updateStats(question, check);
        reloadQuestions();
    }

    public void updateStats(Question question, boolean correct) {
        int totalAttempt = map.get(question.getType()).getTotalAttempt();
        int totalScore = map.get(question.getType()).getTotalScore();
        if(correct){
            totalAttempt++;
            totalScore++;
        }else{
            totalAttempt++;
        }
        map.get(question.getType()).setTotalAttempt(totalAttempt);
        map.get(question.getType()).setTotalScore(totalAttempt);
        System.out.println("Score update:");
        System.out.println(question.getType() + "\"");
        System.out.println("Total Attempt: "  + totalAttempt);
        System.out.println("Total Score: "  + totalScore);
        System.out.println(correct);

    }
}
