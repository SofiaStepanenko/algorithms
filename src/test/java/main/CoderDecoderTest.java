package main;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author sofiiastepanenko  7/02/18.
 */
public class CoderDecoderTest {

    @Test
    public void test() {
        String input = "I can fly 3";
        String salt = "f";

        String encoded = enCoder(input, salt);
        System.out.println(encoded);
        String decoded = deCoder(encoded, salt);
        System.out.println(decoded);
        Assert.assertEquals(decoded, input);
    }

    private String enCoder(String input, String salt) {

        Integer iterator = Integer.parseInt(salt, 16);
        String output = "";

        for (int i = 0; i < input.length(); i++) {
            if (Character.isSpaceChar(input.charAt(i))) {
                output = output.concat(" ");
            } else if (Character.isUpperCase(input.charAt(i))) {
                int charIndex = (int) input.charAt(i) + iterator;
                while (charIndex > 90) {
                    charIndex = charIndex - 26;
                }
                output = output.concat(Character.toString((char) charIndex));
            } else if (Character.isLowerCase(input.charAt(i))) {
                int charIndex = (int) input.charAt(i) + iterator;
                while (charIndex > 122) {
                    charIndex = charIndex - 26;
                }
                output = output.concat(Character.toString((char) charIndex));
            } else if (Character.isDigit(input.charAt(i))) {
                int charIndex = (int) input.charAt(i) + iterator;
                while (charIndex > 57) {
                    charIndex = charIndex - 10;
                }
                output = output.concat(Character.toString((char) charIndex));
            }
        }
        return output;
    }

    private String deCoder(String input, String salt) {
        Integer iterator = Integer.parseInt(salt, 16);
        String output = "";

        for (int i = 0; i < input.length(); i++) {
            if (Character.isSpaceChar(input.charAt(i))) {
                output = output.concat(" ");
            } else if (Character.isUpperCase(input.charAt(i))) {
                int charIndex = (int) input.charAt(i) - iterator;
                while (charIndex < 65) {
                    charIndex = charIndex + 26;
                }
                output = output.concat(Character.toString((char) charIndex));
            } else if (Character.isLowerCase(input.charAt(i))) {
                int charIndex = (int) input.charAt(i) - iterator;
                while (charIndex < 97) {
                    charIndex = charIndex + 26;
                }
                output = output.concat(Character.toString((char) charIndex));
            } else if (Character.isDigit(input.charAt(i))) {
                int charIndex = (int) input.charAt(i) - iterator;
                while (charIndex < 48) {
                    charIndex = charIndex + 10;
                }
                output = output.concat(Character.toString((char) charIndex));
            }
        }
        return output;
    }
}
