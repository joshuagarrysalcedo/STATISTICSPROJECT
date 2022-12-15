package xu.stat.statestix.data.Statistics;
import xu.stat.statestix.data.Statistics.probability.Type;


public class Median extends Statistics{

    public Median() {
        setType(Type.MEDIAN);
        setDescription("The median is the middle value of a set of numbers.");
    }


    @Override
    public double result(double[] array) {
        org.apache.commons.math3.stat.descriptive.rank.Median med = new org.apache.commons.math3.stat.descriptive.rank.Median();
        System.out.println("Result in Median: " + med.evaluate(array));
        setResult(med.evaluate(array));
        return med.evaluate(array);
    }
}
