import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        System.out.println(calculate(data));
    }

    public static String calculate(String input) throws Exception {


        String[] strings = input.split(" ");
        if (strings.length > 3) {
            throw new Exception();
        }
        String num1str = strings[0];
        String num2str = strings[2];
        String action = strings[1];


        int num1;
        int num2;
        int result;

        boolean isRoman = false;
        try {
            num1 = Integer.parseInt(num1str);
            num2 = Integer.parseInt(num2str);
        } catch (NumberFormatException e) {
            num1 = stringToRoman(num1str);
            num2 = stringToRoman(num2str);
            isRoman = true;
        }
        if ((num1 < 1 || num1 > 10) || (num2 < 1 || num2 > 10)) {
            throw new Exception();
        }
        result = switch (action) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> throw new Exception();
        };
        if (isRoman) {
            if (result < 1) {
                throw new Exception();
            }
            return integerToRoman(result);
        } else {
            return String.valueOf(result);
        }
    }

    private static int stringToRoman(String num) throws Exception {
        return switch (num) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> throw new Exception();
        };
    }

    public static String integerToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLetters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num = num - values[i];
                roman.append(romanLetters[i]);
            }
        }
        return roman.toString();
    }
}