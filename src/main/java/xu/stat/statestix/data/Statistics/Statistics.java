package xu.stat.statestix.data.Statistics;

import xu.stat.statestix.data.Statistics.probability.Type;
import xu.stat.statestix.util.MathUTIL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public abstract class Statistics{
    private String description;
    private String answer;
    private Type type;

    private double result;
    private ArrayList<String> choices = new ArrayList<>();

    public Statistics() {

    }

    public  double result(double[] set) {
        return new Double(null);
    }
    public ArrayList<String> generateChoices(double result){
         choices = new ArrayList<>();
         choices.add(MathUTIL.df.format(result));
         choices.add(MathUTIL.df.format(result*.95));
         choices.add(MathUTIL.df.format(result*1.05));
         choices.add(MathUTIL.df.format(result* .98));

        Collections.shuffle(choices);
        return choices;
    }

    public String getDescription() {
        return description;
    }

    public String getAnswer() {
        return answer;
    }

    public Type getType() {
        return type;
    }

    public ArrayList<String> getChoices() {
        return choices;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String generateStringQuestion(double set[], Type type){
        return String.format("Find the %s of the following set: %s", type.getTopic(), Arrays.toString(set));
    }

    public void setResult(double result) {
        this.result = result;
    }
}

