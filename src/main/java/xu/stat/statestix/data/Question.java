package xu.stat.statestix.data;

import java.util.Arrays;

public class Question {
    private String question;
    private String[] choices;
    private String answer;

    public Question(String question, String[] choices, String answer) {
        this.question = question;
        this.choices = choices;
        this.answer = answer;
    }

    public Question(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getChoices() {
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
                ", choices=" + Arrays.toString(choices) +
                ", answer='" + answer + '\'' +
                '}';
    }
}
