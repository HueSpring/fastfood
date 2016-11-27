package com.food.common;

import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

/**
 * Created by Hue on 11/12/2016.
 */
public class Common {

    public static String stringDate = "yyyy-MM-dd";
    public static String stringDateTime = "yyyy-MM-dd HH:mm:ss";
    public static int size = 10;


    public static String dateToString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(stringDate);
        return simpleDateFormat.format(date);
    }

    public static String dateTimeToString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(stringDateTime);
        return simpleDateFormat.format(date);
    }

    public static String parseArrayInt(Date date, Long day){
        String dat = Common.dateToString(date);
        String[] s = dat.split("-");
        LocalDate d = LocalDate.of(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
        return d.plusDays(day).toString();
    }

    public static String encryptMD5(String string) {
        int lenMax = 32;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(string.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < lenMax) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String randomString() {

        String str01 = "abcdefghijklmnopqrstuvwxyz";
        String str02 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String str03 = "0123456789";

        String strValid = str01 + str02 + str03;

        Random random = new Random();

        String mystring = "";
        for (int i = 0; i < size; i++) {
            int randnum = random.nextInt(strValid.length());
            mystring = mystring + strValid.charAt(randnum);
        }
        return mystring;
    }


    public static String splitDateTime(Date date){
        String string = dateTimeToString(date);
        String[] d = string.split(" ");
        String[] d1 = d[0].split("-");
        String[] d2 = d[1].split(":");
        return d2[0] + d1[1] + d2[2] + d1[0] + d1[2] + d2[1];
     }


}
