package xu.stat.statestix.data;

import xu.stat.statestix.data.Statistics.probability.Type;

import java.util.ArrayList;
import java.util.HashMap;

public class Question {
    private String question;
    private ArrayList<String> list;
    private String answer;
    private Type type;



    public Question(String question, String answer, ArrayList<String> list, Type type) {
        this.question = question;
        this.list = list;
        this.answer = answer;
        this.type = type;
    }



    public String getQuestion() {
        return question;
    }


    public ArrayList<String> getList() {
        return list;
    }

    public String getAnswer() {
        return answer;
    }


    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", choices=" + list +
                ", answer='" + answer + '\'' +
                '}';
    }

    public Type getType() {
        return type;
    }
}
