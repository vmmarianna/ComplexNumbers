package com.company;

import java.util.Scanner;

public class Commands {

    private Scanner scanner = new Scanner(System.in);
    private ComplexNumbers x;
    private ComplexNumbers y;
    private ComplexNumbers z;


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
                    System.out.println("div");
                    System.out.println("comparison");
                    System.out.println("rotate");
                    System.out.println("exit");
                    break;
                case "ADD":
                    input();
                    break;
                case "PRINT":
                    System.out.println(x);
                    System.out.println(y);
                    break;
                case "COMPARISON":

                    if (x.comparison(y) == true) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                    break;
                case "SUM":
                    z = x.sum(y);
                    print(command);
                    break;

                case "ROTATE":
                    z = x.rotate(y, 2);
                    print(command);
                    break;

                case "SUB":
                    z = x.sub(y);
                    print(command);
                    break;

                case "MULTIPLY":
                    z = x.multiply(y);
                    print(command);
                    break;

                case "DIV":
                    z = x.div(y);
                    print(command);
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
        System.out.println(command + " " + z);
    }

    public void input() {
        System.out.println("Input x1: ");
        double x1 = scanner.nextDouble();
        System.out.println("Input y1: ");
        double y1 = scanner.nextDouble();
        System.out.println("Input x2: ");
        double x2 = scanner.nextDouble();
        System.out.println("Input y2: ");
        double y2 = scanner.nextDouble();
        x = new ComplexNumbers(x1, y1);
        y = new ComplexNumbers(x2, y2);
    }


}