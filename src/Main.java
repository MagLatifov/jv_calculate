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

        if (data.length > 2) {
            throw new Exception("Работаем только с двумя аргументами");
        }

        System.out.println("Результат действия:  " + calculate(action, data) );

    }

    public static int calculate(char action, String[] data) {
        int result = 0;
        return switch (action) {
            case '+' -> {
                try {
                   result = Integer.parseInt(data[0].trim()) + Integer.parseInt(data[1].trim());
                } catch(NumberFormatException e) {
                    System.out.println("Введены не целые числа.");
                }
                yield result;
            }
            case '-' -> {
                try {
                    result = Integer.parseInt(data[0].trim()) - Integer.parseInt(data[1].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Введены не целые числа.");
                }
                yield result;
            }
            case '*' -> {
                try {
                    result = Integer.parseInt(data[0].trim()) * Integer.parseInt(data[1].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Введены не целые числа.");
                }
                yield result;
            }
            case '/' -> {
                try {
                    result = Integer.parseInt(data[0].trim()) / Integer.parseInt(data[1].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Введены не целые числа.");
                }
                yield result;
            }
            default -> {
                yield result;
              }
        };
    }
}