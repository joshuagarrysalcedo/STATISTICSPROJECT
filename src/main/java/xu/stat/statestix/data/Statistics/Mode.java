package xu.stat.statestix.data.Statistics;

import xu.stat.statestix.data.Statistics.probability.Type;
import xu.stat.statestix.util.MathUTIL;

import java.util.Arrays;
import java.util.HashMap;

public class Mode extends Statistics{

    public Mode() {
        setType(Type.MODE);
        setDescription("The mode is the value that appears most frequently in a data set");

    }

    @Override
    public double result(double[] array) {
        System.out.println("Result in MODE: " + org.apache.commons.math3.stat.StatUtils.mode(array)[0]);
        setResult(org.apache.commons.math3.stat.StatUtils.mode(array)[0]);
        return org.apache.commons.math3.stat.StatUtils.mode(array)[0];
    }



}
