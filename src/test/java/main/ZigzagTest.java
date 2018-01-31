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
    public void test10() {
        Assert.assertEquals(zigzag("abcdefghij", 4), "agbfhceidj", "Ooops!");
    }


    private String zigzag(String inputString, int matrixHeight) {

        int matrixLength = ((int) Math.ceil(inputString.length() / 2.0));
        String[][] matrix = new String[matrixHeight][matrixLength];
        for (String[] row: matrix)
            Arrays.fill(row, "•");

        //filling the matrix:
        String[] charArray = inputString.split("");
        int n = 0;

        for (int j = 0; j < matrixLength; j++) {
            for (int i = 0; i < matrixHeight; i++) {
                if (j % (matrixHeight - 1) == 0) {
                    matrix[i][j] = charArray[n];
                    if (n + 1 < charArray.length) {
                        n++;
                    } else {
                        i = matrixHeight;
                        j = matrixLength;
                    }
                } else if ((i + j) % (matrixHeight - 1) == 0) {
                    matrix[i][j] = charArray[n];
                    if (n + 1 < charArray.length) {
                        n++;
                    } else {
                        i = matrixHeight;
                        j = matrixLength;
                    }
                }
            }
        }


        String response = "";

        for (int i = 0; i < matrixHeight; i++) {
            System.out.println();
            for (int j = 0; j < matrixLength; j++) {
                System.out.print(matrix[i][j]);
                if (!matrix[i][j].equals("•")) {
                    response = response.concat(matrix[i][j]);
                }
            }
        }

        return response;
    }
}
