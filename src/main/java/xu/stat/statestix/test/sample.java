package xu.stat.statestix.test;

import xu.stat.statestix.data.Statistics.*;
import xu.stat.statestix.data.Statistics.probability.Probability;

public class sample {
    public static void main(String[] args) {
//        System.out.println(Coin.map.get(0));
//
//        ProbabilityQuestions questions = new ProbabilityQuestions();
//        ArrayList<Question> list = questions.generateQuestions(20);
//
//        for(Question i : list) {
//            System.out.println(i);
//        }
//
//        ProbabilityQuestions p = new ProbabilityQuestions();
//        System.out.println(p.getAnswerInPercent(.00000000000323));
//
//        BigDecimal decimal = new BigDecimal("100");
//        System.out.println(decimal);
//        BigDecimal percentage = decimal.multiply(new BigDecimal(.00000000000323/100.0));
//        System.out.println(percentage);

//        Mode mode = new Mode();
//        Mean mean = new Mean();
//        System.out.println(mode.getClass().getName());
//        System.out.println(mean.getClass().getName());


        Statistics[] stat = {new Mode(), new Median(), new Mean(), new SDeviation(), new Range(), new Probability()};

        for(int i = 0; i < 100; i++) {
            System.out.println(QuestionGenerator.generateQuestion(stat));
        }

    }
}
