package xu.stat.statestix.test;

import org.junit.Test;
import xu.stat.statestix.data.Statistics.Permutation;

import static org.junit.Assert.assertEquals;

public class PermutationTest {
    public void testFormat(int num1, int num2, int expected){
        Permutation test = new Permutation();
        int result = test.sum(num1, num2);
        assertEquals(expected, result);
    }

    @Test
    public void test1(){
        testFormat(1, 1, 2);
    }
    @Test
    public void test2(){
        testFormat(2, 2, 4);
    }
    @Test
    public void test3(){
        testFormat(4, 1, 5);
    }
    @Test
    public void test4(){
        testFormat(3, 2, 5);
    }
    @Test
    public void test5(){
        testFormat(10, 7, 17);
    }
}
