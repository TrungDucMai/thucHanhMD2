package com.company.stogare;

import com.company.model.Contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContactFileManagement {
    public static void  writeFile(List<Contacts> contactsList) throws IOException {
        FileOutputStream fos = new FileOutputStream("contacts.CSV");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(contactsList);
        oos.close();
        fos.close();
    }

    public static List<Contacts> readFile() throws IOException, ClassNotFoundException {
        List<Contacts> contactsList = new ArrayList<>();
        File file = new File("contacts.CSV");
        if(file.length()>0){
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            contactsList = (List<Contacts>) o;
            ois.close();
            fis.close();
        }
        return contactsList;
    }
}
