package xu.stat.statestix.data;

import java.util.Arrays;
import java.util.HashMap;

public class Question {
    private String question;
    private HashMap<Character, String> choices;
    private String answer;

    public Question(String question,  String answer, HashMap<Character, String> choices) {
        this.question = question;
        this.choices = choices;
        this.answer = answer;
    }

    public Question(String question) {
        this.question = question;
    }

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public HashMap<Character, String> getChoices() {
        return choices;
    }

    public void setChoices(double answer) {

    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", choices=" + choices +
                ", answer='" + answer + '\'' +
                '}';
    }
}
