package xu.stat.statestix.data.Statistics;

import xu.stat.statestix.data.Statistics.probability.Type;

public class Mean extends Statistics{

    public Mean() {
        setType(Type.MEAN);
        setDescription("A mean in maths is the average of a data set");

    }


    @Override
    public double result(double[] array) {
       double result = org.apache.commons.math3.stat.StatUtils.mean(array);
        System.out.println("result in Mean: " + result);
       setResult(result);
       return result;
    }
}
