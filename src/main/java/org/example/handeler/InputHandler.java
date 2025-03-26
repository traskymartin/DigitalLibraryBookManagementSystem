package org.example.handeler;

import org.example.enums.AvailabilityStatus;

import java.util.Scanner;

public class InputHandler {
    private  static final Scanner scanner = new Scanner(System.in);

    public static String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public static AvailabilityStatus getAvailabilityStatus(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("AVAILABLE")) return AvailabilityStatus.AVAILABLE;
            if (input.equalsIgnoreCase("CHECKED_OUT")) return AvailabilityStatus.CHECKED_OUT;
            if (input.equalsIgnoreCase("UNAVAILABLE")) return AvailabilityStatus.UNAVAILABLE;
            System.out.print("Please enter a valid option: ");
        }
    }
}
