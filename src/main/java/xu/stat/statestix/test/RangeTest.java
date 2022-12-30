//package xu.stat.statestix.test;
//
//import org.junit.Test;
//import xu.stat.statestix.data.Statistics.Median;
//import xu.stat.statestix.data.Statistics.Range;
//
//import static org.testng.AssertJUnit.assertEquals;
//
//public class RangeTest {
//    Range rg = new Range();
//
//    public void testFormat(double[] set, double expected) {
//        double result = rg.range(set);
//
//        System.out.println("Expected: " + expected);
//        System.out.println("Result: " + result);
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void test1() {
//        double set[] = {17, 18, 21, 29, 33, 34, 54, 67, 78, 79};
//        double expected = 62;
//        testFormat(set, expected);
//    }
//
//    @Test
//    public void test2() {
//        double set[] = {12, 16, 23, 26, 28, 32, 56, 71, 75, 97};
//        double expected = 85;
//        testFormat(set, expected);
//    }
//
//    @Test
//    public void test3() {
//        double set[] = {17, 24, 40, 59, 63, 70, 83, 87, 88, 93};
//        double expected = 76;
//        testFormat(set, expected);
//    }
//}