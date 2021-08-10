package com.company.management;

import com.company.model.Contacts;
import com.company.stogare.ContactFileManagement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactsManagement {
    List<Contacts> contactsList = new ArrayList<>();

    public ContactsManagement() {
    }

    public ContactsManagement(List<Contacts> contactsList) {
        this.contactsList = contactsList;
    }

    public List<Contacts> getContactsList() {
        return contactsList;
    }

    public void setContactsList(List<Contacts> contactsList) {
        this.contactsList = contactsList;
    }

    public void showContactsList() throws IOException, ClassNotFoundException {
        contactsList = ContactFileManagement.readFile();
        for (int i = 0; i < contactsList.size(); i++) {
            contactsList.get(i).toString();
        }
    }

    public void addContactsList(Contacts newContact) throws IOException {
        contactsList.add(newContact);
        ContactFileManagement.writeFile(contactsList);
    }

    public void deleteContactsList(int index) throws IOException {
        contactsList.remove(index);
        ContactFileManagement.writeFile(contactsList);
    }

    public void editContactsList(int index, Contacts newContact) throws IOException {
        contactsList.set(index, newContact);
        ContactFileManagement.writeFile(contactsList);
    }

    public int findByPhoneNumber(String phoneNumber) {
        int index = -1;
        for (int i = 0; i < contactsList.size(); i++) {
            if (contactsList.get(i).getPhoneNumber().contains(phoneNumber)) {
                index = i;
            }

        }
        return index;
    }

    public int findByName(String name) {
        int index = -1;
        for (int i = 0; i < contactsList.size(); i++) {
            if (contactsList.get(i).getName().contains(name)) {
                index = i;
            }

        }
        return index;
    }


}