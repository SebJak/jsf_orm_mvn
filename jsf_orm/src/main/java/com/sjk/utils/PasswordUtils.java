package com.sjk.utils;

/**
 * Created by Sebastian on 2015-06-02.
 */
public class PasswordUtils {

    private String password;

    private String confPassword;

    private final int PASS_LENGTH = 7;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfPassword() {
        return confPassword;
    }

    public void setConfPassword(String confPassword) {
        this.confPassword = confPassword;
    }

    public boolean checkSmallLetters(){
        String smallLetter = ".*[a-z]+.*";
        return password.matches(smallLetter);
    }

    public boolean checkBigLetters(){
        String bigLetter = ".*[A-Z]+.*";
        return password.matches(bigLetter);
    }

    public boolean checkNumbers(){
        String numbers = ".*[0-9]+.*";
        return password.matches(numbers);
    }

    public boolean checkOtherSign(){
        String otherSign = ".*[^A-Za-z0-9\\s]+.*";
        return password.matches(otherSign);
    }

    public boolean validatePassword(){
        boolean validated = checkBigLetters() && checkNumbers() && checkSmallLetters() && checkOtherSign() && password.length()>=PASS_LENGTH;
        return validated ? true : false;
    }

    public boolean confirmPassword(){

        return password.equals(confPassword);
    }

    @Override
    public String toString() {
        return "Password{" +
                "password='" + password + '\'' +
                ", Confirm password='" + confPassword + '\'' +
                '}';
    }
}
