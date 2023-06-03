import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = scanner.nextLine();
        scanner.close();

            try {
                String result = calc(input);
                System.out.println("Рузльтат "+result);
            }catch (IllegalArgumentException e) {
                System.out.println("Ошибка: "+e.getMessage());

            }
        }


    public static String calc(String input) {
        String[] tokens = input.split(" ");
        if (tokens.length !=3) {
            throw new IllegalArgumentException("throws Exception");
        }
        int a, b;

        try {
            a=Integer.parseInt(tokens[0]);
            b=Integer.parseInt(tokens[2]);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("Некорректные числа");
        }
        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new IllegalArgumentException("Числа должны быть в диапазоне от 1 до 10");
        }
        int result;
        switch (tokens[1]) {
            case "+" -> result = a + b;
            case "-" -> result = a - b;
            case "*" -> result = a * b;
            case "/" -> result = a / b;
            default -> throw new IllegalArgumentException("Некорректная операция");

        }
        return String.valueOf(result);
    }
}