package com.company;

import java.util.Scanner;

public class Commands {

    Scanner scanner = new Scanner(System.in);
    ComplexNumbers complexNumbers;

    public void serve() {

        while (true) {
            System.out.print("--> ");
            String command = scanner.nextLine();
            switch (command.toUpperCase()) {

                case "SUM":
                    //complexNumbers.sum();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + command.toUpperCase());
            }

        }
    }
}