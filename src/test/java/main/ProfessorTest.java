package main;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * https://docs.google.com/document/d/1cLQgFHuceNrjYODGKMRZ0gvwILPiwkqQSkxfrHKExPc/edit
 * @author sofiiastepanenko  15/01/18.
 */
public class ProfessorTest {

    @Test
    public void test(){
        int threshold = 3;
        int[] timeArrival = { -1, -3, 4, 2};
        Assert.assertEquals(angryProfessor(threshold, timeArrival), "YES");
    }
    @Test
    public void test1(){
        int threshold = 2;
        int[] timeArrival = { 0, -1, 2, 1};
        Assert.assertEquals(angryProfessor(threshold, timeArrival), "NO");
    }

    private String angryProfessor(int k, int[] a) {

        String response = "NO";
        int studentsArrived = 0;

        for (int i : a) {
            if (i <= 0) {
                studentsArrived++;
            }
        }

        if (studentsArrived < k) {
            response = "YES";
        }

        return response;
    }

}
