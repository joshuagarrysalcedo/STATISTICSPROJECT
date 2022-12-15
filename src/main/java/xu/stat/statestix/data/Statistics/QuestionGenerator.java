package xu.stat.statestix.data.Statistics;

import xu.stat.statestix.data.Question;
import xu.stat.statestix.data.Statistics.probability.Probability;
import xu.stat.statestix.data.Statistics.probability.Type;
import xu.stat.statestix.util.MathUTIL;

import java.util.ArrayList;
import java.util.Random;

public class QuestionGenerator {

    private QuestionGenerator(){}

    public static Question generateQuestion(Statistics[] stat) {

        Random ran = new Random();
        int n = ran.nextInt(stat.length);
        int len = ran.nextInt(11) + 5;
        double set[] = new double[len];
        for(int i = 0; i < len; i++) {
            set[i] = ran.nextInt(20) + 1;
        }
        if(stat[n].getType() == Type.PROB) {
            Probability prob = new Probability();
            return prob.generateQuestion();
        }else{
            String question = stat[n].generateStringQuestion(set, stat[n].getType());
            String answer = MathUTIL.df.format(stat[n].result(set));
            ArrayList<String> choices = stat[n].generateChoices(stat[n].result(set));
            Question  q = new Question(question, answer, choices, stat[n].getType());
            return q;
        }
    }
}
