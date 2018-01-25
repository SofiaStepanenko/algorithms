package main;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author sofiiastepanenko  5/01/18.
 */
public class KangarooTest {

    @DataProvider(name = "kangaroo")
    public static Object[][] kang() {
        return new Object[][]{
                {0, 3, 4, 2, "YES"},
                {0, 2, 5, 3, "NO"},
                {14, 4,  98, 2, "YES"}
        };
    }


    @Test(dataProvider = "kangaroo")
    public void kangarooTest(int x1, int v1, int x2, int v2, String expectedResult) {
        Assert.assertEquals(kangaroo(x1, v1, x2, v2), expectedResult);
    }

    private String kangaroo(int x1, int v1, int x2, int v2) {

        Assert.assertTrue(0 <= x1);
        Assert.assertTrue(x1 < x2);
        Assert.assertTrue(x2 <= 10000);
        Assert.assertTrue(1 <= v1);
        Assert.assertTrue(1 <= v2);
        Assert.assertTrue(v1 <= 10000);
        Assert.assertTrue(v2 <= 10000);

        String response = null;
        int deltaBefore = 0;
        int deltaAfter = 0;

        if (v2 >= v1) {
            response = "NO";
        } else {

            do {
                if (x1 == x2) {
                    response = "YES";
                } else {
                    deltaBefore = Math.abs(x1 - x2);
                    x1 = x1 + v1;
                    x2 = x2 + v2;
                    deltaAfter = Math.abs(x1 - x2);
                }
            } while (response == null && deltaBefore >= deltaAfter);

            if (response == null){response = "NO";}
        }

        return response;
    }

}
