package xu.stat.statestix.data.Statistics;



import org.apache.commons.math3.stat.StatUtils;
import xu.stat.statestix.data.Question;
import xu.stat.statestix.util.MathUTIL;

public class Mean extends Statistics{

    private double[] set;
    private double mean;
    public Mean() {
        super();
        setSubject("Mean");
        setDescription("A mean in maths is the average of a data set");
    }

    public double calculateMean(double[] set){
        double mean = StatUtils.mean(set);
        return Double.parseDouble(MathUTIL.df.format(mean));
    }

    public double[] getSet() {
        return set;
    }

    public void setSet(double[] set) {
        this.set = set;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }
}
