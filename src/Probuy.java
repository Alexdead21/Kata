import java.util.Scanner;

public class Probuy {
    public static void main(String[] args) throws Exception {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String data = scanner.nextLine();
            String[] strings = data.split(" ");
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
            switch (action) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
                default:
                    throw new Exception();
            }
            if (isRoman == false) {
                System.out.println(result);
            } else {
                if (result < 0) {
                    throw new Exception();
                }
                System.out.println(integerToRoman(result));
            }
        }
    }
    private static int stringToRoman(String num) throws Exception {
        switch (num) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                throw new Exception();
        }
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