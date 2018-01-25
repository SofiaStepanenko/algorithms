package main;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author sofiiastepanenko  5/01/18.
 */
public class ChocolateTest {
    @Test
    public void test1() {
        int[] numbers = {1, 2, 1, 3, 2};
        int day = 3;
        int months = 2;
        Assert.assertEquals(solve(numbers, day, months), 2);
    }

    @Test
    public void test2() {
        int[] numbers = {1, 1, 1, 1, 1, 1};
        int day = 3;
        int months = 2;
        Assert.assertEquals(solve(numbers, day, months), 0);
    }

    @Test
    public void test3() {
        int[] numbers = {4};
        int day = 4;
        int months = 1;
        Assert.assertEquals(solve(numbers, day, months), 1);
    }

    public int solve(int[] s, int d, int m) {

        Assert.assertTrue(1 <= d);
        Assert.assertTrue(d <= 31);
        Assert.assertTrue(1 <= m);
        Assert.assertTrue(m <= 12);
        Assert.assertTrue(1 <= s.length);
        Assert.assertTrue(s.length <= 100);
        for (int i : s) {
            Assert.assertTrue(1 <= i);
            Assert.assertTrue(i <= 5);
        }

        int output = 0;

        if (s.length < m) {
        } else {
            for (int i = 0; i <= (s.length - m); i++) {
                int sum = 0;
                for (int j = 0; j < m; j++) {
                    sum = sum + s[i + j];
                }
                if (sum == d) {
                    output = output + 1;
                }
            }
        }

        return output;
    }

}
