package com.company;

import java.util.Scanner;

public class Commands {

    private Scanner scanner = new Scanner(System.in);
    private ComplexNumbers complexNumbers1;
    private ComplexNumbers complexNumbers2;
    private ComplexNumbers result;


    public void serve() {
        System.out.println("You can use 'help' ");
        while (true) {
            System.out.print("--> ");
            String command = scanner.nextLine();
            switch (command.toUpperCase()) {
                case "HELP":
                    System.out.println("print");
                    System.out.println("add");
                    System.out.println("sum");
                    System.out.println("sub");
                    System.out.println("multiply");
                    System.out.println("pow");
                    System.out.println("div");
                    System.out.println("comparison");
                    System.out.println("rotate");
                    System.out.println("exit");
                    break;
                case "ADD":
                    input();
                    break;
                case "PRINT":
                    System.out.println(complexNumbers1);
                    System.out.println(complexNumbers2);
                    break;
                case "COMPARISON":
                    if (complexNumbers1.comparison(complexNumbers2)) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                    break;
                case "SUM":
                    result = complexNumbers1.sum(complexNumbers2);
                    print(command);
                    break;
                case "POW":
                    System.out.println("Input power: ");
                    int power = scanner.nextInt();
                    try {
                        result = complexNumbers1.pow(power);
                        ComplexNumbers result2 = complexNumbers2.pow(power);
                        print(command);
                        System.out.println(command + " " + result2);
                        scanner.nextLine();
                    } catch (ArithmeticException e) {
                        e.printStackTrace();
                        scanner.nextLine();
                    }
                    break;
                case "SUB":
                    result = complexNumbers1.sub(complexNumbers2);
                    print(command);
                    break;
                case "ROTATE":
                    System.out.println("Input angle: ");
                    double angle = scanner.nextDouble();
                    ComplexNumbers result2;
                    result = complexNumbers1.rotate(angle);
                    result2 = complexNumbers2.rotate(angle);
                    print(command);
                    System.out.println(command + " " + result2);
                    break;
                case "MULTIPLY":
                    result = complexNumbers1.multiply(complexNumbers2);
                    print(command);
                    break;

                case "DIV":
                    try {
                        result = complexNumbers1.div(complexNumbers2);
                        print(command);

                    } catch (ArithmeticException e) {
                        e.printStackTrace();
                    }

                    break;
                case "EXIT":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Unexpected value: " + command.toUpperCase());
                    break;
            }

        }
    }

    private void print(String command) {

        System.out.println(command + " " + result);
    }

    public void input() {
        System.out.println("Input Re1: ");
        double x1 = scanner.nextDouble();
        System.out.println("Input Im1: ");
        double y1 = scanner.nextDouble();
        System.out.println("Input Re2: ");
        double x2 = scanner.nextDouble();
        System.out.println("Input Im2: ");
        double y2 = scanner.nextDouble();
        complexNumbers1 = new ComplexNumbers(x1, y1);
        complexNumbers2 = new ComplexNumbers(x2, y2);
        scanner.nextLine();
    }
}