package xu.stat.statestix.data.Statistics;

import org.apache.commons.math3.stat.descriptive.rank.Median;
import xu.stat.statestix.util.MathUTIL;

import java.util.ArrayList;
import java.util.Collections;

public class Range extends Statistics {
    private double answer;

    public Range() {
        super();
        setSubject("Range");
        setDescription("A mean in maths is the average of a data set");
    }


    public double range(double[] set) {
        double x = org.apache.commons.math3.stat.StatUtils.max(set);
        double y = org.apache.commons.math3.stat.StatUtils.min(set);
        double answer = x - y;

        return Double.parseDouble(MathUTIL.df.format(answer));
    }
}
