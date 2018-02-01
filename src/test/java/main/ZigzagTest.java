package main;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * make zigzag word, e.g.:
 * <p>
 * Input:
 * String = "abcdefghij"
 * int = 4
 * <p>
 * Result:
 * 1|a| | |g
 * 2|b| |f|h
 * 3|c|e| |i
 * 4|d| | |j
 * <p>
 * String "agbfhceidj"
 *
 * @author sofiiastepanenko  29/01/18.
 */
public class ZigzagTest {

    @Test
    public void test1() {
        Assert.assertEquals(zigzag("a", 5), "a", "Ooops!");
    }

    @Test
    public void test3() {
        Assert.assertEquals(zigzag("abc", 1), "abc", "Ooops!");
    }

    @Test
    public void test5() {
        Assert.assertEquals(zigzag("aqwer", 2), "awrqe", "Ooops!");
    }

    @Test
    public void test10() {
        Assert.assertEquals(zigzag("abcdefghij", 4), "agbfhceidj", "Ooops!");
    }

    @Test
    public void test36() {
        Assert.assertEquals(zigzag("1234567890abcdefghijklmnopqrstuvwxyz", 10), "1i2hjz3gky4flx5emw6dnv7cou8bpt9aqs0r", "Ooops!");
    }


    private String zigzag(String inputString, int matrixHeight) {

        String response = "";

        if (matrixHeight == 1) {
            response = inputString;
        } else {

            int matrixLength = ((int) Math.ceil(inputString.length() / 2.0));
            String[][] matrix = new String[matrixHeight][matrixLength];
            for (String[] row : matrix)
                Arrays.fill(row, "•");

            //filling the matrix:
            String[] charArray = inputString.split("");
            int n = 0; // iterates through characters in array
            for (int j = 0; j < matrixLength; j++) {
                for (int i = 0; i < matrixHeight; i++) {
                    if ((j % (matrixHeight - 1) == 0) || ((i + j) % (matrixHeight - 1) == 0)) {
                        matrix[i][j] = charArray[n];
                        if (n < charArray.length - 1) {
                            n++;
                        } else {
                            i = matrixHeight;
                            j = matrixLength;
                        }
                    }
                }
            }

            for (int i = 0; i < matrixHeight; i++) {
                System.out.println();
                for (int j = 0; j < matrixLength; j++) {
                    System.out.print(matrix[i][j]);
                    if (!matrix[i][j].equals("•")) {
                        response = response.concat(matrix[i][j]);
                    }
                }
            }
        }

        return response;
    }
}
