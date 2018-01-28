package main;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * https://docs.google.com/document/d/1w0wlvZ-O4FURbPgtPLn-D1_n0Oc47ssZ2xxri11QNHc/edit
 * @author sofiiastepanenko  5/01/18.
 */
public class RecordsTest {

    @Test
    public void recordsTest1() {
        int[] test = {10, 5, 20, 20, 4, 5, 2, 25, 1};
        int[] expectedRecords = {2, 4};
        Assert.assertEquals(breakingRecords(test), expectedRecords);
    }

    @Test
    public void recordsTest2() {
        int[] test = {3, 4, 21, 36, 10, 28, 35, 5, 24, 42};
        int[] expectedRecords = {4, 0};
        Assert.assertEquals(breakingRecords(test), expectedRecords);
    }

    @Test
    public void recordsTest3() {
        int[] test = {10};
        int[] expectedRecords = {0, 0};
        Assert.assertEquals(breakingRecords(test), expectedRecords);
    }

    private int[] breakingRecords(int[] score) {

        Assert.assertTrue(1 <= score.length);
        Assert.assertTrue(score.length <= 1000);
        for (int i : score) {
            Assert.assertTrue(0 <= i);
            Assert.assertTrue(i <= 100000000);
        }

        int[] output = {0, 0};
        int max = score[0];
        int min = score[0];

        for (int i : score) {
            if (i > max) {
                output[0] = output[0] + 1;
                max = i;
            }
            if (i < min) {
                output[1] = output[1] + 1;
                min = i;
            }
        }

        return output;
    }

}
