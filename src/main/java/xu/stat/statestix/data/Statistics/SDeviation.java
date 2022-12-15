package xu.stat.statestix.data.Statistics;

import xu.stat.statestix.data.Statistics.probability.Type;
import xu.stat.statestix.util.MathUTIL;

public class SDeviation extends Statistics {

    public SDeviation() {
        super();
        setDescription("Standard Deviation is a measure of the amount of variation or dispersion of a set of values.");
        setType(Type.SD);
    }

    @Override
    public double result(double[] array) {
                double sum = 0.0;
        for (double i : array) {
            sum += i;
        }

        int length = array.length;
        double mean = sum / length;

        double standardDeviation = 0.0;
        for (double num : array) {
            standardDeviation += Math.pow(num - mean, 2);
        }
        System.out.println("Result in SD " + Double.parseDouble(MathUTIL.df.format(Math.sqrt(standardDeviation / length))));
        setResult(Double.parseDouble(MathUTIL.df.format(Math.sqrt(standardDeviation / length))));
        return Double.parseDouble(MathUTIL.df.format(Math.sqrt(standardDeviation / length)));
    }
}














//package xu.stat.statestix.data.Statistics;
//
//import xu.stat.statestix.data.Question;
//import xu.stat.statestix.data.Statistics.probability.TOPIC;
//import xu.stat.statestix.util.MathUTIL;
//
//import java.util.HashMap;
//
//public class SDeviation extends Statistics implements Answerable, Questionnaire{
//
//    private double sdeviation;
//    private double[] set;
//    public SDeviation(double set[]){
//        super();
//        setTopic(TOPIC.SD);
//        setDescription("Standard Deviation is a measure of the amount of variation or dispersion of a set of values.");
//        setSD(set);
//    }
//
//    public void setSD(double[] array) {
//
//        double sum = 0.0;
//        for (double i : array) {
//            sum += i;
//        }
//
//        int length = array.length;
//        double mean = sum / length;
//
//        double standardDeviation = 0.0;
//        for (double num : array) {
//            standardDeviation += Math.pow(num - mean, 2);
//        }
//
//        this.sdeviation = Double.parseDouble(MathUTIL.df.format(Math.sqrt(standardDeviation / length)));
//    }
//
//    @Override
//    public double result(double[] set) {
//        return this.sdeviation;
//    }
//
//    @Override
//    public Question generateQuestion(String question, String answer, HashMap<Character, String> choices) {
//        return null;
//    }
//
//    @Override
//    public String theQuestion() {
//        return String.format("Find the Standard deviation of the Following set : %s", this.set);
//    }
//
//    @Override
//    public Question generateQuestion() {
//        return null;
//    }
//}
