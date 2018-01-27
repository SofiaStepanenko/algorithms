package main;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * @author sofiiastepanenko  27/01/18.
 */
public class EmasComputerTest {

    @Test
    public void test1() {
        String[] grid = {"GGGGGG", "GBBBGB", "GGGGGG", "GGBBGB", "GGGGGG"};

        int result = calculatePluses(grid);
        Assert.assertEquals(5, result, "Something went wrong");
    }

    @Test
    public void test() {
        String[] grid = {"BGBBGB", "GGGGGG", "BGBBGB", "GGGGGG", "BGBBGB", "BGBBGB"};

        int result = calculatePluses(grid);
        Assert.assertEquals(25, result, "Something went wrong");
    }


    private int calculatePluses(String[] grid) {

        int response;
        ArrayList<Integer> crossesAreas = new ArrayList<Integer>();

        int matrixLength = grid[0].length();
        int matrixHeight = grid.length;
        int maxCrossDiameter = getMaxCrossDiameter(matrixLength, matrixHeight);

        String[][] matrix = new String[matrixHeight][matrixLength];
        int cell = 0;
        for (String row : grid) {
            matrix[cell++] = row.split("");
        }

        if (noGoodCellsInMatrix(matrix, matrixLength, matrixHeight)) {
            response = 0;
        } else if (maxCrossDiameter == 1) {
            response = 1;
        } else {
            int maxRayLength = (maxCrossDiameter - 1) / 2;
            for (int rayLengh = maxRayLength; rayLengh >= 0; rayLengh--) {
                for (int i = rayLengh; i < (matrixHeight - rayLengh); i++) {
                    for (int j = rayLengh; j < (matrixLength - rayLengh); j++) {
                        if (matrix[i][j].equals("G")) {
                            boolean crossExists = true;
                            for (int x = 1; x <= rayLengh; x++) {
                                if (matrix[i + x][j].equals("B") ||
                                        matrix[i - x][j].equals("B") ||
                                        matrix[i][j + x].equals("B") ||
                                        matrix[i][j - x].equals("B")) {
                                    crossExists = false;
                                }
                            }
                            if (crossExists) {
                                crossesAreas.add(rayLengh * 4 + 1);
                                matrix[i][j] = "B";
                                for (int x = 1; x <= rayLengh; x++) {
                                    matrix[i + x][j] = "B";
                                    matrix[i - x][j] = "B";
                                    matrix[i][j + x] = "B";
                                    matrix[i][j - x] = "B";
                                }
                            }
                        }
                    }
                }
            }
            //if there's only one big cross on the field, we count a smaller cross + 1-cell cross
            if (crossesAreas.size() == 1) {
                crossesAreas.set(0, crossesAreas.get(0) - 4);
                crossesAreas.add(1);
            }
            response = crossesAreas.get(0) * crossesAreas.get(1);
        }
        return response;
    }


    private int getMaxCrossDiameter(int matrixLength, int matrixHeight) {
        int maxCrossDiameter;
        if (matrixLength > matrixHeight) {
            if (matrixHeight % 2 == 1) {
                maxCrossDiameter = matrixHeight;
            } else {
                maxCrossDiameter = matrixHeight - 1;
            }
        } else {
            if (matrixLength % 2 == 1) {
                maxCrossDiameter = matrixLength;
            } else {
                maxCrossDiameter = matrixLength - 1;
            }
        }
        return maxCrossDiameter;
    }

    private boolean noGoodCellsInMatrix(String[][] matrix, int matrixLength, int matrixHeight) {
        Boolean result = true;
        for (int i = 0; i < matrixHeight; i++) {
            for (int j = 0; j < matrixLength; j++) {
                if (matrix[i][j].equals("G")) {
                    result = false;
                }
            }
        }
        return result;
    }
}
