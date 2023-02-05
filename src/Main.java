import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите три числа (от 1 до 10) и операцию между числами (+, -, *, /) (н-р: 1 + 4 * 7   Не забывайте про пробелы!):");
        String line = input.nextLine();
        Calculator calculator = new Calculator();
        int result = calculator.calculate(line);
        System.out.println("Результат операции: " + result);
    }
}

class Calculator {
    int calculate(String line) {
        String[] tokens = line.split("\\s");

        int num1 = getValidNumber(tokens[0]);
        int num2 = getValidNumber(tokens[2]);
        int num3 = getValidNumber(tokens[4]);
        char operation1 = getValidOperation(tokens[1].charAt(0));
        char operation2 = getValidOperation(tokens[3].charAt(0));

        int result = 0;
        switch (operation1) {
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
                result = num1 / num2;
                break;
        }

        switch (operation2) {
            case '+':
                result = result + num3;
                break;
            case '-':
                result = result - num3;
                break;
            case '*':
                result = result * num3;
                break;
            case '/':
                result = result / num3;
                break;
        }
        return result;
    }

    private int getValidNumber(String token) {
        int num = Integer.parseInt(token);
        if (num < 1 || num > 10) {
            System.out.println("Неправильное значение. Пожалуйста, введите число между 1 и 10.");
            System.exit(1);
        }
        return num;
    }

    private char getValidOperation(char operation) {
        if (operation != '+' && operation != '-' && operation != '*' && operation != '/') {
            System.out.println("Неправильный ввод. Пожалуйста введите знак (+, -, *, /).");
            System.exit(1);
        }
        return operation;
    }
}