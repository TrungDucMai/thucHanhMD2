package com.company.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static boolean isPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^[0-9]{10}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static boolean isEmail(String email) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$"
        );
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
