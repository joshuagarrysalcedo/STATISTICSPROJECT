package xu.stat.statestix.data.Statistics;

import org.apache.commons.math3.stat.StatUtils;
import xu.stat.statestix.util.MathUTIL;

public class Mode extends Statistics{
    public double[] set;
    public double mode;
    public Mode() {
        super();
        setSubject("Mode");
        setDescription("The mode is the value that appears most frequently in a data set");
    }

    public double findMode(double[] set){
        StatUtils.mode(set);
        return Double.parseDouble(MathUTIL.df.format(set));
    }
}
