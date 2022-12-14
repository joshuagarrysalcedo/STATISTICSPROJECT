package xu.stat.statestix.test;

import xu.stat.statestix.data.Question;
import xu.stat.statestix.data.Statistics.probability.Coin;
import xu.stat.statestix.data.Statistics.probability.ProbabilityQuestions;

import java.math.BigDecimal;
import java.util.ArrayList;

public class sample {
    public static void main(String[] args) {
        System.out.println(Coin.map.get(0));

        ProbabilityQuestions questions = new ProbabilityQuestions();
        ArrayList<Question> list = questions.generateQuestions(20);

        for(Question i : list) {
            System.out.println(i);
        }

        ProbabilityQuestions p = new ProbabilityQuestions();
        System.out.println(p.getAnswerInPercent(.00000000000323));

        BigDecimal decimal = new BigDecimal("100");
        System.out.println(decimal);
        BigDecimal percentage = decimal.multiply(new BigDecimal(.00000000000323/100.0));
        System.out.println(percentage);

    }
}
