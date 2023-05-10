import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println(calc(in.nextLine()));
    }
    public static String calc(String input) throws Exception {
        int a, b;
        char sign;
        String[] listOfVal;
        Exception e = new Exception();

        listOfVal = input.split("[+/\\-*]");
        if (listOfVal.length != 2) throw e;

        sign = input.toCharArray()[listOfVal[0].length()];

        if (listOfVal[0].trim().matches("^[IVX].*$")) {
            a = romeToArab(listOfVal[0].trim());
            b = romeToArab(listOfVal[1].trim());
            if (sign == '+') return arabToRome(a + b);
            if (sign == '*') return arabToRome(a * b);
            if (a > b && sign == '-') return arabToRome(a - b);
            if (a >= b && sign == '/') return arabToRome(a / b);
            else throw e;
        }
        else {
            a = Integer.parseInt(listOfVal[0].trim());
            b = Integer.parseInt(listOfVal[1].trim());
            if (a > 10 || b > 10 || a == 0 || b == 0) throw e;
            return switch (sign) {
                case '+' -> String.valueOf(a + b);
                case '-' -> String.valueOf(a - b);
                case '/' -> String.valueOf(a / b);
                case '*' -> String.valueOf(a * b);
                default -> "";
            };
        }
    }

    static int romeToArab(String num) throws Exception {
        String[] list = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        if (Arrays.asList(list).contains(num)) return Arrays.asList(list).indexOf(num) + 1;
        else throw new Exception();
    }

    static String arabToRome(int num) {
        if (num == 100) return "C";
        if (num >= 90) return "XC" + arabToRome(num - 90);
        if (num >= 50) return "L" + arabToRome(num - 50);
        if (num >= 40) return "XL" + arabToRome(num - 40);
        if (num >= 10) return "X" + arabToRome(num - 10);
        if (num == 9) return "IX";
        if (num >= 5) return "V" + arabToRome(num - 5);
        if (num == 4) return "IV";
        if (num > 0) return "I" + arabToRome(num - 1);
        return "";
    }
}