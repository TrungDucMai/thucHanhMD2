package com.company.view;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("----Contacts Management---- ");
        System.out.println("Please choose an option to continue");
        System.out.println("1.Show contacts list");
        System.out.println("2.Add a new contact");
        System.out.println("3.Update a contact");
        System.out.println("4.Remove a contact");
        System.out.println("5.Search for contact");
        System.out.println("6.Read from File");
        System.out.println("7.Write to File");
        System.out.println("8.Exit");
        int choice = -1;
        do {
            System.out.println("Plese enter your selection ");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                break;
                case 7:
                    break;
                case 8:
                    System.exit(choice);
            }

        } while (choice!= -1);
    }
}
