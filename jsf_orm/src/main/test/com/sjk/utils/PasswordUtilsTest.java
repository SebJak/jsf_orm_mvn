package com.sjk.utils;

import junit.framework.TestCase;

/**
 * Created by Sebastian on 2015-06-08.
 */
public class PasswordUtilsTest extends TestCase {

    public void testValidateWrongPassword() throws Exception {

        PasswordUtils passwordUtils = new PasswordUtils();
        passwordUtils.setPassword("password");
        passwordUtils.setConfPassword("Password");
        assertEquals(false, passwordUtils.confirmPassword());
    }

    public void testValidateCorrectPassword() throws Exception {

        PasswordUtils passwordUtils = new PasswordUtils();
        passwordUtils.setPassword("password");
        passwordUtils.setConfPassword("password");
        assertEquals(true, passwordUtils.confirmPassword());
    }

    public void testSmallLetters() throws Exception {
        PasswordUtils passwordUtils = new PasswordUtils();
        passwordUtils.setPassword("password");
        passwordUtils.setConfPassword("password");
        assertEquals(true, passwordUtils.checkSmallLetters());
    }

    public void testNoSmallLetters() throws Exception {
        PasswordUtils passwordUtils = new PasswordUtils();
        passwordUtils.setPassword("PASS");
        passwordUtils.setConfPassword("PASS");
        assertEquals(false, passwordUtils.checkSmallLetters());
    }

    public void testBigLetters() throws Exception {
        PasswordUtils passwordUtils = new PasswordUtils();
        passwordUtils.setPassword("PASS");
        passwordUtils.setConfPassword("PASS");
        assertEquals(true, passwordUtils.checkBigLetters());
    }

    public void testNoBigLetters() throws Exception {
        PasswordUtils passwordUtils = new PasswordUtils();
        passwordUtils.setPassword("pass");
        passwordUtils.setConfPassword("pass");
        assertEquals(false, passwordUtils.checkBigLetters());
    }

    public void testNumbers() throws Exception {
        PasswordUtils passwordUtils = new PasswordUtils();
        passwordUtils.setPassword("4ss");
        passwordUtils.setConfPassword("4ss");
        assertEquals(true, passwordUtils.checkNumbers());
    }
    public void testNoNumbers() throws Exception {
        PasswordUtils passwordUtils = new PasswordUtils();
        passwordUtils.setPassword("pass");
        passwordUtils.setConfPassword("pass");
        assertEquals(false, passwordUtils.checkNumbers());
    }

    public void testOtherSigns() throws Exception {
        PasswordUtils passwordUtils = new PasswordUtils();
        passwordUtils.setPassword("pass!");
        passwordUtils.setConfPassword("pass!");
        assertEquals(true, passwordUtils.checkOtherSign());
    }

    public void testNoOtherSigns() throws Exception {
        PasswordUtils passwordUtils = new PasswordUtils();
        passwordUtils.setPassword("pass01 ");
        passwordUtils.setConfPassword("pass01 ");
        assertEquals(false, passwordUtils.checkOtherSign());
    }

    public void testNoValidatePassword() throws Exception {
        PasswordUtils passwordUtils = new PasswordUtils();
        passwordUtils.setPassword("p01Wo!");
        passwordUtils.setConfPassword("p01Wo!"); // Wrong length
        assertEquals(false, passwordUtils.validatePassword());
    }

    public void testValidatePassword() throws Exception {
        PasswordUtils passwordUtils = new PasswordUtils();
        passwordUtils.setPassword("pass01Wo!");
        passwordUtils.setConfPassword("pass01Wo!");
        assertEquals(true, passwordUtils.validatePassword());
    }

}