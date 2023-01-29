package by.a1qa.task3.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomStringGenerator {
    public static String getRandomString(){
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        return generatedString;
    }
}
