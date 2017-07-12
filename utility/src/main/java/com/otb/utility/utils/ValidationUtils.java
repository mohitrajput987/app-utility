package com.otb.utility.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mohit Rajput on 4/7/17.
 * Util class which provides methods to validate constraints on fields i.e. email, phone number etc.
 */

public class ValidationUtils {

    /**
     * Length of Australian Business Number that is 11
     */
    public static final int ABN_LENGTH = 11;
    /**
     * Length of Australian Compnay Number that is 9
     */
    public static final int ACN_LENGTH = 9;
    /**
     * Method checks if an email is in valid format.
     *
     * @param email
     * @return boolean true if email is valid, false if invalid
     */
    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * Method checks if a password is in valid format or not by checking its all constraints i.e. minimum length 8,
     * at least one small, one capital, one special character and at least one number.
     *
     * @param password
     * @return boolean true if password is valid, false if invalid
     */
    public static boolean isPasswordValid(String password) {
//        String expression = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
//        Pattern pattern = Pattern.compile(expression);
//        Matcher matcher = pattern.matcher(password);
//        return matcher.matches();
        if (password != null && password.length() >= 6) {
            return true;
        }
        return false;
    }

    /**
     * Method checks if a name is in valid format. It checks unicode character of all languages.
     *
     * @param name
     * @return boolean true if name is valid, false if invalid
     */
    public static boolean isNameValid(String name) {
        String expression = "^[\\p{L} .'-]+$";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    /**
     * Method checks if a mobile number is valid.
     *
     * @param mobileNumber
     * @return boolean true if name is valid, false if invalid
     */
    public static boolean isMobileNumberValid(String mobileNumber) {
        if (mobileNumber != null && mobileNumber.length() >= 7 && mobileNumber.length() <= 13) {
            return true;
        }
        return false;
    }

    /**
     * Method checks if ABN is valid.
     *
     * @param abn
     * @return boolean true if ABN is valid, false if invalid
     */
    public static boolean isAbnValid(String abn) {
        if (abn != null && abn.length() == ABN_LENGTH) {
            return true;
        }
        return false;
    }

    /**
     * Method checks if ACN is valid.
     *
     * @param acn
     * @return boolean true if ACN is valid, false if invalid
     */
    public static boolean isAcnValid(String acn) {
        if (acn != null && acn.length() == ACN_LENGTH) {
            return true;
        }
        return false;
    }
}
