package com.company.view;

import com.company.management.ContactsManagement;
import com.company.model.Contacts;
import com.company.stogare.ContactFileManagement;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactsView {
    ContactsManagement  contactsManagement = new ContactsManagement();

    public void formShowList (){

    }
    public void formAddContact (){
        List<Contacts> contactsList = new ArrayList<>();
        try {
            contactsList = ContactFileManagement.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        contactsManagement.setContactsList(contactsList);
        Contacts contact = new Contacts();
        System.out.println("Add a new contact :");
        System.out.println("Enter phone number ");

        boolean checkPhoneNumber;
        do {
            Scanner scanner = new Scanner(System.in);
            String phoneNumber = scanner.nextLine();
            checkPhoneNumber = Validate.isPhoneNumber(phoneNumber);
            if (checkPhoneNumber) {
                String checkedPhoneNumber = phoneNumber;
                contact.setPhoneNumber(checkedPhoneNumber);
                System.out.println("Phone number is accepted.");
            } else {
                System.out.println("Phone number must have 10 numbers. Please re-enter your phone number ");
            }
        } while (!checkPhoneNumber);

        System.out.println("Enter contact's group");
        Scanner scanner1 = new Scanner(System.in);
        int group = scanner1.nextInt();
        System.out.println("Enter name ");
        Scanner scanner2 = new Scanner(System.in);
        String name = scanner2.nextLine();
        System.out.println("Enter gender");
        Scanner scanner5 = new Scanner(System.in);
        String gender = scanner5.nextLine();
        System.out.println("Enter address ");
        Scanner scanner3 = new Scanner(System.in);
        String address = scanner3.nextLine();
        System.out.println("Enter birth ");
        Scanner scanner4 = new Scanner(System.in);
        int year = scanner4.nextInt();
        int month = scanner4.nextInt();
        int day = scanner4.nextInt();
        LocalDate birth = LocalDate.of(year,month,day);
        System.out.println("Enter email");
        Scanner scanner6 = new Scanner(System.in);
        String email = scanner6.nextLine();
        Contacts contact = new Contacts(phoneNumber, group,name, gender,address,birth, email);
        try {
            contactsManagement.addContactsList(contact);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void formDeleteContact (){
        List<Contacts> contactsList = new ArrayList<>();
        try {
            contactsList = ContactFileManagement.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        contactsManagement.setContactsList(contactsList);
        System.out.println("Find and delete a contact ");
        System.out.println("Enter phone number to find contact to remove ");
        Scanner scanner = new Scanner(System.in);
        String checkPhoneNumber = scanner.nextLine();
       int index = contactsManagement.findByPhoneNumber(checkPhoneNumber);
        try {
            contactsManagement.deleteContactsList(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void formEditContact (){
        List<Contacts> contactsList = new ArrayList<>();
        try {
            contactsList = ContactFileManagement.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        contactsManagement.setContactsList(contactsList);
        System.out.println("Edit a contact :");
        System.out.println("Enter phone number ");
        Scanner scanner = new Scanner(System.in);
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter contact's group");
        Scanner scanner1 = new Scanner(System.in);
        int group = scanner1.nextInt();
        System.out.println("Enter name ");
        Scanner scanner2 = new Scanner(System.in);
        String name = scanner2.nextLine();
        System.out.println("Enter gender");
        Scanner scanner5 = new Scanner(System.in);
        String gender = scanner5.nextLine();
        System.out.println("Enter address ");
        Scanner scanner3 = new Scanner(System.in);
        String address = scanner3.nextLine();
        System.out.println("Enter birth ");
        Scanner scanner4 = new Scanner(System.in);
        int year = scanner4.nextInt();
        int month = scanner4.nextInt();
        int day = scanner4.nextInt();
        LocalDate birth = LocalDate.of(year,month,day);
        System.out.println("Enter email");
        Scanner scanner6 = new Scanner(System.in);
        String email = scanner6.nextLine();
        Contacts contact = new Contacts(phoneNumber, group,name, gender,address,birth, email);

        System.out.println("Enter name to find the contact that you need to edit ");
        Scanner scanner7 = new Scanner(System.in);
        String checkName = scanner7.nextLine();
        int index = contactsManagement.findByName(checkName);
        try {
            contactsManagement.editContactsList(index , contact);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
