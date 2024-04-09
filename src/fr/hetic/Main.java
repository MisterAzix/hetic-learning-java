package fr.hetic;

public class Main {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("You must provide 3 arguments: two numbers and an operator (<number> <number> <operator>)");
            System.exit(1);
        }

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        Calculator calculator = new Calculator();
        switch (args[2]) {
            case "+":
                System.out.println(calculator.add(a, b));
                break;
            case "-":
                System.out.println(calculator.substract(a, b));
                break;
            case "*":
                System.out.println(calculator.multiply(a, b));
                break;
            case "/":
                System.out.println(calculator.divide(a, b));
                break;
            default:
                System.out.println("Invalid operator");
        }
    }
}
