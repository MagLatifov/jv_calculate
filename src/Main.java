import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        //Массив операций
        char[] a = {'+','-', '*', '/'};
        char action = ' ';
        boolean found = false;

        System.out.println("Введите выражение: ");
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();

        for (char chars : a) {
            if (exp.indexOf(chars) != -1) {
                found = true;
                action = chars;
                break;
            }
        }

        if (action == ' ') throw new Exception("Такого действия нету.");

        //получаем два числа из вырадения, для этого дробим строку
        String[] data = exp.split("\\" + action);

        System.out.println("Результат действия:  " + calculate(action, data) );

    }

    public static int calculate(char action, String[] data) {
        int result;
        return switch (action) {
            case '+' -> {
                result = Integer.parseInt(data[0]) + Integer.parseInt(data[1]);
                yield result;
            }
            case '-' -> {
                result = Integer.parseInt(data[0]) - Integer.parseInt(data[1]);
                yield result;
            }
            case '*' -> {
                result = Integer.parseInt(data[0]) * Integer.parseInt(data[1]);
                yield result;
            }
            case '/' -> {
                result = Integer.parseInt(data[0]) / Integer.parseInt(data[1]);
                yield result;
            }
            default -> {
                result = 0;
                yield result;
              }
        };
    }
}