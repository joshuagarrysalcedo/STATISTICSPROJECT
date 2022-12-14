package xu.stat.statestix.test;

import org.junit.Assert;
import org.junit.Test;
import xu.stat.statestix.data.Statistics.Median;

import static org.testng.AssertJUnit.assertEquals;


public class MedianTest {
    Median median = new Median();

    public void testFormat(double[] set, double expected) {
        double result = median.findMedian(set);

        System.out.println("Expected: " + expected);
        System.out.println("Result: " + result);
        assertEquals(expected, result);
    }

    @Test
    public void test1() {
        double set[] = {17, 18, 21, 29, 33, 34, 54, 67, 78, 79};
        double expected = 33.5;
        testFormat(set, expected);
    }

    @Test
    public void test2() {
        double set[] = {12, 16, 23, 26, 28, 32, 56, 71, 75, 97};
        double expected = 30;
        testFormat(set, expected);
    }

    @Test
    public void test3() {
        double set[] = {17, 24, 40, 59, 63, 70, 83, 87, 88, 93};
        double expected = 66.5;
        testFormat(set, expected);
    }
}
