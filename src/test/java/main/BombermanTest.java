package main;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * https://docs.google.com/document/d/1H_glbh32wMSw_BP6202H0Z0Y6tdLvZMkATgGeY9uXNw/edit
 * @author sofiiastepanenko  28/01/18.
 */
public class BombermanTest {

    @Test
    public void test1() {
        String[] grid = {".......", "...O...", "....O..", ".......", "OO.....", "OO....."};
        int n = 1;

        String[] result = {".......", "...O...", "....O..", ".......", "OO.....", "OO....."};
        grid = bomberMan(n, grid);
        printResult(grid);
        Assert.assertEquals(result, grid, "Something went wrong");
    }

    @Test
    public void test2() {
        String[] grid = {".......", "...O...", "....O..", ".......", "OO.....", "OO....."};
        int n = 2;

        String[] result = {"OOOOOOO", "OOOOOOO", "OOOOOOO", "OOOOOOO", "OOOOOOO", "OOOOOOO"};
        grid = bomberMan(n, grid);
        printResult(grid);
        Assert.assertEquals(result, grid, "Something went wrong");
    }

    @Test
    public void test3() {
        String[] grid = {".......", "...O...", "....O..", ".......", "OO.....", "OO....."};
        int n = 3;
        String[] result = {"OOO.OOO", "OO...OO", "OOO...O", "..OO.OO", "...OOOO", "...OOOO"};
        grid = bomberMan(n, grid);
        printResult(grid);
        Assert.assertEquals(result, grid, "Something went wrong");
    }

    @Test
    public void test5() {
        String[] grid = {".......", "...O...", "....O..", ".......", "OO.....", "OO....."};
        int n = 5;

        String[] result = {".......", "...O...", "....O..", ".......", "OO.....", "OO....."};
        grid = bomberMan(n, grid);
        printResult(grid);
        Assert.assertEquals(result, grid, "Something went wrong");
    }

    @Test
    public void test25() {
        String[] grid = {".......", "...O...", "....O..", ".......", "OO.....", "OO....."};
        int n = 25;

        String[] result = {".......", "...O...", "....O..", ".......", "OO.....", "OO....."};
        grid = bomberMan(n, grid);
        printResult(grid);
        Assert.assertEquals(result, grid, "Something went wrong");
    }

    private String[] bomberMan(int n, String[] grid) {

        String[] response = grid;

        if (n == 0 || n == 1) { // nothing happens in these seconds
        } else if (n % 2 == 0) {
            //for every even second the field is filled with bombs
            String filledRow = grid[0].replace(".", "O");
            for (int i = 0; i < grid.length; i++) {
                grid[i] = filledRow;
            }
            response = grid;
        } else {
            for (int sec = 3; sec <= n; sec = sec + 2) {

                //transform grid to a matrix with 1 cell padding filled with " "
                int matrixLength = grid[0].length()+2;
                int matrixHeight = grid.length + 2;
                String[][] matrix = new String[matrixHeight][matrixLength];
                for (String[] row: matrix)
                    Arrays.fill(row, " ");
                for (int i = 1; i < matrixHeight - 1; i++) {
                    String row = grid[i - 1];
                    for (int j = 1; j < matrixLength - 1; j++) {
                        matrix[i][j] = row.split("")[j - 1];
                    }
                }

                //detonate all bombs, mark detonated place as "X"
                for (int i = 1; i < matrixHeight - 1; i++) {
                    for (int j = 1; j < matrixLength - 1; j++) {
                        if (matrix[i][j].equals("O")) {
                            matrix[i][j] = "X";
                            if (matrix[i][j - 1].equals(".")) {
                                matrix[i][j - 1] = "X";
                            }
                            if (matrix[i - 1][j].equals(".")) {
                                matrix[i - 1][j] = "X";
                            }
                            if (matrix[i][j + 1].equals(".")) {
                                matrix[i][j + 1] = "X";
                            }
                            if (matrix[i + 1][j].equals(".")) {
                                matrix[i + 1][j] = "X";
                            }
                        }
                    }
                }

                //plant remaining bombs on undetonated areas, set everything else as "."
                for (int i = 1; i < matrixHeight - 1; i++) {
                    for (int j = 1; j < matrixLength - 1; j++) {
                        if (matrix[i][j].equals(".")) {
                            matrix[i][j] = "O";
                        } else {
                            matrix[i][j] = ".";
                        }
                    }
                }

                //transform result back to grid format
                for (int i = 1; i < matrixHeight - 1; i++) {
                    String row = "";
                    for (int j = 1; j < matrixLength - 1; j++) {
                        row=row.concat(matrix[i][j]);
                    }
                    grid[i-1] = row;
                }

                response = grid;
            }
        }

        return response;
    }


    private void printResult(String[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
