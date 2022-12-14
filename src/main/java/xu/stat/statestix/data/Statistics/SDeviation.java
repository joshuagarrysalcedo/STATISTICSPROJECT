package xu.stat.statestix.data.Statistics;

import xu.stat.statestix.util.MathUTIL;

public class SDeviation extends Statistics {

    private double[] set;
    private int sdeviation[];

    public SDeviation(){
        super();
        setSubject("Standard Deviation");
        setDescription("Standard Deviation is a measure of the amount of variation or dispersion of a set of values.");
    }

    public double findSDeviation(double[] array) {

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

        return Double.parseDouble(MathUTIL.df.format(Math.sqrt(standardDeviation / length)));
    }

}
