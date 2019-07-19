package com.company;

import java.util.Scanner;

public class Commands {

    private Scanner scanner = new Scanner(System.in);
    private ComplexNumbers x = new ComplexNumbers(2, 3);
    private ComplexNumbers y = new ComplexNumbers(-1, 2);
    private ComplexNumbers z;

    public void serve() {
        System.out.println("You can use 'help' ");

        while (true) {
            System.out.print("--> ");
            String command = scanner.nextLine();
            switch (command.toUpperCase()) {
                case "HELP":
                    System.out.println("sum");
                    System.out.println("sub");
                    System.out.println("multiply");
                    System.out.println("div");
                    System.out.println("comparison");
                    break;
               case "COMPARISON":

                   if ( x.comparison(y) == true){
                       System.out.println("YES");
                   }
                   else {
                       System.out.println("NO");
                   }
                   break;
                case "SUM":
                    z = x.sum(y);
                    print(command);
                    break;

                case "ROTATE":
                    z = x.rotate(y,2);
                    print(command);
                    break;

                case "SUB":
                    z = x.sub(y);
                    print(command);

                case "MULTIPLY":
                    z = ComplexNumbers.multiply(x, y);
                    print(command);

                case "DIV":
                    z = ComplexNumbers.div(x, y);
                    print(command);

                default:
                    System.out.println("Unexpected value: " + command.toUpperCase());
            }

        }
    }

    private void print(String command) {
        System.out.println(command + " " + z);
    }


}