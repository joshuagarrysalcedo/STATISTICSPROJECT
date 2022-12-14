package xu.stat.statestix.data.Statistics;

import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import xu.stat.statestix.util.MathUTIL;

public class Median extends Statistics{
    private double[] set;
    private double median;
    public Median() {
        super();
        setSubject("Median");
        setDescription("The median is the middle value of a set of numbers.");
    }

    public double findMedian(double[] set){
        org.apache.commons.math3.stat.descriptive.rank.Median med = new org.apache.commons.math3.stat.descriptive.rank.Median();
        double answer = med.evaluate(set);
        return Double.parseDouble(MathUTIL.df.format(answer));
    }
}
