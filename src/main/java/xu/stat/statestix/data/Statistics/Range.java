package xu.stat.statestix.data.Statistics;

import xu.stat.statestix.data.Statistics.Statistics;
import xu.stat.statestix.data.Statistics.probability.Type;
import xu.stat.statestix.util.MathUTIL;

public class Range extends Statistics{
    public Range() {
        setType(Type.RANGE);
        setDescription("The Range is the difference between the lowest and highest values.");
    }

    @Override
    public double result(double[] array) {
        double x = org.apache.commons.math3.stat.StatUtils.max(array);
        double y = org.apache.commons.math3.stat.StatUtils.min(array);
        double answer = x - y;
        System.out.println("Result in : Range" + Double.parseDouble(MathUTIL.df.format(answer)));
        setResult(Double.parseDouble(MathUTIL.df.format(answer)));
        return Double.parseDouble(MathUTIL.df.format(answer));
    }
}











//package xu.stat.statestix.data.Statistics;
//;
//import xu.stat.statestix.data.Question;
//import xu.stat.statestix.data.Statistics.probability.TOPIC;
//import xu.stat.statestix.util.MathUTIL;
//
//import java.util.Arrays;
//import java.util.HashMap;
//
//
//public class Range extends Statistics implements Answerable, Questionnaire{
//    private double range;
//    private double[] set;
//    public Range(double[] set) {
//        super();
//        setTopic(TOPIC.RANGE);
//        setDescription("The Range is the difference between the lowest and highest values.");
//        setRange(set);
//    }
//
//    public void setRange(double[] set) {
//        double x = org.apache.commons.math3.stat.StatUtils.max(set);
//        double y = org.apache.commons.math3.stat.StatUtils.min(set);
//        double answer = x - y;
//
//        this.range=Double.parseDouble(MathUTIL.df.format(answer));
//    }
//
//
//    @Override
//    public double result(double[] set) {
//        return this.range;
//    }
//
//    @Override
//    public Question generateQuestion(String question, String answer, HashMap<Character, String> choices) {
//        return null;
//    }
//
//    @Override
//    public String theQuestion() {
//        return String.format("Find the Range of the Following set: %s", Arrays.toString(this.set));
//    }
//
//    @Override
//    public Question generateQuestion() {
//        return null;
//    }
//}
