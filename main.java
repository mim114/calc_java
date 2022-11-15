import java.util.*;

public class Main {
    public static void main(String[] args) {

        // запрашиваем данные на ввод
        System.out.println("Введите выражение типа 2 + 5 или V - III");
        System.out.print("числа от 1 до 10 включительно, через пробел: ");
        Scanner sca = new Scanner(System.in);
        String str = sca.nextLine();
        String[] string = str.split(" ");
        String[] nameArray = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        List<String> nameList = new ArrayList<>(Arrays.asList(nameArray));
        String a;
        String operator;
        String b;
        int num = string.length;

        if(checkString(string[0]) || nameList.contains(string[0])) {
            if (num == 3) {
                a = string[0];
                operator = string[1];
                b = string[2];
                boolean bo = checkString(a) & checkString(b);
                boolean bo1 = nameList.contains(string[0]) & nameList.contains(string[2]);

                if (bo || bo1) {
                    // проверяем, что введено. строка или число
                    boolean a1 = checkString(a);
                    boolean b1 = checkString(b);

                    int a2;
                    int b2;
                    if (a1 & b1) {
                        a2 = Integer.parseInt(a);
                        b2 = Integer.parseInt(b);
                        if (a2 <= 10 & b2 <= 10) {
                            int result = calc(a2, b2, operator);
                            System.out.println(result);
                        } else {
                            System.out.println("throws Exception //т.к. Число больше 10");

                        }
                    } else {
                        a2 = Convert.romanToArabic(a);
                        b2 = Convert.romanToArabic(b);
                        if (a2 <= 10 & b2 <= 10) {
                            int resul = calc(a2, b2, operator);
                            if (resul > 0) {
                                String result = Convert.arabicToRoman(resul);
                                System.out.println(result);
                            } else if (resul == 0) {
                                System.out.println("throws Exception //т.к. в римской системе нет 0");
                            } else {
                                System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");
                            }
                        } else {
                            System.out.println("throws Exception //т.к. Число больше 10");
                        }
                    }
                } else {
                    System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
                }
            } else if (num > 3) {
                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию" +
                        " - два операнда и один оператор (+, -, /, *)");
            } else {
                System.out.println("throws Exception //т.к. строка не является математической операцией");
            }
        } else {
            System.out.println("throws Exception //т.к. строка введина слитно. без пробелов");
        }
        sca.close();
    }

    // выполнение математической операции
    public static int calc(int x, int y, String z) {

        switch (z) {
            case "+" -> {
                return (x + y);
            }
            case "-" -> {
                return (x - y);
            }
            case "*" -> {
                return (x * y);
            }
            case "/" -> {
                return (x / y);
            }
            default -> {
                try {
                    throw new Exception("Unexpected value: " + z);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    // проверка. является ли строка числом
    public static boolean checkString(String str) {

        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
