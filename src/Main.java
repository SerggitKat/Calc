package Calc;

import java.util.InputMismatchException;
import java.util.Scanner;

class RomanArabianCalc {
    static char operation;
    static int result;

    public static void main(String[] args) throws Exception {
        System.out.println("Vvedite virajenie: Primer: 2 + 2 cherez probel ili dva chisla ot I do X + Enter ");
        Scanner scanner = new Scanner(System.in);
        String strokaVvoda1 = scanner.nextLine();
        String[] array1 = strokaVvoda1.toUpperCase().strip().split(" "); // убираю лишнее, первел в верхний регистр + разделил по пробелу
        String num1 = array1[0]; // вытащил 1 число
        operation = array1[1].charAt(0); // присвоил операции символ
        String num2 = array1[2]; // второе число
        if (array1.length != 3) { // проверил на длинну
            throw new Exception("Ne 3 znachen");
        }
        if (romanToNumber(num1) != -1 && romanToNumber(num2) != -1) {
            result = calculated(romanToNumber(num1), romanToNumber(num2), operation);
            if (result == 0) {
                throw new ArithmeticException();
            } else {
                System.out.println("Result for Rome: " + "\n" + num1 + " " + operation + " " + num2 + " = " + convertNumToRoman(result));
            }
        } else if (Integer.parseInt(num1) > 0 && Integer.parseInt(num1) <= 10 && Integer.parseInt(num2) > 0 && Integer.parseInt(num2) <= 10) {
            result = calculated(Integer.parseInt(num1), Integer.parseInt(num2), operation);
            System.out.println("Result for Arabian: " + "\n" + +Integer.parseInt(num1) + " " + operation + " " + Integer.parseInt(num2) + " = " + result);
        } else {
            throw new ArithmeticException("Ne dopustimoe zyachenie, vvedite ot I do X!");
        }
    }

    private static String convertNumToRoman(int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
    }

    private static int romanToNumber(String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Vvedite ot I do X!");
        }
        return -1;
    }

    public static int calculated(int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Tolko chisla ot 0 do 10");

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Takoy operacii net");
        }
        return result;
    }
}
